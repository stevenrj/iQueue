package br.com.sampaioimportacoes.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sampaioimportacoes.domain.Usuario;
import br.com.sampaioimportacoes.service.UsuarioService;

@Path("/usuario")
@Component
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@GET
	@Path("/logar")
	public boolean logar(Usuario usuario){
		return usuarioService.logar(usuario);
	}
	
	@GET
	@Path("/buscarusuario/{id}")
	@Produces("application/json")
	public Usuario buscarUsuario(@PathParam("id") int id){
		//Gson g = new Gson();
		return usuarioService.buscarUsuario(id);
	}
}
