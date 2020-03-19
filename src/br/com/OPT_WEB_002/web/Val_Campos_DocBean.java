package br.com.OPT_WEB_002.web;

import java.math.BigInteger;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import br.com.OPT_WEB_002.grupo_valores.Grupo_Valores;
import br.com.OPT_WEB_002.layout_empresa.*;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.val_campos_doc.*;


@ManagedBean(name = "valCampDocBean")
@ViewScoped
public class Val_Campos_DocBean {

	private Val_Campos_Doc val_Campos_Doc;
	private Val_Campos_Doc val_Campos_DocSelecionado;
	private BigInteger  id_val_campos_doc;	
	private Usuario usuario;
	private Val_Campos_DocRN val_Campos_DocRN;
	private Layout_Empresa layout_Empresa = new Layout_Empresa();
	private Tipo_Documento tipo_Documento = new Tipo_Documento();
	private Grupo_Valores grupo_Valores = new Grupo_Valores();
		
	public Val_Campos_DocBean() {}
	
	@PostConstruct
	public void init(){
		
		val_Campos_Doc = new Val_Campos_Doc();
		val_Campos_DocSelecionado = new Val_Campos_Doc();		
		
	}
				
	public Val_Campos_Doc iniciar(Usuario usuario) {
	
	val_Campos_DocRN = null;	
	val_Campos_DocRN = new Val_Campos_DocRN();
	
			
		if(id_val_campos_doc == null){
				
			this.val_Campos_Doc.getCod_empresa().setCod_empresa(usuario.getCod_empresa().getCod_empresa());
			this.val_Campos_Doc.getCod_filial().setCod_filial(usuario.getCod_filial().getCod_filial());
			this.val_Campos_Doc.getCod_unidade().setCod_unidade(usuario.getCod_unidade().getCod_unidade());
	
			
			return this.val_Campos_Doc;
			
		}else{
		
			this.val_Campos_Doc = val_Campos_DocRN.carregar(id_val_campos_doc);
			return this.val_Campos_Doc;
			
		}				
					
	}
	
	public String salvar() {
				
		val_Campos_DocRN = null;	
		val_Campos_DocRN = new Val_Campos_DocRN();

		if(val_Campos_Doc.getId_val_campos_doc() == null){
			
				val_Campos_DocRN.salvar(val_Campos_Doc);					
				return "/restrito/val_campos_doc/val_campos_doc.xhtml?faces-redirect=true";
						
		}else{		
						
				val_Campos_DocRN.alterar(this.val_Campos_Doc);
				return "/restrito/val_campos_doc/val_campos_doc.xhtml?faces-redirect=true";
		}
	}
	
	

		
	public void excluir() {

		val_Campos_DocRN = null;	
		val_Campos_DocRN = new Val_Campos_DocRN();
		
		this.val_Campos_Doc = val_Campos_DocRN.carregar(val_Campos_DocSelecionado.getId_val_campos_doc());
		val_Campos_DocRN.excluir(this.val_Campos_Doc);

	}
	
	public List<Val_Campos_Doc> listarPorCodEmCodFiCodUni(Usuario usuario) {
		
		val_Campos_DocRN = null;	
		val_Campos_DocRN = new Val_Campos_DocRN();
		
		return val_Campos_DocRN.listarPorCodEmpresaCodFilialCodUnidade(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
	}
	
	public List<Layout_Empresa> listarPorIdTipoDoc(Usuario usuario){
		
		Layout_EmpresaRN layout_EmpresaRN = new Layout_EmpresaRN();
		
		if(iniciar(usuario).getId_tipo_doc().getId_tipo_doc() != null){		
			return layout_EmpresaRN.listarPorIdTipoDoc(iniciar(usuario).getId_tipo_doc().getId_tipo_doc(),usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		}else{
			
			return null;
		}
		
	}
		
	public String novo(){
		
		return "/restrito/val_campos_doc/cadastro_val_campos_doc.xthml?faces-redirect=true";
	}
	

	public String alterar(){
						
			return "/restrito/val_campos_doc/cadastro_val_campos_doc.xhtml?id=" + val_Campos_DocSelecionado.getId_val_campos_doc() +"faces-redirect=true";
	}

	public String tamanhoNomeArquivo(String label){
		
	if(label.length() > 10){
        return label.substring(0, 10);
	}
    else
       	return label;	
	}

	public Val_Campos_Doc getVal_Campos_Doc() {
		return val_Campos_Doc;
	}

	public void setVal_Campos_Doc(Val_Campos_Doc val_Campos_Doc) {
		this.val_Campos_Doc = val_Campos_Doc;
	}

	public Val_Campos_Doc getVal_Campos_DocSelecionado() {
		return val_Campos_DocSelecionado;
	}

	public void setVal_Campos_DocSelecionado(Val_Campos_Doc val_Campos_DocSelecionado) {
		this.val_Campos_DocSelecionado = val_Campos_DocSelecionado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public BigInteger getId_val_campos_doc() {
		return id_val_campos_doc;
	}

	public void setId_val_campos_doc(BigInteger id_val_campos_doc) {
		this.id_val_campos_doc = id_val_campos_doc;
	}
	
	public Val_Campos_DocRN getVal_Campos_DocRN() {
		return val_Campos_DocRN;
	}

	public void setVal_Campos_DocRN(Val_Campos_DocRN val_Campos_DocRN) {
		this.val_Campos_DocRN = val_Campos_DocRN;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_val_campos_doc == null) ? 0 : id_val_campos_doc.hashCode());		
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((val_Campos_Doc == null) ? 0 : val_Campos_Doc.hashCode());
		result = prime * result + ((val_Campos_DocSelecionado == null) ? 0 : val_Campos_DocSelecionado.hashCode());
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
		Val_Campos_DocBean other = (Val_Campos_DocBean) obj;
		if (id_val_campos_doc == null) {
			if (other.id_val_campos_doc != null)
				return false;
		} else if (!id_val_campos_doc.equals(other.id_val_campos_doc))
			return false;		
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (val_Campos_Doc == null) {
			if (other.val_Campos_Doc != null)
				return false;
		} else if (!val_Campos_Doc.equals(other.val_Campos_Doc))
			return false;
		if (val_Campos_DocSelecionado == null) {
			if (other.val_Campos_DocSelecionado != null)
				return false;
		} else if (!val_Campos_DocSelecionado.equals(other.val_Campos_DocSelecionado))
			return false;
		return true;
	}

	public Layout_Empresa getLayout_Empresa() {
		return layout_Empresa;
	}

	public void setLayout_Empresa(Layout_Empresa layout_Empresa) {
		this.layout_Empresa = layout_Empresa;
	}

	public Tipo_Documento getTipo_Documento() {
		return tipo_Documento;
	}

	public void setTipo_Documento(Tipo_Documento tipo_Documento) {
		this.tipo_Documento = tipo_Documento;
	}

	public Grupo_Valores getGrupo_Valores() {
		return grupo_Valores;
	}

	public void setGrupo_Valores(Grupo_Valores grupo_Valores) {
		this.grupo_Valores = grupo_Valores;
	}

	
	    
  
	
}