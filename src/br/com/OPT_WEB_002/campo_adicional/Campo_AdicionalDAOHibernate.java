package br.com.OPT_WEB_002.campo_adicional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;

import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.HibernateUtil;

public class Campo_AdicionalDAOHibernate implements Campo_AdicionalDAO {
	
	public Campo_AdicionalDAOHibernate() {}

	/**Objeto para iniciar sessão com o banco de dados**/
	private Session session;

	/**Método para gravar dados para a tabela campo adicional**/
	@Override
	public void salvar(Campo_Adicional campoAdicional) throws DAOException {

		try {

			this.session.clear();
			this.session.save(campoAdicional);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();

			throw new DAOException("ID Campo Adicional já foi cadastrado!", e);

		}

	}

	/**Método para alterar dados para a tabela campo adicional**/
	@Override
	public void alterar(Campo_Adicional campoAdicional) {

		this.session.clear();
		this.session.update(campoAdicional);
		this.session.flush();
	}

	/**Método para excluir dados para a tabela campo adicional**/
	@Override
	public void excluir(Campo_Adicional campoAdicional) throws DAOException {

		try {

			this.session.clear();
			this.session.delete(campoAdicional);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();

			throw new DAOException("Item relacionado com outra tabela", e);
		}
	}

	/**Método para carregar dados para a tabela campo adicional por id_camp_adic,cod_empresa,cod_filial e unidade negocio**/
	@Override
	public Campo_Adicional carregar(BigInteger id_camp_adic, Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {

		String hql = "select tb from campo_adicional tb where tb.id_camp_adic = :id_camp_adic and cod_empresa = :cod_empresa and cod_filial = :cod_filial and cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_camp_adic", id_camp_adic);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return (Campo_Adicional) consulta.uniqueResult();
	}

	/**Método para listar todos dados para a tabela campo adicional**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Campo_Adicional> listar() {

		return this.session.createCriteria(Campo_Adicional.class).list();
	}

	/**Método para gravar dados para a tabela campo adicional por id_transacao,cod_empresa,cod_filial e cod_unidade**/
	@SuppressWarnings("unchecked")
	public List<Campo_Adicional> listarPorIdTransacao(Integer id_transacao, Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {

		String hql = "select tb from campo_adicional tb where tb.id_transacao = :id_transacao and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("id_transacao", id_transacao);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();

	}

	/**Método para listar dados para a tabela campo adicional por cod_empresa,cod_filial e cod_unidade**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Campo_Adicional> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {

		String hql = "select ca from campo_adicional ca where ca.cod_empresa = :cod_empresa and ca.cod_filial = :cod_filial and ca.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();
	}
	
	/**Método para listar dados para a tabela campo adicional por id_transacao**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Campo_Adicional> listarPorIdTransCodEmCodFiCodUni(BigInteger id_transacao) {
			
		String hql = "select ca from campo_adicional ca where ca.id_transacao = :id_transacao";
	
		Query consulta = session.createQuery(hql);
		
		consulta.setBigInteger("id_transacao", id_transacao);
			
		return consulta.list();
	}

	/**Método para listar dados para a tabela campo adicional por id_transacao**/
	@SuppressWarnings("unchecked")
	@Override
	public List<Campo_Adicional> listarPorIdTransCodEmCodFiCodUniWebService(BigInteger id_transacao) {
		
		List<Campo_Adicional> lista = new ArrayList<Campo_Adicional>();
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();		
		
		String hql = "select ca from campo_adicional ca where ca.id_transacao = :id_transacao";
	
		Query consulta = session.createQuery(hql);
		
		consulta.setBigInteger("id_transacao", id_transacao);
	
		lista = consulta.list();
		
		this.session.getTransaction().commit();
		
		return lista;
	}

	/**Método para listar o ultimo valor gravado para a tabela campo adicional**/
	@Override
	public Campo_Adicional listarUltimoId() {

		Query consulta = this.session.createQuery("select tb from campo_adicional tb order by id_camp_adic desc");
		consulta.setMaxResults(1);
		return (Campo_Adicional) consulta.uniqueResult();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
