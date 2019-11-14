package br.com.OPT_WEB_002.unidade_negocio;

import java.util.*;
import br.com.OPT_WEB_002.util.*;

public class Unidade_NegocioRN {

	private Unidade_NegocioDAO unidade_negocioDAO;

	public Unidade_NegocioRN() {

		this.unidade_negocioDAO = DAOFactory.criarUnidade_NegocioDAO();

	}

	public void salvar(Unidade_Negocio unidadeNegocio) throws DAOException {

		this.unidade_negocioDAO.salvar(unidadeNegocio);

	}

	public void alterar(Unidade_Negocio unidadeNegocio) {

		this.unidade_negocioDAO.alterar(unidadeNegocio);
	}

	public void excluir(Unidade_Negocio unidadeNegocio) throws DAOException {

		this.unidade_negocioDAO.excluir(unidadeNegocio);
	}

	public List<Unidade_Negocio> listar() {

		return this.unidade_negocioDAO.listar();

	}

	public Unidade_Negocio carregar(Integer cod_unidade) {

		return this.unidade_negocioDAO.carregar(cod_unidade);

	}

	public List<Unidade_Negocio> listarPorCodUnidade(Integer cod_unidade) {

		return this.unidade_negocioDAO.listarPorCodUnidade(cod_unidade);
	}
	
	public List<Unidade_Negocio> listarPorCodEmpresa(Integer cod_empresa){
		
		return this.unidade_negocioDAO.listarPorCodEmpresa(cod_empresa);
	}


}
