package com.kamakhya.controller;

import com.kamakhya.entity.*;
import com.kamakhya.service.ILoginService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ILoginService loginService;

    @PostMapping("/user")
    public ResponseEntity<Void> add(@RequestBody User user) {
        loginService.add(user);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/action")
    public ResponseEntity<Void> add(@RequestBody ActionType actionType) {
        loginService.add(actionType);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/resource")
    public ResponseEntity<Void> add(@RequestBody Resource resource) {
        loginService.add(resource);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/permission")
    public ResponseEntity<Void> add(@RequestBody Permission permission) {
        loginService.add(permission);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/role")
    public ResponseEntity<Void> add(@RequestBody Role role) {
        loginService.add(role);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/hasPermission")
    public ResponseEntity<Boolean> hasPermission(@RequestParam int userId, @RequestParam int actionTypeId, @RequestParam int resourceId) {
        Boolean flag = loginService.hasPermission(userId, actionTypeId, resourceId);
        HttpHeaders headers = new HttpHeaders();
        if (flag) {
            headers.set("hasPermission", flag.toString());
            return new ResponseEntity<Boolean>(headers, HttpStatus.OK);
        }
        else{
            headers.set("hasPermission", flag.toString());
            return new ResponseEntity<Boolean>(headers, HttpStatus.NO_CONTENT);
        }
    }

}
