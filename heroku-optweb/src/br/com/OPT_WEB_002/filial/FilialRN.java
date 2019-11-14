package br.com.OPT_WEB_002.filial;

import java.util.*;
import br.com.OPT_WEB_002.util.*;


public class FilialRN {

	private FilialDAO filialDAO;

	public FilialRN() {

		this.filialDAO = DAOFactory.criarFilialDAO();

	}

	public Filial carregar(Integer cod_filial) {

		return this.filialDAO.carregar(cod_filial);

	}

	public void salvar(Filial filial) throws DAOException {

		this.filialDAO.salvar(filial);

	}

	public void excluir(Filial filial) throws DAOException {

		this.filialDAO.excluir(filial);
	}

	public List<Filial> listar() {

		return this.filialDAO.listar();
	}

	public void alterar(Filial filial) {

		this.filialDAO.alterar(filial);

	}

	public List<Filial> listarPorCodFilial(Integer cod_filial) {

		return this.filialDAO.listarPorCodFilial(cod_filial);

	}
	 
	public List<Filial> listarPorCodEmpresa(Integer cod_empresa){
		
		return this.filialDAO.listarPorEmpresa(cod_empresa);
	}
	

}
