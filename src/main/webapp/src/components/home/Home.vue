<template>
    <div class="home">
        <v-container fluid grid-list-md>
            <v-layout row wrap>

                <v-flex d-flex xs12 sm6 md3 v-for="anuncio in anuncios" :key="anuncio.idanuncio">
                    <v-card>

                        <v-card-media
                                src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                                height="200px"
                        >
                        </v-card-media>

                        <v-card-title primary-title>
                            <div>
                                <div class="headline">{{anuncio.bairro}}</div>
                                <span class="grey--text">{{anuncio.tipoanuncio}}</span>
                            </div>
                        </v-card-title>


                        <v-card-text>{{ anuncio.descricao.slice(0, 100) }}</v-card-text>

                    </v-card>
                </v-flex>

            </v-layout>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: 'home',
        data: () => ({
            loading: false,
            anuncios: []
        }),
        mounted: function() {
            this.fetchData();
        },
        methods: {
            fetchData: function () {
                this.loading = true;
                this.$http.get('/anuncio')
                    .then(
                        (data) => {
                            this.anuncios = data.body;
                            this.loading = false;
                        },
                        () => {
                            this.loading = false;
                        }
                    );
            }
        },
    }
</script>
