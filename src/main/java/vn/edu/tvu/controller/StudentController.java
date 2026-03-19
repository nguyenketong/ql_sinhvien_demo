package vn.edu.tvu.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.tvu.model.Student;
import vn.edu.tvu.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }
    
    @PostMapping
    public String createStudent(@Valid @ModelAttribute Student student, 
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "students/form";
        }
        
        if (studentService.existsByStudentCode(student.getStudentCode())) {
            result.rejectValue("studentCode", "error.student", 
                             "Mã sinh viên đã tồn tại");
            return "students/form";
        }
        
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "students/form";
    }
    
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, 
                               @Valid @ModelAttribute Student student,
                               BindingResult result) {
        if (result.hasErrors()) {
            student.setId(id);
            return "students/form";
        }
        
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
