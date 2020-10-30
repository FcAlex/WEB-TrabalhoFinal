<template>
	<div class="cadastro">
		<Header></Header>

		<section class="container-fluid p-4 principal">
			<form class="d-block mx-auto col-6" @submit="cadastrar">
				<div id="divAdd" class="card p-4">
					<h1 class="text-center">
						<i class="fa fa-user-plus" aria-hidden="true"></i>
						Cadastrar
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
								aria-describedby="passHelp"
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
								>Senha deverá conter no mínimo uma letra
								minúscula, uma maiúscula, um número, um
								caractere especial e com o comprimento mínimo de
								oito caracteres.</small
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
								placeholder="(00)00000-0000 ou (00)0000-0000"
								v-model="telefone"
								@blur="validarTelefone"
								:class="{
									'is-invalid': telefoneValido === false,
								}"
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
								@blur="
									isValid('estado', 'form-control') &&
										opcaoErrada('estado', 'form-control')
								"
							>
								<option value="ERROR" selected>
									Escolher...
								</option>
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
						<button type="button" @click="cadastrar" class="btn btn-primary">
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
	name: "Cadastro",
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
			pets: [],
			senhaValida: true,
			emailValido: true,
			cepValido: true,
			telefoneValido: true,
		};
	},
	created: function () {
		if (this.$session.exists()) {
			this.$router.push("/");
		}
	},
	methods: {
		cadastrar: function () {
			let obj = {
				firstName: this.firstName == "" ? this.data.firstName.trim() : this.firstName.trim(),
				lastName: this.lastName == "" ? this.data.lastName.trim() : this.lastName.trim(),
				email: this.email == "" ? this.data.email.trim() : this.email.trim(),
				senha: this.senha == "" ? this.data.senha.trim() : this.senha.trim(),
				telefone: this.telefone == "" ? this.data.telefone.trim() : this.telefone.trim(),
				logradouro: this.logradouro == "" ? this.data.logradouro.trim() : this.logradouro.trim(),
				numero: this.numero == "" ? this.data.numero.trim() : this.numero.trim(),
				bairro: this.bairro == "" ? this.data.bairro.trim() : this.bairro.trim(),
				complemento: this.complemento == "" ? this.data.complemento.trim() : this.complemento.trim(),
				cidade: this.cidade == "" ? this.data.cidade.trim() : this.cidade.trim(),
				estado: this.estado == "" ? this.data.estado.trim() : this.estado.trim(),
				cep: this.cep == "" ? this.data.cep.trim() : this.cep.trim(),
				//pets: this.pets,
			};

			auth.criarConta(this, obj);
		},
		validarSenha: function () {
			var regex = /(?=^.{8,}$)((?=.*\d)(?=.*\W+))(?![.\n]).*$/;
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
		validarTelefone: function () {
			var regex = /^\(?\d{2}\)?[\s-]?[\s9]?\d{4}-?\d{4}$/;
			if (regex.test(this.telefone)) {
				this.telefoneValido = true;
			} else {
				this.telefoneValido = false;
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
		opcaoErrada: function (input, padrao) {
			var elem = this.$refs[input];
			if (elem.value == "ERROR") elem.classList += " is-invalid";
			else elem.classList = padrao;
		},
	},
};
</script>

<style>
</style>