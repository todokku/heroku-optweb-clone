package br.com.OPT_WEB_002.campo_adicional;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface Campo_AdicionalDAO {

	public void salvar(Campo_Adicional campoAdicional) throws DAOException;

	public void alterar(Campo_Adicional campoAdicional);

	public void excluir(Campo_Adicional campoAdicional) throws DAOException;

	public Campo_Adicional carregar(BigInteger id_camp_adic, Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade);

	public List<Campo_Adicional> listar();

	public List<Campo_Adicional> listarPorIdTransCodEmCodFiCodUni(BigInteger id_transacao);

	public List<Campo_Adicional> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,Integer cod_unidade);

	public Campo_Adicional listarUltimoId();
	
	public List<Campo_Adicional> listarPorIdTransCodEmCodFiCodUniWebService(BigInteger id_transacao);

}
