<template>
	<div class="cadastro">
		<Header></Header>

		<section class="container p-4 principal">
			<form class="d-flex justify-content-center">
				<div id="divAdd" class="card p-4 cardShadow">
					<h1 class="text-center">
						<i class="fa fa-user-plus" aria-hidden="true"></i>
						Editar
					</h1>
					<hr />
					<div class="form-group row">
						<div class="col-md-11 control-label text-right">
							<p class="help-block">* Campo Obrigatório</p>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="primeiroNome"
							class="col-4 col-form-label text-center"
							>Primeiro Nome: *</label
						>
						<div class="col-8">
							<input
								type="text"
								class="form-control"
								id="primeiroNome"
								placeholder="Insira seu primeiro nome"
								v-model="firstName"
								required
								ref="primeiroNome"
								@blur="isValid('primeiroNome', 'form-control')"
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="segundoNome"
							class="col-4 col-form-label text-center"
							>Segundo Nome: *</label
						>
						<div class="col-8">
							<input
								type="text"
								class="form-control"
								id="segundoNome"
								placeholder="Insira seu segundo nome"
								v-model="lastName"
								required
								ref="segundoNome"
								@blur="isValid('segundoNome', 'form-control')"
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="emailCadastro"
							class="col-4 col-form-label text-center"
							>Email: *</label
						>
						<div class="col-8">
							<input
								type="email"
								class="form-control"
								id="emailCadastro"
								placeholder="Insira seu email"
								required
								v-model="email"
								@blur="validarEmail"
								ref="email"
								:class="{ 'is-invalid': emailValido === false }"
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="passwordCadastro"
							class="col-4 col-form-label text-center"
							>Sua Senha: *</label
						>
						<div class="col-8">
							<input
								type="password"
								class="form-control"
								id="passwordCadastro"
								placeholder="Insira sua senha"
								required
								v-model="senha"
								@blur="validarSenha"
								:class="{ 'is-invalid': senhaValida === false }"
							/>
							<small
								id="passHelp"
								class="form-text text-center"
								:class="{
									'text-danger': !senhaValida,
									'text-muted': senhaValida,
								}"
								>Sua senha deve ter mais de 8 caracteres
								incluindo letras e números</small
							>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="telefoneCadastro"
							class="col-4 col-form-label text-center"
							>Telefone: *</label
						>
						<div class="col-8">
							<input
								type="tel"
								class="form-control"
								id="telefoneCadastro"
								placeholder="Insira seu telefone"
								v-model="telefone"
								required
								@blur="validarTelefone"
								:class="{ 'is-invalid': telefoneValido === false }"
							/>
						</div>
					</div>

					<hr />

					<div class="form-row">
						<div class="form-group col-5">
							<label for="inputAddress">Logradouro: *</label>
							<input
								type="text"
								class="form-control"
								id="logradouroCadastro"
								placeholder="Rua dos Bobos"
								required
								v-model="logradouro"
								ref="logradouro"
								@blur="isValid('logradouro', 'form-control')"
							/>
						</div>

						<div class="form-group col-2">
							<label for="inputAddress">Número: *</label>
							<input
								type="number"
								class="form-control"
								id="numeroCadastro"
								placeholder="0"
								required
								v-model="numero"
								ref="numero"
								@blur="isValid('numero', 'form-control')"
							/>
						</div>

						<div class="form-group col-5">
							<label for="inputAddress">Bairro: *</label>
							<input
								type="text"
								class="form-control"
								id="bairroCadastro"
								placeholder="Tal"
								required
								v-model="bairro"
								ref="bairro"
								@blur="isValid('bairro', 'form-control')"
							/>
						</div>
					</div>

					<div class="form-group">
						<label for="inputAddress">Complemento:</label>
						<input
							type="text"
							class="form-control"
							id="complementoCadastro"
							placeholder="Apartamento, casa, etc"
							v-model="complemento"
							ref="complemento"
							@blur="isValid('complemento', 'form-control')"
						/>
					</div>

					<div class="form-row">
						<div class="col-5 mb-3">
							<label for="inputCity">Cidade: *</label>
							<input
								type="text"
								class="form-control"
								id="cidadeCadastro"
								required
								v-model="cidade"
								ref="cidade"
								@blur="isValid('cidade', 'form-control')"
							/>
						</div>
						<div class="col-md-3 mb-3">
							<label for="inputEstado">Estado: *</label>
							<select
								id="estadoCadastro"
								class="form-control"
								required
								v-model="estado"
								ref="estado"
								@blur="isValid('estado', 'form-control')"
							>
								<option value="CE">Ceará</option>
								<option value="PI">Piauí</option>
							</select>
						</div>
						<div class="col-4 mb-3">
							<label for="inputCEP">CEP: *</label>
							<input
								type="text"
								class="form-control"
								id="cepCadastro"
								required
								maxlength="10"
								minlength="10"
								v-model="cep"
								placeholder="00.000-000"
								@blur="validarCep"
								:class="{ 'is-invalid': cepValido === false }"
							/>
						</div>
					</div>

					<div class="d-flex justify-content-end">
						<button
							type="button"
							@click="atualizar"
							class="btn btn-primary"
						>
							Cadastrar
						</button>
					</div>
				</div>
			</form>
		</section>

		<Footer></Footer>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import auth from "../auth";

export default {
	name: "Editar",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			firstName: "",
			lastName: "",
			email: "",
			senha: "",
			telefone: "",
			logradouro: "",
			numero: "",
			bairro: "",
			complemento: "",
			cidade: "",
			estado: "",
			cep: "",
			senhaValida: true,
			emailValido: true,
			cepValido: true,
			data: "",
			baseURI: "http://localhost:8080/adoteumamigo/users",
		};
	},
	created: function () {
		if (this.$session.exists()) {
			this.$http.get(this.baseURI + "/" + this.$session.id()).then((result) => {
				this.data = result.data;
			});
		} else {
			this.$router.replace("/");
		}
	},
	methods: {
		atualizar: function () {
			let obj = {
				firstName: this.firstName,
				lastName: this.lastName,
				email: this.email,
				senha: this.senha,
				telefone: this.telefone,
				logradouro: this.logradouro,
				numero: this.numero,
				bairro: this.bairro,
				complemento: this.complemento,
				cidade: this.cidade,
				estado: this.estado,
				cep: this.cep,
			};
			this.$http
				.put(this.baseURI + "/" + this.data.id, obj)
				.then((result) => {
					this.user = result.data;
					alert("Atualizado com sucesso!");
					location.reload();
				});
		},
		validarSenha: function () {
			var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
			if (regex.test(this.senha)) {
				this.senhaValida = true;
			} else {
				this.senhaValida = false;
			}
		},
		validarEmail: function () {
			var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			if (regex.test(this.email)) {
				this.emailValido = true;
			} else {
				this.emailValido = false;
			}
		},
		validarCep: function () {
			var regex = /^[0-9]{2}.[0-9]{3}-[0-9]{3}$/;
			if (regex.test(this.cep)) {
				this.cepValido = true;
			} else {
				this.cepValido = false;
			}
		},
		isValid: function (input, padrao) {
			var elem = this.$refs[input];
			if (elem.value == "") {
				elem.classList += " is-invalid";
			} else {
				elem.classList = padrao;
			}
		},
		validarTelefone: function () {
			var regex = /^(\(\d{2}\))(\d{4,5}\-\d{4})$/;
			if (regex.test(this.telefone)) {
				this.telefoneValido = true;
			} else {
				this.telefoneValido = false;
			}
		},
	},
};
</script>

<style>
</style>