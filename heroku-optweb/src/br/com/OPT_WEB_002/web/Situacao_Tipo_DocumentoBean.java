package br.com.OPT_WEB_002.web;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import br.com.OPT_WEB_002.situacao_tipo_documento.*;
import br.com.OPT_WEB_002.usuario.*;

@ManagedBean(name = "situacaoBean")
@ViewScoped
public class Situacao_Tipo_DocumentoBean {

	private Situacao_Tipo_Documento situacao_Tipo_Documento = new Situacao_Tipo_Documento();
	private Situacao_Tipo_Documento situacao_Tipo_DocumentoSelecionado = new Situacao_Tipo_Documento();
	private Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN;
	private Usuario usuario;
	private String cod_situacao;

	@PostConstruct
	public void init() {

		
		situacao_Tipo_Documento = new Situacao_Tipo_Documento();

	}
	

	public Situacao_Tipo_Documento iniciar(Usuario usuario) {
		
		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();
	
		if (cod_situacao == null) {			
			
			this.situacao_Tipo_Documento.setCod_empresa(usuario.getCod_empresa());
			this.situacao_Tipo_Documento.setCod_filial(usuario.getCod_filial());
			this.situacao_Tipo_Documento.setCod_unidade(usuario.getCod_unidade());						
			
			return this.situacao_Tipo_Documento;

		} else {

			situacao_Tipo_Documento = situacao_Tipo_DocumentoRN.carregar(cod_situacao);
			
			return situacao_Tipo_Documento;
		}
	}

	public String salvar() {

		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();

		if (cod_situacao == null) {

			situacao_Tipo_DocumentoRN.salvar(this.situacao_Tipo_Documento);
			return "/restrito/situacao_tipo_documento/situacao_tipo_documento.xhtml?faces-redirect=true";

		} else {

			situacao_Tipo_DocumentoRN.alterar(this.situacao_Tipo_Documento);

			return "/restrito/situacao_tipo_documento/situacao_tipo_documento.xhtml?faces-redirect=true";
		}
	}

	public String novo() {

		return "/restrito/situacao_tipo_documento/cadastro_situacao_tipo_documento.xhtml?faces-redirect=true";
	}

	public String alterar() {

		cod_situacao = situacao_Tipo_DocumentoSelecionado.getCod_campo() ;
		return "/restrito/situacao_tipo_documento/cadastro_situacao_tipo_documento.xhtml?cod= "
				+ cod_situacao + "faces-redirect=true";
	}

	public void excluir() {

		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();
		this.situacao_Tipo_Documento = situacao_Tipo_DocumentoRN.carregar(situacao_Tipo_DocumentoSelecionado.getCod_campo());

		situacao_Tipo_DocumentoRN.excluir(this.situacao_Tipo_Documento);

	}
	
	public List<Situacao_Tipo_Documento> listarPorSituacaoDocumento(BigInteger id_tipo_doc) {

		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();

		List<Situacao_Tipo_Documento> lista = new ArrayList<>();

		for (Situacao_Tipo_Documento situacao : situacao_Tipo_DocumentoRN.listarPorIdTipoDoc(id_tipo_doc)) {

			lista.add(situacao);

		}

		return lista;

	}

	public List<Situacao_Tipo_Documento> listarPorCodEmpCodFiCodUni(Usuario usuario) {

		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();
		return situacao_Tipo_DocumentoRN.listarPorCodEmpCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),
				usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());

	}

	public List<Situacao_Tipo_Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc) {

		Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN = new Situacao_Tipo_DocumentoRN();
		return situacao_Tipo_DocumentoRN.listarPorIdTipoDoc(id_tipo_doc);

	}

	public Situacao_Tipo_Documento getSituacao_Tipo_Documento() {
		return situacao_Tipo_Documento;
	}

	public void setSituacao_Tipo_Documento(Situacao_Tipo_Documento situacao_Tipo_Documento) {
		this.situacao_Tipo_Documento = situacao_Tipo_Documento;
	}

	public Situacao_Tipo_Documento getSituacao_Tipo_DocumentoSelecionado() {
		return situacao_Tipo_DocumentoSelecionado;
	}

	public void setSituacao_Tipo_DocumentoSelecionado(Situacao_Tipo_Documento situacao_Tipo_DocumentoSelecionado) {
		this.situacao_Tipo_DocumentoSelecionado = situacao_Tipo_DocumentoSelecionado;
	}

	public Situacao_Tipo_DocumentoRN getSituacao_Tipo_DocumentoRN() {
		return situacao_Tipo_DocumentoRN;
	}

	public void setSituacao_Tipo_DocumentoRN(Situacao_Tipo_DocumentoRN situacao_Tipo_DocumentoRN) {
		this.situacao_Tipo_DocumentoRN = situacao_Tipo_DocumentoRN;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getCod_situacao() {
		return cod_situacao;
	}


	public void setCod_situacao(String cod_situacao) {
		this.cod_situacao = cod_situacao;
	}

}
