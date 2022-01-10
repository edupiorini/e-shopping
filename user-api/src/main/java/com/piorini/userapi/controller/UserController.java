package com.piorini.userapi.controller;

import com.piorini.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage(){
        return "Spring is working!";
    }

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList(){
        // User 1
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setEmail("edupiorini@spring.com");
        userDTO.setAdress("rua spring, 95, taubate");
        userDTO.setCpf("12345678901");
        userDTO.setPhoneNumber("12999995555");
        userDTO.setDataCadastro(new Date());

        // User 2
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Laura");
        userDTO2.setEmail("laurapiorini@spring.com");
        userDTO2.setAdress("rua spring, 96, taubate");
        userDTO2.setCpf("12345678902");
        userDTO2.setPhoneNumber("12999995556");
        userDTO2.setDataCadastro(new Date());

        // User 3
        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Melissa");
        userDTO3.setEmail("melpiorini@spring.com");
        userDTO3.setAdress("rua spring, 97, taubate");
        userDTO3.setCpf("12345678903");
        userDTO3.setPhoneNumber("12999995557");
        userDTO3.setDataCadastro(new Date());

        // Add to list users
        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);

    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFilter(@PathVariable String cpf) {
        for (UserDTO userFilter : users) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
             return null;
    }
}
