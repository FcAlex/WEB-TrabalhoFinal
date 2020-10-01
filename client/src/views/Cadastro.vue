<template>
	<div class="cadastro">
		<Header></Header>

		<section class="container p-4 principal">
			<form class="d-flex justify-content-center h-100">
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
							for="exampleInputPassword1"
							class="col-4 col-form-label text-center"
							>Primeiro Nome:</label
						>
						<div class="col-8">
							<input
								type="text"
								class="form-control"
								id="primeiroNome"
								placeholder="Insira seu primeiro nome"
								required
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="exampleInputPassword1"
							class="col-4 col-form-label text-center"
							>Segundo Nome:</label
						>
						<div class="col-8">
							<input
								type="text"
								class="form-control"
								id="segundoNome"
								placeholder="Insira seu segundo nome"
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="exampleInputPassword1"
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
							/>
						</div>
					</div>

					<div class="form-group row">
						<label
							for="exampleInputPassword1"
							class="col-4 col-form-label text-center"
							>Nova Senha:</label
						>
						<div class="col-8">
							<input
								type="password"
								class="form-control"
								id="passwordCadastro"
								aria-describedby="passHelp"
								placeholder="Insira sua senha"
								required
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
						/>
					</div>

					<div class="form-group">
						<label for="inputAddress">Complemento:</label>
						<input
							type="text"
							class="form-control"
							id="complementoCadastro"
							placeholder="Apartamento, casa, etc"
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
							/>
						</div>
						<div class="form-group col-md-3">
							<label for="inputEstado">Estado</label>
							<select
								id="estadoCadastro"
								class="form-control"
								required
							>
								<option selected>Escolher...</option>
								<option>Ceará</option>
								<option>Piauí</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputCEP">CEP</label>
							<input
								type="text"
								class="form-control"
								id="cepCadastro"
								required
							/>
						</div>
					</div>

					<div class="d-flex justify-content-end">
						<button
							@click="cadastrar"
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

export default {
	name: "Cadastro",
	components: {
		Header,
		Footer,
	},
	methods: {
		cadastrar: function () {
			this.$router.replace("/perfilUsuario");
		},
	},
};
</script>

<style>
</style>