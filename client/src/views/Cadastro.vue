<template>
	<div class="cadastro">
		<Header></Header>

		<section class="container p-4 principal">
			<form class="d-flex justify-content-center" @submit="cadastrar">
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
							/>
						</div>
					</div>

					<hr />

					<div class="form-group">
						<label for="inputAddress">Endereço: *</label>
						<input
							type="text"
							class="form-control"
							id="enderecoCadastro"
							placeholder="Rua dos Bobos, nº 0"
							required
							v-model="endereco"
						/>
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
								class="form-control border border-success"
								id="cidadeCadastro"
								required
								v-model="cidade"
							/>
						</div>
						<div class="col-md-3 mb-3">
							<label for="inputEstado">Estado: *</label>
							<select
								id="estadoCadastro"
								class="form-control"
								required
								v-model="estado"
							>
								<option selected>Escolher...</option>
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
								maxlength="9"
								minlength="9"
								v-model="cep"
								placeholder="00000-000"
							/>
						</div>
					</div>

					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-primary">
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
			endereco: "",
			complemento: "",
			cidade: "",
			estado: "",
			cep: "",
			senhaValida: true,
			emailValido: true,
		};
	},
	created: function () {
		if (localStorage.getItem("user")) {
			this.$router.replace("/");
		}
	},
	methods: {
		cadastrar: function () {
			/*if (!cadastroValido()) {
				alert("ERRO");
				return;
			}*/
			let obj = {
				firstName: this.firstName,
				lastName: this.lastName,
				email: this.email,
				senha: this.senha,
				telefone: this.telefone,
				endereco: this.endereco,
				complemento: this.complemento,
				cidade: this.cidade,
				estado: this.estado,
				cep: this.cep,
			};

			alert("OK");

			//auth.criarConta(this, obj);
			//this.$router.replace("/perfilUsuario");
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
	},
};
</script>

<style>
.form-sucess:focus {
	border-color: #28a745;
	box-shadow: 0 0 0 0.2rem rgba(40, 167, 69, 0.25);
}
</style>