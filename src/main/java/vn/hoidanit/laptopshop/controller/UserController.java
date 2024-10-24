package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import java.util.List;

@Controller
public class UserController {
  // dependency injection
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/")
  public String getHomePage(Model model) {
    return "index";
  }

  @RequestMapping("/admin/users")
  public String getUserListPage(Model model) {
    List<User> usersList = this.userService.getAllUsers();
    model.addAttribute("usersList", usersList);
    return "admin/user/users";
  }

  @RequestMapping("/admin/user/create")
  public String createUserPage(Model model, @ModelAttribute("newUser") User newUser) {
    return "admin/user/create";
  }

  @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
  public String getUserPage(Model model, @ModelAttribute("newUser") User newUser) {
    this.userService.handleSaveUser(newUser);
    System.out.println(newUser);
    // return "redirect:admin/users";
    return "index";
  }
}