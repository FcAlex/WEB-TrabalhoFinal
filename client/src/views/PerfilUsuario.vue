<template>
	<div class="perfilUsuario">
		<Header></Header>
		<section class="container mx-auto my-4">
			<div class="row">
				<div class="col-4">
					<!--<form class="form form-vertical" action="post">-->
					<div class="center-block">
						<img
							src="https://bootdey.com/img/Content/avatar/avatar6.png"
							class="rounded-circle img-thumbnail profile"
							alt="profile-image"
						/>
					</div>
					<!--</form>-->
				</div>

				<div class="col-8">
					<div class="profile-head">
						<h4 class="mb-3">Olá, {{ data.firstName }} {{ data.lastName }}!</h4>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item">
								<a
									class="nav-link active"
									data-toggle="tab"
									href="#home"
									role="tab"
									aria-controls="home"
									aria-selected="true"
									>Seus dados</a
								>
							</li>
							<li class="nav-item">
								<a
									class="nav-link"
									data-toggle="tab"
									href="#configuracao"
									role="tab"
									aria-controls="profile"
									aria-selected="false"
									>Opções</a
								>
							</li>
						</ul>

						<div class="tab-content p-3">
							<div class="tab-pane container active" id="home">
								<div class="row">
									<div class="col-sm-6">
										<p class="">Email</p>
										<h6 class="text-muted">
											{{ data.email }}
										</h6>
									</div>
									<div class="col-sm-6">
										<p class="">Telefone</p>
										<h6 class="text-muted">
											{{ data.telefone }}
										</h6>
									</div>
								</div>
								<hr />
								<div class="row text-center">
									<div class="col-12">
										<p class="">Endereço</p>
										<h6 class="text-muted">
											{{ data.endereco }},
											{{ data.complemento }},
											{{ data.cidade }}-{{ data.estado }}
										</h6>
									</div>
								</div>
							</div>
							<div class="tab-pane container fade" id="configuracao">
								...
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<Footer fixed="fixed-bottom"></Footer>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import auth from "../auth";

export default {
	name: "PerfilUsuario",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			data: [],
			baseURI: "http://localhost:8080/server/api/users",
		};
	},
	created: function () {
		var user = JSON.parse(localStorage.getItem("user"));
		if (user != null) {
			this.$http.get(this.baseURI + "/" + user).then((result) => {
				this.data = result.data;
			});
		}
	},
};
</script>
 
<style>
.profile {
	width: 250px;
}
</style>