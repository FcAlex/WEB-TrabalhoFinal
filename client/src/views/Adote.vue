<template>
	<div class="adote">
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4" />
			<div class="row d-flex justify-content-center">
				<div class="col-4">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-filter" aria-hidden="true"></i>
							</div>
						</div>
						<input
							type="number"
							class="form-control"
							placeholder="Indique a qtd"
							v-model="qtd"
						/>
						<div class="input-group-append">
							<button
								type="button"
								class="btn btn-success"
								@click="qtdPet"
							>
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="col-4">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-filter" aria-hidden="true"></i>
							</div>
						</div>
						<input
							type="text"
							class="form-control"
							placeholder="Indique o nome"
							v-model="nome"
						/>
						<div class="input-group-append">
							<button
								type="button"
								class="btn btn-success"
								@click="nomePet"
							>
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<hr class="mt-3 mb-4" />

			<div id="addCardsPets" class="row">
				<div class="col-4" v-for="pet in pets" :key="pet.id">
					<div class="card mb-2">
						<img 
							:src="'uploads/pet/' + pet.id"
							class="rounded-circle img-thumbnail usuario mx-auto d-block mt-3"
							alt="Imagem do Usuário"
							onerror="this.src='static/pet.png'"
						/>

						<div class="card-body">
							<h5 class="card-title">
								<router-link
									:to="{
										name: 'perfilPet',
										params: { id: pet.id },
									}"
									>{{ pet.nome }}</router-link
								>
							</h5>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<strong>Raça:</strong>
									{{ pet.raca }}
								</li>
								<li class="list-group-item">
									<strong>Sexo:</strong> {{ pet.sexo }}
								</li>
								<li class="list-group-item">
									<strong>Porte:</strong>
									{{ pet.porte }}
								</li>
							</ul>
						</div>
					</div>
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
	name: "Adote",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			pets: [],
			nome: "",
			qtd: 0,
			baseURI: "http://localhost:8080/api/pets",
		};
	},
	created: function () {
		this.$http.get(this.baseURI).then((result) => {
			this.pets = result.data;
		});
	},
	methods: {
		qtdPet() {
			this.$http
				.get(this.baseURI + "/search?qtd=" + this.qtd)
				.then((result) => {
					this.pets = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
		nomePet() {
			this.$http
				.get(this.baseURI + "/search?nome=" + this.nome.trim())
				.then((result) => {
					this.pets = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
	},
};
</script>

<style>
a {
	color: inherit;
}
a:hover {
	color: inherit;
}
img.usuario {
	width: 200px;
	height: 200px;
	object-fit: cover;
	object-position: top;
}
</style>




