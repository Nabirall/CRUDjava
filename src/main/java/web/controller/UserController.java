package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

private final UserService userService;

@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}


@GetMapping(value = "/")
public String showAllUsers(ModelMap model) {
    List<User> list = userService.getUsers();
    model.addAttribute("listUsers", list);
    return "index";
}

@GetMapping(value = "/show_single_user")
public String showSingleUser (@RequestParam(value = "id") Long id, Model model) {
    model.addAttribute("user", userService.getSingleUserById(id));
    return "show_user";
}

@GetMapping("/add_user")
public String addUser(Model model){
    model.addAttribute("user", new User());
    return "add_user";
}

@PostMapping()
public String createNewUser(@ModelAttribute("user") User user){
    userService.addUser(user);
    return "redirect:/";
}

@GetMapping("/edit_user")
public String edit(@RequestParam(value = "id") Long id, Model model) {
    model.addAttribute("user", userService.getSingleUserById(id));
    return "edit_user";
}
@PatchMapping("/save_edit_user")
public String updateUser(@ModelAttribute("user") User user) {
    userService.update(user);
    return "redirect:/";
}

@GetMapping(value = "/delete_user")
public String deleteUser (@RequestParam(value = "id") Long id, Model model) {
    userService.delete(id);
    return "redirect:/";
}

}