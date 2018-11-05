package br.com.driveme.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.driveme.dao.GenericDao;
import br.com.driveme.entity.Peca;
import br.com.driveme.entity.TipoUsuario;
import br.com.driveme.entity.Usuario;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class UsuarioBusiness {

	@Autowired
	GenericDao<Usuario> dao;
	
	public ServiceResponse save(Usuario usuario) {
		
		Map<String, Object> result = new HashMap<>();
		
		if(usuario.getUsuaEmail() == null || usuario.getUsuaEmail().equals(""))
			return new ServiceResponse(ResponseType.VALIDATION,"Email n�o enviado","Email n�o enviado",result);

		if(usuario.getUsuaSenha() == null || usuario.getUsuaSenha().equals(""))
			return new ServiceResponse(ResponseType.VALIDATION,"Senha n�o enviada","Senha n�o enviada",result);
		
		if(usuario.getUsuaNome() == null || usuario.getUsuaNome().equals(""))
			return new ServiceResponse(ResponseType.VALIDATION,"Nome n�o enviado","Nome n�o enviado",result);
		
		try {
			List<Usuario> usuarios = dao.list();
			for(Usuario u : usuarios) {
				if(u.getUsuaEmail().equals(usuario.getUsuaEmail())) {
					result.put("usuario", u);
					return new ServiceResponse(ResponseType.VALIDATION, "Usu�rio j� existente", "Usu�rio j� existente", result);
				}
			}
			usuario.setTipoUsuario(new TipoUsuario(3, ""));
			dao.save(usuario);
			for(Usuario u : usuarios) {
				if(u.getUsuaEmail().equals(usuario.getUsuaEmail())) {
					if(u.getUsuaSenha().equals(usuario.getUsuaSenha())) {						
						result.put("usuario", u);
						return new ServiceResponse(ResponseType.SUCCESS, "Usu�rio cadastrado com sucesso", "Usu�rio cadastrado com sucesso", result);
					}
				}
			}
			result.put("usuario", usuario);
			return new ServiceResponse(ResponseType.SUCCESS, "Usu�rio cadastrado com sucesso", "Usu�rio cadastrado com sucesso", result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.SUCCESS, "Erro ao obter usu�rio", e.getMessage(), result);
		}
		
	}
	
	public void delete(Usuario u) {
		dao.delete(u);
	}
	
	public void update(Usuario u) {
		dao.update(u);
	}
	
	public Usuario findById(Long id) {
		return dao.findById(id);
	}
	
	public ServiceResponse list(){
		dao.list();
		return new ServiceResponse(ResponseType.SUCCESS,"","",null);
	}
	
	public List<Usuario> listAll(){
		
		List<Usuario> usuarios = dao.list();
		List<Usuario> usuarios1 = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < usuarios.size(); j++) {
				if(i == usuarios.get(j).getUsuaId()) {
					usuarios1.add(usuarios.get(j));
					break;						
				}
			}
		}
		
		return usuarios1;
	}

	public ServiceResponse login(String email, String senha){
		
		Map<String, Object> result = new HashMap<>();
		
		if(email == null || email.equals(""))
			return new ServiceResponse(ResponseType.VALIDATION,"Email n�o enviado","Email n�o enviado",result);

		if(senha == null || senha.equals(""))
			return new ServiceResponse(ResponseType.VALIDATION,"Senha n�o enviada","Senha n�o enviada",result);
		
		try {
			List<Usuario> usuarios = dao.list();
			for(Usuario u : usuarios) {
				if(u.getUsuaEmail().equals(email)) {
					if(u.getUsuaSenha().equals(senha)) {						
						result.put("usuario", u);
						return new ServiceResponse(ResponseType.SUCCESS, "Usu�rio obtido com sucesso", "Usu�rio obtido com sucesso", result);
					}
				}
			}
			return new ServiceResponse(ResponseType.SUCCESS,"Nenhum usu�rio encontrado","Nenhum usu�rio encontrado",result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponse(ResponseType.SUCCESS, "Erro ao obter usu�rio", e.getMessage(), result);
		}

	}
}
