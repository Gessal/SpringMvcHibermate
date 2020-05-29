package crud.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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