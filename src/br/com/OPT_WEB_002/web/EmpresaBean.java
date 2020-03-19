package br.com.OPT_WEB_002.web;


import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import br.com.OPT_WEB_002.empresa.*;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;

@ManagedBean(name = "empresaBean")
@RequestScoped
public class EmpresaBean {

	private Empresa empresa;
	private Empresa empresaSelecionada;
	private List<Empresa> lista;
	private LazyDataModel<Empresa> lazymodel;
	private StreamedContent streamedContent;
	private UploadedFile arquivo;
	private Usuario usuario;
	private EmpresaRN empresaRN;

	public EmpresaBean() {
	}

	@PostConstruct
	public void init() {

		empresa = new Empresa();
		empresaSelecionada = new Empresa();

	}

	public String mudarCorLayout(Usuario usuario) {

		try {

			empresaRN = null;
			empresaRN = new EmpresaRN();

			Empresa empresa = new Empresa();

			if (usuario != null) {
				empresa = empresaRN.carregar(usuario.getCod_empresa().getCod_empresa());
				return "#" + empresa.getCorEmpresa();

			} else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public String descricaoDeAnexo(Empresa empresa) {

		if (empresa.getNomeArq() != null) {

			return empresa.getNomeArq();
		} else {

			return "Logotipo";
		}
	}

	public Empresa iniciar() {

		empresaRN = null;
		empresaRN = new EmpresaRN();

		if (empresaSelecionada.getCod_empresa() == null) {

			return this.empresa;

		} else {

			this.empresa = empresaRN.carregar(empresaSelecionada.getCod_empresa());
			return empresa;
		}

	}

	public boolean desabilitarCampo() {

		if (this.empresaSelecionada.getCod_empresa() != null) {

			return true;
		}

		return false;

	}

	public String novo() {

		return "/restrito/empresa/cadastro_empresa.xhtml?faces-redirect=true";

	}

	public String alterar() {

		return "/restrito/empresa/cadastro_empresa.xhtml?id =" + empresaSelecionada.getCod_empresa()
				+ "faces-redirect=true";
	}

	public String excluir() {

		empresaRN = null;
		empresaRN = new EmpresaRN();

		this.empresa = empresaRN.carregar(empresaSelecionada.getCod_empresa());

		try {

			empresaRN.excluir(this.empresa);
			return "/restrito/empresa/empresa.xhtml?faces-redirect=true";

		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
			return null;
		}

	}

	public String salvar() {
		
		empresaRN = null;
		empresaRN = new EmpresaRN();

		if (empresaSelecionada.getCod_empresa() == null) {

			try { 		
					
				try {
					
					if(arquivo.getFileName().contains(".png")){
						
						this.empresa.setExtensaoArq(".png");
					}
					
					else if(arquivo.getFileName().contains(".jpg")){
						
						this.empresa.setExtensaoArq(".jpg");				}
												
						this.empresa.setNomeArq(arquivo.getFileName());
												
						this.empresa.setLogotipo(IOUtils.toByteArray(arquivo.getInputstream()));
									
				} catch (IOException e) {
					
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao salvar arquivo!",null));
					
				}
				
						
				
				empresaRN.salvar(this.empresa);	
				
				
				return "/restrito/empresa/empresa.xhtml?faces-redirect=true";
				
			} catch (DAOException e) {
		
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,e.getMessage(),null));
			}

		} else {

			try {	
					
					if(arquivo != null && arquivo.getFileName().contains(".png")){
				     					     
						 this.empresa.setExtensaoArq(".png");
						 this.empresa.setNomeArq(arquivo.getFileName());
						 this.empresa.setLogotipo(IOUtils.toByteArray(arquivo.getInputstream()));
										
					}else if(arquivo != null && arquivo.getFileName().contains(".jpg")){	
						
						this.empresa.setExtensaoArq(".jpg");
						this.empresa.setNomeArq(arquivo.getFileName());
						this.empresa.setLogotipo(IOUtils.toByteArray(arquivo.getInputstream()));
					}		
								
			} catch (IOException e) {
				
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Erro ao salvar arquivo!"));
				
			}
			
			empresaRN.alterar(empresa);
		
			return "/restrito/empresa/empresa.xhtml?faces-redirect=true";
		}
		return null;


	}

	public List<Empresa> listar(Usuario usuario) {

		empresaRN = null;
		empresaRN = new EmpresaRN();

		if (usuario != null) {
			if (usuario.getPermissao().toString().contains("ADMINISTRADOR")) {

				return empresaRN.listar();
			} else {

				return empresaRN.listarPorCodEmpresa(usuario.getCod_empresa().getCod_empresa());
			}
		} else {
			return null;
		}
	}

	public StreamedContent getStreamedContent() {

		return this.streamedContent;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public List<Empresa> getLista() {
		return lista;
	}

	public void setLista(List<Empresa> lista) {
		this.lista = lista;
	}

	public LazyDataModel<Empresa> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Empresa> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EmpresaRN getEmpresaRN() {
		return empresaRN;
	}

	public void setEmpresaRN(EmpresaRN empresaRN) {
		this.empresaRN = empresaRN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((empresaSelecionada == null) ? 0 : empresaSelecionada.hashCode());
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((streamedContent == null) ? 0 : streamedContent.hashCode());
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
		EmpresaBean other = (EmpresaBean) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (empresaSelecionada == null) {
			if (other.empresaSelecionada != null)
				return false;
		} else if (!empresaSelecionada.equals(other.empresaSelecionada))
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
		if (streamedContent == null) {
			if (other.streamedContent != null)
				return false;
		} else if (!streamedContent.equals(other.streamedContent))
			return false;
		return true;
	}
}
