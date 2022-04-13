package com.example.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapi.dto.UserDTO;
import com.example.userapi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/user/")
    public static List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }
    
    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
    	return userService.findById(id);
    }
    	
    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDTO) {
    	return userService.save(userDTO);
    }
    
    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
    	return userService.findbyCpf(cpf);
    }
    
    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable Long id) {
    	return userService.delete(id);
    	
    }
    
    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
    		@RequestParam(name="nome", required=true)
    		String nome){
    	return userService.queryByName(nome);
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
