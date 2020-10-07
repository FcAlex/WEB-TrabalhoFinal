<template>
	<div class="pessoas">
		<Header></Header>
		<section id="principal" class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre pessoas</h1>
			<hr class="mt-3 mb-4">
			<div class="row">
				<div class="col-4" v-for="user in users" :key="user.id">
					<div class="card">
						<img
							class="card-img-top rounded mx-auto d-block mt-2"
							src="../assets/pessoas/pessoa.png"
							alt="Imagem de capa do card"
              				style="max-width: 250px"
						/>

						<div class="card-body">
							<h5 class="card-title">
								{{ user.firstName }} {{ user.lastName }}
							</h5>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<strong>Telefone:</strong>
									{{ user.telefone }}
								</li>
								<li class="list-group-item">
									<strong>Email:</strong> {{ user.email }}
								</li>
								<li class="list-group-item">
									<strong>Endereço:</strong>
									{{ user.endereco }}
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
import Card from "../components/Card";

export default {
	name: "Pessoas",
	components: {
		Header,
		Footer,
		Card,
	},
	data() {
		return {
			users: [], //todo
			baseURI: "http://localhost:8080/server/api/users",
		};
	},
	created: function () {
		this.$http.get(this.baseURI).then((result) => {
			this.users = result.data;
		});
	},
};
</script>

<style>
</style>