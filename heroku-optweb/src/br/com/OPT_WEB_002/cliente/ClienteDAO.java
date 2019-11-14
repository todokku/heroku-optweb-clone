package br.com.OPT_WEB_002.cliente;

import java.math.BigInteger;
import java.util.List;


public interface ClienteDAO {

	public void salvar(Cliente cliente);
	
	public void alterar(Cliente cliente);
	
	public Cliente carregar (BigInteger id_cliente);
	
	public void excluir (Cliente cliente);
	
	public List<Cliente> listar();
	
	public Cliente listarUltimoId();
	
	public List<Cliente> listarPorEmpresa(Integer cod_empresa);
	
	public Cliente carregarPorCodCliente(String codigo);
}
