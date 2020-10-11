<template>
	<div class="perfilUsuario">
		<Header></Header>
		<section class="container mx-auto my-4">
			<div class="row">
				<div class="col-4 d-flex justify-content-center">
					<div>
						<img
							:src="'uploads/user/' + data.id"
							class="rounded-circle img-thumbnail profile"
							alt="Imagem do Usuário"
							ref="imagePadrao"
							@error="imagemPadrao()"
						/>
						<div class="d-flex justify-content-center">
							<label
								for="image"
								class="badge badge-info p-2 m-2"
								style="cursor: pointer"
								><i class="fa fa-camera" aria-hidden="true"></i>
								Alterar Imagem</label
							>
							<input
								class="file-upload d-none"
								id="image"
								type="file"
								name="image"
								ref="image"
								accept="image/*"
								@change="selecionarImagem()"
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

							<li class="nav-item">
								<a
									class="nav-link text-secondary"
									data-toggle="tab"
									href="#pets"
									role="tab"
									aria-controls="profile"
									aria-selected="false"
								>
									<i class="fa fa-paw" aria-hidden="true"></i>
									Adoção</a
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
									data-toggle="modal"
									data-target="#deletarConta"
								>
									<i
										class="fa fa-exclamation-triangle"
										aria-hidden="true"
									></i>
									Deletar conta
								</button>

								<div class="modal fade" id="deletarConta">
									<div
										class="modal-dialog modal-dialog-centered"
										role="document"
									>
										<div class="modal-content">
											<div class="modal-header">
												<h5
													class="modal-title"
													id="exampleModalLongTitle"
												>
													Você realmente deseja isso?
													<i
														class="fa fa-frown-o"
														aria-hidden="true"
													></i>
												</h5>
												<button
													type="button"
													class="close"
													data-dismiss="modal"
													aria-label="Close"
												>
													<span aria-hidden="true"
														>&times;</span
													>
												</button>
											</div>
											<div class="modal-body">
												<div
													class="alert alert-danger"
													role="alert"
												>
													<i
														class="fa fa-exclamation-circle"
														aria-hidden="true"
													></i>

													Se você confirmar, todos os
													seus dados serão perdidos.
												</div>
											</div>
											<div class="modal-footer">
												<button
													type="button"
													class="btn btn-primary"
													data-dismiss="modal"
												>
													Fechar
												</button>
												<button
													type="button"
													class="btn btn-secondary"
													@click="deletarConta()"
													data-dismiss="modal"
												>
													Confirmar
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div
								class="tab-pane container fade"
								id="pets"
							>
								
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
import auth from "../auth";

export default {
	name: "PerfilUsuario",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			file: null,
			data: "",
			baseURI: "http://localhost:8080/server/api/users",
			baseUploadURI: "http://localhost:8080/server/upload",
		};
	},
	methods: {
		selecionarImagem() {
			this.$http.put(this.baseURI, this.data).then((result) => {
				console.log(result);
				this.handleFileUpload(this.data.id);
			});
		},
		handleFileUpload(id) {
			this.file = this.$refs.image.files[0];

			let obj = {
				resource: "user",
				id: id,
			};
			let json = JSON.stringify(obj);

			let form = new FormData();
			form.append("obj", json);
			form.append("file", this.file);

			this.$http
				.post(this.baseUploadURI, form, {
					headers: {
						"Content-Type": "multipart/form-data",
					},
				})
				.then((result) => {
					console.log(result);
				});
		},
		deletarConta() {
			this.$http
				.delete(this.baseURI + "/" + this.data.id)
				.then((result) => {
					auth.sair();
					this.$router.replace("/");
				})
				.catch((e) => {
					console.log(e);
				});
		},
		imagemPadrao() {
			this.$refs.imagemPadrao.src = "static/pessoa.png";
		},
	},
	created: function () {
		var user = JSON.parse(localStorage.getItem("user"));
		if (user != null) {
			this.$http.get(this.baseURI + "/" + user).then((result) => {
				this.data = result.data;
			});
		} else {
			this.$router.replace("/");
		}
	},
};
</script>
 
<style>
.profile {
	width: 250px;
	height: 250px;
	object-fit: cover;
	object-position: top;
}
</style>