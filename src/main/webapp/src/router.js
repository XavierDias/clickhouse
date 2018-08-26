import Vue from 'vue'
import Router from 'vue-router'
import Usuario from './components/usuario/Usuario.vue'
import UsuarioAdd from './components/usuario/UsuarioAdd.vue'
import AnuncioAdd from './components/anuncio/AnuncioAdd.vue'
import Home from './components/home/Home.vue'

Vue.use(Router)

export default new Router({
  base: process.env.BASE_URL,
  routes:[
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/usuario',
      name: 'usuario',
      component: Usuario
    },
    {
      path: '/usuario/add',
      name: 'usuario-add',
      component: UsuarioAdd
    },
    {
      path: '/usuario/anuncio',
      name: 'anuncio-add',
      component: AnuncioAdd
    }
  ]
})
