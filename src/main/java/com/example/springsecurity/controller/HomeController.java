package com.example.springsecurity.controller;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.entities.User;
import com.example.springsecurity.services.groupe.GroupeService;
import com.example.springsecurity.services.role.RoleService;
import com.example.springsecurity.services.user.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final GroupeService groupeService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    public HomeController(UserService userService, GroupeService groupeService, RoleService roleService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.groupeService = groupeService;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @GetMapping(path = {"", "/"})
    public String getHome(Model model){
        User u = new User();
        u.setUsername("Martin");
        u.setPassword(encoder.encode("123456"));

        Role admin = roleService.findById(1L);
        Role user = roleService.findById(2L);



        return "model/home";
    }

    @GetMapping(path = {"/admin"})
    @Secured({"ROLE_ADMIN"})
    public String getAdmin(Model model){

        return "model/admin";
    }
}
