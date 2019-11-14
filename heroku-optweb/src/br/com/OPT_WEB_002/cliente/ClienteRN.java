package br.com.OPT_WEB_002.cliente;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOFactory;

public class ClienteRN {

	private ClienteDAO clienteDAO;
	
	public ClienteRN(){
		
		clienteDAO = DAOFactory.criarDAOCliente();
	}
	
		public void salvar(Cliente cliente) {

						
			if(listar().isEmpty()){
							
				cliente.setId_cliente(BigInteger.valueOf(Long.parseLong("1")));
				this.clienteDAO.salvar(cliente);
			
			}else{
				
				cliente.setId_cliente(listarIUltimoId().getId_cliente().add(BigInteger.valueOf(Long.parseLong("1"))));
				this.clienteDAO.salvar(cliente);
			}
			
		}
	
		public List<Cliente> listar() {
			
			return clienteDAO.listar();
		}
		
	
		public void excluir(Cliente cliente) {
			
			clienteDAO.excluir(cliente);
			
		}
		
	
		public Cliente carregar(BigInteger id_cliente) {
			
			return clienteDAO.carregar(id_cliente);
		}
		
	
		public void alterar(Cliente cliente) {
			
			clienteDAO.alterar(cliente);
			
		}
	
		public Cliente listarIUltimoId(){
			
			return clienteDAO.listarUltimoId();
		}	

		public List<Cliente> listarPorEmpresa(Integer cod_empresa){
			
			return clienteDAO.listarPorEmpresa(cod_empresa);
		}
		
		public Cliente carregarPorCodCliente(String codigo){
			
			if(codigo != ""){
								
					return clienteDAO.carregarPorCodCliente(codigo);
			
			}else{
				return null;
			}
					
			
		}
		
}
