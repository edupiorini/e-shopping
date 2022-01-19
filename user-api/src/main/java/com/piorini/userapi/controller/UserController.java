package com.piorini.userapi.controller;

import com.piorini.userapi.dto.UserDTO;
import com.piorini.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {

        return userService.getAll();
    }

//    public static List<UserDTO> users = new ArrayList<UserDTO>();

//    @PostConstruct
//    public void initiateList(){
//        // User 1
//        UserDTO userDTO = new UserDTO();
//        userDTO.setName("Eduardo");
//        userDTO.setEmail("edupiorini@spring.com");
//        userDTO.setAddress("rua spring, 95, taubate");
//        userDTO.setCpf("12345678901");
//        userDTO.setPhoneNumber("12999995555");
      //  userDTO.setCreationDate(new Date());
//
//        // User 2
//        UserDTO userDTO2 = new UserDTO();
//        userDTO2.setName("Laura");
//        userDTO2.setEmail("laurapiorini@spring.com");
//        userDTO2.setAddress("rua spring, 96, taubate");
//        userDTO2.setCpf("12345678902");
//        userDTO2.setPhoneNumber("12999995556");
//        userDTO2.setCreationDate(new Date());
//
//        // User 3
//        UserDTO userDTO3 = new UserDTO();
//        userDTO3.setName("Melissa");
//        userDTO3.setEmail("melpiorini@spring.com");
//        userDTO3.setAddress("rua spring, 97, taubate");
//        userDTO3.setCpf("12345678903");
//        userDTO3.setPhoneNumber("12999995557");
//        userDTO3.setCreationDate(new Date());
//
//        // Add to list users
//        users.add(userDTO);
//        users.add(userDTO2);
//        users.add(userDTO3);
//
//    }


    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name= "name", required = true) String name) {
        return userService.queryByName(name);
    }
//    @GetMapping("/users/{cpf}")
//    public UserDTO getUsersFilter(@PathVariable String cpf) {
//        for (UserDTO userFilter : users) {
//            if (userFilter.getCpf().equals(cpf)) {
//                return userFilter;
//            }
//        }
//             return null;
//    }
//
//    @PostMapping("/newUser")
//    public UserDTO insert(@RequestBody UserDTO userDTO) {
//        userDTO.setCreationDate(new Date());
//        users.add(userDTO);
//
//        return userDTO;
//    }
//
//    @DeleteMapping("/users/{cpf}")
//    public boolean remove(@PathVariable String cpf) {
//        boolean status = false;
//        for (UserDTO userFilter : users ) {
//            if (userFilter.getCpf().equals(cpf)) {
//                users.remove(userFilter);
//                status = true;
//            }
//        }
//        return status;
//    }
}
