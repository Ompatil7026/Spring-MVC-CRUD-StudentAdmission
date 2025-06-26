package com.example.dao;

import com.example.annotation.Loggable;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            };

    @Override
    @Loggable
    public void create(Student student) {
        String sql = "INSERT INTO student (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(),
                student.getEmail());
    }

    @Override
    @Loggable
    public Student read(int id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id},
                    studentRowMapper);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Loggable
    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(),
                student.getEmail(), student.getId());
    }

    @Override
    @Loggable
    public void delete(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    @Loggable
    public List<Student> getAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, studentRowMapper);
    }
}