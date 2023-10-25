package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

List<User> getUsers();

void addUser(User user);

User getSingleUserById(Long id);

void update(User user);

void delete(Long id);

}

