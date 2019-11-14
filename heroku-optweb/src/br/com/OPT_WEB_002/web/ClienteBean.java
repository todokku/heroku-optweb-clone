package br.com.OPT_WEB_002.web;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import br.com.OPT_WEB_002.cliente.*;
import br.com.OPT_WEB_002.usuario.*;

@javax.faces.bean.ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean {

	private Cliente cliente;
	private Cliente clienteSelecionado;
	private BigInteger id_cliente;
	private List<Cliente> lista;
	private Usuario usuario;
	private ClienteRN clienteRN;

	public ClienteBean() {}

	@PostConstruct
	public void init() {
	
		cliente = new Cliente();
		clienteSelecionado = new Cliente();
		
	}

	public List<Cliente> listarPorEmpresa(Usuario usuario) {
		
		clienteRN = null;
		clienteRN = new ClienteRN();
	
		return clienteRN.listarPorEmpresa(usuario.getCod_empresa().getCod_empresa());
	}

	public Cliente iniciar() {
		
		clienteRN = null;
		clienteRN = new ClienteRN();
	
		if (id_cliente == null) {

			return this.cliente;

		} else {

			this.cliente = clienteRN.carregar(id_cliente);
			return this.cliente;
		}
	}

	public String novo() {

		return "/restrito/cliente/cadastro_cliente.xhtml?faces-redirect=true";
	}

	public String alterar() {

		return "/restrito/cliente/cadastro_cliente.xhtml?id=" + clienteSelecionado.getId_cliente()+ "faces-redirect=true";
	}

	public void excluir() {

		clienteRN = null;
		clienteRN = new ClienteRN();
	
		this.cliente = clienteRN.carregar(clienteSelecionado.getId_cliente());

		clienteRN.excluir(this.cliente);
				
		id_cliente = null;
	}

	public String salvar() {

		clienteRN = null;
		clienteRN = new ClienteRN();
	
		if (id_cliente == null) {

			clienteRN.salvar(cliente);

			id_cliente = null;
			
			return "/restrito/cliente/cliente.xhtml?faces-redirect=true";

		} else {

			clienteRN.alterar(this.cliente);
			
			id_cliente = null;

			return "/restrito/cliente/cliente.xhtml?faces-redirect=true";
		}

	}

	public String carregarPorCodCliente(String cliente) {


		clienteRN = null;
		clienteRN = new ClienteRN();
	

		if (clienteRN.carregarPorCodCliente(cliente) != null) {

			return clienteRN.carregarPorCodCliente(cliente).getDescricao();

		} else {

			return "";
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public BigInteger getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(BigInteger id_cliente) {
		this.id_cliente = id_cliente;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ClienteRN getClienteRN() {
		return clienteRN;
	}

	public void setClienteRN(ClienteRN clienteRN) {
		this.clienteRN = clienteRN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((clienteSelecionado == null) ? 0 : clienteSelecionado.hashCode());
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteBean other = (ClienteBean) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (clienteSelecionado == null) {
			if (other.clienteSelecionado != null)
				return false;
		} else if (!clienteSelecionado.equals(other.clienteSelecionado))
			return false;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}



}
