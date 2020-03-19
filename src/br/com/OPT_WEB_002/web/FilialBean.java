package br.com.OPT_WEB_002.web;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.filial.*;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOException;

@ManagedBean(name = "filialBean")
@RequestScoped
public class FilialBean {

	private Filial filial;
	private Filial filialSelecionada;
	private List<Filial> lista;
	private LazyDataModel<Filial> lazymodel;
	private Usuario usuario;
	private FilialRN FilialRN;
	
	@PostConstruct
	public void init(){

		filial = new Filial();		
		filialSelecionada = new Filial();
		
		
		
	}
		
	public Filial iniciar(Usuario usuario) {
		
		FilialRN = null;
		FilialRN filialRN = new FilialRN();
		
		if (filialSelecionada.getCod_filial() == null) {
			
			this.filial.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			return this.filial;
		
		}else {

			this.filial = filialRN.carregar(filialSelecionada.getCod_filial());

			return this.filial;
		}

	}

	public boolean opcao() {

		if (this.filialSelecionada.getCod_filial() != null) {

			return true;
		}

		return false;
	}

	public String novo() {

		return "/restrito/filial/cadastro_filial.xhtml?faces-redirect=true";

	}

	public String alterar() {

		return "/restrito/filial/cadastro_filial.xhtml?id=" + filialSelecionada.getCod_filial() + "faces-redirect=true";
	}

	public String excluir() {

		FilialRN = null;
		FilialRN filialRN = new FilialRN();

		this.filial = filialRN.carregar(filialSelecionada.getCod_filial());
		
		try {
			
			filialRN.excluir(this.filial);
			return "/restrito/filial/filial.xhtml?faces-redirect=true";
			
		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;

		}	
	}

	public String salvar() {

		FilialRN = null;
		FilialRN filialRN = new FilialRN();

		if (filialSelecionada.getCod_filial() == null) {
					
			try {
										
				
				filialRN.salvar(filial);			
				return "/restrito/filial/filial.xhtml?faces-redirect=true";
				
			} catch (DAOException e) {
				
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,e.getMessage(),null));
				
			}

		} else {

			filialRN.alterar(this.filial);
			return "/restrito/filial/filial.xhtml?faces-redirect=true";
		}

		return null;
	}
	
	public List<Filial> listar(Usuario usuario) {

		FilialRN = null;
		FilialRN filialRN = new FilialRN();
		
		if(usuario != null){
			
		if(usuario.getPermissao().toString().contains("ADMINISTRADOR")){
	
			return filialRN.listar();
			
		}else{
						
			/**if(getUsuarioBean().retornoDeEmpresaSelecionada().getCod_empresa() != null){
			*/	
	
				return filialRN.listarPorCodEmpresa(usuario.getCod_empresa().getCod_empresa());
						
			/**}else{		
			
				return filialRN.listarPorCodEmpresa(usuario.getCod_empresa().getCod_empresa());
		
			}**/
		}
		}else{
			return null;
		}
	
			
	}
	
	public Filial getFilial() {
		return filial;
	}


	public void setFilial(Filial filial) {
		this.filial = filial;
	}


	public Filial getFilialSelecionada() {
		return filialSelecionada;
	}


	public void setFilialSelecionada(Filial filialSelecionada) {
		this.filialSelecionada = filialSelecionada;
	}


	public List<Filial> getLista() {
		return lista;
	}


	public void setLista(List<Filial> lista) {
		this.lista = lista;
	}


	public LazyDataModel<Filial> getLazymodel() {
		return lazymodel;
	}


	public void setLazymodel(LazyDataModel<Filial> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filial == null) ? 0 : filial.hashCode());
		result = prime * result + ((filialSelecionada == null) ? 0 : filialSelecionada.hashCode());
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());
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
		FilialBean other = (FilialBean) obj;
		if (filial == null) {
			if (other.filial != null)
				return false;
		} else if (!filial.equals(other.filial))
			return false;
		if (filialSelecionada == null) {
			if (other.filialSelecionada != null)
				return false;
		} else if (!filialSelecionada.equals(other.filialSelecionada))
			return false;
		if (lazymodel == null) {
			if (other.lazymodel != null)
				return false;
		} else if (!lazymodel.equals(other.lazymodel))
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

	public FilialRN getFilialRN() {
		return FilialRN;
	}

	public void setFilialRN(FilialRN filialRN) {
		FilialRN = filialRN;
	}

}
