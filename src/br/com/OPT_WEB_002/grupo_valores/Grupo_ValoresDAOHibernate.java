package br.com.OPT_WEB_002.grupo_valores;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Grupo_ValoresDAOHibernate implements Grupo_ValoresDAO{

	private Session session;
	
	
	public Grupo_ValoresDAOHibernate() {
		
	}

	@Override
	public void salvar(Grupo_Valores grupo_Valores) {
		
		this.session.save(grupo_Valores);
		
	}

	@Override
	public void excluir(Grupo_Valores grupo_Valores) {
		
		this.session.delete(grupo_Valores);		
	}

	@Override
	public void alterar(Grupo_Valores grupo_Valores) {
		
		this.session.merge(grupo_Valores);
		
	}

	@Override
	public Grupo_Valores carregar(BigInteger id_grupo_valores) {
		
		return (Grupo_Valores) this.session.load(Grupo_Valores.class, id_grupo_valores);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo_Valores> listar() {
	
		return this.session.createCriteria(Grupo_Valores.class).list();
	}
	
	@Override
	public Grupo_Valores listarUltimoId() {
		
		String hql = "select tb from grupo_valores tb order by id_grupo_valores desc";
		Query consulta = this.session.createQuery(hql);
		
		consulta.setMaxResults(1);
		
		return (Grupo_Valores) consulta.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo_Valores> listarPorCodEmCodFiCodUni(Integer cod_empresa, Integer cod_filial, Integer cod_unidade) {
		String hql = "select tb from grupo_valores tb where tb.cod_empresa = :cod_empresa and tb.cod_filial = :cod_filial and tb.cod_unidade = :cod_unidade";
	
		Query consulta = this.session.createQuery(hql);
		
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
