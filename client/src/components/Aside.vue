<template>
	<aside class="container text-center p-4">
		<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
		<div class="aside row d-flex justify-content-between">
			<Card
				imagePath="adocao.png"
				imageAlt="Um novo lar para um grande parceiro!"
				titulo="Um novo lar para um grande parceiro!"
				corpo="Que tal ajudar um animal carente e ainda ganhar um amor incondicional?"
				rodape="Atualizados 3 minutos atrás"
			>
			</Card>

			<Card
				imagePath="novo_amigo.png"
				imageAlt="Imagem de capa do card"
				titulo="Um amigo de verdade!"
				corpo="Com a adoção, você tira mais um animal da rua, e ajuda traz felicidade e alegria para sua vida. Não seria uma bom negócio?"
				rodape="Atualizados 3 minutos atrás"
			>
			</Card>

			<Card
				imagePath="animais.png"
				imageAlt="E então? Vamos lá"
				titulo="E então? Vamos lá?"
				corpo="Para realizar esse ato de amor, basta realizar uma rápida pesquisa. Garanto que não vai tomar muito seu tempo!"
				rodape="Atualizados 3 minutos atrás"
			>
			</Card>
		</div>
	</aside>
</template>

<script>
import Card from "./Card.vue";

export default {
	name: "Aside",
	components: {
		Card,
	},
};
</script>

<style>
.aside img {
	width: 10em;
}
</style>