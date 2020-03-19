package br.com.OPT_WEB_002.grupo_valores_possiveis_doc;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.*;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Grupo_Valores_Possiveis_DocRN {

	private Usuario usuario;
	private Grupo_Valores_Possiveis_DocDAO grupo_Valores_Possiveis_DocDAO;
	
public Grupo_Valores_Possiveis_DocRN() {
		
		grupo_Valores_Possiveis_DocDAO = DAOFactory.criarGrupo_Valores_Possiveis_Doc();
		
		
	}
	
		
		public void salvar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {

			if (listar().isEmpty()) {
		
				grupo_Valores_Possiveis_Doc.setId_grup_val_pos_doc(BigInteger.valueOf(Long.parseLong("1")));
							
			}else{
				
				 grupo_Valores_Possiveis_Doc.setId_grup_val_pos_doc(listarUltimoId().getId_grup_val_pos_doc().add(BigInteger.valueOf(Long.parseLong("1"))));
										
				
			
				
			}
				
		
			this.grupo_Valores_Possiveis_DocDAO.salvar(grupo_Valores_Possiveis_Doc);
			
		}
		
		public Grupo_Valores_Possiveis_Doc listarUltimoId() {
			
			return grupo_Valores_Possiveis_DocDAO.listarUltimoId();
		}
		
		
		public List<Grupo_Valores_Possiveis_Doc> listar() {
			
			return grupo_Valores_Possiveis_DocDAO.listar();
		}
				
		public void excluir(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
			
			this.grupo_Valores_Possiveis_DocDAO.excluir(grupo_Valores_Possiveis_Doc);
			
		}
				
		public Grupo_Valores_Possiveis_Doc carregar(BigInteger id_grup_val_pos_doc) {
			
			return this.grupo_Valores_Possiveis_DocDAO.carregar(id_grup_val_pos_doc);
		}
			
		public void alterar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
			
			this.grupo_Valores_Possiveis_DocDAO.alterar(grupo_Valores_Possiveis_Doc);
			
		}
		
		public List<Grupo_Valores_Possiveis_Doc> listarPorCodEmCodFiCodUni(){
			
			return this.grupo_Valores_Possiveis_DocDAO.listarPorCodEmCodFiCodUni(usuario.getCod_empresa().getCod_empresa(),usuario.getCod_filial().getCod_filial(),usuario.getCod_unidade().getCod_unidade());
		}
		
		public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(BigInteger id_grupo_valores,Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
			
			return this.grupo_Valores_Possiveis_DocDAO.listarPorIdGrupoValoresCodEmCodFiCodUni(id_grupo_valores, cod_empresa, cod_filial, cod_unidade);
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Grupo_Valores_Possiveis_DocDAO getGrupo_Valores_Possiveis_DocDAO() {
			return grupo_Valores_Possiveis_DocDAO;
		}

		public void setGrupo_Valores_Possiveis_DocDAO(Grupo_Valores_Possiveis_DocDAO grupo_Valores_Possiveis_DocDAO) {
			this.grupo_Valores_Possiveis_DocDAO = grupo_Valores_Possiveis_DocDAO;
		}
	
}
