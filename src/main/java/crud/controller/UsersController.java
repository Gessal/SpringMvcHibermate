package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    public String printUsers(ModelMap model) {
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users")
    public String deleteUser(@RequestParam(name = "id") Long id, ModelMap model) {
        service.delete(id);
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/update")
    public String printUserForUpdate(@RequestParam(name = "id") Long id, ModelMap model) {
        User user = service.get(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam(name = "id") Long id, @RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname, @RequestParam(name = "age") byte age, ModelMap model) {
        service.set(new User(id, name, surname, age));
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String printAddUser(ModelMap model) {
        return "add";
    }

    @PostMapping("/add")
    public String AddUser(@RequestParam(name = "name") String name, @RequestParam(name = "surname") String surname,
                          @RequestParam(name = "age") byte age,ModelMap model) {
        service.add(new User(name, surname, age));
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }
}
