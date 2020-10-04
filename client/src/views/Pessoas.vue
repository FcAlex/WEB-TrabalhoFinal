<template>
  <div class="pessoas">
    <Header></Header>
    <section id = "principal" class="container text-center p-4">
    
    <h1><i class="fa fa-paw"></i> Encontre pessoas </h1>
    <div id = "addCards" class="card-deck">
      <div class="card">
        <img class="card-img-top" src="../assets/pessoas/pessoa.png" alt="Imagem de capa do card">
        <div class="card-body">
          <h5 class="card-title">Título do card</h5>
          <p class="card-text">Este é um card maior com suporte a texto embaixo, que funciona como uma introdução a um conteúdo adicional. Este conteúdo é um pouco maior, para demonstração.</p>
        </div>
        <div class="card-footer">
          <small class="text-muted">Atualizados 3 minutos atrás</small>
        </div>
      </div>
      <div class="card">
        <img class="card-img-top" src="../assets/pessoas/pessoa.png" alt="Imagem de capa do card">
        <div class="card-body">
          <h5 class="card-title">Título do card</h5>
          <p class="card-text">Este é um card com suporte a texto embaixo, que funciona como uma introdução a um conteúdo adicional.</p>
        </div>
        <div class="card-footer">
          <small class="text-muted">Atualizados 3 minutos atrás</small>
        </div>
      </div>
      <div class="card">
        <img class="card-img-top" src="../assets/pessoas/pessoa.png" alt="Imagem de capa do card">
        <div class="card-body">
          <h5 class="card-title">Título do card</h5>
          <p class="card-text">Este é um card maior com suporte a texto embaixo, que funciona como uma introdução a um conteúdo adicional. Este card tem o conteúdo ainda maior que o primeiro, para mostrar a altura igual, em ação.</p>
        </div>
        <div class="card-footer">
          <small class="text-muted">Atualizados 3 minutos atrás</small>
        </div>
      </div>
      <div class="card m">
        <img class="card-img-top" src="../assets/pessoas/pessoa.png" alt="Imagem de capa do card">
        <div class="card-body">
          <h5 class="card-title">Título do card</h5>
          <p class="card-text">Este é um card maior com suporte a texto embaixo, que funciona como uma introdução a um conteúdo adicional. Este card tem o conteúdo ainda maior que o primeiro, para mostrar a altura igual, em ação.</p>
        </div>
        <div class="card-footer">
          <small class="text-muted">Atualizados 3 minutos atrás</small>
        </div>
      </div>
    </div>
  <ul>
      <li v-for="user in users" :key="user.id">
        <div id="geral">
          <div class="left">
            <h4>{{ user.id }}</h4>
            <p>{{ user.email }}</p>
            <p>{{ user.senha }}</p>
          </div>
        </div>
        <hr />
      </li>
    </ul>
    <button @click="getAll" class="btn btn-primary">
								Listar 
							</button>
  </section>

    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "Pessoas",
  components: {
    Header,
    Footer
  },
  data() {
		return {
      users: [],
      baseURI: "http://localhost:8080/servidor/api/users"
    };
  },
  created: function() {
			 if(localStorage.getItem("user")) {
        this.$router.replace("/");
    }
  },
  methods: {
    getAll: function() {
			  this.$http.get(this.baseURI).then((result) => {
				this.users = result.data;
		  });
	  }
  }
};
</script>

<style>
</style>