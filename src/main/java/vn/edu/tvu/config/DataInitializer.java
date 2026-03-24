package vn.edu.tvu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.tvu.model.Role;
import vn.edu.tvu.model.User;
import vn.edu.tvu.repository.UserRepository;
import vn.edu.tvu.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) {
        // Tạo tài khoản demo nếu chưa có
        if (!userRepository.existsByUsername("admin")) {
            userService.createUser(new User("admin", "admin123", "Quản trị viên", Role.ADMIN));
        }
        
        if (!userRepository.existsByUsername("teacher")) {
            userService.createUser(new User("teacher", "teacher123", "Giảng viên Nguyễn Văn A", Role.TEACHER));
        }
        
        if (!userRepository.existsByUsername("student")) {
            userService.createUser(new User("student", "student123", "Sinh viên Trần Thị B", Role.STUDENT));
        }
    }
}
