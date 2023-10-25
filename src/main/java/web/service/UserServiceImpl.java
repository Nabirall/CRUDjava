package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


private final UserDao userDao;

@Autowired
public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
}

@Override
public List<User> getUsers() {
    return userDao.getUsers();
}

@Override
public void addUser(User user) {
    userDao.addUser(user);
}

@Override
public User getSingleUserById(Long id) {
    return userDao.getSingleUserById(id);
}

@Override
public void update(User user){
    userDao.update(user);
}

@Override
public void delete(Long id) {
    userDao.delete(id);
}


}