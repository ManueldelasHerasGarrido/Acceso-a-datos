package com.manuelhg.demo;

import com.manuelhg.demo.model.Module;
import com.manuelhg.demo.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class AddApplication implements CommandLineRunner {

    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(AddApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student("12345678A", "Manuel", "Hernandez", "Computer Science");
        Module module1 = new Module("CS101", "Introduction to Computer Science");
        Module module2 = new Module("CS102", "Data Structures");
        studentService.createStudent(student);
    }
}
