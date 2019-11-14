package br.com.OPT_WEB_002.transacao;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;

import br.com.OPT_WEB_002.util.DAOException;

public class TransacaoDAOHibernate implements TransacaoDAO {

	private Session session;

	public TransacaoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Transacao transacao) throws DAOException {
			
			this.session.save(transacao);	
	}
	

	@Override
	public void alterar(Transacao transacao) {

		this.session.clear();
		this.session.merge(transacao);

	}

	@Override
	public void excluir(Transacao transacao) throws DAOException {

		try {

			this.session.delete(transacao);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			this.session.clear();
			e.printStackTrace();
			throw new DAOException("Item relacionado com outra tabela", e);

		}

	}


	@Override
	public Transacao carregar(BigInteger id_transacao,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {
	
		String hql = "select tb from transacao tb where tb.id_transacao = :id_transacao and tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setBigInteger("id_transacao",id_transacao);
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return (Transacao) consulta.uniqueResult();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao> listar() {

		return this.session.createCriteria(Transacao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao> listarPorIdTransacao(BigInteger id_transacao) {

		String hql = "select t from transacao t where t.id_transacao = :id_transacao";

		Query consulta = this.session.createQuery(hql);

		consulta.setBigInteger("id_transacao", id_transacao);

		return consulta.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao> listarPorCodEmCodFiCodUn(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		String hql = "select t from transacao t where t.cod_empresa = :cod_empresa and t.cod_filial = :cod_filial and cod_unidade = :cod_unidade";
	
		Query consulta = this.session.createQuery(hql);
	
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);

		return consulta.list();
		
	} 
	
	@Override
	public Transacao listarUltimoId() {
		
		Query consulta = this.session.createQuery("select tb from transacao tb order by id_transacao desc");
		consulta.setMaxResults(1);
		
		
		return (Transacao) consulta.uniqueResult();
	}

	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}



}
