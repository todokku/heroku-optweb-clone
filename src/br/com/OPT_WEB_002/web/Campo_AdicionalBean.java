package br.com.OPT_WEB_002.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.campo_adicional.*;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOException;

@ManagedBean(name = "campoAdicBean")
@ViewScoped
public class Campo_AdicionalBean{

	private Campo_Adicional campoAdicional;
	private Campo_Adicional campoAdicionalSelecionado;
	private List<Campo_Adicional> lista;
	private LazyDataModel<Campo_Adicional> lazymodel; 
	private Usuario usuario;
	private Campo_AdicionalRN campo_AdicionalRN;
				
	public Campo_AdicionalBean() {}
	
	@PostConstruct
	public void init(){
	
		campoAdicional = new Campo_Adicional();
		campoAdicionalSelecionado = new Campo_Adicional();
	}
		
	
	public List<Campo_Adicional> listarPorCodEmCodFiCodUni(Usuario usuario) {
		
		campo_AdicionalRN = null;
		campo_AdicionalRN = new Campo_AdicionalRN();
			
		return campo_AdicionalRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());

	}
			
	public Campo_Adicional iniciar(Usuario usuario) {
		
		campo_AdicionalRN = null;
		campo_AdicionalRN = new Campo_AdicionalRN();
		
			if(campoAdicionalSelecionado.getId_camp_adic() == null){
	
				this.campoAdicional.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
				this.campoAdicional.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
				this.campoAdicional.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
							
				return this.campoAdicional;
				
			}else{					
								
					this.campoAdicional = campo_AdicionalRN.carregar(this.campoAdicionalSelecionado.getId_camp_adic(),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
					return campoAdicional;
									
			}					
	}
	
	public String novo() {
		
		return "/restrito/campo_adicional/cadastro_campo_adicional.xhtml?faces-redirect=true";
	}
	
	public String alterar() {
		
		return "/restrito/campo_adicional/cadastro_campo_adicional.xhtml?id=" + campoAdicionalSelecionado.getId_camp_adic() + "faces-redirect=true";
	}
	
	public String excluir() {

		campo_AdicionalRN = null;
		campo_AdicionalRN = new Campo_AdicionalRN();
		
		this.campoAdicional = campo_AdicionalRN.carregar(campoAdicionalSelecionado.getId_camp_adic(),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());

		try {
							
			campo_AdicionalRN.excluir(this.campoAdicional);
			return "/restrito/campo_adicional/campo_adicional.xhtml?faces-redirect=true";
						
		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}
				
	}
	
	public String salvar() {

		campo_AdicionalRN = null;
		campo_AdicionalRN = new Campo_AdicionalRN();
		
			 if (campoAdicionalSelecionado.getId_camp_adic() == null){			
					
				 try {
					
					if(campoAdicional.getId_grupo_Valores().getId_grupo_valores() == null){
						
						campoAdicional.setId_grupo_Valores(null);
					} 
					
					campo_AdicionalRN.salvar(campoAdicional);							
					return "/restrito/campo_adicional/campo_adicional.xhtml?faces-redirect=true";
								
					 	} catch (DAOException e) {
	
					 			 FacesContext.getCurrentInstance().addMessage(null,
								 new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
					 	}				 		

			 	} else {
				 			
			 		campo_AdicionalRN.alterar(campoAdicional);
			 		return "/restrito/campo_adicional/campo_adicional.xhtml?faces-redirect=true";
			    
			 	}
			 
			 return null;				
	}
		
	public boolean desabilitarCamposCampoAdicional() {
		
		if(campoAdicionalSelecionado.getId_camp_adic() != null){		
			return true;
		}
		return false;
	}
		

	public Campo_Adicional getCampoAdicional() {
		return campoAdicional;
	}

	public void setCampoAdicional(Campo_Adicional campoAdicional) {
		this.campoAdicional = campoAdicional;
	}

	public Campo_Adicional getCampoAdicionalSelecionado() {
		return campoAdicionalSelecionado;
	}

	public void setCampoAdicionalSelecionado(Campo_Adicional campoAdicionalSelecionado) {
		this.campoAdicionalSelecionado = campoAdicionalSelecionado;
	}

	public List<Campo_Adicional> getLista() {
		return lista;
	}

	public void setLista(List<Campo_Adicional> lista) {
		this.lista = lista;
	}
	
	public LazyDataModel<Campo_Adicional> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Campo_Adicional> lazymodel) {
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
		result = prime * result + ((campoAdicional == null) ? 0 : campoAdicional.hashCode());
		result = prime * result + ((campoAdicionalSelecionado == null) ? 0 : campoAdicionalSelecionado.hashCode());
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
		Campo_AdicionalBean other = (Campo_AdicionalBean) obj;		
		if (campoAdicional == null) {
			if (other.campoAdicional != null)
				return false;
		} else if (!campoAdicional.equals(other.campoAdicional))
			return false;
		if (campoAdicionalSelecionado == null) {
			if (other.campoAdicionalSelecionado != null)
				return false;
		} else if (!campoAdicionalSelecionado.equals(other.campoAdicionalSelecionado))
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

	public Campo_AdicionalRN getCampo_AdicionalRN() {
		return campo_AdicionalRN;
	}

	public void setCampo_AdicionalRN(Campo_AdicionalRN campo_AdicionalRN) {
		this.campo_AdicionalRN = campo_AdicionalRN;
	}



}
