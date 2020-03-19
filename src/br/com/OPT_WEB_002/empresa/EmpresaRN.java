package br.com.OPT_WEB_002.empresa;

import java.util.*;
import br.com.OPT_WEB_002.util.*;


public class EmpresaRN {

	private EmpresaDAO empresaDAO;

	public EmpresaRN() {

		this.empresaDAO = DAOFactory.criarEmpresaDAO();

	}

	public void alterar(Empresa empresa) {

		this.empresaDAO.alterar(empresa);	

	}

	public Empresa carregar(Integer cod_empresa) {

		return this.empresaDAO.carregar(cod_empresa);

	}

	public void salvar(Empresa empresa) throws DAOException {

		this.empresaDAO.salvar(empresa);

	}

	public void excluir(Empresa empresa) throws DAOException {

		this.empresaDAO.excluir(empresa);

	}

	public List<Empresa> listar() throws org.hibernate.HibernateException {

		return this.empresaDAO.listar();

	}

	public List<Empresa> listarPorCodEmpresa(Integer cod_empresa) {

		return this.empresaDAO.listarPorCodEmpresa(cod_empresa);

	}

}
