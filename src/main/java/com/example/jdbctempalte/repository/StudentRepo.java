package com.example.jdbctempalte.repository;

import com.example.jdbctempalte.dto.Student;

import java.util.List;

/**
 * Created by nikeshpathak on 22/07/17.
 */
public interface StudentRepo {

    boolean add(Student student);
    boolean update(Student student);
    boolean delete(String email);
    Student get(String email);
    List<Student> getAll();
}
