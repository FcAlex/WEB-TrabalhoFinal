package ufc.crateus.web.traballho_final.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue
	int id;
	
	@NotBlank
	@Email
	@Column(unique = true)
	String email;
	
	@NotBlank
	@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)(?=.*\\W+))(?![.\\n]).*$")
	String senha;
	
	@NotBlank
	String firstName;
	
	@NotBlank
	String lastName;
	
	@NotBlank
	@Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?[\\s9]?\\d{4}-?\\d{4}$")
	String telefone;
	
	@NotBlank
	String logradouro;
	
	@NotBlank
	String numero;
	
	@NotBlank
	String bairro;
	
	String complemento;
	
	@NotBlank
	String cidade;
	
	@NotBlank
	String estado;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{2}.[0-9]{3}-[0-9]{3}$")
	String cep;

	public User(int id, String email, String senha, String firstName, String lastName, String telefone,
			String logradouro, String numero, String bairro, String complemento, String cidade, String estado,
			String cep) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public User(String email, String senha, String firstName, String lastName, String telefone,
			String logradouro, String numero, String bairro, String complemento, String cidade, String estado,
			String cep) {
		super();
		this.email = email;
		this.senha = senha;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", senha=" + senha + ", firstName=" + firstName + ", lastName="
				+ lastName + ", telefone=" + telefone + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", bairro=" + bairro + ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado
				+ ", cep=" + cep + "]";
	}

	public void setAll(User user) {
		this.email = user.email;
		this.senha = user.senha;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.telefone = user.telefone;
		this.logradouro = user.logradouro;
		this.numero = user.numero;
		this.bairro = user.bairro;
		this.complemento = user.complemento;
		this.cidade = user.cidade;
		this.estado = user.estado;
		this.cep = user.cep;
	}
	
	
}