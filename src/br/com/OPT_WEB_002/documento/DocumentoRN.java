
package br.com.OPT_WEB_002.documento;

import java.math.BigInteger;
import java.util.*;
import br.com.OPT_WEB_002.campo_adicional.*;
import br.com.OPT_WEB_002.tipo_documento_transacao.*;
import br.com.OPT_WEB_002.transacao_documento.*;
import br.com.OPT_WEB_002.util.*;
import br.com.OPT_WEB_002.val_campos_trans_doc.*;

public class DocumentoRN {

	private DocumentoDAO documentoDAO;

	public DocumentoRN() {
		
		this.documentoDAO = DAOFactory.criarDocumentoDAO();		
	}

	public void salvar(Documento documento) throws DAOException {
	
		DocumentoRN documentoRN = new DocumentoRN();
		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
	    Transacao_Documento transacao_Documento;	
		Tipo_Documento_TransacaoRN tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
		Campo_AdicionalRN campo_AdicionalRN = new Campo_AdicionalRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		Val_Campos_Trans_Doc val_Campos_Trans_Doc;
		BigInteger incremento = null;
				
		float resultadoTempo = 0;		
		float comparador = 0;	
		documento.setQuantidade(0);
					
		try {
			
			incremento = documentoRN.listarUltimoRegistro(documento.getId_tipo_doc().getId_tipo_doc(),documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade()).getId();
			  	
			documento.setId(incremento.add(BigInteger.valueOf(Long.parseLong("1"))));
				
					
			documentoDAO.salvar(documento);
		
		}catch(NullPointerException e) {
			
			e.printStackTrace();
		}
		
		if(incremento == null){
			documento.setId(BigInteger.valueOf(Long.parseLong("1")));
		}else{
			
			documento.setId(incremento.add(BigInteger.valueOf(Long.parseLong("1"))));
		}
		
		documentoDAO.salvar(documento);
		
		for(Tipo_Documento_Transacao tipo_Documento_Transacao : tipo_Documento_TransacaoRN.listarPorIdTipoDocCodEmCodFiCodUni(documento.getId_tipo_doc().getId_tipo_doc())){
			
			transacao_Documento = new Transacao_Documento();
		
			transacao_Documento.getCod_empresa().setCod_empresa(documento.getCod_empresa().getCod_empresa());
			transacao_Documento.getCod_filial().setCod_filial(documento.getCod_filial().getCod_filial());
			transacao_Documento.getCod_unidade().setCod_unidade(documento.getCod_unidade().getCod_unidade());
			transacao_Documento.getId_transacao().setId_transacao(tipo_Documento_Transacao.getId_transacao().getId_transacao());				
			transacao_Documento.getId_doc().setId_doc(documento.getId_doc());
					
			transacao_Documento.setEstado("Nao Iniciado");
			
			if(tipo_Documento_Transacao.getId_transacao().getTratamento_tempo() == true ){
					
					transacao_Documento.setUnidadeTempo(tipo_Documento_Transacao.getId_transacao().getUnidade_tempo());
					resultadoTempo = (documento.getQuantidade() * tipo_Documento_Transacao.getId_transacao().getTempo_operacao()) / tipo_Documento_Transacao.getId_transacao().getQuantidade();
			}
					
			transacao_Documento.setTempo_previsto(resultadoTempo);
			
			if(tipo_Documento_Transacao.getId_transacao().getTratamento_tempo() == false){
									
					transacao_Documento.setUnidadeTempo(tipo_Documento_Transacao.getId_transacao().getUnidade_tempo());
					transacao_Documento.setTempo_previsto(tipo_Documento_Transacao.getId_transacao().getTempo_operacao());								
			}
				
				
			if(documento.getQuantidade() == comparador){
				
					transacao_Documento.setTempo_previsto(comparador);
			}	
				
			transacao_DocumentoRN.salvar(transacao_Documento);
			
				for(Campo_Adicional campo_Adicional : campo_AdicionalRN.listarPorIdTransCodEmCodFiCodUni(transacao_Documento.getId_transacao().getId_transacao())){
			
						val_Campos_Trans_Doc = new  Val_Campos_Trans_Doc();
																					
						val_Campos_Trans_Doc.getId_trans_doc().setId_transacao_doc(transacao_Documento.getId_transacao_doc());							
						val_Campos_Trans_Doc.getCod_empresa().setCod_empresa(campo_Adicional.getCod_empresa().getCod_empresa());
						val_Campos_Trans_Doc.getCod_filial().setCod_filial(campo_Adicional.getCod_filial().getCod_filial());
						val_Campos_Trans_Doc.getCod_unidade().setCod_unidade(campo_Adicional.getCod_unidade().getCod_unidade());
						val_Campos_Trans_Doc.getId_camp_adic().setId_camp_adic(campo_Adicional.getId_camp_adic());
																					
						val_Campos_Trans_DocRN.salvar(val_Campos_Trans_Doc);	
					
				}		
		
		}
		
	}
		
					
	public void alterar(Documento documento) {		
		this.documentoDAO.alterar(documento);
	}
	
	public void  cadastrarDocumentoWebService(Documento documento) {
			
		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
	    Transacao_Documento transacao_Documento;	
		Tipo_Documento_TransacaoRN tipo_Documento_TransacaoRN = new Tipo_Documento_TransacaoRN();
		Campo_AdicionalRN campo_AdicionalRN = new Campo_AdicionalRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
		Val_Campos_Trans_Doc val_Campos_Trans_Doc;
				
		documento.setId(BigInteger.valueOf(Long.parseLong(String.valueOf(listarPorCodEmCodFiCodUni(documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade()).size()))).add(BigInteger.valueOf(Long.parseLong("1")))) ;
	
		 this.documentoDAO.cadastrarDocumentoWebService(documento);
		
		  for(Tipo_Documento_Transacao tipo_Documento_Transacao : tipo_Documento_TransacaoRN.listarPorIdTipoDocCodEmCodFiCodUniWebService(documento.getId_tipo_doc().getId_tipo_doc())){
		
				transacao_Documento = new Transacao_Documento();
								
				transacao_Documento.getCod_empresa().setCod_empresa(documento.getCod_empresa().getCod_empresa());
				transacao_Documento.getCod_filial().setCod_filial(documento.getCod_filial().getCod_filial());
				transacao_Documento.getCod_unidade().setCod_unidade(documento.getCod_unidade().getCod_unidade());
				transacao_Documento.getId_transacao().setId_transacao(tipo_Documento_Transacao.getId_transacao().getId_transacao());				
				transacao_Documento.getId_doc().setId_doc(documento.getId_doc());
						
				transacao_Documento.setEstado("Nao Iniciado");		
			
						transacao_DocumentoRN.cadastrarTransacaoDocumentoWebService(transacao_Documento);
						
						for(Campo_Adicional campo_Adicional : campo_AdicionalRN.listarPorIdTransCoEmCodFiCodUniWebService(transacao_Documento.getId_transacao().getId_transacao())){
						
							val_Campos_Trans_Doc = new  Val_Campos_Trans_Doc();
																						
							val_Campos_Trans_Doc.getId_trans_doc().setId_transacao_doc(transacao_Documento.getId_transacao_doc());							
							val_Campos_Trans_Doc.getCod_empresa().setCod_empresa(campo_Adicional.getCod_empresa().getCod_empresa());
							val_Campos_Trans_Doc.getCod_filial().setCod_filial(campo_Adicional.getCod_filial().getCod_filial());
							val_Campos_Trans_Doc.getCod_unidade().setCod_unidade(campo_Adicional.getCod_unidade().getCod_unidade());
							val_Campos_Trans_Doc.getId_camp_adic().setId_camp_adic(campo_Adicional.getId_camp_adic());
					
						    val_Campos_Trans_DocRN.cadastrarCampoAdicionalWebService(val_Campos_Trans_Doc);
							
						}
						
			}	
					 
	}

	public void excluir(Documento documento) throws DAOException {
				
		Transacao_DocumentoRN transacao_DocumentoRN = new Transacao_DocumentoRN();
		Val_Campos_Trans_DocRN val_Campos_Trans_DocRN = new Val_Campos_Trans_DocRN();
					
		for(Transacao_Documento transacao_Documento : transacao_DocumentoRN.listarPorIdDoc(documento.getId_doc(),documento.getCod_empresa().getCod_empresa(),documento.getCod_filial().getCod_filial(),documento.getCod_unidade().getCod_unidade())){
						
			for(Val_Campos_Trans_Doc val_Campos_Trans_Doc : val_Campos_Trans_DocRN.listarPorIdTransDoc(transacao_Documento.getId_transacao_doc(),transacao_Documento.getCod_empresa().getCod_empresa(),transacao_Documento.getCod_filial().getCod_filial(),transacao_Documento.getCod_unidade().getCod_unidade())){
				
				val_Campos_Trans_DocRN.excluir(val_Campos_Trans_Doc);			
			}
			
			transacao_DocumentoRN.excluir(transacao_Documento);
		}
			
		documentoDAO.excluir(documento);
	}
	
	public Documento carregar(BigInteger id_doc) {	
			
		return this.documentoDAO.carregar(id_doc);
	}
			
	public Documento listar() {			
		return documentoDAO.listar();
	}
		
	public List<Documento> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {		
		return this.documentoDAO.listarPorCodEmCodFiCodUni(cod_empresa,cod_filial, cod_unidade);
	}
	
	public List<Documento> listarPorIdTipoDocCodEmpCodFiCodUni(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){		
		return this.documentoDAO.listarPorIdTipoDocCodEmpCodFiCodUni(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
	}

	public List<Documento> listarPorCliente(String cliente,BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){					
			return documentoDAO.listarPorCliente(cliente,id_tipo_doc,cod_empresa,cod_filial,cod_unidade);			
	}
	
	public List<Documento> listarPorCodEmCodFi(Integer cod_empresa,Integer cod_filial){		
		return this.documentoDAO.listarPorCodEmCodFi(cod_empresa, cod_filial);
		
	}
	
	public List<Documento> listarPorIdDoc(BigInteger id_doc){		
		return this.documentoDAO.listarPorIdDoc(id_doc);
	}
	
	public Documento listarUltimoRegistro(BigInteger id_tipo_doc, Integer cod_empresa,Integer cod_filial,Integer cod_unidade){		
		return this.documentoDAO.listarUltimoId(id_tipo_doc,cod_empresa, cod_filial, cod_unidade);
	}
	
	public List<Documento> listarPorIdTipoDescCodEmpCodFiCodUni(BigInteger id_tipo_doc,String situacao,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){		
		return this.documentoDAO.listarPorIdTipoDescCodEmpCodFiCodUni(id_tipo_doc, situacao, cod_empresa, cod_filial, cod_unidade);
	}
	
	public  Documento consultaWebService(BigInteger id_doc){
		
		return documentoDAO.consultaWebService(id_doc);
	}
	
	public List<Documento> listarPorIdTipoDoc(BigInteger id_tipo_doc){
		
		return documentoDAO.listarPorIdTipoDoc(id_tipo_doc);
	}
	
	public DocumentoDAO getDocumentoDAO() {
		return documentoDAO;
	}

	public void setDocumentoDAO(DocumentoDAO documentoDAO) {
		this.documentoDAO = documentoDAO;
	}


}
