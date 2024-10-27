package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @RequestMapping("/admin/user/create") // GET method
  public String createUserPage(Model model, @ModelAttribute("newUser") User newUser) {
    return "admin/user/user-create";
  }

  @PostMapping("/admin/user/create")
  public String handleCreateUser(Model model, @ModelAttribute("newUser") User newUser) {
    this.userService.handleSaveUser(newUser);
    return "redirect:/admin/users";
  }

  @RequestMapping("/admin/user/{id}")
  public String getUserDetailPage(Model model, @PathVariable long id) {
    User user = this.userService.getUserById(id);
    model.addAttribute("user", user);
    return "admin/user/user-detail";
  }

  @RequestMapping("/admin/user/{id}/update")
  public String getUpdateUserPage(Model model,
      @ModelAttribute("userUpdate") User userUpdate, @PathVariable long id) {
    User user = this.userService.getUserById(id);
    model.addAttribute("user", user);
    return "admin/user/user-update";
  }

  @PostMapping("/admin/user/{id}/update")
  public String handleUpdateUser(Model model,
      @ModelAttribute("userUpdate") User userUpdate) {
    User user = this.userService.getUserById(userUpdate.getId());

    if (user != null) {
      user.setAddress(userUpdate.getAddress());
      user.setPhone(userUpdate.getPhone());
      user.setUserName(userUpdate.getUserName());
      this.userService.handleSaveUser(user);
    }
    return "redirect:/admin/users";
  }

  @GetMapping("/admin/user/{id}/delete")
  public String handleDeleteUser(Model model,
      @PathVariable long id) {
    this.userService.deleteUserById(id);
    return "redirect:/admin/users";
  }
}