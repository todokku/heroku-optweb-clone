package br.com.OPT_WEB_002.documento;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.*;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.tipo_documento.Tipo_Documento;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@javax.persistence.Entity(name = "documento")
@SequenceGenerator(name = "doc_id_seq", sequenceName = "doc_id_seq")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "doc_id_seq")
	private BigInteger id_doc;

	private BigInteger id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_empresa", nullable = false)
	private Empresa cod_empresa;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_filial", nullable = false)
	private Filial cod_filial;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cod_unidade", nullable = false)
	private Unidade_Negocio cod_unidade;

	@OneToOne()
	@JoinColumn(name = "id_tipo_doc", nullable = true)
	private Tipo_Documento id_tipo_doc;

	@Column(length = 255)
	private String char_001, char_002, char_003, char_004, char_005, char_006, char_007, char_008, char_009, char_010,
			char_011, char_012, char_013, char_014, char_015, char_016, char_017, char_018, char_019, char_020;

	@Column(nullable = true)
	private Integer int_001, int_002, int_003, int_004, int_005, int_006, int_007, int_008, int_009, int_010;

	@Column(nullable = true)
	private float dec_001, dec_002, dec_003, dec_004, dec_005, dec_006, dec_007, dec_008, dec_009, dec_010;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date data_001, data_002, data_003, data_004, data_005, data_006, data_007, data_008, data_009, data_010;

	private String cliente;
	
	private float quantidade;

	@Lob
	private byte[] arquivo;

	private String extensao_arq;

	private String nome_arquivo;

	@javax.persistence.Transient
	private Documento documento;

	@javax.persistence.Transient
	private String label;

	@javax.persistence.Transient
	private String campo;

	@javax.persistence.Transient
	private String idInc;

	public Documento Doc(Documento documento) {

		return documento;

	}

	public Documento() {

		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
		Tipo_Documento tipo_Documento = new Tipo_Documento();

		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
		this.id_tipo_doc = tipo_Documento;

	}

	public Documento(String label, String campo) {

		this.label = label;
		this.campo = campo;
	}

	public Documento(String label, String campo, String idInc) {

		this.label = label;
		this.campo = campo;
		this.idInc = idInc;
	}

	public BigInteger getId_doc() {
		return id_doc;
	}

	public void setId_doc(BigInteger id_doc) {
		this.id_doc = id_doc;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	public Tipo_Documento getId_tipo_doc() {
		return id_tipo_doc;
	}

	public void setId_tipo_doc(Tipo_Documento id_tipo_doc) {
		this.id_tipo_doc = id_tipo_doc;
	}

	public String getChar_001() {
		return char_001;
	}

	public void setChar_001(String char_001) {
		this.char_001 = char_001;
	}

	public String getChar_002() {
		return char_002;
	}

	public void setChar_002(String char_002) {
		this.char_002 = char_002;
	}

	public String getChar_003() {
		return char_003;
	}

	public void setChar_003(String char_003) {
		this.char_003 = char_003;
	}

	public String getChar_004() {
		return char_004;
	}

	public void setChar_004(String char_004) {
		this.char_004 = char_004;
	}

	public String getChar_005() {
		return char_005;
	}

	public void setChar_005(String char_005) {
		this.char_005 = char_005;
	}

	public String getChar_006() {
		return char_006;
	}

	public void setChar_006(String char_006) {
		this.char_006 = char_006;
	}

	public String getChar_007() {
		return char_007;
	}

	public void setChar_007(String char_007) {
		this.char_007 = char_007;
	}

	public String getChar_008() {
		return char_008;
	}

	public void setChar_008(String char_008) {
		this.char_008 = char_008;
	}

	public String getChar_009() {
		return char_009;
	}

	public void setChar_009(String char_009) {
		this.char_009 = char_009;
	}

	public String getChar_010() {
		return char_010;
	}

	public void setChar_010(String char_010) {
		this.char_010 = char_010;
	}

	public String getChar_011() {
		return char_011;
	}

	public void setChar_011(String char_011) {
		this.char_011 = char_011;
	}

	public String getChar_012() {
		return char_012;
	}

	public void setChar_012(String char_012) {
		this.char_012 = char_012;
	}

	public String getChar_013() {
		return char_013;
	}

	public void setChar_013(String char_013) {
		this.char_013 = char_013;
	}

	public String getChar_014() {
		return char_014;
	}

	public void setChar_014(String char_014) {
		this.char_014 = char_014;
	}

	public String getChar_015() {
		return char_015;
	}

	public void setChar_015(String char_015) {
		this.char_015 = char_015;
	}

	public String getChar_016() {
		return char_016;
	}

	public void setChar_016(String char_016) {
		this.char_016 = char_016;
	}

	public String getChar_017() {
		return char_017;
	}

	public void setChar_017(String char_017) {
		this.char_017 = char_017;
	}

	public String getChar_018() {
		return char_018;
	}

	public void setChar_018(String char_018) {
		this.char_018 = char_018;
	}

	public String getChar_019() {
		return char_019;
	}

	public void setChar_019(String char_019) {
		this.char_019 = char_019;
	}

	public String getChar_020() {
		return char_020;
	}

	public void setChar_020(String char_020) {
		this.char_020 = char_020;
	}

	public Integer getInt_001() {
		return int_001;
	}

	public void setInt_001(Integer int_001) {
		this.int_001 = int_001;
	}

	public Integer getInt_002() {
		return int_002;
	}

	public void setInt_002(Integer int_002) {
		this.int_002 = int_002;
	}

	public Integer getInt_003() {
		return int_003;
	}

	public void setInt_003(Integer int_003) {
		this.int_003 = int_003;
	}

	public Integer getInt_004() {
		return int_004;
	}

	public void setInt_004(Integer int_004) {
		this.int_004 = int_004;
	}

	public Integer getInt_005() {
		return int_005;
	}

	public void setInt_005(Integer int_005) {
		this.int_005 = int_005;
	}

	public Integer getInt_006() {
		return int_006;
	}

	public void setInt_006(Integer int_006) {
		this.int_006 = int_006;
	}

	public Integer getInt_007() {
		return int_007;
	}

	public void setInt_007(Integer int_007) {
		this.int_007 = int_007;
	}

	public Integer getInt_008() {
		return int_008;
	}

	public void setInt_008(Integer int_008) {
		this.int_008 = int_008;
	}

	public Integer getInt_009() {
		return int_009;
	}

	public void setInt_009(Integer int_009) {
		this.int_009 = int_009;
	}

	public Integer getInt_010() {
		return int_010;
	}

	public void setInt_010(Integer int_010) {
		this.int_010 = int_010;
	}

	public float getDec_001() {
		return dec_001;
	}

	public void setDec_001(float dec_001) {
		this.dec_001 = dec_001;
	}

	public float getDec_002() {
		return dec_002;
	}

	public void setDec_002(float dec_002) {
		this.dec_002 = dec_002;
	}

	public float getDec_003() {
		return dec_003;
	}

	public void setDec_003(float dec_003) {
		this.dec_003 = dec_003;
	}

	public float getDec_004() {
		return dec_004;
	}

	public void setDec_004(float dec_004) {
		this.dec_004 = dec_004;
	}

	public float getDec_005() {
		return dec_005;
	}

	public void setDec_005(float dec_005) {
		this.dec_005 = dec_005;
	}

	public float getDec_006() {
		return dec_006;
	}

	public void setDec_006(float dec_006) {
		this.dec_006 = dec_006;
	}

	public float getDec_007() {
		return dec_007;
	}

	public void setDec_007(float dec_007) {
		this.dec_007 = dec_007;
	}

	public float getDec_008() {
		return dec_008;
	}

	public void setDec_008(float dec_008) {
		this.dec_008 = dec_008;
	}

	public float getDec_009() {
		return dec_009;
	}

	public void setDec_009(float dec_009) {
		this.dec_009 = dec_009;
	}

	public float getDec_010() {
		return dec_010;
	}

	public void setDec_010(float dec_010) {
		this.dec_010 = dec_010;
	}

	public Date getData_001() {
		return data_001;
	}

	public void setData_001(Date data_001) {
		this.data_001 = data_001;
	}

	public Date getData_002() {
		return data_002;
	}

	public void setData_002(Date data_002) {
		this.data_002 = data_002;
	}

	public Date getData_003() {
		return data_003;
	}

	public void setData_003(Date data_003) {
		this.data_003 = data_003;
	}

	public Date getData_004() {
		return data_004;
	}

	public void setData_004(Date data_004) {
		this.data_004 = data_004;
	}

	public Date getData_005() {
		return data_005;
	}

	public void setData_005(Date data_005) {
		this.data_005 = data_005;
	}

	public Date getData_006() {
		return data_006;
	}

	public void setData_006(Date data_006) {
		this.data_006 = data_006;
	}

	public Date getData_007() {
		return data_007;
	}

	public void setData_007(Date data_007) {
		this.data_007 = data_007;
	}

	public Date getData_008() {
		return data_008;
	}

	public void setData_008(Date data_008) {
		this.data_008 = data_008;
	}

	public Date getData_009() {
		return data_009;
	}

	public void setData_009(Date data_009) {
		this.data_009 = data_009;
	}

	public Date getData_010() {
		return data_010;
	}

	public void setData_010(Date data_010) {
		this.data_010 = data_010;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public String getExtensao_arq() {
		return extensao_arq;
	}

	public void setExtensao_arq(String extensao_arq) {
		this.extensao_arq = extensao_arq;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
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

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arquivo);
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((char_001 == null) ? 0 : char_001.hashCode());
		result = prime * result + ((char_002 == null) ? 0 : char_002.hashCode());
		result = prime * result + ((char_003 == null) ? 0 : char_003.hashCode());
		result = prime * result + ((char_004 == null) ? 0 : char_004.hashCode());
		result = prime * result + ((char_005 == null) ? 0 : char_005.hashCode());
		result = prime * result + ((char_006 == null) ? 0 : char_006.hashCode());
		result = prime * result + ((char_007 == null) ? 0 : char_007.hashCode());
		result = prime * result + ((char_008 == null) ? 0 : char_008.hashCode());
		result = prime * result + ((char_009 == null) ? 0 : char_009.hashCode());
		result = prime * result + ((char_010 == null) ? 0 : char_010.hashCode());
		result = prime * result + ((char_011 == null) ? 0 : char_011.hashCode());
		result = prime * result + ((char_012 == null) ? 0 : char_012.hashCode());
		result = prime * result + ((char_013 == null) ? 0 : char_013.hashCode());
		result = prime * result + ((char_014 == null) ? 0 : char_014.hashCode());
		result = prime * result + ((char_015 == null) ? 0 : char_015.hashCode());
		result = prime * result + ((char_016 == null) ? 0 : char_016.hashCode());
		result = prime * result + ((char_017 == null) ? 0 : char_017.hashCode());
		result = prime * result + ((char_018 == null) ? 0 : char_018.hashCode());
		result = prime * result + ((char_019 == null) ? 0 : char_019.hashCode());
		result = prime * result + ((char_020 == null) ? 0 : char_020.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((data_001 == null) ? 0 : data_001.hashCode());
		result = prime * result + ((data_002 == null) ? 0 : data_002.hashCode());
		result = prime * result + ((data_003 == null) ? 0 : data_003.hashCode());
		result = prime * result + ((data_004 == null) ? 0 : data_004.hashCode());
		result = prime * result + ((data_005 == null) ? 0 : data_005.hashCode());
		result = prime * result + ((data_006 == null) ? 0 : data_006.hashCode());
		result = prime * result + ((data_007 == null) ? 0 : data_007.hashCode());
		result = prime * result + ((data_008 == null) ? 0 : data_008.hashCode());
		result = prime * result + ((data_009 == null) ? 0 : data_009.hashCode());
		result = prime * result + ((data_010 == null) ? 0 : data_010.hashCode());
		result = prime * result + Float.floatToIntBits(dec_001);
		result = prime * result + Float.floatToIntBits(dec_002);
		result = prime * result + Float.floatToIntBits(dec_003);
		result = prime * result + Float.floatToIntBits(dec_004);
		result = prime * result + Float.floatToIntBits(dec_005);
		result = prime * result + Float.floatToIntBits(dec_006);
		result = prime * result + Float.floatToIntBits(dec_007);
		result = prime * result + Float.floatToIntBits(dec_008);
		result = prime * result + Float.floatToIntBits(dec_009);
		result = prime * result + Float.floatToIntBits(dec_010);
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((extensao_arq == null) ? 0 : extensao_arq.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idInc == null) ? 0 : idInc.hashCode());
		result = prime * result + ((id_doc == null) ? 0 : id_doc.hashCode());
		result = prime * result + ((id_tipo_doc == null) ? 0 : id_tipo_doc.hashCode());
		result = prime * result + ((int_001 == null) ? 0 : int_001.hashCode());
		result = prime * result + ((int_002 == null) ? 0 : int_002.hashCode());
		result = prime * result + ((int_003 == null) ? 0 : int_003.hashCode());
		result = prime * result + ((int_004 == null) ? 0 : int_004.hashCode());
		result = prime * result + ((int_005 == null) ? 0 : int_005.hashCode());
		result = prime * result + ((int_006 == null) ? 0 : int_006.hashCode());
		result = prime * result + ((int_007 == null) ? 0 : int_007.hashCode());
		result = prime * result + ((int_008 == null) ? 0 : int_008.hashCode());
		result = prime * result + ((int_009 == null) ? 0 : int_009.hashCode());
		result = prime * result + ((int_010 == null) ? 0 : int_010.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((nome_arquivo == null) ? 0 : nome_arquivo.hashCode());
		result = prime * result + Float.floatToIntBits(quantidade);
		return result;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		if (!Arrays.equals(arquivo, other.arquivo))
			return false;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (char_001 == null) {
			if (other.char_001 != null)
				return false;
		} else if (!char_001.equals(other.char_001))
			return false;
		if (char_002 == null) {
			if (other.char_002 != null)
				return false;
		} else if (!char_002.equals(other.char_002))
			return false;
		if (char_003 == null) {
			if (other.char_003 != null)
				return false;
		} else if (!char_003.equals(other.char_003))
			return false;
		if (char_004 == null) {
			if (other.char_004 != null)
				return false;
		} else if (!char_004.equals(other.char_004))
			return false;
		if (char_005 == null) {
			if (other.char_005 != null)
				return false;
		} else if (!char_005.equals(other.char_005))
			return false;
		if (char_006 == null) {
			if (other.char_006 != null)
				return false;
		} else if (!char_006.equals(other.char_006))
			return false;
		if (char_007 == null) {
			if (other.char_007 != null)
				return false;
		} else if (!char_007.equals(other.char_007))
			return false;
		if (char_008 == null) {
			if (other.char_008 != null)
				return false;
		} else if (!char_008.equals(other.char_008))
			return false;
		if (char_009 == null) {
			if (other.char_009 != null)
				return false;
		} else if (!char_009.equals(other.char_009))
			return false;
		if (char_010 == null) {
			if (other.char_010 != null)
				return false;
		} else if (!char_010.equals(other.char_010))
			return false;
		if (char_011 == null) {
			if (other.char_011 != null)
				return false;
		} else if (!char_011.equals(other.char_011))
			return false;
		if (char_012 == null) {
			if (other.char_012 != null)
				return false;
		} else if (!char_012.equals(other.char_012))
			return false;
		if (char_013 == null) {
			if (other.char_013 != null)
				return false;
		} else if (!char_013.equals(other.char_013))
			return false;
		if (char_014 == null) {
			if (other.char_014 != null)
				return false;
		} else if (!char_014.equals(other.char_014))
			return false;
		if (char_015 == null) {
			if (other.char_015 != null)
				return false;
		} else if (!char_015.equals(other.char_015))
			return false;
		if (char_016 == null) {
			if (other.char_016 != null)
				return false;
		} else if (!char_016.equals(other.char_016))
			return false;
		if (char_017 == null) {
			if (other.char_017 != null)
				return false;
		} else if (!char_017.equals(other.char_017))
			return false;
		if (char_018 == null) {
			if (other.char_018 != null)
				return false;
		} else if (!char_018.equals(other.char_018))
			return false;
		if (char_019 == null) {
			if (other.char_019 != null)
				return false;
		} else if (!char_019.equals(other.char_019))
			return false;
		if (char_020 == null) {
			if (other.char_020 != null)
				return false;
		} else if (!char_020.equals(other.char_020))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
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
		if (data_001 == null) {
			if (other.data_001 != null)
				return false;
		} else if (!data_001.equals(other.data_001))
			return false;
		if (data_002 == null) {
			if (other.data_002 != null)
				return false;
		} else if (!data_002.equals(other.data_002))
			return false;
		if (data_003 == null) {
			if (other.data_003 != null)
				return false;
		} else if (!data_003.equals(other.data_003))
			return false;
		if (data_004 == null) {
			if (other.data_004 != null)
				return false;
		} else if (!data_004.equals(other.data_004))
			return false;
		if (data_005 == null) {
			if (other.data_005 != null)
				return false;
		} else if (!data_005.equals(other.data_005))
			return false;
		if (data_006 == null) {
			if (other.data_006 != null)
				return false;
		} else if (!data_006.equals(other.data_006))
			return false;
		if (data_007 == null) {
			if (other.data_007 != null)
				return false;
		} else if (!data_007.equals(other.data_007))
			return false;
		if (data_008 == null) {
			if (other.data_008 != null)
				return false;
		} else if (!data_008.equals(other.data_008))
			return false;
		if (data_009 == null) {
			if (other.data_009 != null)
				return false;
		} else if (!data_009.equals(other.data_009))
			return false;
		if (data_010 == null) {
			if (other.data_010 != null)
				return false;
		} else if (!data_010.equals(other.data_010))
			return false;
		if (Float.floatToIntBits(dec_001) != Float.floatToIntBits(other.dec_001))
			return false;
		if (Float.floatToIntBits(dec_002) != Float.floatToIntBits(other.dec_002))
			return false;
		if (Float.floatToIntBits(dec_003) != Float.floatToIntBits(other.dec_003))
			return false;
		if (Float.floatToIntBits(dec_004) != Float.floatToIntBits(other.dec_004))
			return false;
		if (Float.floatToIntBits(dec_005) != Float.floatToIntBits(other.dec_005))
			return false;
		if (Float.floatToIntBits(dec_006) != Float.floatToIntBits(other.dec_006))
			return false;
		if (Float.floatToIntBits(dec_007) != Float.floatToIntBits(other.dec_007))
			return false;
		if (Float.floatToIntBits(dec_008) != Float.floatToIntBits(other.dec_008))
			return false;
		if (Float.floatToIntBits(dec_009) != Float.floatToIntBits(other.dec_009))
			return false;
		if (Float.floatToIntBits(dec_010) != Float.floatToIntBits(other.dec_010))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (extensao_arq == null) {
			if (other.extensao_arq != null)
				return false;
		} else if (!extensao_arq.equals(other.extensao_arq))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idInc == null) {
			if (other.idInc != null)
				return false;
		} else if (!idInc.equals(other.idInc))
			return false;
		if (id_doc == null) {
			if (other.id_doc != null)
				return false;
		} else if (!id_doc.equals(other.id_doc))
			return false;
		if (id_tipo_doc == null) {
			if (other.id_tipo_doc != null)
				return false;
		} else if (!id_tipo_doc.equals(other.id_tipo_doc))
			return false;
		if (int_001 == null) {
			if (other.int_001 != null)
				return false;
		} else if (!int_001.equals(other.int_001))
			return false;
		if (int_002 == null) {
			if (other.int_002 != null)
				return false;
		} else if (!int_002.equals(other.int_002))
			return false;
		if (int_003 == null) {
			if (other.int_003 != null)
				return false;
		} else if (!int_003.equals(other.int_003))
			return false;
		if (int_004 == null) {
			if (other.int_004 != null)
				return false;
		} else if (!int_004.equals(other.int_004))
			return false;
		if (int_005 == null) {
			if (other.int_005 != null)
				return false;
		} else if (!int_005.equals(other.int_005))
			return false;
		if (int_006 == null) {
			if (other.int_006 != null)
				return false;
		} else if (!int_006.equals(other.int_006))
			return false;
		if (int_007 == null) {
			if (other.int_007 != null)
				return false;
		} else if (!int_007.equals(other.int_007))
			return false;
		if (int_008 == null) {
			if (other.int_008 != null)
				return false;
		} else if (!int_008.equals(other.int_008))
			return false;
		if (int_009 == null) {
			if (other.int_009 != null)
				return false;
		} else if (!int_009.equals(other.int_009))
			return false;
		if (int_010 == null) {
			if (other.int_010 != null)
				return false;
		} else if (!int_010.equals(other.int_010))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (nome_arquivo == null) {
			if (other.nome_arquivo != null)
				return false;
		} else if (!nome_arquivo.equals(other.nome_arquivo))
			return false;
		if (Float.floatToIntBits(quantidade) != Float.floatToIntBits(other.quantidade))
			return false;
		return true;
	}

}
