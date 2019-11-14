package br.com.OPT_WEB_002.usuario;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;
	private Usuario usuarioExistente;

	public UsuarioRN() {

		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
		
	}
	
	public Usuario login(String login,String senha){
		
		return usuarioDAO.login(login,senha);
		
	}

	public Usuario carregar(BigInteger id_usuario) {

		return this.usuarioDAO.carregar(id_usuario);
	}

	public Usuario buscarPorLogin(String login) {
	
		return this.usuarioDAO.carregarPorLogin(login);

	}

	public void salvar(Usuario usuario) throws DAOException {

		usuario.getPermissao().add("ROLE_ADMINISTRADOR");	
		usuario.setAtivo(true);
		
		this.usuarioDAO.salvar(usuario);					
	}

	public void excluir(Usuario usuario) throws DAOException {

		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {

		return this.usuarioDAO.listar();
	}
	
	public List<Usuario> listarPorCodEmCoFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.usuarioDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}

	public void alterar(Usuario usuario) {

		this.usuarioDAO.alterar(usuario);
		
	}

	/** metodo:verifica o usuario após o login e recupera os dados no banco
	public Usuario carregarLoginDoUsuario() {

		FacesContext ctx = FacesContext.getCurrentInstance();
	
		ExternalContext ext = ctx.getExternalContext();
		String login = ext.getRemoteUser();

		usuarioExistente = buscarPorLogin(login);
			
		return usuarioExistente;

	} **/
	
	public List<Usuario> listarPorCodEmpresa(Integer cod_empresa){
		
		return usuarioDAO.listarPorCodEmpresa(cod_empresa);
	
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Usuario getUsuarioExistente() {
		return usuarioExistente;
	}

	public void setUsuarioExistente(Usuario usuarioExistente) {
		this.usuarioExistente = usuarioExistente;
	}
}
