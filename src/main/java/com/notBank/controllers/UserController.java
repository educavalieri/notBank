package com.notBank.controllers;

import com.notBank.dtos.UserDto;
import com.notBank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) throws Exception {
        UserDto dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable("email") String email) throws Exception {
        UserDto dto = userService.findByEmail(email);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> dtos = userService.findAll();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        UserDto userDto = userService.save(dto);
        return ResponseEntity.ok().body(userDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{update}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto){
        UserDto userDto = userService.update(dto);
        return ResponseEntity.ok().body(userDto);
    }
}
