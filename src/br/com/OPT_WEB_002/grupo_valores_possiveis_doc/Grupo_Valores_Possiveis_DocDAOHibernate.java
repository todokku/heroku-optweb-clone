package br.com.OPT_WEB_002.grupo_valores_possiveis_doc;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class Grupo_Valores_Possiveis_DocDAOHibernate implements Grupo_Valores_Possiveis_DocDAO  {

	
	private Session session;
	
	
	public Grupo_Valores_Possiveis_DocDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
		
		this.session.save(grupo_Valores_Possiveis_Doc);
		
	}



	@Override
	public void alterar(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
		this.session.merge(grupo_Valores_Possiveis_Doc);
	}

	@Override
	public void excluir(Grupo_Valores_Possiveis_Doc grupo_Valores_Possiveis_Doc) {
		this.session.delete(grupo_Valores_Possiveis_Doc);
		
	}

	@Override
	public Grupo_Valores_Possiveis_Doc carregar(BigInteger id_grup_val_pos_doc) {
		
		return (Grupo_Valores_Possiveis_Doc) this.session.load(Grupo_Valores_Possiveis_Doc.class, id_grup_val_pos_doc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo_Valores_Possiveis_Doc> listar() {
		
		return this.session.createCriteria(Grupo_Valores_Possiveis_Doc.class).list();
	}


	@Override
	public Grupo_Valores_Possiveis_Doc listarUltimoId() {
		
		String hql = "select tb from grupo_valores_possiveis_doc tb order by id_grup_val_pos_doc desc";
		Query consulta = this.session.createQuery(hql);
		consulta.setMaxResults(1);
		
		
		return (Grupo_Valores_Possiveis_Doc) consulta.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo_Valores_Possiveis_Doc> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial,
			Integer cod_unidade) {
		
		String hql = "select tb from grupo_valores_possiveis_doc tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
		Query consulta = this.session.createQuery(hql);
		
		
		consulta.setInteger("cod_empresa",cod_empresa);
		consulta.setInteger("cod_filial",cod_filial);
		consulta.setInteger("cod_unidade",cod_unidade);
		
		return consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo_Valores_Possiveis_Doc> listarPorIdGrupoValoresCodEmCodFiCodUni(BigInteger id_grupo_valores,
			Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
			
			String hql = "select tb from grupo_valores_possiveis_doc tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade and tb.id_grupo_valores = :id_grupo_valores";
			Query consulta = this.session.createQuery(hql);
			
			consulta.setBigInteger("id_grupo_valores",id_grupo_valores);
			consulta.setInteger("cod_empresa",cod_empresa);
			consulta.setInteger("cod_filial",cod_filial);
			consulta.setInteger("cod_unidade",cod_unidade);
			
			return consulta.list();
			
	}





	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	


}
