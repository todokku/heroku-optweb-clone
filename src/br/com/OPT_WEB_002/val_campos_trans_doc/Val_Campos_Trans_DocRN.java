package br.com.OPT_WEB_002.val_campos_trans_doc;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Val_Campos_Trans_DocRN {

	private Val_Campos_Trans_DocDAO valCampDAO;	
	

	public Val_Campos_Trans_DocRN() {
				
		valCampDAO = DAOFactory.criarValCampDAO();
				
	}

			public void salvar(Val_Campos_Trans_Doc valCamp) throws DAOException {
							
			this.valCampDAO.salvar(valCamp);
	
			}				
		
	public void excluir(Val_Campos_Trans_Doc valCamp) throws DAOException {

		this.valCampDAO.excluir(valCamp);
	}

	public void alterar(Val_Campos_Trans_Doc valCamp) {

		this.valCampDAO.alterar(valCamp);
	}

	public Val_Campos_Trans_Doc carregar(Integer id_val_camp_trans_etiq){
		
		return this.valCampDAO.carregar(id_val_camp_trans_etiq);
	}
	
	public List<Val_Campos_Trans_Doc> listar() {

		return valCampDAO.listar(); 
	}
	
	public List<Val_Campos_Trans_Doc> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.valCampDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}
				
	public List<Val_Campos_Trans_Doc> listarPorIdTransDoc(BigInteger id_trans_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.valCampDAO.listarPorIdTransDoc(id_trans_doc, cod_empresa, cod_filial, cod_unidade);
	}
	
	
	public List<Val_Campos_Trans_Doc> carregarPorIdCampAdic(BigInteger id_camp_adic,BigInteger id_trans_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
			
			return this.valCampDAO.carregarPorIdCampAdic(id_camp_adic,id_trans_doc, cod_empresa, cod_filial, cod_unidade);
			
	} 
	
	public List<Val_Campos_Trans_Doc> listarPorValCampoTransDoc(BigInteger id_val_camp_trans_doc){
		
		return valCampDAO.listarPorValCampoTransDoc(id_val_camp_trans_doc);
	}
	
	public Val_Campos_Trans_Doc listarUltimoid(){
		
		return this.valCampDAO.listarUltimoId();
	}
	
	public Val_Campos_Trans_DocDAO getValCampDAO() {
		return valCampDAO;
	}

	public void setValCampDAO(Val_Campos_Trans_DocDAO valCampDAO) {
		this.valCampDAO = valCampDAO;
	}
	
	public void cadastrarCampoAdicionalWebService(Val_Campos_Trans_Doc val_Campos_Trans_Doc) {
		
		
		this.valCampDAO.cadastrarCampoAdicionalWebService(val_Campos_Trans_Doc);
	}

	
}
