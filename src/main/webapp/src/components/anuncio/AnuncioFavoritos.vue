<template>
    <div class="anuncio-favoritos">
        <v-container fluid grid-list-md>
            <v-layout row wrap>

                <v-flex d-flex xs12 sm6 md3 v-for="anuncio in anuncios" :key="anuncio.idanuncio">
                    <v-card>

                        <v-card-title primary-title>
                            <div>
                                <div class="headline">{{anuncio.bairro}}</div>
                                <span class="grey--text">{{anuncio.tipoanuncio}}</span>
                            </div>
                        </v-card-title>

                        <v-card-media
                            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                            height="200px"
                        >
                        </v-card-media>

                        <v-card-text>
                            <p>{{ anuncio.descricao.slice(0, 100) }}</p>
                        </v-card-text>

                        <v-card-actions>

                            <v-btn flat @click="onClickEditarAnuncio(anuncio.idanuncio)">
                                <v-icon class="mr-1">edit</v-icon> Editar
                            </v-btn>

                            <v-spacer></v-spacer>

                            <v-btn icon>
                                <v-icon>bookmark</v-icon>
                            </v-btn>

                        </v-card-actions>

                    </v-card>
                </v-flex>

            </v-layout>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: "AnuncioFavoritos"
    }
</script>

<style scoped>

</style>