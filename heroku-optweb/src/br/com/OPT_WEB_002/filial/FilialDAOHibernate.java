package br.com.OPT_WEB_002.filial;

import java.util.*;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;

import br.com.OPT_WEB_002.util.DAOException;

public class FilialDAOHibernate implements FilialDAO {

	private Session session;

	@Override
	public void salvar(Filial filial) throws DAOException {
		try {

			this.session.clear();
			this.session.save(filial);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();

			throw new DAOException("Este código já foi cadastrado!", e);
		}
	}

	@Override
	public void alterar(Filial filial) {

		this.session.merge(filial);

	}
	
	@Override
	public void excluir(Filial filial) throws DAOException {
		try {
		
			this.session.delete(filial);
			this.session.flush();
		
		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();
			throw new DAOException("Item relacionado com outra tabela", e);
		}

	}


	@Override
	public Filial carregar(Integer cod_filial) {

		return (Filial) this.session.get(Filial.class, cod_filial);
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Filial> listar() {

		return this.session.createCriteria(Filial.class).list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filial> listarPorCodFilial(Integer cod_filial) {

		String hql = "select f from filial f where f.cod_filial = :cod_filial";

		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_filial", cod_filial);

		return consulta.list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filial> listarPorEmpresa(Integer cod_empresa) {
		
		String hql = "select tb from filial tb where tb.cod_empresa = :cod_empresa";
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
