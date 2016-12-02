package dominio;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
		
	private String nome;
	@NotEmpty(message="O campo não pode estar vazio")
	private String senha;
	@NotEmpty(message="O campo não pode estar vazio")
	private String login;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	
	
	
}
