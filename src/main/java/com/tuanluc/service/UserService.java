package com.tuanluc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tuanluc.dao.UserDAO;
import com.tuanluc.entities.User;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        return userDAO.findAll();
    }
    public User findById(int id) {
        return userDAO.findById(id);
    }

    public void save(User user){
        // validate business
        userDAO.save(user);
    }
    public void update(User user){
        // validate business
        userDAO.update(user);
    }

    public void delete(int id){
        // validate business
        userDAO.delete(id);
    }
}