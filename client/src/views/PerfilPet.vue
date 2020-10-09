<template>
  <div class="perfilPet">
    <Header></Header>
    
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "PerfilPet",
	components: {
		Header,
		Footer,
  },
  data() {
		return {
      pets: [],
      baseURI: "http://localhost:8080/servidor/api/pets"
    };
  },
  created: function() {
			 if(localStorage.getItem("pet")) {
        this.$router.replace("/");
    }
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