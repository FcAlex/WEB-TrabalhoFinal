<template>
	<footer
		class="container-fluid font-small bg-success text-white pt-4"
		:class="fixed"
	>
		<div class="text-left">
			<div class="row">
				<div class="col-5 mt-0">
					<h5 class="text-uppercase">Adote um amigo</h5>
					<p class="mr-5 pr-5 text-justify">
						Somos uma entidade, sem fins lucrativos, com o objetivo
						de encontrar um lar para aqueles que foram abandonados
						pelos seus donos, ou estes não possuem condição de
						mantê-los.
					</p>

					<a class="navbar-brand col-sm-1 logo" href="index.html">
						<img src="../assets/logo_adote.png" alt="Logo" />
					</a>
				</div>

				<div class="col-4 mb-3">
					<h5 class="text-uppercase">Links</h5>
					<ul class="list-unstyled">
						<li>
							<router-link to="/ajude" class="text-white"
								>Ajude-nos</router-link
							>
						</li>
						<li>
							<router-link to="/sobre" class="text-white"
								>Quem Somos</router-link
							>
						</li>
					</ul>
				</div>

				<div class="col-3 mb-0">
					<h5 class="text-uppercase font-weight-bold">Contatos</h5>
					<ul class="list-unstyled">
						<li class="p-1">
							<i class="fa fa-home" aria-hidden="true"></i>
							Rua dos Felizes, 1568, bairro Centro,
							Independência-CE.
						</li>
						<li class="p-1">
							<i class="fa fa-envelope" aria-hidden="true"></i>
							adoteumamigo@gmail.com
						</li>
						<li class="p-1">
							<i class="fa fa-phone" aria-hidden="true"></i> +55
							88 99981-6387
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="footer-copyright text-center py-3">
			© 2020 Copyright: Adote um amigo.
		</div>
	</footer>
</template>

<script>
export default {
	props: {
		fixed: ""
	},
};
</script>

<style>
</style>