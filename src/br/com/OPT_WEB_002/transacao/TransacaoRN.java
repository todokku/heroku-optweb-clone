package br.com.OPT_WEB_002.transacao;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.*;


public class TransacaoRN {

	private TransacaoDAO transacaoDAO;
	private Usuario usuario;

	public TransacaoRN() {
	
		this.transacaoDAO = DAOFactory.criarTransacaoDAO();
		
	}

	public void salvar(Transacao transacao) throws DAOException {
				
		/**Se for o primeiro objeto a ser salvo**/	
		if (listar().size() >= 1) {
			
			long id = Long.parseLong("1");
						
			BigInteger incremento = BigInteger.valueOf(id);
							
			Transacao transacao2 = transacao;
				
			/**Incremento da chave com +1 a partir do último id que está salvo no banco de dados**/
			transacao2.setId_transacao(listarUltimoId().getId_transacao().add(incremento));
	
			this.transacaoDAO.salvar(transacao2);		
					
		}else{
						
			/**Inicia chave com valor 1**/			
			String idString = "1";
			
			long id = Long.parseLong(idString);
			
			transacao.setId_transacao(BigInteger.valueOf(id));
		
			this.transacaoDAO.salvar(transacao);
			
		}
			
	}

	public void alterar(Transacao transacao) {

		this.transacaoDAO.alterar(transacao);
	}

	public void excluir(Transacao transacao) throws DAOException {
		
		this.transacaoDAO.excluir(transacao);
	}

	public Transacao carregar(BigInteger id_transacao,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {

		return this.transacaoDAO.carregar(id_transacao,cod_empresa,cod_filial,cod_unidade);

	}

	public List<Transacao> listar() {
		
		return transacaoDAO.listar();
	}

	public List<Transacao> listarPorIdTransacao(BigInteger id_transacao) {

		return this.transacaoDAO.listarPorIdTransacao(id_transacao);

	}
	
	public List<Transacao> listarPorCodEmCodFiCodUn(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
		
		return this.transacaoDAO.listarPorCodEmCodFiCodUn(cod_empresa, cod_filial, cod_unidade);
				
	}
	
	public Transacao listarUltimoId(){
		
		return this.transacaoDAO.listarUltimoId();
	}

	public TransacaoDAO getTransacaoDAO() {
		return transacaoDAO;
	}

	public void setTransacaoDAO(TransacaoDAO transacaoDAO) {
		this.transacaoDAO = transacaoDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
