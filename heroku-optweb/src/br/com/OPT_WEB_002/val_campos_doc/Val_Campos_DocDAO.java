package br.com.OPT_WEB_002.val_campos_doc;

import java.math.BigInteger;
import java.util.List;

public interface Val_Campos_DocDAO {

	public void salvar (Val_Campos_Doc val_Campos_Doc);
	
	public void alterar (Val_Campos_Doc val_Campos_Doc);
	
	public void excluir (Val_Campos_Doc val_Campos_Doc); 
	
	public Val_Campos_Doc carregar(BigInteger id_val_campos_doc); 
	
	public List<Val_Campos_Doc> listar();
			
	public List<Val_Campos_Doc> listarPorCodEmpresaCodFilialCodUnidade(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Val_Campos_Doc> listarPorIdTipoDocIdLay(BigInteger id_tipo_doc,BigInteger id_layout_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Val_Campos_Doc> listarPorIdTipoDoc(BigInteger id_tipo_doc,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public Val_Campos_Doc listarUltimoId();
}

