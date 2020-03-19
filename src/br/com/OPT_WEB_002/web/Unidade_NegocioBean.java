package br.com.OPT_WEB_002.web;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.unidade_negocio.*;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOException;


@ManagedBean(name = "unidadeNegocioBean")
@RequestScoped
public class Unidade_NegocioBean {

	private Unidade_Negocio unidade_Negocio;
	private Unidade_Negocio  unidade_NegocioSelecionada;	
	private LazyDataModel<Unidade_Negocio> lazymodel;
	private Usuario usuario;
	private Integer id_unidade_negocio;
	private Unidade_NegocioRN unidade_negocioRN;
	
	@PostConstruct
	public void init(){

		unidade_Negocio = new Unidade_Negocio();
		unidade_NegocioSelecionada = new Unidade_Negocio();
		
	
		
	}
		
	public Unidade_Negocio iniciar(Usuario usuario) {
		
		unidade_negocioRN = new Unidade_NegocioRN();
		if(id_unidade_negocio == null) {
		
			this.unidade_Negocio.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			
			return this.unidade_Negocio;
		
		}else {
		
		
			this.unidade_Negocio = unidade_negocioRN.carregar(id_unidade_negocio);
		
			return this.unidade_Negocio;
		}

	}

	public boolean opcao() {

		if (id_unidade_negocio != null) {

			return true;
		}

		return false;
	}

	public String novo() {

		return "/restrito/unidade_negocio/cadastro_unidade_negocio.xhtml?faces-redirect=true";

	}

	public String alterar() {

		return "/restrito/unidade_negocio/cadastro_unidade_negocio.xhtml?id=" + unidade_NegocioSelecionada.getCod_unidade() + "faces-redirect=true";
	}

	public String excluir() {

		unidade_negocioRN = new Unidade_NegocioRN();

		this.unidade_Negocio = unidade_negocioRN.carregar(unidade_NegocioSelecionada.getCod_unidade());
		
		try {
			
			unidade_negocioRN.excluir(this.unidade_Negocio);
			return "/restrito/unidade_negocio/unidade_negocio.xhtml?faces-redirect=true";
			
		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;

		}	
	}

	public String salvar() {

		unidade_negocioRN = new Unidade_NegocioRN();

		if (id_unidade_negocio == null) {
					
			try {
				
				unidade_negocioRN.salvar(this.unidade_Negocio);			
				return "/restrito/unidade_negocio/unidade_negocio.xhtml?faces-redirect=true";
				
			} catch (DAOException e) {
				
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,e.getMessage(),null));
				
			}

		} else {
			
			unidade_negocioRN.alterar(this.unidade_Negocio);
			return "/restrito/unidade_negocio/unidade_negocio.xhtml?faces-redirect=true";
		}

		return null;
	}
	
	public List<Unidade_Negocio> listar(Usuario usuario) {

		unidade_negocioRN = new Unidade_NegocioRN();
		
		if(usuario != null){
			
			if(usuario.getPermissao().toString().contains("ADMINISTRADOR")){
					
				return unidade_negocioRN.listar();
			
			}else{
						
			/**if(getUsuarioBean().retornoDeEmpresaSelecionada().getCod_empresa() != null){
			*/	
					
				return unidade_negocioRN.listarPorCodEmpresa(usuario.getCod_empresa().getCod_empresa());
						
			/**}else{		
			
				return filialRN.listarPorCodEmpresa(usuario.getCod_empresa().getCod_empresa());
		
			}	**/
			}
		}else{
			return null;
		}
	}

	public Unidade_Negocio getUnidade_Negocio() {
		return unidade_Negocio;
	}

	public void setUnidade_Negocio(Unidade_Negocio unidade_Negocio) {
		this.unidade_Negocio = unidade_Negocio;
	}

	public Unidade_Negocio getUnidade_NegocioSelecionada() {
		return unidade_NegocioSelecionada;
	}

	public void setUnidade_NegocioSelecionada(Unidade_Negocio unidade_NegocioSelecionada) {
		this.unidade_NegocioSelecionada = unidade_NegocioSelecionada;
	}


	public LazyDataModel<Unidade_Negocio> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Unidade_Negocio> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId_unidade_negocio() {
		return id_unidade_negocio;
	}

	public void setId_unidade_negocio(Integer id_unidade_negocio) {
		this.id_unidade_negocio = id_unidade_negocio;
	}
	public Unidade_NegocioRN getUnidade_negocioRN() {
		return unidade_negocioRN;
	}

	public void setUnidade_negocioRN(Unidade_NegocioRN unidade_negocioRN) {
		this.unidade_negocioRN = unidade_negocioRN;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_unidade_negocio == null) ? 0 : id_unidade_negocio.hashCode());
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());	
		result = prime * result + ((unidade_Negocio == null) ? 0 : unidade_Negocio.hashCode());
		result = prime * result + ((unidade_NegocioSelecionada == null) ? 0 : unidade_NegocioSelecionada.hashCode());
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
		Unidade_NegocioBean other = (Unidade_NegocioBean) obj;
		if (id_unidade_negocio == null) {
			if (other.id_unidade_negocio != null)
				return false;
		} else if (!id_unidade_negocio.equals(other.id_unidade_negocio))
			return false;
		if (lazymodel == null) {
			if (other.lazymodel != null)
				return false;
		} else if (!lazymodel.equals(other.lazymodel))
			return false;		
		if (unidade_Negocio == null) {
			if (other.unidade_Negocio != null)
				return false;
		} else if (!unidade_Negocio.equals(other.unidade_Negocio))
			return false;
		if (unidade_NegocioSelecionada == null) {
			if (other.unidade_NegocioSelecionada != null)
				return false;
		} else if (!unidade_NegocioSelecionada.equals(other.unidade_NegocioSelecionada))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	

}
