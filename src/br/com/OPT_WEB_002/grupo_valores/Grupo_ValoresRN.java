package br.com.OPT_WEB_002.grupo_valores;

import java.math.BigInteger;
import java.util.List;
import br.com.OPT_WEB_002.usuario.Usuario;
import br.com.OPT_WEB_002.util.DAOFactory;

public class Grupo_ValoresRN {

	private Grupo_ValoresDAO grupo_ValoresDAO; 
	private Usuario usuario;
	

	public Grupo_ValoresRN() {
	
		this.grupo_ValoresDAO = DAOFactory.criarGrupoValores();
		
		
	}
		
		
		public void salvar(Grupo_Valores grupo_Valores) {

			if (listar().size() >= 1) {

			    grupo_Valores.setId_grupo_valores(listarUltimoId().getId_grupo_valores().add(BigInteger.valueOf(Long.parseLong("1"))));
							
			}else{
							
				grupo_Valores.setId_grupo_valores(BigInteger.valueOf(Long.parseLong("1")));

				this.grupo_ValoresDAO.salvar(grupo_Valores);
				
			}
					
			this.grupo_ValoresDAO.salvar(grupo_Valores);
		}
		
	
		public void excluir(Grupo_Valores grupo_Valores) {
			
			this.grupo_ValoresDAO.excluir(grupo_Valores);
			
		}
		
		
		public Grupo_Valores carregar(BigInteger id_grupo_valores) {
			
			return this.grupo_ValoresDAO.carregar(id_grupo_valores);
		}
		
	
		public void alterar(Grupo_Valores grupo_Valores) {
			
			 this.grupo_ValoresDAO.alterar(grupo_Valores);
			
		}
		
		public List<Grupo_Valores> listar(){
			
			return this.grupo_ValoresDAO.listar();
		}
		

		public Grupo_Valores listarUltimoId(){
			
			return this.grupo_ValoresDAO.listarUltimoId();
		}
		
		
		public List<Grupo_Valores> listarPorCodEmCodFiCodUni(Integer cod_empresa,Integer cod_filial,Integer cod_unidade){
			
			return this.grupo_ValoresDAO.listarPorCodEmCodFiCodUni(cod_empresa,cod_filial,cod_unidade);
		}
		

		public Grupo_ValoresDAO getGrupo_ValoresDAO() {
			return grupo_ValoresDAO;
		}

		public void setGrupo_ValoresDAO(Grupo_ValoresDAO grupo_ValoresDAO) {
			this.grupo_ValoresDAO = grupo_ValoresDAO;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((grupo_ValoresDAO == null) ? 0 : grupo_ValoresDAO.hashCode());
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
			Grupo_ValoresRN other = (Grupo_ValoresRN) obj;
			if (grupo_ValoresDAO == null) {
				if (other.grupo_ValoresDAO != null)
					return false;
			} else if (!grupo_ValoresDAO.equals(other.grupo_ValoresDAO))
				return false;
			return true;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
	};
	
	


