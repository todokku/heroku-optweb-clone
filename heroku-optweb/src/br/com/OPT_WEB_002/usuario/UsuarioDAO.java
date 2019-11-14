package br.com.OPT_WEB_002.usuario;

import java.math.BigInteger;
import java.util.*;
import br.com.OPT_WEB_002.util.DAOException;

public interface UsuarioDAO {

	public void salvar(Usuario usuario) throws DAOException;

	public void alterar(Usuario usuario);

	public void excluir(Usuario usuario) throws DAOException;

	public Usuario carregar(BigInteger id_usuario);

	public Usuario carregarPorLogin(String login);	

	public Usuario carregarPorEmail(String email);
	
	public List<Usuario> listar();	
	
	public List<Usuario> listarPorCodEmpresa(Integer cod_empresa);
	
	public List<Usuario> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public Usuario login(String login,String senha);
	
}
