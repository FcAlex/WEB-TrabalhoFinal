<template>
	<div>
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4" />

			<div v-show="pets == ''" class="my-4">
				<h3 class="h4 text-center">
					<i class="fa fa-exclamation-circle" aria-hidden="true"></i>
					Não foi possível encontrar pets cadastrados!
				</h3>
			</div>
			<div id="addCardsPets" class="row">
				<div class="col-4" v-for="pet in pets" :key="pet.id">
					<div class="card mb-2">
						<img
							class="rounded-circle img-thumbnail usuario mx-auto d-block mt-3"
							:src="'uploads/pet/' +pet.id"
							alt="Imagem de capa do card"
							id="pet"
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
		<Footer v-if="pets == ''" fixed="footer fixed-bottom"></Footer>
		<Footer v-else></Footer>
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
			.get(this.baseURI + "/search?raca=" + this.nomePet)
			.then((result) => {
				this.pets = result.data;
			})
			.catch(function (error) {
				console.log(error);
			});
	},
};
</script>

<style>
#pet {
	width: 200px;
	height: 200px;
	object-fit: cover;
	object-position: top;
}
</style>