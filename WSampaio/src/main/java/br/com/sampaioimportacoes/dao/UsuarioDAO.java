package br.com.sampaioimportacoes.dao;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import br.com.sampaioimportacoes.domain.Usuario;

@Component
public class UsuarioDAO extends HibernateDAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

	/*
	 * public static UsuarioDAO getInstance(){ if (instance == null){ instance =
	 * new UsuarioDAO(); } return instance; }
	 */

	public boolean logar(Usuario usuario){
		boolean resultado = false;
		String usuarioDigitado = usuario.getUsuario().toString();
		String senhaDigitada = usuario.getSenha().toString();
		String senhaBD = null;
		
		// Busca usuario no banco
		Usuario u = getSession().load(Usuario.class, usuarioDigitado);
		
		// Recupera a senha do usuario cadastrada no banco
		senhaBD = u.getSenha();
		
		// Verifica se a senha é válida
		if (BCrypt.checkpw(senhaDigitada, senhaBD)){
			resultado = true;
		}
		
		return resultado;
	}

	public void cadastrarUsuario(Usuario usuario) {
		super.save(usuario);
		/*
		 * Connection conexao = criarConexao(); PreparedStatement pstmt = null;
		 * ResultSet rs = null;
		 * 
		 * String usuarioDigitado = usuario.getUsuario().toString(); String
		 * senhaDigitada = usuario.getSenha().toString(); String nomeDigitado =
		 * usuario.getNome().toString(); String sobrenomeDigitado =
		 * usuario.getSobrenome().toString(); String cpfDigitado =
		 * usuario.getCpf().toString(); String emailDigitado =
		 * usuario.getEmail().toString(); String celularDigitado =
		 * usuario.getCelular().toString();
		 * 
		 * try { pstmt = conexao.prepareStatement("insert into usuario " +
		 * "(usuario, senha, nome, sobrenome, cpf, email, celular) " + "values "
		 * + "(?, ?, ?, ?, ?, ?, ?"); pstmt.setString(1, usuarioDigitado);
		 * String hashed = BCrypt.hashpw(senhaDigitada, BCrypt.gensalt());
		 * pstmt.setString(2, hashed); pstmt.setString(3, nomeDigitado);
		 * pstmt.setString(4, sobrenomeDigitado); pstmt.setString(5,
		 * cpfDigitado); pstmt.setString(6, emailDigitado); pstmt.setString(7,
		 * celularDigitado);
		 * 
		 * rs = pstmt.executeQuery(); } catch (Exception e) {
		 * System.out.println("Erro ao cadastrar usu�rio.");
		 * e.printStackTrace(); }
		 */
	}

	public Usuario buscarUsuarioPorId(long id) {
		return super.get(id);
		/*
		 * Connection conexao = criarConexao(); PreparedStatement pstmt = null;
		 * ResultSet rs = null; Usuario usuario = null; try { String query =
		 * "select * from usuario u where _id = " + id; pstmt =
		 * conexao.prepareStatement(query); rs = pstmt.executeQuery();
		 * 
		 * if (rs.next()){ usuario = new Usuario();
		 * usuario.setUsuario(rs.getString("usuario"));
		 * usuario.setCelular(rs.getString("celular"));
		 * usuario.setCpf(rs.getString("cpf"));
		 * usuario.setEmail(rs.getString("email"));
		 * usuario.setNome(rs.getString("nome"));
		 * usuario.setSobrenome(rs.getString("sobrenome")); }
		 * 
		 * } catch (Exception e) { // TODO: handle exception System.out.println(
		 * "Erro ao buscar o usuario: " + id); e.printStackTrace(); }finally {
		 * fecharConexao(conexao, pstmt, rs); } return usuario;
		 */
	}
}
