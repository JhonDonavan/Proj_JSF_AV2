package dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="AdmSistema")
public class AdmSistema implements IdSequencial, Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "FUNCIONARIO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FUNCIONARIO_ID", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
	private Long id;

	@Column(name="login",unique = true)
	@NotEmpty(message="O campo não pode estar vazio")
	private String login;
	
	@Column(name="nome")
	@NotEmpty(message="O campo não pode estar vazio")
	private String nome;
	
	@Column(name="senha")
	@NotEmpty(message="O campo não pode estar vazio")
	private String senha;
	
	@NotEmpty(message="O campo não pode estar vazio")
	private String senha2;


	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdmSistema [id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + ", senha2="
				+ senha2 + "]";
	}
		
	public boolean senhaCorreta(String senhaDigitada)
	{
		if (this.getSenha().equals(senhaDigitada))
			return true;
		else
			return false;
	}
	
}
