package com.tuanluc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tuanluc.entities.User;
import com.tuanluc.entities.UserMapper;

import java.util.List;

@Repository
@Transactional
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User user) {
        String sql = "INSERT INTO user (user_name, phone_number) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getFullName(), user.getPhoneNumber());
    }
    public void delete(int id) {
        String sql = "DELETE FROM User WHERE id = " + id;
        jdbcTemplate.update(sql);
    }

    public void update(User user) {
        String sql = "UPDATE User SET full_name = ?, phone_number = ? WHERE id = ? ";
        jdbcTemplate.update(sql, user.getFullName(), user.getPhoneNumber(), user.getId());
    }
    public User findById(int id) {
        String sql = "SELECT * FROM User WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }
    public List<User> findAll() {
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}