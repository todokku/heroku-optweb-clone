package br.com.OPT_WEB_002.val_campos_trans_doc;

import java.math.BigInteger;
import java.util.List;


import br.com.OPT_WEB_002.util.DAOException;

public interface Val_Campos_Trans_DocDAO {

	public void salvar(Val_Campos_Trans_Doc valCamp) throws DAOException;

	public void alterar(Val_Campos_Trans_Doc valCamp);
	
	public void excluir(Val_Campos_Trans_Doc valCamp) throws DAOException;
	
	public Val_Campos_Trans_Doc carregar(Integer id_val_camp_trans_doc);
	
	public List<Val_Campos_Trans_Doc> listar();	
				
	public List<Val_Campos_Trans_Doc> listarPorIdTransDoc(BigInteger id_trans_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Val_Campos_Trans_Doc> carregarPorIdCampAdic(BigInteger id_camp_adic,BigInteger id_trans_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
		
	public List<Val_Campos_Trans_Doc> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public Val_Campos_Trans_Doc listarUltimoId(); 
	
	public List<Val_Campos_Trans_Doc> listarPorValCampoTransDoc(BigInteger id_val_camp_trans_doc);
	
	public void cadastrarCampoAdicionalWebService (Val_Campos_Trans_Doc val_Campos_Trans_Doc);
	


}

