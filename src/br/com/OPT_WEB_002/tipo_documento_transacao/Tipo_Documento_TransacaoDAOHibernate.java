package br.com.OPT_WEB_002.tipo_documento_transacao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.HibernateUtil;

public class Tipo_Documento_TransacaoDAOHibernate implements Tipo_Documento_TransacaoDAO{

	
	private Session session;
	
	@Override
	public void salvar(Tipo_Documento_Transacao tipo_Documento_Transacao)  {

			this.session.save(tipo_Documento_Transacao);
			this.session.flush();
	}

	@Override
	public void alterar(Tipo_Documento_Transacao tipo_Documento_Transacao) {

		this.session.merge(tipo_Documento_Transacao);
		
	}


	@Override
	public void excluir(Tipo_Documento_Transacao tipo_Documento_Transacao) throws DAOException{
			
			try{
		
				this.session.delete(tipo_Documento_Transacao);
				this.session.flush();
	
			}catch(ConstraintViolationException e){
				
				e.printStackTrace();
				throw new DAOException("Item relacionado com outra tabela!");
			}
	
	}
	

	@Override
	public Tipo_Documento_Transacao carregar(BigInteger id_tipo_doc_trans) {
		
		String hql = "select tb from tipo_documento_transacao tb where tb.id_tipo_doc_trans = :id_tipo_doc_trans";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_tipo_doc_trans",id_tipo_doc_trans);
		
		return (Tipo_Documento_Transacao) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento_Transacao> listar() {

		return this.session.createCriteria(Tipo_Documento_Transacao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento_Transacao> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,Integer cod_unidade) {

		String hql = "select tb from tipo_documento_transacao tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		
		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
	
		return consulta.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUniWebService(BigInteger id_tipo_doc) {

		List<Tipo_Documento_Transacao> lista = new ArrayList<Tipo_Documento_Transacao>();
	
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction trans = session.beginTransaction();
		
		String hql = "select tb from tipo_documento_transacao tb where tb.id_tipo_doc = :id_tipo_doc";

		Query consulta = this.session.createQuery(hql);
	
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
	
		lista = consulta.list();
		
		this.session.getTransaction().commit();
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_doc) {
		
		String hql = "select tb from tipo_documento_transacao tb where tb.id_tipo_doc = :id_tipo_doc";

		Query consulta = this.session.createQuery(hql);
	
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);
		
		return consulta.list();
	}
	@Override
	public Tipo_Documento_Transacao listarUtlimoId() {
		
		Query consulta = this.session.createQuery("select tb from tipo_documento_transacao tb order by id_tipo_doc_trans desc");
		consulta.setMaxResults(1);
		
		return (Tipo_Documento_Transacao) consulta.uniqueResult();
	}
	
	

	@Override
	public Tipo_Documento_Transacao carregarPorIdTransIdTipo(BigInteger id_transacao, BigInteger id_tipo_doc) {
		
		String hql = "select tb from tipo_documento_transacao tb where tb.id_transacao = :id_transacao and id_tipo_doc = :id_tipo_doc";
		Query consulta = session.createQuery(hql);
		
		consulta.setBigInteger("id_transacao",id_transacao);
		consulta.setBigInteger("id_tipo_doc",id_tipo_doc);		
		
		return (Tipo_Documento_Transacao) consulta.uniqueResult();
	}


		
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	


}
