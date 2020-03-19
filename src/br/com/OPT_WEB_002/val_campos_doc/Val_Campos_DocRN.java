package br.com.OPT_WEB_002.val_campos_doc;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Val_Campos_DocRN {

	private Val_Campos_DocDAO val_Campos_DocDAO;
	private Usuario usuario;
		
		
	public Val_Campos_DocRN() {		
			this.val_Campos_DocDAO = DAOFactory.criarValCamposDoc();
			
	}
						
	
		public void salvar(Val_Campos_Doc val_Campos_Doc) {
		
			if (listar().size() >= 1) {
			
				Val_Campos_Doc val_Campos_Doc2 = val_Campos_Doc;
			
				val_Campos_Doc2.setId_val_campos_doc(listarUltimoId().getId_val_campos_doc().add(BigInteger.valueOf(Long.parseLong("1"))));
			
				this.val_Campos_DocDAO.salvar(val_Campos_Doc2);			
					
			}else{
							
				val_Campos_Doc.setId_val_campos_doc(BigInteger.valueOf((Long.parseLong("1"))));
			
				this.val_Campos_DocDAO.salvar(val_Campos_Doc);
				
		}
		}
	
		public List<Val_Campos_Doc> listarPorCodEmpresaCodFilialCodUnidade(Integer cod_empresa, Integer cod_filial,
		Integer cod_unidade) {
		
			return val_Campos_DocDAO.listarPorCodEmpresaCodFilialCodUnidade(cod_empresa,cod_filial,cod_unidade);
		}
		
	
		public List<Val_Campos_Doc> listar(){
			
			return val_Campos_DocDAO.listar();
		}
		
		public void excluir(Val_Campos_Doc val_Campos_Doc) {
			
			val_Campos_DocDAO.excluir(val_Campos_Doc);
		}
		
	
		public Val_Campos_Doc carregar(BigInteger id_val_campos_doc) {
			
			return val_Campos_DocDAO.carregar(id_val_campos_doc);
		}
		
		
		public List<Val_Campos_Doc> listarPorIdTipoDocIdLay(BigInteger id_tipo_doc,BigInteger id_layout_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
					
			return val_Campos_DocDAO.listarPorIdTipoDocIdLay(id_tipo_doc,id_layout_tipo_doc,cod_empresa, cod_filial, cod_unidade);
		}
		
		public List<Val_Campos_Doc> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
			
			return val_Campos_DocDAO.listarPorIdTipoDoc(id_tipo_doc, cod_empresa, cod_filial, cod_unidade);
		}
		
		
		public void alterar(Val_Campos_Doc val_Campos_Doc) {
			
			val_Campos_DocDAO.alterar(val_Campos_Doc);
		}

		public Val_Campos_Doc listarUltimoId(){
			
			return val_Campos_DocDAO.listarUltimoId();
		}
		

		public Val_Campos_DocDAO getVal_Campos_DocDAO() {
			return val_Campos_DocDAO;
		}


		public void setVal_Campos_DocDAO(Val_Campos_DocDAO val_Campos_DocDAO) {
			this.val_Campos_DocDAO = val_Campos_DocDAO;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
}
	


