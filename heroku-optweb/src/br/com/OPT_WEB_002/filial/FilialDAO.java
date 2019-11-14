package br.com.OPT_WEB_002.filial;

import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface FilialDAO {

	public void salvar(Filial filial) throws DAOException;

	public void alterar(Filial filial);
	
	public void excluir(Filial filial) throws DAOException;

	public Filial carregar(Integer cod_filial);

	public List<Filial> listar();

	public List<Filial> listarPorCodFilial(Integer cod_filial);
	
	public List<Filial> listarPorEmpresa(Integer cod_empresa);

}
