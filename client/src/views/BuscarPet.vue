<template>
	<div>
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4" />
			<div id="addCardsPets" class="row">
				<div class="col-4" v-for="pet in pets" :key="pet.id">
					<div class="card mb-2">
						<img
							class="card-img-top rounded mx-auto d-block rounded mt-2 usuario"
							:src="'uploads/pet/' + + pet.id"
							alt="Imagem de capa do card"
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
	name: "Buscar",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			baseURI: "http://localhost:8080/api/pets",
			pets: [],
		};
	},
	props: {
		nomePet: "",
	},
	created() {
		this.$http
			.get(this.baseURI + "?nome=" + this.nomePet)
			.then((result) => {
				this.pets = result.data;
			})
			.catch(function (error) {
				console.log(error);
			});
	}
};
</script>

<style>
</style>