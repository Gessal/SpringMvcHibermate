package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User get(Long id);
    void set(User user);
    void delete(Long id);
    List<User> list();
}
