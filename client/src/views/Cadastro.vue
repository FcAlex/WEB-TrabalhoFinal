<template>
	<div class="cadastro">
		<Header></Header>

		<section class="container p-4 principal">
			<form class="d-flex justify-content-center h-100" @submit="cadastrar">
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
							>Email:</label
						>
						<div class="col-8">
							<input
								type="email"
								class="form-control"
								id="emailCadastro"
								placeholder="Insira seu email"
								required
								v-model="email"
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="passwordCadastro"
							class="col-4 col-form-label text-center"
							>Sua Senha:</label
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
							/>
							<small
								id="passHelp"
								class="form-text text-muted text-center"
								>Sua senha deve ter mais de 8 caracteres
								incluindo letras e números</small
							>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="exampleInputPassword1"
							class="col-4 col-form-label text-center"
							>Telefone:</label
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
						<label for="inputAddress">Endereço:</label>
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
						<div class="form-group col-md-6">
							<label for="inputCity">Cidade</label>
							<input
								type="text"
								class="form-control"
								id="cidadeCadastro"
								required
								v-model="cidade"
							/>
						</div>
						<div class="form-group col-md-3">
							<label for="inputEstado">Estado</label>
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
						<div class="form-group col-md-3">
							<label for="inputCEP">CEP</label>
							<input
								type="text"
								class="form-control"
								id="cepCadastro"
								required
								v-model="cep"
							/>
						</div>
					</div>

					<div class="d-flex justify-content-end">
						<button
							type="submit"
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
import auth from "../auth"

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
			cep: ""
		}
	},
	created: function() {
    if(localStorage.getItem("user")) {
        this.$router.replace("/");
    }
  },
	methods: {
		cadastrar: function () {
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
				cep: this.cep
			}

			auth.criarConta(this, obj);
			//this.$router.replace("/perfilUsuario");
		},
	},
};
</script>

<style>
</style>