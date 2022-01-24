package br.com.mytv.appbackend.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mytv.appbackend.controller.dto.Input.UserForm;
import br.com.mytv.appbackend.controller.dto.Output.UserOutputDto;
import br.com.mytv.appbackend.model.User;
import br.com.mytv.appbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserOutputDto convertUsertoUserOutputDto(User user) {
        return new UserOutputDto(user.getUserName(), user.getEmail());
    }

    public UserOutputDto saveUser(UserForm userForm) throws Exception {
        try {
            log.info("saving...user");
            User user = parseUserFormToUser(userForm);
            User userCreated = this.userRepository.save(user);
            log.info("save executed with success!");
            return this.convertUsertoUserOutputDto(userCreated);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private User parseUserFormToUser(UserForm userForm) throws Exception {

        String password = userForm.getPassword();
        String confPassword = userForm.getConfPassword();

        try {
            if (this.ValidPassword(password, confPassword)) {
                log.info("Parsing userForm to User");
                return new User(
                        userForm.getEmail(),
                        userForm.getName(),
                        userForm.getPassword());
            }
            return null;
        } catch (Exception e) {
            log.error("Erro in password", e);
            throw new Exception("The password is diferent", e);
        }

    }

    private boolean ValidPassword(String password, String confPassword) {
        return password.equals(confPassword);
    }

    public String parsePasswordToSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);
        return encoded;

    }

    public String parseSHA256ToPassword(String password) {
        byte[] hash = Base64.getDecoder().decode(password);
        BigInteger number = new BigInteger(1, hash);
        /* Convert the digest into hex value */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Pad with leading zeros */
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
}
