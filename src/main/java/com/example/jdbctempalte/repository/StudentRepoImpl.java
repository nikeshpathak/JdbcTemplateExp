package com.example.jdbctempalte.repository;

import com.example.jdbctempalte.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nikeshpathak on 22/07/17.
 */
@Repository
public class StudentRepoImpl implements StudentRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean add(Student student) {
            jdbcTemplate.update("insert into tbl_student(name,email,address) values(?,?,?)",
                    student.getName(), student.getEmail(), student.getAddress());
        return true;
    }

    @Override
    public boolean update(Student student) {
        jdbcTemplate.update("update tbl_student set name=? and email=? and address=? ",student.getName(),student.getEmail(),student.getAddress());
        return true;
    }

    @Override
    public boolean delete(String email) {
        jdbcTemplate.update("delete tbl_student where email=?",email);
        return true;
    }

    @Override
    public Student get(String email) {
        return jdbcTemplate.queryForObject("select * from tbl_student where email=?", new StudentMapper(), email);
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("select * from tbl_student",new StudentMapper());
    }

    private static final class StudentMapper implements RowMapper<Student> {

        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAddress(rs.getString("address"));
            return student;
        }
    }
}
