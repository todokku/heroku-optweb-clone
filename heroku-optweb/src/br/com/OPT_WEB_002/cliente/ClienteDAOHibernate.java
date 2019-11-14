package br.com.OPT_WEB_002.cliente;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ClienteDAOHibernate implements ClienteDAO {
	
	public ClienteDAOHibernate() {}

	/**Objeto para iniciar sessão com o banco de dados**/
	private Session session;
	
	/**Método para gravar dados para a tabela cliente**/
	@Override
	public void salvar(Cliente cliente) {
	
		this.session.save(cliente);
		
	}

	/**Método para alterar dados para a tabela cliente**/
	@Override
	public void alterar(Cliente cliente) {
		
		this.session.merge(cliente);
		
	}

	/**Método para carregar dados para a tabela cliente por id_cliente**/
	@Override
	public Cliente carregar(BigInteger id_cliente) {
			
		return (Cliente) this.session.get(Cliente.class, id_cliente);
	}

	/**Método para excluir dados para a tabela cliente**/
	@Override
	public void excluir(Cliente cliente) {
		
		this.session.delete(cliente);
		
	}

	/**Método para listar todos os dados para a tabela cliente**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		
		return this.session.createCriteria(Cliente.class).list();
	}

	/**Método para gravar dados para a tabela cliente**/
	@Override
	public Cliente listarUltimoId() {
		
		String hql = "select tb from cliente tb order by id_cliente desc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setMaxResults(1);
				
		return (Cliente) consulta.uniqueResult();
	}
	
	/**Método para listar dados para a tabela cliente por cod_empresa**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarPorEmpresa(Integer cod_empresa) {
		String hql = "select tb from cliente tb where tb.cod_empresa = :cod_empresa";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
				
		return consulta.list();
	}


	/**Método para carregar dados para a tabela cliente por codigo**/
	@Override
	public Cliente carregarPorCodCliente(String codigo) {
			
		String hql = "select tb from cliente tb where tb.codigo = :codigo";
	
		Query consulta = this.session.createQuery(hql);
		consulta.setString("codigo", codigo);
		
		return (Cliente) consulta.uniqueResult();
		
	}
		
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


	

}
