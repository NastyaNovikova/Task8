package com.example.task8.controller;

import com.example.task8.model.User;
import com.example.task8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String getAllUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("{id}")
    public String getUserById(@PathVariable ("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getUserById(id));
        return "show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String edit(ModelMap modelMap, @PathVariable ("id") long id){
        modelMap.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") User user, @PathVariable ("id") Long id){
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") Long id){
        userService.removeUser(id);
        return "redirect:/";
    }




}
