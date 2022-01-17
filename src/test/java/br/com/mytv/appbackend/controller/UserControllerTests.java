package br.com.mytv.appbackend.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver400CasoDadosDeCadastroEstiveremInvalidos() throws Exception {
        URI uri = new URI("/user");
        String json = "{ \"name\": \"\"\"password\":\"123456\", \"copassword\":\"123456\", \"email\": \"marlon@email.com\"  }";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400));
    }


    @Test
    public void deveriaDevolver201CasoDadosDeCadastroEstiveremValidos() throws Exception {
        URI uri = new URI("/user");
        String json = "{ \"name\": \"teste2\",\"password\":\"123456\", \"copassword\":\"123456\", \"email\": \"adm@email.com\"  }";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    public void shouldReturnBadRequestCasePasswordIsDifferent() throws Exception {
        URI uri = new URI("/user");
        String json = "{ \"name\": \"teste2\",\"password\":\"12345\", \"copassword\":\"123456\", \"email\": \"adm@email.com\"  }";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400));
    }


    @Test
    public void shouldReturnBadRequestCaseNameISEmpty() throws Exception {
        URI uri = new URI("/user");
        String json = "{ \"name\": \"\",\"password\":\"12345\", \"copassword\":\"123456\", \"email\": \"adm@email.com\"  }";

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
            .content(json)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is(400));
    }
    
}
