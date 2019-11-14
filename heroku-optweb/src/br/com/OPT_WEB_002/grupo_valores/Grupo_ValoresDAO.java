package br.com.OPT_WEB_002.grupo_valores;

import java.math.BigInteger;
import java.util.List;

public interface Grupo_ValoresDAO {

	public void salvar(Grupo_Valores grupo_Valores);
	
	public void excluir (Grupo_Valores grupo_Valores);
	
	public void alterar (Grupo_Valores grupo_Valores);

	public Grupo_Valores carregar (BigInteger id_grupo_valores);
	
	public List<Grupo_Valores> listar();
	
	public Grupo_Valores listarUltimoId();
	
	public List<Grupo_Valores> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);
}

	
