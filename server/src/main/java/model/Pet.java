package model;


public class Pet {
	int id;
	String nome, raca, porte, sexo, caracteristicas, historia;
	int id_User;
	
	public Pet(int id, String nome, String raca, String porte, String sexo, String caracteristicas,
			String historia, int id_user) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.sexo = sexo;
		this.caracteristicas = caracteristicas;
		this.historia = historia;
		this.id_User = id_user;
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
	
	public int getId_User() {
		return id_User;
	}

	public void setId_User(int id_User) {
		this.id_User = id_User;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", raca=" + raca + ", porte=" + porte + ", sexo=" + sexo
				+ ", caracteristicas=" + caracteristicas + ", historia=" + historia
				+ "id_user" + id_User +  "]";
	}

}