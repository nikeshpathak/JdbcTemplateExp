package com.example.jdbctempalte.JdbcTemplateExp;

import com.example.jdbctempalte.dto.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by nikeshpathak on 22/07/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentAddTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void add()
    {
            Student student = new Student();
            student.setAddress("Hiran magri sec 4");
            student.setEmail("test@testmail.com");
            student.setName("Mohit jain2");
            clearIfAlreadyExist(student.getEmail());
            ResponseEntity body = this.restTemplate.postForEntity("/student", student, Object.class);
            assertThat(body.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    public void clearIfAlreadyExist(String email)
    {
        ResponseEntity body = this.restTemplate.getForEntity("/student?email="+email ,ResponseEntity.class);
        if(body.getBody() !=null) {
            Student student = (Student) body.getBody();
            this.restTemplate.delete("/student?email=" + email);
        }

    }
}
