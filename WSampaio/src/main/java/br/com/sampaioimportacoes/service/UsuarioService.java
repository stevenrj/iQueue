package br.com.sampaioimportacoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.sampaioimportacoes.dao.UsuarioDAO;
import br.com.sampaioimportacoes.domain.Usuario;

@Component
public class UsuarioService {
 
	@Autowired
	private UsuarioDAO dao;
	
	public boolean logar(Usuario usuario){
		return dao.logar(usuario);
	}
	
	public Usuario buscarUsuario(long id){
		return dao.buscarUsuarioPorId(id);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean cadastrarUsuario(Usuario usuario){
		dao.saveOrUpdate(usuario);
		return true;
	}
}
