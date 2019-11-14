package br.com.OPT_WEB_002.usuario;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import javax.persistence.*;
import br.com.OPT_WEB_002.empresa.Empresa;
import br.com.OPT_WEB_002.filial.Filial;
import br.com.OPT_WEB_002.unidade_negocio.Unidade_Negocio;

@Entity(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id_usuario;
		
	private String nome;
																		
	private String email;
	
	private String login;	
	
	private String senha;
		
	private String idioma;
	
	private boolean ativo;
	
	@ManyToOne()
	@JoinColumn(name = "cod_empresa")
	private Empresa cod_empresa;
	
	@ManyToOne()
	@JoinColumn(name = "cod_filial")
	private Filial cod_filial;
	
	@ManyToOne()
	@JoinColumn(name = "cod_unidade",nullable=true)
	private Unidade_Negocio cod_unidade;
	
	@Column(nullable = false)
	private boolean tipo_usuario;
	
	@Column(nullable = true)
	private String cliente;

	@ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario",
				"permissao" }) }, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length = 50)

	private Set<String> permissao = new HashSet<String>();

	public Usuario(){
		
		Empresa empresa = new Empresa();
		Filial filial = new Filial();
		Unidade_Negocio unidade_Negocio = new Unidade_Negocio();
				
		this.cod_empresa = empresa;
		this.cod_filial = filial;
		this.cod_unidade = unidade_Negocio;
	
	}

	public BigInteger getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(BigInteger id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public boolean isTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(boolean tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);		
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());	
		result = prime * result + ((cod_empresa == null) ? 0 : cod_empresa.hashCode());
		result = prime * result + ((cod_filial == null) ? 0 : cod_filial.hashCode());
		result = prime * result + ((cod_unidade == null) ? 0 : cod_unidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());	
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (tipo_usuario ? 1231 : 1237);
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (tipo_usuario != other.tipo_usuario)
			return false;
		return true;
	}

	


}
