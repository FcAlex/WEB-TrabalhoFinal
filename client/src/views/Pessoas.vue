<template>
	<div class="pessoas">
		<Header></Header>
		<section id="principal" class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre pessoas</h1>
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
			console.log("OK");
		}).catch (e => {
			console.log("ERRO");
		});
	},
	methods: {
		imagemPadrao(event) {
			event.target.src = 'static/pessoa.png';
		},
		print(e) {
			console.log(e)
		}
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