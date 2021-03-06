package br.com.mytv.appbackend.controller.dto.Input;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserForm {

    @NotEmpty
    @NotNull
    @Length(min = 3, max = 255)
    private String name;
    @NotEmpty
    @NotNull
    @Length(min = 3, max = 255)
    private String password;
    @NotEmpty
    @NotNull
    @Length(min = 3, max = 255)
    private String confPassword;
    @NotEmpty
    @NotNull
    @Length(min = 3, max = 255)
    private String email;


    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}