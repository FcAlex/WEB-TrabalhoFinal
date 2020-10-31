<template>
	<div class="pessoas">
		<Header></Header>
		<section id="principal" class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre pessoas</h1>
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
								@click="qtdUser"
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
								@click="nomeUser"
							>
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<hr class="mt-3 mb-4" />

			<div class="row">
				<div class="col-4" v-for="user in users" :key="user.id">
					<div class="card mb-4">
						<img
							class="card-img-top rounded mx-auto d-block mt-2 rounded-circle img-thumbnail usuario"
							:src="'uploads/user/' + user.id"
							:alt="'Image do Usuario ' + user.firstName"
							@error="imagemPadrao"
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
									{{ user.logradouro }}, nr.
									{{ user.numero }}, {{ user.bairro }},
									{{ user.cidade }}-{{ user.estado }}, CEP
									{{ user.cep }}
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div v-if="users == ''">
				<h3 class="h4 text-center">
					<i class="fa fa-exclamation-circle" aria-hidden="true"></i>
					Você não possui pets cadastrados!
				</h3>
			</div>
		</section>

		<Footer v-if="users!=''"></Footer>
		<Footer v-else fixed="footer fixed-bottom"></Footer>
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
			nome: "",
			qtd: 0,
			baseURI: "http://localhost:8080/api/users",
		};
	},
	created: function () {
		this.$http
			.get(this.baseURI)
			.then((result) => {
				this.users = result.data;
				console.log("OK");
			})
			.catch((e) => {
				console.log("ERRO");
			});
	},
	methods: {
		imagemPadrao(event) {
			event.target.src = "static/pessoa.png";
		},
		print(e) {
			console.log(e);
		},
		qtdUser() {
			this.$http
				.get(this.baseURI + "/search?qtd=" + this.qtd)
				.then((result) => {
					this.users = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
		nomeUser() {
			this.$http
				.get(this.baseURI + "/search?nome=" + this.nome.trim())
				.then((result) => {
					this.users = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
	},
};
</script>

<style>
img.usuario {
	width: 250px;
	height: 250px;
	object-fit: cover;
	object-position: top;
}
</style>