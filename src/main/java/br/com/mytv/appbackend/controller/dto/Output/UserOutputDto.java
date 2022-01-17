package br.com.mytv.appbackend.controller.dto.Output;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserOutputDto {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserOutputDto(@NotNull @NotEmpty String name, @NotNull @NotEmpty String email) {
        this.name = name;
        this.email = email;
    }

    
}
