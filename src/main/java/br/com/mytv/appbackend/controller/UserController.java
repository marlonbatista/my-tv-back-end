package br.com.mytv.appbackend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mytv.appbackend.controller.dto.Input.UserForm;
import br.com.mytv.appbackend.controller.dto.Output.UserOutputDto;
import br.com.mytv.appbackend.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
    

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserOutputDto> cadastrar(@RequestBody @Valid UserForm userInput) throws Exception {
        try {
            UserOutputDto  user = userService.saveUser(userInput);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }   
}
