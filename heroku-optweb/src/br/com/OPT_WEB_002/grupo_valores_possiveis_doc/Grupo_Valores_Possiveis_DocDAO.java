package br.com.OPT_WEB_002.grupo_valores_possiveis_doc;

import java.math.BigInteger;
import java.util.List;

public interface Grupo_Valores_Possiveis_DocDAO {

	
	public void salvar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc);
	
	public void alterar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc);
	
	public void excluir (Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc);
	
	public Grupo_Valores_Possiveis_Doc carregar(BigInteger id_grup_val_pos_doc);
	
	public List<Grupo_Valores_Possiveis_Doc> listar();
	
	public Grupo_Valores_Possiveis_Doc listarUltimoId();
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
	
	public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(BigInteger id_grupo_valores,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

}
