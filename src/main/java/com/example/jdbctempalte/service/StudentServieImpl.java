package com.example.jdbctempalte.service;

import com.example.jdbctempalte.dto.Student;
import com.example.jdbctempalte.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nikeshpathak on 22/07/17.
 */

@Service
public class StudentServieImpl implements StudentService{


    @Autowired
    StudentRepo studentRepo;

    @Override
    public boolean add(Student student) {
        return studentRepo.add(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepo.update(student);
    }

    @Override
    public boolean delete(String email) {
        return studentRepo.delete(email);
    }

    @Override
    public Student get(String email) {
        return studentRepo.get(email);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }
}
