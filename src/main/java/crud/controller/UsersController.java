package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    UserService service;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String printUsers(ModelMap model) {
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(name = "id") Long id, ModelMap model) {
        service.delete(id);
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String printUserForUpdate(@RequestParam(name = "id") Long id, ModelMap model) {
        User user = service.get(id);
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "id") Long id, @RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname, @RequestParam(name = "age") byte age, ModelMap model) {
        service.set(new User(id, name, surname, age));
        List<User> users = service.list();
        model.addAttribute("users", users);
        return "users";
    }
}
