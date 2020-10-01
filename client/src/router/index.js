import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/adote',
    name: 'Adote',
    component: function () {
      return import('../views/Adote.vue')
    }
  },
  {
    path: '/ajude',
    name: 'Ajude',
    component: function () {
      return import('../views/Ajude.vue')
    }
  },
  {
    path: '/sobre',
    name: 'Sobre',
    component: function () {
      return import('../views/Sobre.vue')
    }
  },
  {
    path: '/pessoas',
    name: 'Pessoas',
    component: function () {
      return import('../views/Pessoas.vue')
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: function () {
      return import('../views/Login.vue')
    }
  },
  {
    path: '/cadastro',
    name: 'Cadastro',
    component: function () {
      return import('../views/Cadastro.vue')
    }
  },
  {
    path: '/perfilUsuario',
    name: 'PerfilUsuario',
    component: function () {
      return import('../views/PerfilUsuario.vue')
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router