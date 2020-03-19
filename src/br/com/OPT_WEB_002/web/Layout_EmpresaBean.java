package br.com.OPT_WEB_002.web;



import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import br.com.OPT_WEB_002.layout_empresa.*;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOException;


@ManagedBean(name = "layoutBean")
@ViewScoped
public class Layout_EmpresaBean {

	private Layout_Empresa layoutEmpresa = new Layout_Empresa();
	private Layout_Empresa layoutEmpresaSelecionada = new Layout_Empresa();
	private List<Layout_Empresa> lista;
	private LazyDataModel<Layout_Empresa> lazymodel;
	private Usuario usuario = new Usuario();
	
	
	@PostConstruct
	public void init(){}
	
	public Layout_EmpresaBean() {
		
		layoutEmpresaSelecionada = new Layout_Empresa();
		
	}
	
	public Layout_Empresa iniciar(Usuario usuario) {

		Layout_EmpresaRN layoutEmpresaRN = new Layout_EmpresaRN();
	
				
		if (layoutEmpresaSelecionada.getId_layout() == null) {
						
			this.layoutEmpresa.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.layoutEmpresa.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.layoutEmpresa.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());	
							
			return this.layoutEmpresa;
					
		} else {
						
			this.layoutEmpresa = layoutEmpresaRN.carregar(layoutEmpresaSelecionada.getId_layout());
			return this.layoutEmpresa;
		}		
	}

	public boolean desabilitarCampoIdLayout() {
	
		if(layoutEmpresaSelecionada.getId_layout() != null){
					
			return true;
		}		
		
		return false;
	}
	
	public boolean desabilitarCampos() {
			
		if(layoutEmpresaSelecionada.getId_layout() != null){
			
			return true;
		}		
		
		return false;
	}
	public String novo() {

		return "/restrito/layout_empresa/cadastro_layout_empresa.xhtml?faces-redirect=true";
	}

	public String alterar() {
		return "/restrito/layout_empresa/cadastro_layout_empresa.xhtml?id =" + layoutEmpresaSelecionada.getId_layout() + "faces-redirect=true";

	}

	public String salvar() {

		Layout_EmpresaRN layoutempresaRN = new Layout_EmpresaRN();
	
		if (layoutEmpresaSelecionada.getId_layout() == null) {

			try {
								
				if(layoutempresaRN.listarPorIdTipoDocCodCampo(this.layoutEmpresa.getId_tipo_doc().getId_tipo_doc(),this.layoutEmpresa.getCod_campo(),this.layoutEmpresa.getCod_empresa().getCod_empresa(),this.layoutEmpresa.getCod_filial().getCod_filial(),this.layoutEmpresa.getCod_unidade().getCod_unidade()) != null){
					
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Código Campo já foi cadastrado"));
				
				}else{
									
					layoutempresaRN.salvar(layoutEmpresa);
					return "/restrito/layout_empresa/layout_empresa.xhtml?faces-redirect=true";
				
				}

			} catch (DAOException e) {

				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
				
			}

		} else {

			layoutempresaRN.alterar(this.layoutEmpresa);
			return "/restrito/layout_empresa/layout_empresa.xhtml?faces-redirect=true";
		}

		return null;
	}

	public String excluir() {

		try {

			Layout_EmpresaRN layoutempresaRN = new Layout_EmpresaRN();

			this.layoutEmpresa = layoutempresaRN.carregar(layoutEmpresaSelecionada.getId_layout());
			layoutempresaRN.excluir(this.layoutEmpresa);
			return "/restrito/layout_empresa/layout_empresa.xhtml?faces-redirect=true";
			
		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}
	
	}

	
	public List<Layout_Empresa> listarPorCodEmCodFiCodUni(Usuario usuario){
			
		Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();	
			
		return layout_EmpresaRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
	}
	
	public List<Layout_Empresa> listarPortIdTipoDoc(BigInteger id_tipo_doc){
		
		
		Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
		return layout_EmpresaRN.listarPor_tipoDocumento(id_tipo_doc);
	}
		
	public Layout_Empresa getLayoutEmpresa() {
		return layoutEmpresa;
	}

	public void setLayoutEmpresa(Layout_Empresa layoutEmpresa) {
		this.layoutEmpresa = layoutEmpresa;
	}

	public Layout_Empresa getLayoutEmpresaSelecionada() {
		return layoutEmpresaSelecionada;
	}

	public void setLayoutEmpresaSelecionada(Layout_Empresa layoutEmpresaSelecionada) {
		this.layoutEmpresaSelecionada = layoutEmpresaSelecionada;
	}

	public List<Layout_Empresa> getLista() {
		return lista;
	}

	public void setLista(List<Layout_Empresa> lista) {
		this.lista = lista;
	}

	public LazyDataModel<Layout_Empresa> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Layout_Empresa> lazymodel) {
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
		result = prime * result + ((layoutEmpresa == null) ? 0 : layoutEmpresa.hashCode());
		result = prime * result + ((layoutEmpresaSelecionada == null) ? 0 : layoutEmpresaSelecionada.hashCode());
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
		Layout_EmpresaBean other = (Layout_EmpresaBean) obj;
		if (layoutEmpresa == null) {
			if (other.layoutEmpresa != null)
				return false;
		} else if (!layoutEmpresa.equals(other.layoutEmpresa))
			return false;
		if (layoutEmpresaSelecionada == null) {
			if (other.layoutEmpresaSelecionada != null)
				return false;
		} else if (!layoutEmpresaSelecionada.equals(other.layoutEmpresaSelecionada))
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

}
