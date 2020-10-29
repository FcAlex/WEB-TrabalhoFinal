<template>
	<div class="ajude">
		<Header></Header>
		<section class="container text-center p-4">
			<div class="card border-0">
				<div class="card-header">
					<h1>
						<i class="fa fa-paw"></i> Cadastre seu bichinho para
						adoção
					</h1>
				</div>
				<div class="row pt-4">
					<div class="form-group col">
						<label for="nomePet">Nome/Apelido do Pet</label>
						<input
							type="text"
							class="form-control"
							id="nome"
							v-model="nome"
							required
						/>
					</div>

					<div class="form-group col">
						<label for="nomePet">Raça</label>
						<input
							type="text"
							class="form-control"
							id="raca"
							v-model="raca"
							required
						/>
					</div>
					<div class="form-group col">
						<label for="porteCadastro">Porte</label>
						<select
							id="porte"
							v-model="porte"
							class="form-control"
							required
						>
							<option selected>Escolher...</option>
							<option value="Pequeno">Pequeno</option>
							<option value="Médio">Médio</option>
							<option value="Grande">Grande</option>
						</select>
					</div>
					<div class="form-group col">
						<label for="SexoCadastro">Sexo</label>
						<select
							id="sexo"
							v-model="sexo"
							class="form-control"
							required
						>
							<option selected>Escolher...</option>
							<option value="Macho">Macho</option>
							<option value="Fêmea">Fêmea</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="historia">Caracteristicas</label>
					<textarea
						class="form-control"
						id="caracteristicas"
						v-model="caracteristicas"
						rows="4"
						placeholder="Descreva as principais características do pet."
						required
					></textarea>
				</div>

				<div class="form-group">
					<label for="historia">História</label>
					<textarea
						class="form-control"
						id="historia"
						v-model="historia"
						rows="4"
						placeholder="Descreva a história do seu pet e os motivos que para a doar."
						required
					></textarea>
				</div>
				<div class="container"></div>
				<div class="d-flex justify-content-start">
					<div class="input-group mr-auto p-2 bd-highlight">
						<div class="form-group">
							<input
								type="file"
								id="file"
								@change="imagePath($event)"
							/>
						</div>
					</div>
					
					<div class="alert alert-info" role="alert">
						<p>
							Esta será a imagem que aparecerá ao
							realizar a busca.
						</p>
					</div>
				</div>


				<div class="my-5">
					<button
						type="button"
						@click="cadastrar"
						class="btn btn-success mx-2"
					>
						Cadastrar
					</button>
					<button class="btn btn-secondary mx-2">Limpar</button>
				</div>
			</div>
		</section>
		<Footer></Footer>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
	name: "Ajude",
	components: {
		Header,
		Footer,
	},
	data: function () {
		return {
			nome: "",
			raca: "",
			porte: "",
			sexo: "",
			caracteristicas: "",
			historia: "",
			id_user: "",
			baseURI: "http://localhost:8080/api/users",
			baseURI2: "http://localhost:8080/api/pets",
			baseUploadURI: "http://localhost:8080/api/upload",
			file: null,
			pet: {},
			campos: false,
			user: {},
			pets: [],
		};
	},
	created: function () {
		if (this.$session.exists()) {
			this.user = JSON.parse(this.$session.get("user"));
			console.log(this.user);
			
			this.id_user = this.user.id;
		}
	},
	methods: {
		imagePath(event) {
			this.file = event.target.files[0];
		},
		handleFileUpload(id) {
			
			if(this.file == null) {
				alert("ERROR")
				return;
			}
			let form = new FormData();
			form.append("resource", "pet");
			form.append("id", id);
			form.append("file", this.file);

			this.$http
				.post(this.baseUploadURI, form, {
					headers: {
						"Content-Type": "multipart/form-data",
					},
				})
				.then((result) => {
					console.log(result);
				});
		},
		cadastrar: function () {
			this.validarCampos();
			if (this.campos) {
				if (this.$session.exists()) {  
					let obj = { //Objeto pet
						nome: this.nome,
						raca: this.raca,
						porte: this.porte,
						sexo: this.sexo,
						caracteristicas: this.caracteristicas,
						historia: this.historia,
						user: this.user
					};

					this.user.pets.push(obj)
					let obj2 = { //Objetp user atualizado
						email: this.user.email,
						senha: this.user.senha,
						firstName: this.user.firstName,
						lastName: this.user.lastName,						
						telefone: this.user.telefone,
						logradouro: this.user.logradouro,
						numero: this.user.numero,
						bairro: this.user.bairro,
						complemento: this.user.complemento,
						cidade: this.user.cidade,
						estado: this.user.estado,
						cep: this.user.cep,
						//pets: this.user.pets,
						
					};
					this.$http.post(this.baseURI2, obj).then((result) => {
							
					});
					
					// this.$http.put(this.baseURI + "/" + this.id_user, obj2).then((result) => {
        			// 	//this.$router.push({ name: 'Users'});
					// });
	  				
				} else {
					alert("É preciso fazer o login para continuar");
				}
				this.$router.replace("/adote");
			} else {
				alert("Preencha todos os campos");
			}
		},
		validarCampos: function () {
			//Usando getElementById para não acumalar data
			//Função que garante somente que os campos não estejam vazios
			var nome = document.getElementById("nome");
			var raca = document.getElementById("raca");
			var porte = document.getElementById("porte");
			var sexo = document.getElementById("sexo");
			var caracteristicas = document.getElementById("caracteristicas");
			var historia = document.getElementById("historia");

			var array = [nome, raca, porte, sexo, caracteristicas, historia];

			this.campos = true;
			var i = 0;
			for (i = 0; i < 6; i++) {
				if (array[i].value.length == 0) {
					this.campos = false;
					console.log(array[i]);
					break;
				}
			}
		},
	},
	computed: {
		image() {
			return "uploads/pet/" + this.pet.id;
		},
	},
};
</script>

<style>
textarea {
	resize: none;
}
</style>