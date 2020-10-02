<template>
	<header class="cabecalho container-fluid">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark row">
			<a class="navbar-brand col-sm-1 logo" href="/">
				<img src="../assets/logo_adote.png" alt="Logo" />
			</a>

			<button
				class="navbar-toggler nav justify-content-center"
				type="button"
				data-toggle="collapse"
				data-target="#collapsibleNavbar"
			>
				<span class="navbar-toggler-icon"></span>
			</button>

			<ul
				class="navbar-nav col-sm-6 justify-content-end collapse navbar-collapse"
				id="collapsibleNavbar"
			>
				<li class="nav-item">
					<!--<a class="nav-link" href="index.html">Home</a>-->
					<router-link to="/" class="nav-link">Home</router-link>
				</li>
				<li class="nav-item">
					<!--<a class="nav-link" href="adote.html">Adote</a>-->
					<router-link to="/adote" class="nav-link"
						>Adote</router-link
					>
				</li>
				<li class="nav-item">
					<!--<a class="nav-link" href="ajude.html">Ajude</a>-->
					<router-link to="/ajude" class="nav-link"
						>Ajude</router-link
					>
				</li>
				<li class="nav-item">
					<!--<a class="nav-link" href="sobre.html">Sobre nós</a>-->
					<router-link to="/sobre" class="nav-link"
						>Sobre nós</router-link
					>
				</li>
				<li class="nav-item">
					<!--<a class="nav-link" href="pessoas.html">Pessoas</a>-->
					<router-link to="/pessoas" class="nav-link"
						>Usuários</router-link
					>
				</li>
			</ul>

			<form
				class="form-inline col-sm-4 row collapse navbar-collapse"
				action=""
			>
				<input
					class="form-control mr-sm-1 col-sm-8"
					type="text"
					placeholder="Busque seu novo amigo"
				/>
				<button class="btn btn-success" type="submit">Procurar</button>
			</form>

			<div
				class="col-sm-1 justify-content-end collapse navbar-collapse"
				id="buttonLogin"
			>
				<a
					href="/"
					@click="sair()"
					class="nav-link text-white"
					v-if="logado"
					><i class="fa fa-sign-out"></i
				></a>
				<a href="/login" class="nav-link text-white" v-else
					><i class="fa fa-user-circle-o" aria-hidden="true"></i
				></a>
			</div>
		</nav>
	</header>
</template>

<script>
import auth from "../auth";

export default {
	name: "Header",
	data() {
		return {
			logado: auth.user.logado,
		};
	},
	methods: {
		sair() {
      auth.sair();
      location.reload();
    }
  }, 
  created: function() {
    auth.estaLogado();
  }
};
</script>

<style>
.logo img {
	width: 50px;
}
#buttonLogin a {
	font-size: 25pt;
	color: white;
	cursor: pointer;
}
</style>