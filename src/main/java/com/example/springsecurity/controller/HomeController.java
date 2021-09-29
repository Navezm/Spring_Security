package com.example.springsecurity.controller;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.entities.User;
import com.example.springsecurity.entities.UserRole;
import com.example.springsecurity.repositories.UserRepository;
import com.example.springsecurity.repositories.UserRoleRepository;
import com.example.springsecurity.services.groupe.GroupeService;
import com.example.springsecurity.services.role.RoleService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    private final UserRepository userService;
    private final GroupeService groupeService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;
    private final UserRoleRepository urRepo;

    public HomeController(UserRepository userService, GroupeService groupeService, RoleService roleService, BCryptPasswordEncoder encoder, UserRoleRepository urRepo) {
        this.userService = userService;
        this.groupeService = groupeService;
        this.roleService = roleService;
        this.encoder = encoder;
        this.urRepo = urRepo;
    }

    @GetMapping(path = {"", "/"})
    public String getHome(Model model){
//        User u = new User();
//        u.setUsername("Martin");
//        u.setPassword(encoder.encode("123456"));

//        Role admin = roleService.findById(1L);
//        Role user = roleService.findById(2L);
//
//        User u = userService.findById(3L).get();
//
//        u = userService.save(u);
//
//        UserRole urAdmin = new UserRole(u, admin);
//        UserRole urUser = new UserRole(u, user);
//        urRepo.save(urAdmin);
//        urRepo.save(urUser);

//        userService.save(u);

        return "model/home";
    }

    @GetMapping(path = {"/admin"})
    @Secured({"ROLE_ADMIN"})
    public String getAdmin(Model model){

        return "model/admin";
    }
}
