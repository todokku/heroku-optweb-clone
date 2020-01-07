
package br.com.OPT_WEB_002.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import br.com.OPT_WEB_002.campo_adicional.*;
import br.com.OPT_WEB_002.documento.Documento;
import br.com.OPT_WEB_002.documento.DocumentoRN;
import br.com.OPT_WEB_002.transacao.*;
import br.com.OPT_WEB_002.transacao_documento.*;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;


@ManagedBean(name = "transacaoDocumentoBean")
@ViewScoped
public class Transacao_DocumentoBean {

	private Transacao_Documento transacao_documento;
	private Transacao_Documento transacao_documentoSelecionada;
	private BigInteger id_transacao;
	private BigInteger id_transacao_documento;
	private BigInteger id_trans_doc;	
	private BigInteger id_doc;
	private UploadedFile arquivo;
	private StreamedContent streamedContent;
	private LazyDataModel<Transacao_Documento> lazymodel;
	private Usuario usuario;
	private Documento documento;
	private Transacao_DocumentoRN transacao_DocumentoRN;
	private BigInteger id_tipo_doc;
	private boolean carregaTrans;
		
	public Transacao_DocumentoBean() {}
	
	 @PostConstruct
	    public void init() {	    
		 
		this.documento = new Documento();		 
		this.transacao_documento = new Transacao_Documento();
		transacao_documentoSelecionada = new Transacao_Documento();
				
	 }
	 	 
	public BigInteger selecionarLinhaTransDoc(SelectEvent event) {
					
			String idTransDoc = ((Transacao_Documento) event.getObject()).getId_transacao_doc().toString();					
			this.id_trans_doc =  BigInteger.valueOf(Long.parseLong(idTransDoc));	
		
			return this.id_trans_doc;
	}
		
	public String alterar(BigInteger id_tipo_doc){
		
		if(this.transacao_documentoSelecionada == null){
			
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,null, "Item nao foi selecionado!"));
			return null;		
			
		}else{
		
			return "/restrito/transacao_documento/cadastro_transacao_documento.xhtml?id=" + id_tipo_doc + "&tr=" + this.transacao_documentoSelecionada.getId_transacao_doc()  + "faces-redirect=true";
		}
	}
	
	public List<Transacao_Documento> listarPorIdTransDoc(BigInteger id_trans_doc){
		
		transacao_DocumentoRN = new Transacao_DocumentoRN();
		
			try{
		
				return transacao_DocumentoRN.listarPorIdTrans(id_trans_doc);	
				
			}catch(Exception e){
				
				id_trans_doc = null;
				e.printStackTrace();
				return null;
			}
				
	}
	
	public String tamanhoNomeArquivo(String label){
	
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
		
	
	public String descricaoDeAnexo(Transacao_Documento transacao_Documento){
	
		if(transacao_Documento.getNome_arquivo() != null){
	
			return transacao_Documento.getNome_arquivo();
		}else{

			return "Upload";
		}		
	}
		
	public Transacao_Documento iniciar(Usuario usuario) {
		
		transacao_DocumentoRN = null;
		transacao_DocumentoRN = new Transacao_DocumentoRN();			
			
		if (this.transacao_documentoSelecionada.getId_transacao_doc() == null) {
								
	
					this.transacao_documento.setCod_empresa(usuario.getCod_empresa());
					this.transacao_documento.setCod_filial(usuario.getCod_filial());
					this.transacao_documento.setCod_unidade(usuario.getCod_unidade());
					this.transacao_documento.getId_doc().setId_doc(id_doc);	
					
					return this.transacao_documento;
							
		} else {
					
			this.transacao_documento = transacao_DocumentoRN.carregar(this.transacao_documentoSelecionada.getId_transacao_doc());				
			return this.transacao_documento;
		}
		
	}
		
	
public String salvar() throws DAOException {

		transacao_DocumentoRN = new Transacao_DocumentoRN();	
		DocumentoRN documentoRN = new DocumentoRN();
		    			
		if (this.transacao_documentoSelecionada.getId_transacao_doc() == null) {
						
					if(arquivo.getFileName().contains(".pdf")){	
						
						this.transacao_documento.setExtensaoarq(".pdf");						
					}
				
					else if(arquivo.getFileName().contains(".xlsx")){
					
						this.transacao_documento.setExtensaoarq(".xlsx");	
						
					}else if(arquivo.getFileName().contains(".doc")){						
							
							this.transacao_documento.setExtensaoarq(".doc");
						
					}else if(arquivo.getFileName().contains(".docx")){						
						
						this.transacao_documento.setExtensaoarq(".docx");						
								
					}else if(arquivo.getFileName().contains(".txt")){					
						
						this.transacao_documento.setExtensaoarq(".txt");								
					}
					
					else if(arquivo.getFileName().contains(".htm")){						
						
						this.transacao_documento.setExtensaoarq(".html");
					}	

					else if (arquivo.getFileName().contains(".jpeg")) {
						
						this.transacao_documento.setExtensaoarq(".jpeg");			
			
					} else if (arquivo.getFileName().contains(".png")) {
						
						this.transacao_documento.setExtensaoarq(".png");			
								
					} else if (arquivo.getFileName().contains(".bmp")) {
						
						this.transacao_documento.setExtensaoarq(".bmp");
					}
								
					 else if (arquivo.getFileName().contains(".rar")) {
						 
						this.transacao_documento.setExtensaoarq(".rar");
					}
		
					else if(arquivo.getFileName().contains(".zip")) {
						
						this.transacao_documento.setExtensaoarq(".zip");
					}
					
					else if(arquivo.getFileName().contains(".ppt")) {
						
						this.transacao_documento.setExtensaoarq(".ppt");
					}
					
					else if(arquivo.getFileName().contains(".pptx")) {
						
						this.transacao_documento.setExtensaoarq(".pptx");
					}
					
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());
					
							try {
									
								this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					
							} catch (IOException e) {					
								FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));			
							}
				
							this.transacao_documento.getId_doc().setId_doc(documentoRN.carregar(this.documento.getId_doc()).getId_doc());
							transacao_DocumentoRN.salvar(this.transacao_documento);
				 					
										
								/**if(campo_AdicionalRN.listarPorIdTransCodEmCodFiCodUni(this.transacao_documento.getId_transacao().getId_transacao()).isEmpty()){
								
									return "/restrito/documento/documento.xhtml?faces-redirect=true";
						
								}**/
					      
								return "/restrito/documento/documento.xhtml?id=" + id_tipo_doc +  "&doc=" + this.transacao_documento.getId_doc().getId_doc() + "faces-redirect=true";
						
		}else{
			
			try {
	
				if(arquivo.getFileName().contains(".pdf") && arquivo != null){
				
					this.transacao_documento.setExtensaoarq(".pdf");
					this.transacao_documento.setNome_arquivo(arquivo.getFileName());			
					this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
				
				}		
					else if(arquivo.getFileName().contains(".xlsx") && arquivo != null){
					
						this.transacao_documento.setExtensaoarq(".xlsx");
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());		
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
						
					}else if(arquivo.getFileName().contains(".doc") && arquivo != null){
						
					    this.transacao_documento.setExtensaoarq(".doc");
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());					
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
				
					}else if(arquivo.getFileName().contains(".docx") && arquivo != null){
				
					    this.transacao_documento.setExtensaoarq(".docx");
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());					
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
				
					}else if(arquivo.getFileName().contains(".txt") && arquivo != null){
				
						this.transacao_documento.setExtensaoarq(".txt");
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
				
					else if(arquivo.getFileName().contains(".htm") && arquivo != null){
				
						this.transacao_documento.setExtensaoarq(".html");
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}

					else if (arquivo.getFileName().contains(".jpeg")) {
						
						this.transacao_documento.setExtensaoarq(".jpeg");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
			
					} else if (arquivo.getFileName().contains(".png")) {
					
						this.transacao_documento.setExtensaoarq(".png");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
								
					} else if (arquivo.getFileName().contains(".bmp")) {
						
						this.transacao_documento.setExtensaoarq(".bmp");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					
					}else if (arquivo.getFileName().contains(".rar")) {
						
						this.transacao_documento.setExtensaoarq(".rar");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
								
					} else if (arquivo.getFileName().contains(".zip")) {
						
						this.transacao_documento.setExtensaoarq(".zip");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
						
					else if (arquivo.getFileName().contains(".ppt")) {
						
						this.transacao_documento.setExtensaoarq(".ppt");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
								
					} else if (arquivo.getFileName().contains(".pptx")) {
						
						this.transacao_documento.setExtensaoarq(".pptx");	
						this.transacao_documento.setNome_arquivo(arquivo.getFileName());						
						this.transacao_documento.setArquivo(IOUtils.toByteArray(arquivo.getInputstream()));
					}
				
				} catch (IOException e) {				
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
				}	
					
				transacao_DocumentoRN.alterar(this.transacao_documento);				
				return "/restrito/documento/documento.xhtml?id=" + this.transacao_documento.getId_doc().getId_tipo_doc().getId_tipo_doc() + "&doc=" + transacao_documento.getId_doc().getId_doc() + "faces-redirect=true";			
		}
		
	}

	
	
	public boolean verificarId(Usuario usuario) {

		Transacao transacao = new Transacao();
		TransacaoRN transacaoRN = new TransacaoRN();
		Campo_AdicionalRN campo_AdicionalRN = new Campo_AdicionalRN();

		transacao = transacaoRN.carregar(this.id_transacao,usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());

		String listaCampoAdicional = campo_AdicionalRN.listar().toString();

		if (transacao != null && listaCampoAdicional.contains(this.id_transacao.toString())) {

			return true;

		} else {

			return false;
		}
		
	}

	public void excluir() {

		transacao_DocumentoRN = new Transacao_DocumentoRN();

		this.transacao_documento = transacao_DocumentoRN.carregarPorIdTransDocCodEmpCodFiCodUni(this.transacao_documentoSelecionada.getId_transacao_doc(),transacao_documentoSelecionada.getCod_empresa().getCod_empresa(),transacao_documentoSelecionada.getCod_filial().getCod_filial(),transacao_documentoSelecionada.getCod_unidade().getCod_unidade());

		try {

			transacao_DocumentoRN.excluir(this.transacao_documento);
			
		} catch (DAOException e) {

			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
		}

	
	}

	public String novo(BigInteger id_tipo_doc,BigInteger id_doc) {
	
		return "/restrito/transacao_documento/cadastro_transacao_documento.xhtml?id=" + id_tipo_doc + "&doc=" + id_doc + "faces-redirect=true";
	}

		
	public boolean desabilitarCampos() {

		if (this.transacao_documentoSelecionada.getId_transacao_doc() == null){

			return false;
			
		}else{

			return true;
			
		}
	}
	
	public boolean desabilitarId() {

		if (this.transacao_documentoSelecionada.getId_transacao_doc() != null) {

			return true;
		}

		return false;
	}

	public List<Transacao_Documento> listarPorCodEmCodFiCodUni(Usuario usuario) {
		
		Transacao_DocumentoRN transacao_DocumentoRN = new  Transacao_DocumentoRN();		
	
		if(this.usuario != null){
			return transacao_DocumentoRN.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		}else{
			return null;
		}	
	}	
		
	public Transacao_Documento preencherCodDesc(Usuario usuario){
		
		TransacaoRN transacaoRN = new TransacaoRN();
		Transacao transacao = new Transacao();
		
		try{
			
		transacao = transacaoRN.carregar(iniciar(usuario).getId_transacao().getId_transacao(),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		
		this.transacao_documento.setId_transacao(transacao);
		    
		return this.transacao_documento;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String redireciona(){
	
		return "/restrito/documento/documento.xhtml?id=" + id_tipo_doc + "faces-redirect=true";
	}
	
	public Transacao_Documento preencherDataeHora() throws ParseException{
						
		   if(transacao_documento.getEstado().contentEquals("Iniciado")){
				
				LocalDate datacorrente = LocalDate.now();									
				this.transacao_documento.setData_ini(Date.valueOf(datacorrente.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
								
				LocalTime horariocorrente = LocalTime.now(ZoneId.of("Brazil/East"));
				
				String horario = horariocorrente.getHour() + ":" + horariocorrente.getMinute() + ":" + horariocorrente.getSecond();						    
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				this.transacao_documento.setHorario_ini(sdf.parse(horario));
		
				return this.transacao_documento;
				
			}else if(this.transacao_documento.getEstado().contentEquals("Finalizado")){
				
				LocalDate datacorrente = LocalDate.now();									
				this.transacao_documento.setData_fim(Date.valueOf(datacorrente.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
								
				LocalTime horariocorrente = LocalTime.now();				
				String horario = horariocorrente.getHour() + ":" + horariocorrente.getMinute() + ":" + horariocorrente.getSecond();						    
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				
				this.transacao_documento.setHorario_fim(sdf.parse(horario));
				
				return this.transacao_documento;		
			}
		   
		return null;			
	}
	
	public String verificaArquivoAnexado(String arquivo){
		
		if(arquivo.isEmpty()){
			return "";
					
		}else{
			
			return "/imagens/file.png";
		}		
		
	}

	public StreamedContent getStreamedContent(Usuario usuario) {	
			
			Transacao_Documento transacao_Documento = new Transacao_Documento();
			Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
		
			
			String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTransDoc");
				
			long id = Long.parseLong(idString);
	
			transacao_Documento = transacao_DocumentoRN.carregarPorIdTransDocCodEmpCodFiCodUni(BigInteger.valueOf(id),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());		
			
			if(transacao_Documento.getArquivo() != null){
						
				InputStream in = new ByteArrayInputStream(transacao_Documento.getArquivo());
			
				this.streamedContent = new DefaultStreamedContent(in,transacao_Documento.getExtensaoarq(),transacao_Documento.getNome_arquivo());
					
				return this.streamedContent;
			
					}else{
				
						FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "O arquivo nao existe"));
						return null;
			}
				
		}	
	
	
	public List<Transacao_Documento> listarPorIdDoc(Usuario usuario,BigInteger idDocSelecionado,BigInteger id_doc) {

		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
		System.out.println("doc selecionado" + idDocSelecionado);
		System.out.println("id_doc" + id_doc);
		try {

			
			if(idDocSelecionado != null){
			
				return transacao_DocumentoRN.listarPorIdDoc(idDocSelecionado, usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(), usuario.getCod_unidade().getCod_unidade());
			
			}else{
				
				if(id_doc != null){
								
					return transacao_DocumentoRN.listarPorIdDoc(id_doc, usuario.getCod_empresa().getCod_empresa(),
							usuario.getCod_filial().getCod_filial(), usuario.getCod_unidade().getCod_unidade());
				}else{
					return null;
				}
				
			}
						
		} catch (Exception e) {
		
			e.printStackTrace();			
			id_trans_doc = null;
			return null;

		}

	}
	
	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public Transacao_Documento getTransacao_documento() {
		return transacao_documento;
	}

	public void setTransacao_documento(Transacao_Documento transacao_documento) {
		this.transacao_documento = transacao_documento;
	}

	public Transacao_Documento getTransacao_documentoSelecionada() {
		return transacao_documentoSelecionada;
	}

	public void setTransacao_documentoSelecionada(Transacao_Documento transacao_documentoSelecionada) {
		this.transacao_documentoSelecionada = transacao_documentoSelecionada;
	}

	public BigInteger getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(BigInteger id_transacao) {
		this.id_transacao = id_transacao;
	}

	public BigInteger getId_doc() {
		return id_doc;
	}


	public void setId_doc(BigInteger id_doc) {
		this.id_doc = id_doc;
	}


	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}

	public LazyDataModel<Transacao_Documento> getLazymodel() {
		return lazymodel;
	}

	public void setLazymodel(LazyDataModel<Transacao_Documento> lazymodel) {
		this.lazymodel = lazymodel;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigInteger getId_trans_doc() {
		return id_trans_doc;
	}

	public void setId_trans_doc(BigInteger id_trans_doc) {
		this.id_trans_doc = id_trans_doc;
	}
	
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public Transacao_DocumentoRN getTransacao_DocumentoRN() {
		return transacao_DocumentoRN;
	}

	public void setTransacao_DocumentoRN(Transacao_DocumentoRN transacao_DocumentoRN) {
		this.transacao_DocumentoRN = transacao_DocumentoRN;
	}

	public BigInteger getId_transacao_documento() {
		return id_transacao_documento;
	}

	public void setId_transacao_documento(BigInteger id_transacao_documento) {
		this.id_transacao_documento = id_transacao_documento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());			
		result = prime * result + ((id_doc == null) ? 0 : id_doc.hashCode());
		result = prime * result + ((id_trans_doc == null) ? 0 : id_trans_doc.hashCode());
		result = prime * result + ((id_transacao == null) ? 0 : id_transacao.hashCode());
		result = prime * result + ((lazymodel == null) ? 0 : lazymodel.hashCode());		
		result = prime * result + ((streamedContent == null) ? 0 : streamedContent.hashCode());
		result = prime * result + ((transacao_documento == null) ? 0 : transacao_documento.hashCode());
		result = prime * result + ((transacao_documentoSelecionada == null) ? 0 : transacao_documentoSelecionada.hashCode());
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
		Transacao_DocumentoBean other = (Transacao_DocumentoBean) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;		
		if (id_doc == null) {
			if (other.id_doc != null)
				return false;
		} else if (!id_doc.equals(other.id_doc))
			return false;
		if (id_trans_doc == null) {
			if (other.id_trans_doc != null)
				return false;
		} else if (!id_trans_doc.equals(other.id_trans_doc))
			return false;
		if (id_transacao == null) {
			if (other.id_transacao != null)
				return false;
		} else if (!id_transacao.equals(other.id_transacao))
			return false;
		if (lazymodel == null) {
			if (other.lazymodel != null)
				return false;
		} else if (!lazymodel.equals(other.lazymodel))
			return false;		
		if (streamedContent == null) {
			if (other.streamedContent != null)
				return false;
		} else if (!streamedContent.equals(other.streamedContent))
			return false;
		if (transacao_documento == null) {
			if (other.transacao_documento != null)
				return false;
		} else if (!transacao_documento.equals(other.transacao_documento))
			return false;
		if (transacao_documentoSelecionada == null) {
			if (other.transacao_documentoSelecionada != null)
				return false;
		} else if (!transacao_documentoSelecionada.equals(other.transacao_documentoSelecionada))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public BigInteger getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(BigInteger id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public boolean isCarregaTrans() {
		return carregaTrans;
	}

	public void setCarregaTrans(boolean carregaTrans) {
		this.carregaTrans = carregaTrans;
	}

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	

}

