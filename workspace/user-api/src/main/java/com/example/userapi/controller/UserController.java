package com.example.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapi.dto.UserDTO;

@RestController
public class UserController {
	
    @GetMapping("/users")
    public static List<UserDTO> getUsers() {
        return usuarios;
    }
    
    @GetMapping("/users/{cpf}")
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
    	for(UserDTO userFilter:usuarios) {
    		if(userFilter.getCpf().equals(cpf)) {
    			return userFilter;
    		}
    	}
    	return null;
    }
    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO) {
    	userDTO.setDataCadastro(new Date());
    	usuarios.add(userDTO);
    	return userDTO;
    }
    
    @DeleteMapping("/user/{cpf}")
    public boolean remover(@PathVariable String cpf) {
    	for(UserDTO userFilter:usuarios) {
    		if(userFilter.getCpf().equals(cpf)) {
    			usuarios.remove(userFilter);
    			return true;
    		}
    	}
    	return false;
    }

    public static List<UserDTO> usuarios = new ArrayList<>();

    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("matheus");
        userDTO.setCpf("083");
        userDTO.setEndereco("chibatolandia");
        userDTO.setEmail("fewfew");
        userDTO.setTelefone("frfe");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO.setNome("matheus");
        userDTO.setCpf("083");
        userDTO.setEndereco("chibatolandia");
        userDTO.setEmail("fewfew");
        userDTO.setTelefone("frfe");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO.setNome("matheus");
        userDTO.setCpf("083");
        userDTO.setEndereco("chibatolandia");
        userDTO.setEmail("fewfew");
        userDTO.setTelefone("frfe");
        userDTO.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

}
