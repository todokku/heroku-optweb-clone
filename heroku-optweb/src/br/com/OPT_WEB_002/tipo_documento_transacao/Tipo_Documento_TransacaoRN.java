package br.com.OPT_WEB_002.tipo_documento_transacao;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Tipo_Documento_TransacaoRN {

	private Tipo_Documento_TransacaoDAO tipo_Documento_TransacaoDAO;
	private Usuario usuario;
	
	public Tipo_Documento_TransacaoRN(){

		this.tipo_Documento_TransacaoDAO = DAOFactory.criarTipoDocumentoTransacao();
				
	}
	
	public void salvar(Tipo_Documento_Transacao tipo_Documento_Transacao){

		if (listar().size() >= 1) {
					
			Tipo_Documento_Transacao tipo_Documento_Transacao2 = tipo_Documento_Transacao;
				
			/**Incremento da chave com +1 a partir do último id que está salvo no banco de dados**/
			tipo_Documento_Transacao2.setId_tipo_doc_trans(listarUltimoId().getId_tipo_doc_trans().add(BigInteger.valueOf(Long.parseLong("1"))));
	
			this.tipo_Documento_TransacaoDAO.salvar(tipo_Documento_Transacao2);	
					
		}else{
				
			String idString = "1";
			
			long id = Long.parseLong(idString);
			
			tipo_Documento_Transacao.setId_tipo_doc_trans(BigInteger.valueOf(id));
	
			this.tipo_Documento_TransacaoDAO.salvar(tipo_Documento_Transacao);
			
		}
	}
	
	public void alterar(Tipo_Documento_Transacao tipo_Documento_Transacao){
		
		this.tipo_Documento_TransacaoDAO.alterar(tipo_Documento_Transacao);
	}
	
	public Tipo_Documento_Transacao carregar(BigInteger id_tipo_doc_trans){
		
		return this.tipo_Documento_TransacaoDAO.carregar(id_tipo_doc_trans);
		
	}
	
	public void excluir (Tipo_Documento_Transacao tipo_Documento_Transacao) throws DAOException{
		
		this.tipo_Documento_TransacaoDAO.excluir(tipo_Documento_Transacao);
	}
	
	public List<Tipo_Documento_Transacao> listar(){
		
		return tipo_Documento_TransacaoDAO.listar();
	}
	
	public List<Tipo_Documento_Transacao> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
			
		return this. tipo_Documento_TransacaoDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}
	
	
	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUni(BigInteger id_tipo_doc){
		
		return this.tipo_Documento_TransacaoDAO.listarPorIdTipoDocCodEmCodFiCodUni(id_tipo_doc);
	}
	
	public List<Tipo_Documento_Transacao> listarPorIdTipoDocCodEmCodFiCodUniWebService(BigInteger id_tipo_doc){
		
		return this.tipo_Documento_TransacaoDAO.listarPorIdTipoDocCodEmCodFiCodUniWebService(id_tipo_doc);
	}
	
	public Tipo_Documento_Transacao listarUltimoId(){
		
		return this.tipo_Documento_TransacaoDAO.listarUtlimoId();
	}
	
	public Tipo_Documento_Transacao carregarPorIdTransIdTipo(BigInteger id_transacao,BigInteger id_tipo_doc){
		
		return this.tipo_Documento_TransacaoDAO.carregarPorIdTransIdTipo(id_transacao, id_tipo_doc);
	}
	
	
	public Tipo_Documento_TransacaoDAO getTipo_Documento_TransacaoDAO() {
		return tipo_Documento_TransacaoDAO;
	}

	public void setTipo_Documento_TransacaoDAO(Tipo_Documento_TransacaoDAO tipo_Documento_TransacaoDAO) {
		this.tipo_Documento_TransacaoDAO = tipo_Documento_TransacaoDAO;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
