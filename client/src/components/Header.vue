<template>
	<header class="cabecalho container-fluid">
		<nav class="navbar navbar-expand bg-dark navbar-dark row">
			<router-link class="navbar-brand col-1 logo" to="/">
				<img src="../assets/logo_adote.png" alt="Logo" />
			</router-link>

			<button
				class="navbar-toggler nav justify-content-center"
				type="button"
				data-toggle="collapse"
				data-target="#collapsibleNavbar"
			>
				<span class="navbar-toggler-icon"></span>
			</button>

			<ul
				class="navbar-nav col-7 justify-content-end collapse navbar-collapse"
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

			<div class="form-inline col-3 collapse navbar-collapse d-flex justify-content-start">
				<div class="input-group">
					<input
						class="form-control"
						type="text"
						placeholder="Busque seu novo amigo"
						v-model="pesquisa"
					/>
					<div class="input-group-append">
						<router-link
							class="input-group-text text-white bg-success buscar"
							:to="{
								name: 'buscarPet',
								params: { nomePet: pesquisa },
							}"
							><i class="fa fa-search" aria-hidden="true"></i>
						</router-link>
					</div>
				</div>
			</div>

			<div
				class="col-sm-1 justify-content-end collapse navbar-collapse"
				id="buttonLogin"
			>
				<ul
					v-if="logado"
					class="navbar-nav col-sm-6 justify-content-end collapse navbar-collapse"
				>
					<li class="nav-item">
						<a
							href="/login"
							@click="sair()"
							class="nav-link text-white"
							><i class="fa fa-sign-out"></i
						></a>
					</li>
					<li class="nav-item">
						<router-link
							to="/perfilUsuario"
							class="nav-link text-white"
							><i class="fa fa-user" aria-hidden="true"></i
						></router-link>
					</li>
				</ul>
				<router-link to="/login" class="nav-link text-white" v-else
					><i class="fa fa-user-circle-o" aria-hidden="true"></i
				></router-link>
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
			pesquisa: "",
		};
	},
	methods: {
		sair() {
			auth.sair(this);
			location.reload();
		},
	},
	beforeCreate() {
		auth.estaLogado(this);
	},
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
.buscar:hover {
	text-decoration: none;
}
</style>