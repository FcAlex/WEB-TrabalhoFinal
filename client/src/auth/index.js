const URI = "http://localhost:8080/server/";
const LOGIN = URI + "api/users/login"
const SIGN = URI + "api/users/create"

export default {
  user: {
    logado: false
  },

  login(contexto, obj) {
    contexto.$http.post(LOGIN, obj).then((result) => {
        localStorage.setItem("user", JSON.stringify(result.data));
        this.user.logado = true;
    }).catch((error) => {
      alert(error);
      contexto.error = error;
    });
  },

  criarConta(contexto, obj) {
    contexto.$http.post(SIGN, obj).then((result) => {
      localStorage.setItem("user", JSON.stringify(result.data));
      this.user.logado = true;
    }).catch((error) => {
      alert(error); // todo
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
