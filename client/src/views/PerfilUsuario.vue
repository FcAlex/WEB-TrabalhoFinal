<template>
	<div class="perfilUsuario">
		<Header></Header>
		<div class="card">
      div.c
    </div>
		<Footer></Footer>
	</div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import auth from "../auth"

export default {
	name: "PerfilUsuario",
	components: {
		Header,
    Footer,
	},
	data() {
		return {
      data: [],
      baseURI: "http://localhost:8080/server/api/users"
    };
	},
	created: function () {
    var user = JSON.parse(localStorage.getItem("user"));
		if (user != null) {
			this.$http.get(this.baseURI + "/" + user).then((result) => {
				this.data = result.data;
      });
		}
	},
};
</script>

<style>
</style>