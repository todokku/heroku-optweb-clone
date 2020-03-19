package br.com.OPT_WEB_002.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.Grupo_Valores_Possiveis_Doc;
import br.com.OPT_WEB_002.grupo_valores_possiveis_doc.Grupo_Valores_Possiveis_DocRN;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.val_campos_trans_doc.*;

@ManagedBean(name = "valCampBean")
@ViewScoped
public class Val_Campos_Trans_DocBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Val_Campos_Trans_Doc valCampTrans;
	private Val_Campos_Trans_Doc val_Campos_Trans_DocSelecionado;
	private List<Val_Campos_Trans_Doc> lista;
	private BigInteger id_doc;
	private BigInteger idtransdoc;
	private Integer id_val_camp_trans_doc;		
	private BigInteger id_trans;
	private BigInteger id_camp_adic;
	private StreamedContent streamedContent;
	private UploadedFile arquivo;	
	private Usuario usuario;
	private Val_Campos_Trans_DocRN val_Campos_Trans_DocRN;
		
	public Val_Campos_Trans_DocBean() {}
	
	@PostConstruct
	public void init(){
		
		valCampTrans = new Val_Campos_Trans_Doc();
		val_Campos_Trans_DocSelecionado = new Val_Campos_Trans_Doc();		
		
		
	}
	
	public List<Val_Campos_Trans_Doc> listarPorIdValCampoTransDoc(BigInteger id_val_camp_trans_doc){
	
		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		return val_Campos_Trans_DocRN.listarPorValCampoTransDoc(id_val_camp_trans_doc);
	}
				
	public Val_Campos_Trans_Doc iniciar(Usuario usuario) {
	
		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
	
		
		if(id_val_camp_trans_doc == null){
					
			this.valCampTrans.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.valCampTrans.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.valCampTrans.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
											
			return this.valCampTrans;
			
		}else{
		
			this.valCampTrans = val_Campos_Trans_DocRN.carregar(id_val_camp_trans_doc);
			return this.valCampTrans;
		}				
					
	}
	

	public String descricaoDeAnexo(Val_Campos_Trans_Doc val_Campos_Trans_Doc){

		if(val_Campos_Trans_Doc.getNome_arquivo() != null){
	
			return val_Campos_Trans_Doc.getNome_arquivo();
		}else{

			return "Upload";
		}		
	}
		
	public String salvar() {
				
		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
					
		if(id_val_camp_trans_doc == null){
			
			try {
			
				val_Campos_Trans_DocRN.salvar(this.valCampTrans);						
				return "/restrito/listagem_val_campos_trans_doc.xhtml?faces-redirect=true";
			
			} catch (DAOException e) {
				
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getCause().getMessage()));
				return null;
			}
		
		}else{
							
			try {		
			
					if(arquivo.getFileName().contains(".pdf") && arquivo != null){
									
						this.valCampTrans.setExtensaoarq(".pdf");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
					
					else if(arquivo.getFileName().contains(".xlsx") && arquivo != null){
						
						this.valCampTrans.setExtensaoarq(".xlsx");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
						
					}else if(arquivo.getFileName().contains(".doc") && arquivo != null){
							
						this.valCampTrans.setExtensaoarq(".doc");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
										
					}else if(arquivo.getFileName().contains(".docx") && arquivo != null){
							
						this.valCampTrans.setExtensaoarq(".docx");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
						
					}else if(arquivo.getFileName().contains(".txt") && arquivo != null){
						
						this.valCampTrans.setExtensaoarq(".txt");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					
					}else if(arquivo.getFileName().contains(".htm") && arquivo != null){						
						
						this.valCampTrans.setExtensaoarq(".html");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}						
		
					else if (arquivo.getFileName().contains(".jpeg")) {
						
						this.valCampTrans.setExtensaoarq(".jpeg");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
		
					} else if (arquivo.getFileName().contains(".png")) {
						
						this.valCampTrans.setExtensaoarq(".png");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
								
					} else if (arquivo.getFileName().contains(".bmp")) {
						
						this.valCampTrans.setExtensaoarq(".bmp");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					
					} else if (arquivo.getFileName().contains(".rar")) {
						
						this.valCampTrans.setExtensaoarq(".rar");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
						
					} else if (arquivo.getFileName().contains(".zip")) {
						
						this.valCampTrans.setExtensaoarq(".zip");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
					
					else if (arquivo.getFileName().contains(".ppt")) {
						
						this.valCampTrans.setExtensaoarq(".ppt");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
					
					else if (arquivo.getFileName().contains(".pptx")) {
						
						this.valCampTrans.setExtensaoarq(".pptx");
						this.valCampTrans.setNome_arquivo(arquivo.getFileName());
						this.valCampTrans.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
									 			
					val_Campos_Trans_DocRN.alterar(this.valCampTrans);		
					return "/restrito/documento/documento.xhtml?id=" + this.valCampTrans.getId_trans_doc().getId_doc().getId_tipo_doc().getId_tipo_doc() + "&idtr=" + this.valCampTrans.getId_trans_doc().getId_transacao_doc() + "&doc=" + valCampTrans.getId_trans_doc().getId_doc().getId_doc()  + "faces-redirect=true";
						
				} catch (IOException e) {
				
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Não foi possível salvar o arquivo"));
					return null;
				}
						
		}	
		
	}

		
	public void excluir() {

		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		
		try {
			
			this.valCampTrans = val_Campos_Trans_DocRN.carregar(val_Campos_Trans_DocSelecionado.getId_val_camp_trans_doc());			
			val_Campos_Trans_DocRN.excluir(this.valCampTrans);
			
		} catch (DAOException e) {
			
			e.printStackTrace();
		}

	}
	
	public List<Val_Campos_Trans_Doc> listarPorIdTransCodEmCodFiCodUni() {
		
		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
			
		return val_Campos_Trans_DocRN.listar();		
			
	}
	
	
	public boolean desabilitarCampo(){
		
		if(idtransdoc == null){
			
			return false;
						
		}else{
			
			return true;
		}
		
	}
	
	public String tamanhoNomeArquivo(String label) {

		try{
			
			if(label.isEmpty()){
				return "Upload";
			}else{
				
				if(label.length() >= 15){
					
					return label.substring(0,15);
				}
			return label;
			}
		}catch(Exception e){
		
			e.printStackTrace();
			return null;
		}
		
		
	}

	
	public boolean desabilitarListaDeValores(Usuario usuario){
							
	if(listarPorIdGrupoValoresCodEmCodFiCodUni(usuario).isEmpty()){
				
		return false;
			
	}else{
			
		return true;
	}
	
	}
	

	public String alterar(){
		
		if(val_Campos_Trans_DocSelecionado == null){
			
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,null, "Item não foi selecionado!"));
			return null;		
			
		}else{
				
			return "/restrito/val_campos_trans_doc/cadastro_val_campos_trans_doc?id=" + val_Campos_Trans_DocSelecionado.getId_val_camp_trans_doc() + "&idad=" + val_Campos_Trans_DocSelecionado.getId_camp_adic().getId_camp_adic() +"faces-redirect=true";
		}
	}

	public StreamedContent download(){
		
		val_Campos_Trans_DocRN = null;
		val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();

		String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("image_id");
	
	
		this.valCampTrans =  val_Campos_Trans_DocRN.carregar(Integer.parseInt(idString));		
				
		if(valCampTrans.getArquivo() != null){
						
			InputStream in = new ByteArrayInputStream(valCampTrans.getArquivo());
		
			this.streamedContent = new DefaultStreamedContent(in,valCampTrans.getExtensaoarq(),"teste" + valCampTrans.getExtensaoarq());
				
			return this.streamedContent;
		
				}else{
			
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "O arquivo não existe"));
					return null;
				}
		
	}
	
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(Usuario usuario){
	
		Grupo_Valores_Possiveis_DocRN grupo_Valores_Possiveis_DocRN = new Grupo_Valores_Possiveis_DocRN();	
	
		try{
			return grupo_Valores_Possiveis_DocRN.listarPorIdGrupoValoresCodEmCodFiCodUni(iniciar(usuario).getId_camp_adic().getId_grupo_Valores().getId_grupo_valores(),iniciar(usuario).getCod_empresa().getCod_empresa(),iniciar(usuario).getCod_filial().getCod_filial(),iniciar(usuario).getCod_unidade().getCod_unidade());
		}catch(NullPointerException e){
		
			List<Grupo_Valores_Possiveis_Doc> lista = new  ArrayList<>();
			
			return lista;
		}
		
		}

	
    public String redireciona(){
		
		return "/restrito/documento/documento.xhtml?id=" + this.valCampTrans.getId_trans_doc().getId_doc().getId_tipo_doc().getId_tipo_doc() + "faces-redirect=true";
	}
    
	public String verificaArquivoAnexado(String arquivo){
		
		if(arquivo.isEmpty()){
			return "";
		
			
		}else{
			
			return "/imagens/file.png";
		}		
		
	}
    
  
	public StreamedContent getStreamedContent() {
		
		

		String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idValCamp");
		
			
		valCampTrans = val_Campos_Trans_DocRN.carregar(Integer.parseInt(idString));		
		
		if(valCampTrans.getArquivo() != null){
				
			InputStream in = new ByteArrayInputStream(valCampTrans.getArquivo());
		
			this.streamedContent = new DefaultStreamedContent(in,valCampTrans.getExtensaoarq(),valCampTrans.getNome_arquivo());
				
			return this.streamedContent;
		
				}else{
			
					FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "O arquivo não existe"));
					return null;
				}		
	}
	
	
public List<Val_Campos_Trans_Doc> listarPorIdTrans(BigInteger id_trans_doc, Usuario usuario){
		
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
				
		try{		
		    
			if(id_trans_doc != null){		
			
				return val_Campos_Trans_DocRN.listarPorIdTransDoc(id_trans_doc,usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
			
			}else{
							
				return null;
				
			}
			
		
		}catch(Exception e){
		
			id_doc = null;
			e.printStackTrace();		
			return null;
		}
		
	}	

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public Val_Campos_Trans_Doc getValCampTrans() {
		return valCampTrans;
	}

	public void setValCampTrans(Val_Campos_Trans_Doc valCampTrans) {
		this.valCampTrans = valCampTrans;
	}

	public Val_Campos_Trans_Doc getVal_Campos_Trans_DocSelecionado() {
		return val_Campos_Trans_DocSelecionado;
	}

	public void setVal_Campos_Trans_DocSelecionado(Val_Campos_Trans_Doc val_Campos_Trans_DocSelecionado) {
		this.val_Campos_Trans_DocSelecionado = val_Campos_Trans_DocSelecionado;
	}

	public List<Val_Campos_Trans_Doc> getLista() {
		return lista;
	}

	public void setLista(List<Val_Campos_Trans_Doc> lista) {
		this.lista = lista;
	}

	public BigInteger getIdtransdoc() {
		return idtransdoc;
	}

	public void setIdtransdoc(BigInteger idtransdoc) {
		this.idtransdoc = idtransdoc;
	}

	public BigInteger getId_trans() {
		return id_trans;
	}

	public void setId_trans(BigInteger id_trans) {
		this.id_trans = id_trans;
	}

	public BigInteger getId_camp_adic() {
		return id_camp_adic;
	}

	public void setId_camp_adic(BigInteger id_camp_adic) {
		this.id_camp_adic = id_camp_adic;
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
	

	public BigInteger getId_doc() {
		return id_doc;
	}

	public void setId_doc(BigInteger id_doc) {
		this.id_doc = id_doc;
	}
	

	public Val_Campos_Trans_DocRN getVal_Campos_Trans_DocRN() {
		return val_Campos_Trans_DocRN;
	}

	public void setVal_Campos_Trans_DocRN(Val_Campos_Trans_DocRN val_Campos_Trans_DocRN) {
		this.val_Campos_Trans_DocRN = val_Campos_Trans_DocRN;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime * result + ((id_camp_adic == null) ? 0 : id_camp_adic.hashCode());
		result = prime * result + ((id_trans == null) ? 0 : id_trans.hashCode());
		result = prime * result + ((id_val_camp_trans_doc == null) ? 0 : id_val_camp_trans_doc.hashCode());
		result = prime * result + ((idtransdoc == null) ? 0 : idtransdoc.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((streamedContent == null) ? 0 : streamedContent.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valCampTrans == null) ? 0 : valCampTrans.hashCode());
		result = prime * result
				+ ((val_Campos_Trans_DocSelecionado == null) ? 0 : val_Campos_Trans_DocSelecionado.hashCode());
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
		Val_Campos_Trans_DocBean other = (Val_Campos_Trans_DocBean) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;
		if (id_camp_adic == null) {
			if (other.id_camp_adic != null)
				return false;
		} else if (!id_camp_adic.equals(other.id_camp_adic))
			return false;
		if (id_trans == null) {
			if (other.id_trans != null)
				return false;
		} else if (!id_trans.equals(other.id_trans))
			return false;
		if (id_val_camp_trans_doc == null) {
			if (other.id_val_camp_trans_doc != null)
				return false;
		} else if (!id_val_camp_trans_doc.equals(other.id_val_camp_trans_doc))
			return false;
		if (idtransdoc == null) {
			if (other.idtransdoc != null)
				return false;
		} else if (!idtransdoc.equals(other.idtransdoc))
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valCampTrans == null) {
			if (other.valCampTrans != null)
				return false;
		} else if (!valCampTrans.equals(other.valCampTrans))
			return false;
		if (val_Campos_Trans_DocSelecionado == null) {
			if (other.val_Campos_Trans_DocSelecionado != null)
				return false;
		} else if (!val_Campos_Trans_DocSelecionado.equals(other.val_Campos_Trans_DocSelecionado))
			return false;
		return true;
	}

	public Integer getId_val_camp_trans_doc() {
		return id_val_camp_trans_doc;
	}

	public void setId_val_camp_trans_doc(Integer id_val_camp_trans_doc) {
		this.id_val_camp_trans_doc = id_val_camp_trans_doc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}