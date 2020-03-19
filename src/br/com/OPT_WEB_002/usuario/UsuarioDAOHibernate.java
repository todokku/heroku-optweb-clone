package br.com.OPT_WEB_002.usuario;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.util.DAOException;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private org.hibernate.Session session;

	@Override
	public void salvar(Usuario usuario) throws DAOException {

		try {
				
			this.session.save(usuario);

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
		
			throw new DAOException("Id usuário já foi cadastrado!",e);

		}
	}

	@Override
	public void alterar(Usuario usuario) {
			
	
		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
						
			Usuario usuarioPermissao = this.carregar(usuario.getId_usuario());
			usuario.setPermissao(usuarioPermissao.getPermissao());
      
			this.session.evict(usuarioPermissao);
			
			
		}
		this.session.saveOrUpdate(usuario);
	}
	
	@Override
	public void excluir(Usuario usuario) throws DAOException {

		try {

			this.session.delete(usuario);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();
			throw new DAOException("Item relacionado com outra tabela", e);

		}

	}

	@Override
	public Usuario carregar(BigInteger id_usuario) {
	
		String hql = "select tb from usuario tb where tb.id_usuario = :id_usuario";
		Query consulta = this.session.createQuery(hql);
		consulta.setBigInteger("id_usuario",id_usuario);
				
		Usuario usuario = new Usuario();
		
		Filial filial = new Filial();
		
		usuario.setCod_filial(filial);
		
		usuario = (Usuario) consulta.uniqueResult();
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {

		String hql = "select tb from usuario tb";
		Query consulta = this.session.createQuery(hql);
				
		return consulta.list();

	}

	@Override
	public Usuario carregarPorLogin(String login) {

		String hql = "select u from usuario u where u.login = :login";
		
	    Query consulta = this.session.createQuery(hql);
	   
		consulta.setString("login", login);
		
		return (Usuario) consulta.uniqueResult();

	}


	@Override
	public Usuario carregarPorEmail(String email) {
		
		String hql = "select u from usuario u where u.email = :email";
		
		Query consulta = this.session.createQuery(hql);
	
		consulta.setString("email", email);
				
		return (Usuario) consulta.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		String hql = "select tb from usuario tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarPorCodEmpresa(Integer cod_empresa) {
		

		String hql = "select tb from usuario tb where tb.cod_empresa = :cod_empresa";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		
		return consulta.list();
	
	}
	
	@Override
	public Usuario login(String login, String senha){
		
		String hql = "select tb from usuario tb where tb.login = :login and tb.senha = :senha";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setString("login",login);
		consulta.setString("senha",senha);
		
		return (Usuario) consulta.uniqueResult();
		
	}

	
	
	public void setSession(org.hibernate.Session session) {
		this.session = session;
	}

	public org.hibernate.Session getSession() {
		return session;
	}

	

	


}
