package com.example.jdbctempalte.repo;

import com.example.jdbctempalte.dto.Student;
import com.example.jdbctempalte.repository.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by nikeshpathak on 22/07/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentRepoTest {

    @Autowired
    StudentRepo studentRepo;

    @Test
    public void addStudent()
    {
        Student student = new Student();
        student.setAddress("Hiran magri sec 4");
        student.setEmail("test@testmail.com");
        student.setName("Mohit jain");
        boolean isAdded = studentRepo.add(student);
        assertThat(true).isEqualTo(isAdded);
    }

    @Test
    public void updateStudent()
    {
        Student student = new Student();
        student.setAddress("Hiran magri sec 4");
        student.setEmail("test@testmail.com");
        student.setName("Mohit jain");
        studentRepo.add(student);
        student.setName("Mohit");
         studentRepo.update(student);
    }
}
