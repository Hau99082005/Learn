package com.example.learnhub;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BaseController {

    private final JdbcTemplate jdbcTemplate;

    public BaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.print(result);
            return "Kết nối cơ sở dữ liệu thành công!";
        } catch (DataAccessException e) {
            System.out.print("Lỗi: " + e.getMessage());
            return "Lỗi: " + e.getMessage();
        }
    }

    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        try {
            return jdbcTemplate.queryForList("SELECT * FROM users");
        } catch (DataAccessException e) {
            throw new RuntimeException("Lỗi lấy dữ liệu users: " + e.getMessage());
        }
    }

    @GetMapping("/courses")
    public List<Map<String, Object>> getCourses() {
        try {
            return jdbcTemplate.queryForList("SELECT * FROM courses");
        } catch (DataAccessException e) {
            throw new RuntimeException("Lỗi lấy dữ liệu courses: " + e.getMessage());
        }
    }

}