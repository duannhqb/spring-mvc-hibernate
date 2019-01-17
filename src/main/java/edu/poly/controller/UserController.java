package edu.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.entity.User;
import edu.poly.model.UserDTO;
import edu.poly.service.UserService;
import edu.poly.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/danh-sach-user", "/" })
	public String getAllUsers(Model model) {
		List<UserDTO> listUsers = userService.getAllUsers();
		model.addAttribute("listUsers", listUsers);

		return "user/listUsers";
	}

	@GetMapping("/them-user")
	public String addUser(Model model) {
		model.addAttribute("user", new User());

		return "user/addUser";
	}

	@PostMapping("/them-user")
	public String addUser(@ModelAttribute("user") UserDTO user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {

			return "user/addUser";
		}
		userService.addUser(user);

		return "redirect:/user/danh-sach-user";
	}

	@GetMapping("/sua-user/{id}")
	public String updateUser(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.getUserById(id));

		return "user/editUser";
	}

	@PostMapping("/sua-user")
	public String updateUser(@ModelAttribute("user") UserDTO user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {

			return "user/editUser";
		}
		userService.updateUser(user);

		return "redirect:/user/danh-sach-user";
	}

	@GetMapping("/info-user/{id}")
	public String infoUser(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.getUserById(id));

		return "user/viewUser";
	}

	@GetMapping("/xoa-user/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/user/danh-sach-user";
	}
}
