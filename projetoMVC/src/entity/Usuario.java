package entity;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String nome;
	private String email;
	private String senha;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
  
	
	
	public Usuario(Integer idUsuario, String nome, String email, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean isNome() {
		Pattern p = Pattern.compile("[a-z A-Z]{2,50}");
		Matcher m = p.matcher(this.nome);
		return m.matches();
	}
	public Boolean isEmail() {
		  //letra, numero, simbolo _ -
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(this.email);
		return m.matches();
	}
	//oracle xe (express)
	//mongodb
	//postgre
	public Boolean isSenha() {
		Pattern p = Pattern.compile("[a-zA-Z0-9]{3,6}");
		Matcher m = p.matcher(this.senha);
		return m.matches();
	}
	//kl1p.com/transamericasabado2
	
	public String firewall() {
	 String msg="";
	 if (! isNome()) {
		 msg += "Nome Invalido  \n";
	 }
	 if (! isEmail()) {
		 msg += "Email Invalido \n";
	 }
	 if (! isSenha()) {
		 msg +=" Senha Invalida \n";
	 }
	 return msg;	
	}


	
	
	

}
