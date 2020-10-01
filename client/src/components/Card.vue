<template>
	<div class="card-deck p-4 col-4">
		<div class="card">
			<img
				class="card-img-top mx-auto d-block"
				:src="require(`../assets/card/${imagePath}`)"
				:alt="imageAlt"
			/>
			<div class="card-body">
				<h5 class="card-title">{{ titulo }}</h5>
				<p class="card-text">
					{{ corpo }}
				</p>
			</div>
			<div class="card-footer" v-if="comRodape">
				<small class="text-muted">
					{{ rodape }}
				</small>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: "Card",
	props: {
		imagePath: "",
		imageAlt: "",
		titulo: "",
		corpo: "",
		rodape: "",
		comRodape: false,
		tipoCard: ""
	},
};
</script>

<style>
</style>