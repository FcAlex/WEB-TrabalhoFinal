const URI = "http://localhost:8080/server/";
const LOGIN = URI + "api/users/login"
const USER = URI + "api/users"

export default {
  user: {
    logado: false
  },

  login(contexto, obj) {
    contexto.$http.post(LOGIN, obj).then((result) => {
        if(result.data != '') {
          localStorage.setItem("user", result.data.id);
          this.user.logado = true;
          location.reload();
        } else {
          alert("Cadastro Invalido"); // modal erro 
        }
    }).catch((error) => {
      alert(error);
      contexto.error = error;
    });
  },

  criarConta(contexto, obj) {
    contexto.$http.post(USER, obj).then((result) => {
      if(result.data != '') {
        localStorage.setItem("user", result.data);
        this.user.logado = true;
      } else {
        alert("Cadastro Invalido"); // modal erro 
      }
    }).catch((error) => {
      alert(error);
      contexto.error = error;
    });
  },

  sair() {
    localStorage.removeItem("user");
    this.user.logado = false;
  },

  estaLogado() {
    if(localStorage.getItem("user")) {
      this.user.logado = true;
    } else {
      this.user.logado = false;
    }
  },
}
