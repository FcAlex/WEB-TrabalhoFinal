<template>
	<div class="adote">
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4">
			<div id="addCardsPets" class="card-deck">
				<div class="card">
					<img
						class="card-img-top"
						src="../assets/dog_example_1.jpg"
						alt="Imagem de capa do card"
					/>
					<div class="card-body">
						<h5 class="card-title">Título do card</h5>
						<p class="card-text">
							Este é um card maior com suporte a texto embaixo,
							que funciona como uma introdução a um conteúdo
							adicional. Este conteúdo é um pouco maior, para
							demonstração.
						</p>
					</div>
					<div class="card-footer">
						<small class="text-muted"
							>Atualizados 3 minutos atrás</small
						>
					</div>
				</div>
				<div class="card">
					<img
						class="card-img-top"
						src="../assets/dog_example_2.jpg"
						alt="Imagem de capa do card"
					/>
					<div class="card-body">
						<h5 class="card-title">Título do card</h5>
						<p class="card-text">
							Este é um card com suporte a texto embaixo, que
							funciona como uma introdução a um conteúdo
							adicional.
						</p>
					</div>
					<div class="card-footer">
						<small class="text-muted"
							>Atualizados 3 minutos atrás</small
						>
					</div>
				</div>
				<div class="card">
					<img
						class="card-img-top"
						src="../assets/dog_example_3.jpg"
						alt="Imagem de capa do card"
					/>
					<div class="card-body">
						<h5 class="card-title">Título do card</h5>
						<p class="card-text">
							Este é um card maior com suporte a texto embaixo,
							que funciona como uma introdução a um conteúdo
							adicional. Este card tem o conteúdo ainda maior que
							o primeiro, para mostrar a altura igual, em ação.
						</p>
					</div>
					<div class="card-footer">
						<small class="text-muted"
							>Atualizados 3 minutos atrás</small
						>
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

export default {
	name: "Adote",
	components: {
		Header,
		Footer,
	},
};
</script>

<style>
</style>