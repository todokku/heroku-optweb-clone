package br.com.OPT_WEB_002.transacao_documento;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;
import br.com.OPT_WEB_002.documento.Documento;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.transacao.Transacao;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;


@Entity(name = "transacao_documento")
public class Transacao_Documento implements Serializable,Comparable<Transacao_Documento> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id_transacao_doc;
		
	@ManyToOne()
	@JoinColumn(name="cod_filial")
	private Filial cod_filial;
			
	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@Column(nullable = true)
	private String observacao;
		
	@ManyToOne()
	@JoinColumn(name="cod_unidade")
	private Unidade_Negocio cod_unidade;
	
	@OneToOne()
	@JoinColumn(name = "id_transacao")
	private Transacao id_transacao;

	@OneToOne()
	@JoinColumn(name = "id_doc")
	private Documento id_doc;
	
	@Lob
	private byte[] arquivo;
	
	private String nome_arquivo;

	@Column(columnDefinition = "VARCHAR(6)")
	private String extensaoarq;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date data_ini;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date data_fim;
	
	@Temporal(TemporalType.TIME)
	@Column(nullable = true)
	private Date horario_ini;

	@Temporal(TemporalType.TIME)
	@Column(nullable = true)
	private Date horario_fim;
	
	@Column(nullable = true)
	private float tempo_previsto;
	
	private String unidadeTempo;
			
	@Column(nullable = false)
	private String estado;
		
	@javax.persistence.Transient
	private String label;
	
	@javax.persistence.Transient
	private String campo;
	
	@javax.persistence.Transient
	private String idInc;
		
	public Transacao_Documento() {
	
		Documento documento = new Documento();
		Transacao transacao = new Transacao();
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		
		this.id_doc = documento;
		this.id_transacao = transacao;
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
				
	}
	
	public Transacao_Documento(String label,String campo,String idInc) {
		
		this.label = label;
		this.campo = campo;
		this.idInc = idInc;		
		
	}


	public BigInteger getId_transacao_doc() {
		return id_transacao_doc;
	}

	public void setId_transacao_doc(BigInteger id_transacao_doc) {
		this.id_transacao_doc = id_transacao_doc;
	}

	public Filial getCod_filial() {
		return cod_filial;
	}

	public void setCod_filial(Filial cod_filial) {
		this.cod_filial = cod_filial;
	}

	public Empresa getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Unidade_Negocio getCod_unidade() {
		return cod_unidade;
	}

	public void setCod_unidade(Unidade_Negocio cod_unidade) {
		this.cod_unidade = cod_unidade;
	}

	public Transacao getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Transacao id_transacao) {
		this.id_transacao = id_transacao;
	}

	public Documento getId_doc() {
		return id_doc;
	}

	public void setId_doc(Documento id_doc) {
		this.id_doc = id_doc;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	public String getExtensaoarq() {
		return extensaoarq;
	}

	public void setExtensaoarq(String extensaoarq) {
		this.extensaoarq = extensaoarq;
	}

	public Date getData_ini() {
		return data_ini;
	}

	public void setData_ini(Date data_ini) {
		this.data_ini = data_ini;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public Date getHorario_ini() {
		return horario_ini;
	}

	public void setHorario_ini(Date horario_ini) {
		this.horario_ini = horario_ini;
	}

	public Date getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(Date horario_fim) {
		this.horario_fim = horario_fim;
	}

	public float getTempo_previsto() {
		return tempo_previsto;
	}

	public void setTempo_previsto(float tempo_previsto) {
		this.tempo_previsto = tempo_previsto;
	}

	public String getUnidadeTempo() {
		return unidadeTempo;
	}

	public void setUnidadeTempo(String unidadeTempo) {
		this.unidadeTempo = unidadeTempo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arquivo);
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((data_fim == null) ? 0 : data_fim.hashCode());
		result = prime * result + ((data_ini == null) ? 0 : data_ini.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((extensaoarq == null) ? 0 : extensaoarq.hashCode());
		result = prime * result + ((horario_fim == null) ? 0 : horario_fim.hashCode());
		result = prime * result + ((horario_ini == null) ? 0 : horario_ini.hashCode());
		result = prime * result + ((id_doc == null) ? 0 : id_doc.hashCode());
		result = prime * result + ((id_transacao == null) ? 0 : id_transacao.hashCode());
		result = prime * result + ((id_transacao_doc == null) ? 0 : id_transacao_doc.hashCode());
		result = prime * result + ((nome_arquivo == null) ? 0 : nome_arquivo.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + Float.floatToIntBits(tempo_previsto);
		result = prime * result + ((unidadeTempo == null) ? 0 : unidadeTempo.hashCode());
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
		Transacao_Documento other = (Transacao_Documento) obj;
		if (!Arrays.equals(arquivo, other.arquivo))
			return false;
		if (cod_empresa == null) {
			if (other.cod_empresa != null)
				return false;
		} else if (!cod_empresa.equals(other.cod_empresa))
			return false;
		if (cod_filial == null) {
			if (other.cod_filial != null)
				return false;
		} else if (!cod_filial.equals(other.cod_filial))
			return false;
		if (cod_unidade == null) {
			if (other.cod_unidade != null)
				return false;
		} else if (!cod_unidade.equals(other.cod_unidade))
			return false;
		if (data_fim == null) {
			if (other.data_fim != null)
				return false;
		} else if (!data_fim.equals(other.data_fim))
			return false;
		if (data_ini == null) {
			if (other.data_ini != null)
				return false;
		} else if (!data_ini.equals(other.data_ini))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (extensaoarq == null) {
			if (other.extensaoarq != null)
				return false;
		} else if (!extensaoarq.equals(other.extensaoarq))
			return false;
		if (horario_fim == null) {
			if (other.horario_fim != null)
				return false;
		} else if (!horario_fim.equals(other.horario_fim))
			return false;
		if (horario_ini == null) {
			if (other.horario_ini != null)
				return false;
		} else if (!horario_ini.equals(other.horario_ini))
			return false;
		if (id_doc == null) {
			if (other.id_doc != null)
				return false;
		} else if (!id_doc.equals(other.id_doc))
			return false;
		if (id_transacao == null) {
			if (other.id_transacao != null)
				return false;
		} else if (!id_transacao.equals(other.id_transacao))
			return false;
		if (id_transacao_doc == null) {
			if (other.id_transacao_doc != null)
				return false;
		} else if (!id_transacao_doc.equals(other.id_transacao_doc))
			return false;
		if (nome_arquivo == null) {
			if (other.nome_arquivo != null)
				return false;
		} else if (!nome_arquivo.equals(other.nome_arquivo))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (Float.floatToIntBits(tempo_previsto) != Float.floatToIntBits(other.tempo_previsto))
			return false;
		if (unidadeTempo == null) {
			if (other.unidadeTempo != null)
				return false;
		} else if (!unidadeTempo.equals(other.unidadeTempo))
			return false;
		return true;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getIdInc() {
		return idInc;
	}

	public void setIdInc(String idInc) {
		this.idInc = idInc;
	}

	 @Override
	    public String toString() {
		 	
	        return idInc;
	    }

	@Override
	public int compareTo(Transacao_Documento o) {
		// TODO Auto-generated method stub
		return 0;
	}
		 


}
