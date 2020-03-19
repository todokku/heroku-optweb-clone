package br.com.OPT_WEB_002.empresa;

import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface EmpresaDAO {

	public void salvar(Empresa empresa) throws DAOException;

	public void alterar(Empresa empresa);

	public Empresa carregar(Integer cod_empresa);

	public List<Empresa> listar();

	public void excluir(Empresa empresa) throws DAOException;

	public List<Empresa> listarPorCodEmpresa(Integer cod_empresa);
	
}
