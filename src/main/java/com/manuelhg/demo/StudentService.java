package com.manuelhg.demo;

import com.manuelhg.demo.model.Student;
import com.manuelhg.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements CustomeService<Student> {

    private final StudentRepository studentRepository;

    @Override
    public Student create(Student entity) {
        return null;
    }

    @Override
    public Student read(Student entity) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public boolean delete(Student entity) {
        return false;
    }

    @Override
    public boolean validate(Student entity) {
        return entity.getDni().isBlank() && entity.getName().isBlank();
    }

    public Student createStudent(final Student student) {
        if (validate(student)) {
            return studentRepository.create(student);
        }
        return null;
    }
}
