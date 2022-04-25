package com.phil.checkit.service;

import com.phil.checkit.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    public String saveUser(User user);
    public String updateUser(User user);
    public void deleteUser(Long id);
    public List<User> getAllUsers();


}
