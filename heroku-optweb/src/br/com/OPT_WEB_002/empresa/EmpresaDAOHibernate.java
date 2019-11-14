package br.com.OPT_WEB_002.empresa;

import java.util.*;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import br.com.OPT_WEB_002.util.DAOException;

public class EmpresaDAOHibernate implements EmpresaDAO {

	private Session session;

	@Override
	public void salvar(Empresa empresa) throws DAOException {
		try {
			
			this.session.clear();
			this.session.save(empresa);
			this.session.flush();
	
		} catch (ConstraintViolationException e) {
			
			e.printStackTrace();
			this.session.clear();
			
			throw new DAOException("Este código já foi cadastrado!",e);
		
		}
	}

	@Override
	public void alterar(Empresa empresa) {

		this.session.merge(empresa);

	}
	
	@Override
	public void excluir(Empresa empresa) throws DAOException {

		try {

			this.session.delete(empresa);
			this.session.flush();

		} catch (ConstraintViolationException e) {

			e.printStackTrace();
			this.session.clear();

			throw new DAOException("Item relacionado com outra tabela", e);

		}

	}

	@Override
	public Empresa carregar(Integer cod_empresa) {

		return (Empresa) this.session.get(Empresa.class, cod_empresa);
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listar() {

		return this.session.createCriteria(Empresa.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listarPorCodEmpresa(Integer cod_empresa) {
	
		String hql = "select e from empresa e where e.cod_empresa = :cod_empresa";
		
		Query consulta = this.session.createQuery(hql);

		consulta.setInteger("cod_empresa", cod_empresa);

		return consulta.list();

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
