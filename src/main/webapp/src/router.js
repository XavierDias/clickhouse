import Vue from 'vue'
import Router from 'vue-router'
import Usuario from './components/usuario/Usuario.vue'
import UsuarioAdd from './components/usuario/UsuarioAdd.vue'
import UsuarioEdt from './components/usuario/UsuarioEdit.vue'
import AnuncioAdd from './components/anuncio/AnuncioAdd.vue'
import AnuncioEdit from './components/anuncio/AnuncioEdit.vue'
import AnuncioUsuario from './components/anuncio/AnuncioUsuario.vue'
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
            path: '/usuario/edit',
            name: 'usuario-edt',
            component: UsuarioEdt
        },
        {
            path: '/anuncio/add',
            name: 'anuncio-add',
            component: AnuncioAdd
        },
        {
            path: '/anuncio/edit/:id',
            name: 'anuncio-edit',
            component: AnuncioEdit,
            props: true
        },
        {
            path: '/anuncio/usuario',
            name: 'anuncio-usuario',
            component: AnuncioUsuario
        },
    ]
})
