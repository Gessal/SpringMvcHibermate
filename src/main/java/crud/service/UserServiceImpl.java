package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getByName(String username) {
        return userDao.getByUserName(username);
    }

    @Transactional
    @Override
    public void set(User user) {
        userDao.set(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> list() {
        return userDao.list();
    }
}
