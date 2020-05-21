package crud.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public Role(Long id, User user, String role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /* Переопределяю метод интерфейса GrantedAuthority,
    *  который возрващает роль пользователя из базы.
    *  Роли в базе записаны как ROLE_ADMIN и ROLE_USER,
    *  т.к. ROLE_ - это префикс по умолчанию.*/
    @Override
    public String getAuthority() {
        return role;
    }
}
