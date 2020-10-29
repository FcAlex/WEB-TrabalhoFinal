<template>
	<div class="perfilPet">
		<Header></Header>
		<section class="container mx-auto my-4">
			<div class="row">
				<div class="col-4">
					<!--<form class="form form-vertical" action="post">-->
					<div class="center-block">
						<img
							:src="'uploads/pet/' + pet.id"
							class="rounded img-thumbnail profile pet"
							alt="profile-image"
							onerror="this.src='static/pet.png'"
						/>
					</div>
					<!--</form>-->
				</div>

				<div class="col-8">
					<div class="profile-head">
						<h4 class="mb-3">Um pouco sobre {{pet.nome}}!</h4>
						<hr />

						<div class="tab-content p-3">
							<div class="tab-pane container active" id="home">
								<div class="row">
									<div class="col-sm-6">
										<p class>Atual dono</p>
										<h6 class="text-muted">
											{{user.firstName}} {{user.lastName}}
										</h6>
									</div>
									<div class="col-sm-6">
										<p class>Raça</p>
										<h6 class="text-muted">
											{{ pet.raca }}
										</h6>
									</div>
									<div class="col-sm-6">
										<p class>Porte</p>
										<h6 class="text-muted">
											{{ pet.porte }}
										</h6>
									</div>
									<div class="col-sm-6">
										<p class>Sexo</p>
										<h6 class="text-muted">
											{{ pet.sexo }}
										</h6>
									</div>
								</div>
								<hr />
								<div class="row text-center">
									<div class="col-12">
										<p class="">Características</p>
										<h6 class="text-muted">
											{{ pet.caracteristicas }}
										</h6>
									</div>

									<div class="col-12">
										<hr />
										<p class="">Minha história</p>
										<h6 class="text-muted">
											{{ pet.historia }}
										</h6>
									</div>
								</div>
							</div>
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
	name: "PerfilPet",
	props: {
		id: Number,
	},
	components: {
		Header,
		Footer,
	},
	data: function () {
		return {
			pet: {},
			user: {},
			baseURI: "http://localhost:8080/api/pets",
			baseUserURI: "http://localhost:8080/api/users",
		};
	},
	created: function () {
		this.$http
			.get(this.baseURI + "/" + this.id)
			.then((result) => {
        this.pet = result.data;
        this.buscarUsuario(this.pet.id_user)
			})
			.catch(function (error) {
				console.log(error);
			});
	},
	methods: {
		buscarUsuario(id) {
			this.$http
				.get(this.baseUserURI + "/" + id)
				.then((result) => {
					this.user = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
	},
};
</script>

<style>
img.pet {
	width: 300px;
	height: 300px;
	object-fit: cover;
	object-position: top;
}
</style>