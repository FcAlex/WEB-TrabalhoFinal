<template>
	<div class="adote">
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4" />
			<div id="addCardsPets" class="row">
				<div class="col-4" v-for="pet in pets" :key="pet.id">
					<div class="card mb-2">
						<img 
							:src="'uploads/pet/' + pet.id"
							class="rounded-circle img-thumbnail profile"
							alt="Imagem do Usuário"
							onerror="this.src='static/adote_logo.png'"
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
			baseURI: "http://localhost:8080/server/api/pets",
		};
	},
	created: function () {
		this.$http.get(this.baseURI).then((result) => {
			this.pets = result.data;
		});
	},
	methods: {},
};
</script>

<style>
a {
	color: inherit;
}
img.usuario {
	width: 200px;
	height: 200px;
	object-fit: cover;
	object-position: top;
}
</style>




