package br.com.OPT_WEB_002.unidade_negocio;

import java.util.*;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import br.com.OPT_WEB_002.util.DAOException;

public class Unidade_NegocioDAOHibernate implements Unidade_NegocioDAO {

	private Session session;

	@Override
	public void salvar(Unidade_Negocio unidadeNegocio) throws DAOException {
		try {
				
			this.session.clear();
			this.session.save(unidadeNegocio);
			this.session.flush();
			
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
			this.session.clear();
			
			throw new DAOException("Este código já foi cadastrado!", e);
		}
	}

	@Override
	public void alterar(Unidade_Negocio unidadeNegocio) {

		this.session.merge(unidadeNegocio);

	}

	@Override
	public Unidade_Negocio carregar(Integer cod_unidade) {

		return (Unidade_Negocio) this.session.get(Unidade_Negocio.class, cod_unidade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade_Negocio> listar() {

		return this.session.createCriteria(Unidade_Negocio.class).list();
	}

	@Override
	public void excluir(Unidade_Negocio unidadeNegocio) throws DAOException {
		
		try {
			this.session.delete(unidadeNegocio);
			this.session.flush();
			
		} catch (ConstraintViolationException e) {

			this.session.clear();
			e.printStackTrace();
			throw new DAOException("Item relacionado com outra tabela", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade_Negocio> listarPorCodUnidade(Integer cod_unidade) {

		List<Unidade_Negocio> lista = new ArrayList<>();
		String hql = "select u from unidade_negocio u where u.cod_unidade = :cod_unidade";

		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("cod_unidade", cod_unidade);

		lista = consulta.list();
		return lista;

	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade_Negocio> listarPorCodEmpresa(Integer cod_empresa) {
		
		String hql = "select tb from unidade_negocio tb where tb.cod_empresa = :cod_empresa";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setInteger("cod_empresa",cod_empresa);
		
		return consulta.list();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

}
