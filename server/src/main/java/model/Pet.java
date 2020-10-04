package model;



public class Pet {
	int id;
	String nome, raca, porte, sexo, caracteristicas, historia;
	User user;
	
	public Pet(int id, String nome, String raca, String porte, String sexo, String caracteristicas,
			String historia, User user) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.sexo = sexo;
		this.caracteristicas = caracteristicas;
		this.historia = historia;
		this.user = user;
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getPorte() {
		return porte;
	}
	
	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public String getHistoria() {
		return historia;
	}
	
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", raca=" + raca + ", porte=" + porte + ", sexo=" + sexo
				+ ", caracteristicas=" + caracteristicas + ", historia=" + historia
				+ ", id dono= "+ user.getId() + "]";
	}
}
