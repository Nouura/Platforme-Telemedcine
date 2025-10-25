package com.mycompany.platforme_telemedcine.Controller;

import com.mycompany.platforme_telemedcine.Models.User;
import com.mycompany.platforme_telemedcine.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserContoller {
    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "add_User";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userForm") User user) {
        userService.createUser(user);
        return "redirect:/allUsers";
    }

    @RequestMapping("/allUsers")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listusers", users);
        return "all_Users";
    }

    @GetMapping("/editUser/{id}")
    public String showupdateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update_User";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id, User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update_User";
        }
        userService.updateUser(user);
        return "redirect:/all_Users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/all_Users";
    }

}
