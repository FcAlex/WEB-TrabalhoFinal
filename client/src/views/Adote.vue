<template>
	<div class="adote">
		<Header></Header>
		<section class="container text-center p-4">
			<h1><i class="fa fa-paw"></i> Encontre seu novo amigo</h1>
			<hr class="mt-3 mb-4">
			<div id="addCardsPets" class="card-deck">
				<div class="col-4" v-for="pet in pets" :key="pet.id">
					<div class="card">
						<img
							class="card-img-top rounded mx-auto d-block mt-2"
							src="../assets/dog_example_1.jpg"
							alt="Imagem de capa do card"
              				style="max-width: 250px"  
						/>

						<div class="card-body">
						<h5 class="card-title"> {{ pet.nome }} </h5>
						<ul class="list-group list-group-flush">
								<li class="list-group-item">
									<strong>Raça:</strong>
									{{ pet.raca }}
								</li>
								<li class="list-group-item">
									<strong>Sexo:</strong> {{pet.sexo }}
								</li>
								<li class="list-group-item">
									<strong>Porte:</strong>
									{{ pet.porte}}
								</li>
							</ul>
					</div>
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
  data() {
		return {
      pets: [],
      baseURI: "http://localhost:8080/server/api/pets"
    };
  },
  created: function() {
		this.$http.get(this.baseURI).then((result) => {
			this.pets = result.data;
		});
  },
  methods: {
    getAll: function() {
			  this.$http.get(this.baseURI).then((result) => {
				this.pets = result.data;
		  });
	  }
  }
};
</script>

<style>
</style>




