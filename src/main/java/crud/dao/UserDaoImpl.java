package crud.dao;

import crud.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        String password = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User get(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public User getByUserName(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where username = :username");
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public void set(User user) {
        User u = sessionFactory.getCurrentSession().get(User.class, user.getId());
        u.setUsername(user.getUsername());
        String password = user.getPassword();
        if (!(password == null) && !password.equals("")) {
            u.setPassword(new BCryptPasswordEncoder().encode(password));
        }
        u.setName(user.getName());
        u.setSurname(user.getSurname());
        u.setAge(user.getAge());
        u.setEnabled(user.getEnabled());
        u.setRoles(user.getRoles());
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public void delete(Long id) {
         TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("DELETE User WHERE id = :id");
         query.setParameter("id", id);
         query.executeUpdate();
    }

    @Override
    public List<User> list() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        List<User> users = query.getResultList();
        return users;
    }
}
