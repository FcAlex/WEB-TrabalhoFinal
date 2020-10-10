<template>
	<div class="ajude">
		<Header></Header>
		<section class="container text-center p-4">
			<div class="card">
				<div class="card-header">
					<h1>
						<i class="fa fa-paw"></i> Cadastre seu bichinho para
						adoção
					</h1>
				</div>
				<form action="#" class="mt-3 p-3 card-body">
					<div class="row">
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

					<div class="d-flex justify-content-between">
						<div class="input-group mr-auto p-2 bd-highlight">
							<div class="custom-file">
								<input
									type="file"
									class="custom-file-input"
									id="inputGroupFile04"
									aria-describedby="inputGroupFileAddon04"
								/>
								<label
									class="custom-file-label"
									for="inputGroupFile04"
									>Escolher imagem principal</label
								>
							</div>
						</div>

						<div class="p-2 bd-highlight">
							<div class="card" style="width: 18rem">
								<img
									class="card-img-top"
									src="../assets/padrao_capa.png"
									alt="Imagem de capa do card"
								/>
								<div class="card-footer">
									<p class="card-text">
										Esta será a primeira imagem que
										aparecerá ao realizar a busca.
									</p>
								</div>
							</div>
						</div>

						<div class="input-group p-2 bd-highlight">
							<div class="custom-file">
								<input
									type="file"
									class="custom-file-input"
									id="inputGroupFile04"
									aria-describedby="inputGroupFileAddon04"
									multiple
								/>
								<label
									class="custom-file-label"
									for="inputGroupFile04"
									>Carregar mais imagens</label
								>
							</div>
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
						<button type="reset" class="btn btn-secondary mx-2">
							Limpar
						</button>
					</div>
				</form>
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
	data: function(){
		return {
			nome: "",
			raca: "",
			porte: "",
			sexo: "",
			caracteristicas: "",
			historia: "",
			id_user: "",
			baseURI: "http://localhost:8080/server/api/pets"
		};
	},
	created: function(){
	  if(localStorage.getItem("user")){
		  this.id_user = localStorage.getItem("user");
	  }
	  
  	},
	methods: {
		cadastrar: function () {
			if(localStorage.getItem("user")){
				let obj = {
					nome: this.nome,
					raca: this.raca,
					porte: this.porte,
					sexo: this.sexo,
					caracteristicas: this.caracteristicas,
					historia: this.historia,
					id_user: this.id_user,
				};
			
				this.$http.post(this.baseURI, obj).then((result) => {
					if (result.data != "") {
						alert("Cadastrado")
					}
				});
			}else{
				alert("É preciso fazer o login para continuar");
				
			}
			location.reload();
		}
	}
};
</script>

<style>
textarea {
	resize: none;
}
</style>