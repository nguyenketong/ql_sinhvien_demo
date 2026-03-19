package vn.edu.tvu.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vn.edu.tvu.model.Student;
import vn.edu.tvu.repository.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {
        Student student1 = new Student("SV001", "Nguyen Van A", "a@tvu.edu.vn", "CNTT");
        Student student2 = new Student("SV002", "Tran Thi B", "b@tvu.edu.vn", "Kinh tế");
        
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));
        
        List<Student> students = studentService.getAllStudents();
        
        assertEquals(2, students.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testSaveStudent() {
        Student student = new Student("SV001", "Nguyen Van A", "a@tvu.edu.vn", "CNTT");
        
        when(studentRepository.save(student)).thenReturn(student);
        
        Student saved = studentService.saveStudent(student);
        
        assertNotNull(saved);
        assertEquals("SV001", saved.getStudentCode());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testGetStudentById() {
        Student student = new Student("SV001", "Nguyen Van A", "a@tvu.edu.vn", "CNTT");
        student.setId(1L);
        
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        
        Optional<Student> found = studentService.getStudentById(1L);
        
        assertTrue(found.isPresent());
        assertEquals("SV001", found.get().getStudentCode());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);
        
        studentService.deleteStudent(1L);
        
        verify(studentRepository, times(1)).deleteById(1L);
    }
}
