package br.com.OPT_WEB_002.val_campos_trans_doc;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.*;
import br.com.OPT_WEB_002.campo_adicional.*;
import br.com.OPT_WEB_002.empresa.*;
import br.com.OPT_WEB_002.filial.*;
import br.com.OPT_WEB_002.transacao_documento.*;
import br.com.OPT_WEB_002.unidade_negocio.*;


@Entity(name = "val_campos_trans_doc")
public class Val_Campos_Trans_Doc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_val_camp_trans_doc;
				
	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
		
	@ManyToOne()
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne()
	@JoinColumn(name = "cod_unidade")
	private Unidade_Negocio cod_unidade;
	
	@OneToOne()
	@JoinColumn(name = "id_trans_doc")
	private Transacao_Documento id_trans_doc;
	
	@OneToOne
	@JoinColumn(name = "id_camp_adic")
	private Campo_Adicional id_camp_adic;	
	
	private String resultado;
	
	@Column(nullable = true)
	private String observacao;
	
	@Lob
	private byte[] arquivo;
	
	private String nome_arquivo;
			
	@Column()
	private String extensaoarq;
		
	public Val_Campos_Trans_Doc() {
				
		Campo_Adicional campo_Adicional = new Campo_Adicional();
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Transacao_Documento transacao_Documento = new Transacao_Documento();  
		
		
		
		this.id_camp_adic = campo_Adicional;
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_trans_doc = transacao_Documento;
		
		
	}


	public Empresa getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(Empresa cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public Filial getCod_filial() {
		return cod_filial;
	}

	public void setCod_filial(Filial cod_filial) {
		this.cod_filial = cod_filial;
	}

	public Unidade_Negocio getCod_unidade() {
		return cod_unidade;
	}

	public void setCod_unidade(Unidade_Negocio cod_unidade) {
		this.cod_unidade = cod_unidade;
	}

	public Transacao_Documento getId_trans_doc() {
		return id_trans_doc;
	}

	public void setId_trans_doc(Transacao_Documento id_trans_doc) {
		this.id_trans_doc = id_trans_doc;
	}

	public Campo_Adicional getId_camp_adic() {
		return id_camp_adic;
	}

	public void setId_camp_adic(Campo_Adicional id_camp_adic) {
		this.id_camp_adic = id_camp_adic;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		result = prime * result + ((extensaoarq == null) ? 0 : extensaoarq.hashCode());
		result = prime * result + ((id_camp_adic == null) ? 0 : id_camp_adic.hashCode());
		result = prime * result + ((id_trans_doc == null) ? 0 : id_trans_doc.hashCode());
		result = prime * result + ((id_val_camp_trans_doc == null) ? 0 : id_val_camp_trans_doc.hashCode());
		result = prime * result + ((nome_arquivo == null) ? 0 : nome_arquivo.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
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
		Val_Campos_Trans_Doc other = (Val_Campos_Trans_Doc) obj;
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
		if (extensaoarq == null) {
			if (other.extensaoarq != null)
				return false;
		} else if (!extensaoarq.equals(other.extensaoarq))
			return false;
		if (id_camp_adic == null) {
			if (other.id_camp_adic != null)
				return false;
		} else if (!id_camp_adic.equals(other.id_camp_adic))
			return false;
		if (id_trans_doc == null) {
			if (other.id_trans_doc != null)
				return false;
		} else if (!id_trans_doc.equals(other.id_trans_doc))
			return false;
		if (id_val_camp_trans_doc == null) {
			if (other.id_val_camp_trans_doc != null)
				return false;
		} else if (!id_val_camp_trans_doc.equals(other.id_val_camp_trans_doc))
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
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}


	public Integer getId_val_camp_trans_doc() {
		return id_val_camp_trans_doc;
	}


	public void setId_val_camp_trans_doc(Integer id_val_camp_trans_doc) {
		this.id_val_camp_trans_doc = id_val_camp_trans_doc;
	}


}
