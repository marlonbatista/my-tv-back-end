package br.com.mytv.appbackend.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mytv.appbackend.config.security.TokenService;
import br.com.mytv.appbackend.controller.dto.Input.LoginForm;
import br.com.mytv.appbackend.controller.dto.Output.TokenDto;



@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm loginForm) throws NoSuchAlgorithmException {
        // loginForm.setPassword(this.userService.parsePasswordToSHA256(loginForm.getPassword()));
        UsernamePasswordAuthenticationToken loginData = loginForm.parse();
        try {
        	Authentication authentication = authManager.authenticate(loginData);
        	String token = tokenService.tokenGeration(authentication);

             return ResponseEntity.ok(new TokenDto(token, "Bearer"));

         } catch (Exception e) {
             return ResponseEntity.badRequest().build();
         }
     }
}
