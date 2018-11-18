package br.com.driveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.driveme.business.UsuarioBusiness;
import br.com.driveme.entity.Usuario;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioBusiness business;
	
	@GetMapping(value = {"/usuarios", "/usuarios/{id}"})
	public ServiceResponse getUsuarios(@PathVariable (name = "id", required = false) Long id) {
		return business.list();
	}
	
	@PostMapping(value = {"usuarios"})
	public ServiceResponse postUsuario(@RequestBody Usuario usuario) {
		return business.save(usuario);
	}
	
	@GetMapping(value = {"/usuarios/{email}/{senha}"})
	public ServiceResponse login(@PathVariable (name = "email", required = true) String email, @PathVariable (name = "senha", required = true) String senha) {
		return business.login(email, senha);
	}

}
