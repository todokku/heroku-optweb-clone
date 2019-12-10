package br.com.OPT_WEB_002.campo_adicional;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.*;

public class Campo_AdicionalRN {

	private Campo_AdicionalDAO campoAdicionalDAO;
	private Usuario usuario;
	
	public Campo_AdicionalRN() {

		campoAdicionalDAO = DAOFactory.criarCampoAdicionalDAO();
		
	}

	public void salvar(Campo_Adicional campoAdicional) throws DAOException {
	
		if (listar().size() >= 1) {
			
			campoAdicional.setId_camp_adic(listarUltimoId().getId_camp_adic().add(BigInteger.valueOf(Long.parseLong("1"))));
	
			this.campoAdicionalDAO.salvar(campoAdicional);		
					
		}else{					
					
			campoAdicional.setId_camp_adic(BigInteger.valueOf(Long.parseLong("1")));
		
			this.campoAdicionalDAO.salvar(campoAdicional);
			
		}
	}
	
	public void excluir(Campo_Adicional campoAdicional) throws DAOException {
		
		this.campoAdicionalDAO.excluir(campoAdicional);
	}

	public void alterar(Campo_Adicional campoAdicional) {
		
		this.campoAdicionalDAO.alterar(campoAdicional);
	}

	public Campo_Adicional carregar(BigInteger id_camp_adic,Integer cod_empresa,Integer cod_filial,Integer cod_unidade) {

		return this.campoAdicionalDAO.carregar(id_camp_adic,cod_empresa,cod_filial,cod_unidade);
	}

	public List<Campo_Adicional> listar() {
			
		return campoAdicionalDAO.listar();
	}
	
	public List<Campo_Adicional> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade){
		
		return this.campoAdicionalDAO.listarPorCodEmCodFiCodUni(cod_empresa, cod_filial, cod_unidade);
	}
			
	public List<Campo_Adicional> listarPorIdTransCodEmCodFiCodUni(BigInteger id_transacao){
		return this.campoAdicionalDAO.listarPorIdTransCodEmCodFiCodUni(id_transacao);
	}
	
	public List<Campo_Adicional>  listarPorIdTransCoEmCodFiCodUni (BigInteger id_transacao){
		
		return campoAdicionalDAO.listarPorIdTransCodEmCodFiCodUni(id_transacao);
		
	}
	
	public List<Campo_Adicional>  listarPorIdTransCoEmCodFiCodUniWebService(BigInteger id_transacao){
		
		return campoAdicionalDAO.listarPorIdTransCodEmCodFiCodUniWebService(id_transacao);
		
	}
	
	public Campo_Adicional listarUltimoId(){
		
		return campoAdicionalDAO.listarUltimoId();
	}
	
	public Campo_AdicionalDAO getCampoAdicionalDAO() {
		return campoAdicionalDAO;
	}

	public void setCampoAdicionalDAO(Campo_AdicionalDAO campoAdicionalDAO) {
		this.campoAdicionalDAO = campoAdicionalDAO;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoAdicionalDAO == null) ? 0 : campoAdicionalDAO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo_AdicionalRN other = (Campo_AdicionalRN) obj;
		if (campoAdicionalDAO == null) {
			if (other.campoAdicionalDAO != null)
				return false;
		} else if (!campoAdicionalDAO.equals(other.campoAdicionalDAO))
			return false;
		return true;
	}


}
