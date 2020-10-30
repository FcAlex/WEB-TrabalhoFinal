package ufc.crateus.web.traballho_final.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name="pets")
public class Pet {

	@Id
	@GeneratedValue
	int id;
	@NotBlank
	String nome;
	@NotBlank
	String raca;
	
	@NotBlank
	@Pattern(regexp = "Pequeno|Médio|Grande")
	String porte;
	
	@NotBlank
	@Pattern(regexp = "Fêmea|Macho")
	String sexo;
	@NotBlank
	@Column(columnDefinition = "TEXT")
	String caracteristicas;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	String historia;
	
	//@NotBlank
	//int id_user;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_user", nullable = false)
//	User user;
//	
	//@JoinColumn(name = "id_user" )
	int id_user;
	public Pet() {
		
	}
	
	public Pet(String nome, String raca, String porte, String sexo, String caracteristicas, String historia, int id_user) {
		super();
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.sexo = sexo;
		this.caracteristicas = caracteristicas;
		this.historia = historia;
		this.id_user = id_user;
	}
	
	public Pet(int id, String nome, String raca, String porte, String sexo, String caracteristicas, String historia, int id_user
			) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.sexo = sexo;
		this.caracteristicas = caracteristicas;
		this.historia = historia;
		this.id_user = id_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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


//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", raca=" + raca + ", porte=" + porte + ", sexo=" + sexo
				+ ", caracteristicas=" + caracteristicas + ", historia=" + historia + "]";
	}
	
	
	
}
