package br.com.OPT_WEB_002.unidade_negocio;

import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface Unidade_NegocioDAO {

	public void salvar(Unidade_Negocio unidadeNegocio) throws DAOException;

	public void excluir(Unidade_Negocio unidadeNegocio) throws DAOException;

	public void alterar(Unidade_Negocio unidadeNegocio);

	public Unidade_Negocio carregar(Integer cod_unidade);

	public List<Unidade_Negocio> listar();

	public List<Unidade_Negocio> listarPorCodUnidade(Integer cod_unidade);
	
	public List<Unidade_Negocio> listarPorCodEmpresa(Integer cod_empresa);

}
