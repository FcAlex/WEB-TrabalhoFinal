<template>
	<div class="perfilUsuario">
		<Header></Header>
		<section class="container mx-auto my-5">
			<div class="row mb-5">
				<div class="col-4 d-flex justify-content-center">
					<div>
						<img
							:src="'uploads/user/' + data.id"
							class="rounded-circle img-thumbnail profile"
							alt="Imagem do Usuário"
							onerror="this.src='static/pet.png'"
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
											{{ data.logradouro }}, nr.
											{{ data.numero }},
											{{ data.bairro }},
											{{ data.complemento }},
											{{ data.cidade }}-{{ data.estado }},
											{{ data.cep }}
										</h6>
									</div>
								</div>
							</div>
							<div
								class="tab-pane container fade"
								id="configuracao"
							>
								<button
									type="button"
									class="btn btn-info mx-2"
									@click="$router.replace('/editarUser')"
								>
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
										class="fa fa-trash-o"
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
													<i
														class="fa fa-trash"
														aria-hidden="true"
													></i>
													| Você realmente deseja
													isso?
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
							<div class="tab-pane container fade" id="pets">
								<div class="text-center">
									<h2 class="h3">Meus pets</h2>
								</div>
								<div v-show="pets == ''" class="my-4">
									<h3 class="h4 text-center">
										<i
											class="fa fa-exclamation-circle"
											aria-hidden="true"
										></i>
										Você não possui pets cadastrados!
									</h3>
								</div>
								<div
									v-for="pet in pets"
									:key="pet.id"
									class="card m-2"
								>
									<div class="card-body">
										<div>
											<div class="header">
												<div class="row">
													<div class="col-4 d-flex">
														<img
															:src="
																'uploads/pet/' +
																pet.id
															"
															class="rounded img-thumbnail profileT pet"
															alt="profile-image"
															onerror="this.src='static/pet.png'"
														/>
													</div>
													<hr />
													<div class="col-8">
														<div
															class="ml-3 text-left"
														>
															<h5
																class="text-weight-bold"
															>
																{{ pet.nome }}
															</h5>
															<p>
																<strong>
																	Raça:
																</strong>
																{{ pet.raca }}
															</p>
															<p>
																<strong>
																	Porte:
																</strong>
																{{ pet.porte }}
															</p>
															<p>
																<strong>
																	Sexo:
																</strong>
																{{ pet.sexo }}
															</p>
														</div>
													</div>
												</div>
											</div>
											<div class="left">
												<p></p>
												<p>
													<strong>
														Caracteristicas:
													</strong>
													{{ pet.caracteristicas }}
												</p>
												<p>
													<strong> História: </strong>
													{{ pet.historia }}
												</p>
											</div>
											<div>
												<h6>Ações</h6>
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
													<i
														class="fa fa-wrench"
														aria-hidden="true"
													></i>
													Alterar dados
												</button>
												<div
													class="modal fade"
													id="deletarPet"
												>
													<div
														class="modal-dialog modal-dialog-centered"
														role="document"
													>
														<div
															class="modal-content"
														>
															<div
																class="modal-header"
															>
																<h5
																	class="modal-title"
																>
																	<i
																		class="fa fa-star"
																		aria-hidden="true"
																	></i>
																	Adotado!
																</h5>
																<button
																	type="button"
																	class="close"
																	data-dismiss="modal"
																	aria-label="Close"
																>
																	<span
																		aria-hidden="true"
																		>&times;</span
																	>
																</button>
															</div>
															<div
																class="modal-body"
															>
																<div
																	class="alert alert-success"
																	role="alert"
																>
																	Que ótimo!
																	Os dados
																	serão
																	removidos da
																	lista de
																	pets para
																	adoção.
																</div>
															</div>
															<div
																class="modal-footer"
															>
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
																	@click="
																		deletarPet(
																			pet.id
																		)
																	"
																	data-dismiss="modal"
																>
																	Confirmar
																</button>
															</div>
														</div>
													</div>
												</div>

												<div
													class="modal fade"
													id="alterarPet"
												>
													<div
														class="modal-dialog modal-lg"
														role="document"
													>
														<div
															class="modal-content"
														>
															<div
																class="modal-header"
															>
																<h5
																	class="modal-title"
																>
																	Alterar
																	Dados
																</h5>
																<button
																	type="button"
																	class="close"
																	data-dismiss="modal"
																	aria-label="Close"
																>
																	<span
																		aria-hidden="true"
																		>&times;</span
																	>
																</button>
															</div>
															<div
																class="modal-body"
															>
																<section
																	class="container text-center p-4"
																>
																	<div
																		class="card border-0"
																	>
																		<div
																			class="row pt-4"
																		>
																			<div
																				class="form-group col"
																			>
																				<label
																					for="nomePet"
																					>Nome/Apelido
																					do
																					Pet</label
																				>
																				<input
																					type="text"
																					class="form-control"
																					id="nome"
																					v-model="
																						atualizar.nome
																					"
																					required
																				/>
																			</div>

																			<div
																				class="form-group col"
																			>
																				<label
																					for="nomePet"
																					>Raça</label
																				>
																				<input
																					type="text"
																					class="form-control"
																					id="raca"
																					v-model="
																						atualizar.raca
																					"
																					required
																				/>
																			</div>
																			<div
																				class="form-group col"
																			>
																				<label
																					for="porteCadastro"
																					>Porte</label
																				>
																				<select
																					id="porte"
																					v-model="
																						atualizar.porte
																					"
																					class="form-control"
																					required
																				>
																					<option
																						selected
																					>
																						Escolher...
																					</option>
																					<option
																						value="Pequeno"
																					>
																						Pequeno
																					</option>
																					<option
																						value="Médio"
																					>
																						Médio
																					</option>
																					<option
																						value="Grande"
																					>
																						Grande
																					</option>
																				</select>
																			</div>
																			<div
																				class="form-group col"
																			>
																				<label
																					for="SexoCadastro"
																					>Sexo</label
																				>
																				<select
																					id="sexo"
																					v-model="
																						atualizar.sexo
																					"
																					class="form-control"
																					required
																				>
																					<option
																						selected
																					>
																						Escolher...
																					</option>
																					<option
																						value="Macho"
																					>
																						Macho
																					</option>
																					<option
																						value="Fêmea"
																					>
																						Fêmea
																					</option>
																				</select>
																			</div>
																		</div>

																		<div
																			class="form-group"
																		>
																			<label
																				for="historia"
																				>Caracteristicas</label
																			>
																			<textarea
																				class="form-control"
																				id="caracteristicas"
																				v-model="
																					atualizar.caracteristicas
																				"
																				rows="4"
																				placeholder="Descreva as principais características do pet."
																				required
																			></textarea>
																		</div>

																		<div
																			class="form-group"
																		>
																			<label
																				for="historia"
																				>História</label
																			>
																			<textarea
																				class="form-control"
																				id="historia"
																				v-model="
																					atualizar.historia
																				"
																				rows="4"
																				placeholder="Descreva a história do seu pet e os motivos que para a doar."
																				required
																			></textarea>
																		</div>
																		<div
																			class="container"
																		></div>
																		<div
																			class="d-flex justify-content-start"
																		>
																			<div
																				class="input-group mr-auto p-2 bd-highlight"
																			>
																				<div
																					class="form-group"
																				>
																					<input
																						type="file"
																						id="file"
																						@change="
																							imagePath(
																								$event
																							)
																						"
																					/>
																				</div>
																			</div>

																			<div
																				class="alert alert-info"
																				role="alert"
																			>
																				<p>
																					Os
																					campos
																					em
																					branco
																					não
																					serão
																					atualizados!
																				</p>
																			</div>
																		</div>
																	</div>
																</section>
															</div>
															<div
																class="modal-footer"
															>
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
																	@click="
																		atualizarPet(
																			pet
																		)
																	"
																	data-dismiss="modal"
																>
																	Confirmar
																</button>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
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
import auth from "../auth";

export default {
	name: "PerfilUsuario",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			pets: [],
			file: "",
			data: "",
			atualizar: {
				nome: "",
				raca: "",
				porte: "",
				sexo: "",
				caracteristicas: "",
				historia: "",
				id_user: "",
			},
			baseURI: "http://localhost:8080/api/users",
			baseURI2: "http://localhost:8080/api/pets",
			baseUploadURI: "http://localhost:8080/api/upload",
		};
	},
	methods: {
		selecionarImagem() {
			this.handleFileUpload(this.data.id);
			location.reload();
		},
		handleFileUpload(id) {
			this.file = this.$refs.image.files[0];

			let form = new FormData();
			form.append("resource", "user");
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
		deletarPet(id) {
			this.$http
				.delete(this.baseURI2 + "/" + id)
				.then((result) => {
					location.reload();
				})
				.catch((e) => {
					console.log(e);
				});
		},
		selecionarPets() {
			this.$http
				.get(this.baseURI2 + "/search?id_user=" + this.data.id)
				.then((result) => {
					pets = result.data;
				})
				.catch(function (error) {
					console.log(error);
				});
		},
		atualizarPet(pet) {
			let obj = {
				nome: this.atualizar.nome == "" ? pet.nome : this.atualizar.nome, 
				raca: this.atualizar.raca == "" ? pet.raca : this.atualizar.raca,
				porte: this.atualizar.porte == "" ? pet.porte : this.atualizar.porte,
				sexo: this.atualizar.sexo == "" ? pet.sexo : this.atualizar.sexo,
				caracteristicas: this.atualizar.caracteristicas == "" ? pet.caracteristicas : this.atualizar.caracteristicas,
				historia: this.atualizar.historia == "" ? pet.historia : this.atualizar.historia,
				id_user: this.data.id,
			};
			this.$http.put(this.baseURI2 + "/" + pet.id, obj).then((result) => {
				location.reload();
			});
		},
	},
	created: function () {
		if (this.$session.exists()) {
			this.data = JSON.parse(this.$session.get("user"));
			//console.log(this.$session.get("user"));
			//this.$http.get(this.baseURI + "/" + user.id).then((result) => {
			//this.data = result.data;
			//});
		} else {
			this.$router.replace("/");
		}
	},
	mounted: function () {
		this.$http
			.get(this.baseURI2 + "/search?id_user=" + this.data.id)
			.then((result) => {
				//console.log(this.pets);
				this.pets = result.data;
			})
			.catch(function (error) {
				console.log(this.data);
				console.log(error);
			});
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
.profileT {
	max-width: 200px;
	max-height: 150px;
	width: auto;
	height: auto;
}
.divs {
	margin-block-end: 10px;
}
</style>