package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService service;

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/users")
    public String printUsers(ModelMap model) {
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/admin/users")
    public String deleteUser(@RequestParam(name = "id") Long id, ModelMap model) {
        service.delete(id);
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/update")
    public String printUserForUpdate(@RequestParam(name = "id") Long id, ModelMap model) {
        User user = service.get(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/admin/update")
    public String updateUser(@RequestParam(name = "id") Long id, @RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password, @RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname, @RequestParam(name = "age") byte age,
                             @RequestParam(name = "age") byte enabled, ModelMap model) {
        service.set(new User(id, username, password, name, surname, age, enabled));
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/add")
    public String printAddUser(ModelMap model) {
        return "add";
    }

    @PostMapping("/admin/add")
    public String AddUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,
                          @RequestParam(name = "name") String name, @RequestParam(name = "surname") String surname,
                          @RequestParam(name = "age") byte age,ModelMap model) {
        service.add(new User(username, password, name, surname, age));
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }
}
