<template>
	<div class="perfilUsuario">
		<Header></Header>
		<section class="container mx-auto my-4">
			<div class="row">
				<div class="col-4 d-flex justify-content-center">
					<div>
						<img
							src="https://bootdey.com/img/Content/avatar/avatar6.png"
							class="rounded-circle img-thumbnail profile"
							alt="Imagem do Usuário"
						/>
						<div class="d-flex justify-content-center">
							<label for="image" class="badge badge-info p-2 m-2" style="cursor: pointer;"
								><i class="fa fa-camera" aria-hidden="true"></i>
								Alterar Imagem</label
							>
							<input
								class="file-upload d-none"
								id="image"
								type="file"
								@change="selecionarImagem"
								accept="image/*"
							/>
						</div>
					</div>
				</div>

				<div class="col-8">
					<div class="profile-head">
						<h4 class="mb-3">
							Olá, {{ data.firstName }} {{ data.lastName }}!
						</h4>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item">
								<a
									class="nav-link active text-secondary"
									data-toggle="tab"
									href="#home"
									role="tab"
									aria-controls="home"
									aria-selected="true"
									><i
										class="fa fa-user"
										aria-hidden="true"
									></i>
									Seus dados</a
								>
							</li>
							<li class="nav-item">
								<a
									class="nav-link text-secondary"
									data-toggle="tab"
									href="#configuracao"
									role="tab"
									aria-controls="profile"
									aria-selected="false"
								>
									<i
										class="fa fa-wrench"
										aria-hidden="true"
									></i>
									Opções</a
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
							<div
								class="tab-pane container fade"
								id="configuracao"
							>
								<button type="button" class="btn btn-info mx-2">
									<i
										class="fa fa-info-circle"
										aria-hidden="true"
									></i>
									Alterar dados
								</button>
								<button
									type="button"
									class="btn btn-danger mx-2"
								>
									<i
										class="fa fa-exclamation-triangle"
										aria-hidden="true"
									></i>
									Deletar conta
								</button>
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
	methods: {
		selecionarImagem(event) {
			console.log(event);
		}
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
	max-width: 250px;
	max-height: 250px;
}
</style>