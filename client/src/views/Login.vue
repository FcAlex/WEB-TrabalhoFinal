<template>
	<div class="login">
		<Header></Header>
		<section class="container p-4 principal">
			<div class="d-flex justify-content-center h-100">
				<form class="col-6" @submit="fazerLogin">
					<div class="card p-4">
						<h1 class="text-center">
							<i class="fa fa-user" aria-hidden="true"></i> Entrar
						</h1>
						<hr />
						<div class="form-group row">
							<label
								for="emailLogin"
								class="col-2 col-form-label text-center"
								>Email:
							</label>
							<div class="col-10">
								<input
									type="email"
									class="form-control"
									id="emailLogin"
									placeholder="exemplo@algo.com"
                  v-model="email"
									required
								/>
							</div>
						</div>

						<div class="form-group row my-2">
							<label
								for="senhaLogin"
								class="col-2 col-form-label text-center"
								>Senha:</label
							>
							<div class="col-10">
								<input
									type="password"
									class="form-control"
									id="senhaLogin"
									placeholder="Insira sua senha"
                  v-model="senha"
									required
								/>
							</div>
						</div>

						<div class="d-flex justify-content-end my-2">
							<button type="submit" class="btn btn-primary">
								Entrar
							</button>
						</div>

						<div id="divAvisoErro" class="my-2 text-center">
							<p>
								Não tem uma conta?
								<span>
									<router-link to="/cadastro"
										>Crie uma!</router-link
									>
								</span>
								<br />
								<a href="#"> Esqueci minha Senha</a>
							</p>
						</div>
					</div>
				</form>
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
	name: "Login",
	components: {
		Header,
		Footer,
	},
	data() {
		return {
			email: "",
      senha: "",
      data: Object,
			baseURI: "http://localhost:8080/server/api/users",
		};
	},
	created: function() {
    if(localStorage.getItem("user")) {
        this.$router.replace("/");
    }
  },
	methods: {
		fazerLogin: function () {
			let obj = {
				email: this.email,
				senha: this.senha,
			};
			auth.login(this, obj);
		},
	}
};
</script>

<style>
</style>