<template>
    <div id="app">
        <v-app id="inspire">

            <v-toolbar flat="true" dense="true" color="transparent">

                <v-btn router-link to="/" icon>
                    <v-icon>home</v-icon>
                </v-btn>

                <v-toolbar-title>
                    ClickHouse
                </v-toolbar-title>

                <v-spacer></v-spacer>

                <v-toolbar-items v-if="isLoged()">

                    <v-btn router-link to="/anuncio/favoritos" icon>
                        <v-tooltip bottom>
                            <v-icon slot="activator">collections_bookmark</v-icon>
                            <span>Favoritos</span>
                        </v-tooltip>
                    </v-btn>

                    <v-btn flat router-link to="/usuario/edit">{{getUsername()}}</v-btn>

                    <v-btn router-link to="/anuncio/usuario" flat>Meus Anúncios</v-btn>

                    <v-btn @click="logout" flat>Sair</v-btn>

                </v-toolbar-items>

                <v-btn v-else router-link to="/usuario" icon>
                    <v-icon>person</v-icon>
                </v-btn>

            </v-toolbar>

            <v-content>
                <v-container fluid>
                    <router-view></router-view>
                </v-container>
            </v-content>

            <v-footer dark class="grey lighten-1 justify-center" app>
                &copy;2018 &nbsp; <strong>ClickHouse</strong>
            </v-footer>

        </v-app>
    </div>
</template>

<script>
    export default {
        methods: {
            isLoged: function () {
                return window.localStorage.getItem('isLoged');
            },
            getUsername: function () {
                return window.localStorage.getItem('username');
            },
            logout: function () {
                this.$http.get('/logout')
                    .then(
                        () => {
                            window.localStorage.removeItem('isLoged');
                            window.localStorage.removeItem('username');

                            this.$router.go('/');
                        },
                        (data) => console.log(data)
                    );
            }
        }
    }
</script>
