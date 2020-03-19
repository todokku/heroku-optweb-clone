package br.com.OPT_WEB_002.transacao_documento;

import java.math.BigInteger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.HibernateUtil;

public class Transacao_DocumentoDAOHibernate implements Transacao_DocumentoDAO {

	private Session session;

	@Override
	public void salvar(Transacao_Documento transacao_documento) throws DAOException {	
		
		this.session.save(transacao_documento);	
		this.session.flush();
	
	}


	@Override
	public void alterar(Transacao_Documento transacao_documento) {		

		this.session.clear();	
		this.session.update(transacao_documento);	
	}
	
	@Override
	public void excluir(Transacao_Documento transacao_documento) throws DAOException {

		try {

			this.session.delete(transacao_documento);
			this.session.flush();

			/**Validação de relacionamento entre tabelas**/
		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();
			throw new DAOException("Item relacionado com outra tabela", e);

		}
	}


	@Override
	public Transacao_Documento carregar(BigInteger id_transacao_doc) {
				
		return (Transacao_Documento) session.get(Transacao_Documento.class,id_transacao_doc);
	}

		
	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao_Documento> listar() {
	
		return this.session.createCriteria(Transacao_Documento.class).list();
	}

	
	public Transacao_Documento listarUltimoId() {
		
		Query query = session.createQuery("select tb from transacao_documento tb order by id_transacao_doc desc");
		query.setMaxResults(1);
		return (Transacao_Documento) query.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		String hql = "select tr from transacao_documento tr where tr.cod_empresa = :cod_empresa and tr.cod_filial = :cod_filial and tr.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);

		return consulta.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao_Documento> listarPorIdDoc(BigInteger id_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
	

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		String hql = "select tb from transacao_documento tb where tb.id_doc = :id_doc and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade order by id_transacao";
		
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("cod_empresa", cod_empresa);
		consulta.setInteger("cod_filial", cod_filial);
		consulta.setInteger("cod_unidade", cod_unidade);
		consulta.setBigInteger("id_doc",id_doc);
	
		return  consulta.list();
		
	}

	@Override
	public void cadastrarTransacaoDocumentoWebService(Transacao_Documento transacao_documento) {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction trans = session.beginTransaction();
		
		session.save(transacao_documento);
	
		this.session.getTransaction().commit();
		
	}
		
	@Override
	public Transacao_Documento carregarPorIdTransDocCodEmpCodFiCodUni(BigInteger id_transacao_doc,
	Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		String hql = "select transdoc from transacao_documento transdoc where transdoc.id_transacao_doc = :id_transacao_doc and transdoc.cod_empresa = :cod_empresa and transdoc.cod_filial = :cod_filial and transdoc.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);
	
		consulta.setBigInteger("id_transacao_doc",id_transacao_doc);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
	
		return (Transacao_Documento) consulta.uniqueResult();		
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao_Documento> listarPorIdTrans(BigInteger id_transacao_doc) {
		
		String hql = "select tb from transacao_documento tb where tb.id_transacao_doc = :id_transacao_doc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_transacao_doc",id_transacao_doc);
		
		return consulta.list();

	}
	
	@Override
	public Transacao_Documento consultaWebService(BigInteger id_transacao_doc) {
	
		Session session2;
		session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction transaction = session2.beginTransaction();
				
		return (Transacao_Documento) session2.get(Transacao_Documento.class,id_transacao_doc);
	}
		
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


}
