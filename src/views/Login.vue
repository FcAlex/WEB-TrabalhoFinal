<template>
 <div class="login">

     <Header></Header>


    <section class="container p-4 principal">
        <div class="d-flex justify-content-center h-100">
            <form class="col-6">
                <div class="card p-4">
                   <h1 class="text-center"><i class="fa fa-user" aria-hidden="true"></i> Entrar</h1>
                   <hr>
                    <div class="form-group row">
                        
                        <label for="exampleInputPassword1" class="col-2 col-form-label text-center">Email:</label>
                        <div class="col-10">
                            <input type="email" class="form-control" id="emailLogin" placeholder="exemplo@algo.com" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="exampleInputPassword1" class="col-2 col-form-label text-center">Senha:</label>
                        <div class="col-10">
                            <input type="password" class="form-control" id="passwordLogin" placeholder="Insira sua senha" required>
                        </div>
                    </div>

                    <p> </p>

                    <div class="d-flex justify-content-end">
                        <button @click="login" type="submit" class="btn btn-primary">Entrar</button>
                    </div>

                    <p></p>
                    <p></p>

                    <div id = "divAvisoErro">
                        <p>
                            Não tem uma conta? 
                            
                            <span>
                                <router-link to="/cadastro" >Crie uma!</router-link>
                            </span>
                            <br>
                            <a href="#"> Esqueci minha Senha</a>
                        </p>       
                    </div >
                   
                   <p></p>
                    
                </div>

            </form>

            
        </div>
    </section>

<Footer></Footer>

 </div> 
 
</template>

<script>

import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'

export default {
    name: "Login",
    components: {
        Header,
        Footer
  },
  methods: {
      login: function (){
          this.$router.replace("/");
      }
  }
}
</script>

<style>

</style>