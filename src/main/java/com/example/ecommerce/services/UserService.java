package com.example.ecommerce.services;

import com.example.ecommerce.models.User;
import java.util.List;

public interface UserService {

  List<User> queryUsers(User user);

  User getUserById(Long id);

  User addUser(User user);

  User updateUserById(Long id, User user);

  void deleteUserById(Long id);

}
