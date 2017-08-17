package com.example.jdbctempalte.service;

import com.example.jdbctempalte.dto.Student;

import java.util.List;

/**
 * Created by nikeshpathak on 22/07/17.
 */
public interface StudentService {

    boolean add(Student student);
    boolean update(Student student);
    boolean delete(String email);
    Student get(String email);
    List<Student> getAll();
}
