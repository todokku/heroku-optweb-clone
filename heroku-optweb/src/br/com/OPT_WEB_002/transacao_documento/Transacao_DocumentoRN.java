package br.com.OPT_WEB_002.transacao_documento;

import java.math.BigInteger;
import java.util.*;
import br.com.OPT_WEB_002.util.*;
import br.com.OPT_WEB_002.val_campos_trans_doc.*;



public class Transacao_DocumentoRN {

	private Transacao_DocumentoDAO transacaoDocumentoDAO;

	private BigInteger totalTransDoc;

	public Transacao_DocumentoRN() {
       
		this.transacaoDocumentoDAO = DAOFactory.criarTransacaoDocumentoDAO();		
	}

	public void salvar(Transacao_Documento transacao_documento) throws DAOException {
	
		transacao_documento.setEstado("Nao Iniciado");
		this.transacaoDocumentoDAO.salvar(transacao_documento);	
	
	}

	public void cadastrarTransacaoDocumentoWebService(Transacao_Documento transacao_documento) {
		
		  try{	  
			  
			  transacaoDocumentoDAO.cadastrarTransacaoDocumentoWebService(transacao_documento);
		  
		  }catch(Exception e){
			  
			  e.printStackTrace();
		  }
		  
		  
	}

	public void excluir(Transacao_Documento transacao_documento) throws DAOException {

		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
			
		for(Val_Campos_Trans_Doc val_Campos_Trans_Doc : val_Campos_Trans_DocRN.listarPorIdTransDoc(transacao_documento.getId_transacao_doc(),transacao_documento.getCod_empresa().getCod_empresa(),transacao_documento.getCod_filial().getCod_filial(),transacao_documento.getCod_unidade().getCod_unidade())){
			
			val_Campos_Trans_DocRN.excluir(val_Campos_Trans_Doc);
		}
		
		this.transacaoDocumentoDAO.excluir(transacao_documento);
	}

	public void alterar(Transacao_Documento transacao_documento) {
		
		this.transacaoDocumentoDAO.alterar(transacao_documento);
	}

	public List<Transacao_Documento> listar() {
		
		return transacaoDocumentoDAO.listar();
	}
	
	public List<Transacao_Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {

		return this.transacaoDocumentoDAO.listarPorCodEmCodFiCodUni(cod_empresa,cod_filial,cod_unidade);
	}
	
	public Transacao_Documento carregar(BigInteger id_transacao){
		
		return this.transacaoDocumentoDAO.carregar(id_transacao);
	}

	public Transacao_Documento carregarPorIdTransDocCodEmpCodFiCodUni(BigInteger id_transacao_doc,Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		
		return this.transacaoDocumentoDAO.carregarPorIdTransDocCodEmpCodFiCodUni(id_transacao_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Transacao_Documento> listarPorIdDoc(BigInteger id_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.transacaoDocumentoDAO.listarPorIdDoc(id_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Transacao_Documento> listarPorIdTrans(BigInteger id_transacao_doc){
		
		return transacaoDocumentoDAO.listarPorIdTrans(id_transacao_doc);
	}
			
	public Transacao_Documento listarUltimoId(){
		
		return this.transacaoDocumentoDAO.listarUltimoId();
	}
	
	public Transacao_Documento consultaWebService(BigInteger id_transacao_doc){
		
		return transacaoDocumentoDAO.consultaWebService(id_transacao_doc);
	}
	
	public Transacao_DocumentoDAO getTransacaoEtiquetaDAO() {
		return transacaoDocumentoDAO;
	}

	public void setTransacaoEtiquetaDAO(Transacao_DocumentoDAO transacaoEtiquetaDAO) {
		this.transacaoDocumentoDAO = transacaoEtiquetaDAO;
	}

	public Transacao_DocumentoDAO getTransacaoDocumentoDAO() {
		return transacaoDocumentoDAO;
	}

	public void setTransacaoDocumentoDAO(Transacao_DocumentoDAO transacaoDocumentoDAO) {
		this.transacaoDocumentoDAO = transacaoDocumentoDAO;
	}

	public BigInteger getTotalTransDoc() {
		return totalTransDoc;
	}

	public void setTotalTransDoc(BigInteger totalTransDoc) {
		this.totalTransDoc = totalTransDoc;
	}

}
