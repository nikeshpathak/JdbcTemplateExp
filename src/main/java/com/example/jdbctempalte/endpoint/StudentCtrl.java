package com.example.jdbctempalte.endpoint;

import com.example.jdbctempalte.dto.Student;
import com.example.jdbctempalte.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nikeshpathak on 22/07/17.
 */

@RestController
@RequestMapping("/student")
public class StudentCtrl {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/check")
    public String check()
    {
        return "Hello World";
    }


    @PostMapping
    public ResponseEntity<String> add(@RequestBody Student student) throws Exception
    {
        ResponseEntity responseEntity;
                studentService.add(student);
                responseEntity = new ResponseEntity("Success",HttpStatus.OK);
            return responseEntity;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Student student) throws Exception
    {
        ResponseEntity responseEntity;
        studentService.update(student);
        responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("email") String email) throws Exception
    {
        ResponseEntity responseEntity;
        studentService.delete(email);
        responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity get(@RequestParam("email") String email) throws Exception
    {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(studentService.get(email), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAll(String email) throws Exception
    {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity(studentService.getAll(), HttpStatus.OK);
        return responseEntity;
    }
}
