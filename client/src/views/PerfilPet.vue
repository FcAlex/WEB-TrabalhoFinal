<template>
	<div class="perfilPet">
		<Header></Header>
		<section class="container mx-auto my-4">
			<div class="row">
				<div class="col-4">
					<div class="d-flex justify-content-center">
						<img
							:src="'uploads/pet/' + pet.id"
							class="rounded img-thumbnail profile pet"
							alt="profile-image"
							onerror="this.src='static/pet.png'"
						/>
					</div>

					<div class="text-center mt-4" v-if="user.id == idUser">
						<h5>Ações</h5>
						<hr />
						<button
							type="button"
							class="btn btn-success"
							data-toggle="modal"
							data-target="#deletarPet"
						>
							<i
								class="fa fa-check-circle-o"
								aria-hidden="true"
							></i>
							Adotado!
						</button>
						<button
							type="button"
							class="btn btn-info mx-2"
							data-toggle="modal"
							data-target="#alterarPet"
						>
							<i class="fa fa-wrench" aria-hidden="true"></i>
							Alterar dados
						</button>
					</div>
				</div>

				<div class="col-8">
					<div class="profile-head">
						<h4 class="mb-3">Um pouco sobre {{ pet.nome }}!</h4>
						<hr />

						<div class="tab-content p-3">
							<div class="tab-pane container active" id="home">
								<div class="row">
									<div class="col-sm-6">
										<p class>Atual dono</p>
										<h6
											class="text-muted"
											data-toggle="modal"
											data-target="#verDono"
											id="dono"
										>
											<small
												><i
													class="fa fa-info-circle"
													aria-hidden="true"
												></i
											></small>
											{{ user.firstName }}
											{{ user.lastName }}
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

			<div class="modal fade" id="verDono" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button
								type="button"
								class="close"
								data-dismiss="modal"
							>
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<Usuario :user="user"></Usuario>
						</div>
					</div>
				</div>
			</div>
		</section>
		<Footer></Footer>

		<div class="modal fade" id="deletarPet">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">
							<i class="fa fa-star" aria-hidden="true"></i>
							Adotado!
						</h5>
						<button
							type="button"
							class="close"
							data-dismiss="modal"
							aria-label="Close"
						>
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="alert alert-success" role="alert">
							Que ótimo! Os dados serão removidos da lista de pets
							para adoção.
						</div>
					</div>
					<div class="modal-footer">
						<button
							type="button"
							class="btn btn-primary"
							data-dismiss="modal"
						>
							Voltar
						</button>
						<button
							type="button"
							class="btn btn-success"
							@click="deletarPet"
							data-dismiss="modal"
						>
							Confirmar
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="alterarPet">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Alterar Dados</h5>
						<button
							type="button"
							class="close"
							data-dismiss="modal"
							aria-label="Close"
						>
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<section class="container text-center p-4">
							<div class="card border-0">
								<div class="row pt-4">
									<div class="form-group col">
										<label for="nomePet"
											>Nome/Apelido do Pet</label
										>
										<input
											type="text"
											class="form-control"
											id="nome"
											v-model="atualizar.nome"
											required
										/>
									</div>

									<div class="form-group col">
										<label for="nomePet">Raça</label>
										<input
											type="text"
											class="form-control"
											v-model="atualizar.raca"
											required
										/>
									</div>
									<div class="form-group col">
										<label for="porteCadastro">Porte</label>
										<select
											id="porte"
											v-model="atualizar.porte"
											class="form-control"
											required
										>
											<option selected>
												Escolher...
											</option>
											<option value="Pequeno">
												Pequeno
											</option>
											<option value="Médio">Médio</option>
											<option value="Grande">
												Grande
											</option>
										</select>
									</div>
									<div class="form-group col">
										<label for="SexoCadastro">Sexo</label>
										<select
											id="sexo"
											v-model="atualizar.sexo"
											class="form-control"
											required
										>
											<option selected>
												Escolher...
											</option>
											<option value="Macho">Macho</option>
											<option value="Fêmea">Fêmea</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="historia"
										>Caracteristicas</label
									>
									<textarea
										class="form-control"
										id="caracteristicas"
										v-model="atualizar.caracteristicas"
										rows="4"
										placeholder="Descreva as principais características do pet."
										required
									></textarea>
								</div>

								<div class="form-group">
									<label for="historia">História</label>
									<textarea
										class="form-control"
										id="historia"
										v-model="atualizar.historia"
										rows="4"
										placeholder="Descreva a história do seu pet e os motivos que para a doar."
										required
									></textarea>
								</div>
								<div class="container"></div>
								<div class="d-flex justify-content-start">
									<div
										class="input-group mr-auto p-2 bd-highlight"
									>
										<div class="form-group">
											<input
												type="file"
												id="file"
												accept="image/*"
												ref="pet"
												@change="imagePath"
											/>
										</div>
									</div>

									<div class="alert alert-info" role="alert">
										<p>
											Os campos em branco não serão
											atualizados!
										</p>
									</div>
								</div>
							</div>
						</section>
					</div>
					<div class="modal-footer">
						<button
							type="button"
							class="btn btn-primary"
							data-dismiss="modal"
						>
							Voltar
						</button>
						<button
							type="button"
							class="btn btn-success"
							@click="atualizarPet"
							data-dismiss="modal"
						>
							Confirmar
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import Usuario from "@/components/Usuario.vue";

export default {
	name: "PerfilPet",
	props: {
		id: Number,
	},
	components: {
		Header,
		Footer,
		Usuario,
	},
	data: function () {
		return {
			pet: {},
			user: {},
			idUser: undefined,
			atualizar: {
				nome: "",
				raca: "",
				porte: "",
				sexo: "",
				caracteristicas: "",
				historia: "",
				id_user: "",
			},
			file: "",
			baseURI: "http://localhost:8080/api/pets",
			baseUserURI: "http://localhost:8080/api/users",
			baseUploadURI: "http://localhost:8080/api/upload"
		};
	},
	created: function () {
		this.$http
			.get(this.baseURI + "/" + this.id)
			.then((result) => {
				this.pet = result.data;
				this.buscarUsuario(this.pet.id_user);
			})
			.catch(function (error) {
				console.log(error);
			});

		if (this.$session.exists()) {
			this.idUser = JSON.parse(this.$session.get("user")).id;
		}
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
		imagePath(e) {
			this.file = e.target.files[0];
			//this.handleFileUpload(this.data.id, this.filePet);
		},
		handleFileUpload(id) {
			let form = new FormData();
			form.append("resource", "pet");
			form.append("id", id);
			form.append("file", this.file);
			this.$http
				.put(this.baseUploadURI, form, {
					headers: {
						"Content-Type": "multipart/form-data",
					},
				})
				.then((result) => {
					console.log(result);
				});
		},
		atualizarPet() {
			let obj = {
				nome:
					this.atualizar.nome == ""
						? this.pet.nome.trim()
						: this.atualizar.nome.trim(),
				raca:
					this.atualizar.raca == ""
						? this.pet.raca.trim()
						: this.atualizar.raca.trim(),
				porte:
					this.atualizar.porte == ""
						? this.pet.porte.trim()
						: this.atualizar.porte.trim(),
				sexo:
					this.atualizar.sexo == ""
						? this.pet.sexo.trim()
						: this.atualizar.sexo.trim(),
				caracteristicas:
					this.atualizar.caracteristicas.trim() == ""
						? this.pet.caracteristicas
						: this.atualizar.caracteristicas.trim(),
				historia:
					this.atualizar.historia == ""
						? this.pet.historia.trim()
						: this.atualizar.historia.trim(),
				id_user: this.user.id,
			};

			this.$http.put(this.baseURI + "/" + this.pet.id, obj).then((result) => {
				this.pet = result.data;
				this.handleFileUpload(this.pet.id);
				this.$router.replace("/adote");
			});
		},
		deletarPet() {
			this.$http
				.delete(this.baseURI + "/" + this.pet.id)
				.then((result) => {
					this.$router.replace("/adote");
				})
				.catch((e) => {
					console.log(e);
				});
		},
	},
};
</script>

<style>
img.pet {
	width: 100%;
	max-width: 300px;
	height: 300px;
	object-fit: cover;
	object-position: top;
}
#dono {
	cursor: pointer;
}

#dono:hover {
	text-decoration: underline;
}
</style>