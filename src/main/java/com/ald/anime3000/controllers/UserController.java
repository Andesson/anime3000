package com.ald.anime3000.controllers;

import com.ald.anime3000.Services.UsersService;
import com.ald.anime3000.dtos.UsersDto;
import com.ald.anime3000.models.user.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UsersService usersService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping()
    public ResponseEntity<Page<UserModel>> getAll(Pageable pageable){
        return new ResponseEntity<>(usersService.findAll(pageable), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public ResponseEntity<UserModel> save(@RequestBody @Valid UsersDto usersDto){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(usersDto,userModel);
        usersService.saveUsers(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
}
