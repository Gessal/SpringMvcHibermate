package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User get(Long id);
    void set(User user);
    void delete(Long id);
    List<User> list();
    User getByName(String username);
}
