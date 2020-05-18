package crud.controller;

import crud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<User> users = new ArrayList<>();
        users.add(new User("name1", "surname1", (byte) 1));
        users.add(new User("name2", "surname2", (byte) 2));
        users.add(new User("name3", "surname3", (byte) 3));
        users.add(new User("name4", "surname4", (byte) 4));
        users.add(new User("name5", "surname5", (byte) 5));
        model.addAttribute("users", users);
        return "users";
    }
}
