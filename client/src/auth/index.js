const URI = "http://localhost:8080/";
const LOGIN = URI + "api/users/login"
const USER = URI + "api/users"

export default {
  user: {
    logado: false
  },

  login(contexto, obj) {
    contexto.$http.post(LOGIN, obj).then((result) => {
        if(result.status === 200) {
          contexto.$session.start();
          contexto.$session.set("user", JSON.stringify(result.data));
          this.user.logado = true;
          location.reload();
        }
    }).catch((error) => {
      if(error.response.status === 401) {
        alert("Login Inválido")
      } else {
        alert("Não foi possivel logar. ERRO: " +  error.response.status)
        console.log(error.response);
      }
      contexto.error = error;
    });
  },

  criarConta(contexto, obj) {
    contexto.$http.post(USER, obj).then((result) => {
      if(result.status === 201) {
        contexto.$session.start();
        contexto.$session.set("user", JSON.stringify(result.data));
        this.user.logado = true;
      }
    }).catch((error) => {
      
      alert(error);
      contexto.error = error;
    });
  },

  sair(self) {
    self.$session.destroy();
    this.user.logado = false;
  },

  estaLogado(self) {
    if(self.$session.exists()) {
      this.user.logado = true;
    } else {
      this.user.logado = false;
    }
  },

  
}
