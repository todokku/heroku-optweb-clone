package br.com.OPT_WEB_002.transacao;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.util.DAOException;

public interface TransacaoDAO {

	public void salvar(Transacao transacao) throws DAOException;

	public void excluir(Transacao transacao) throws DAOException;

	public void alterar(Transacao transacao);

	public Transacao carregar(BigInteger id_transacao,Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public List<Transacao> listar();

	public List<Transacao> listarPorIdTransacao(BigInteger id_transacao);

	public List<Transacao> listarPorCodEmCodFiCodUn(Integer cod_empresa,Integer cod_filial,Integer cod_unidade);

	public Transacao listarUltimoId();
}