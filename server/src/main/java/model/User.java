package model;

public class User {
	int id;
	String email, senha, firstName, lastName, telefone, endereco, complemento, cidade, estado, cep;
	
	public User(int id, String email, String senha, String firstName, String lastName, String telefone,
			String endereco, String complemento, String cidade, String estado, String cep) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telefone = telefone;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public User(int id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", senha=" + senha + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", telefone=" + telefone + ", endereco=" + endereco + ", complemento="
				+ complemento + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
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
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
}
