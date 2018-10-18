<template>
    <div class="anuncio-usuario">

        <v-btn router-link to="/anuncio/add">
            <v-icon class="mr-1">add</v-icon> Criar Anúncio
        </v-btn>

        <v-btn router-link to="/relatorios/venda">
            Relatório de Vendas
        </v-btn>

        <v-btn router-link to="/relatorios/aluguel">
            Relatório de Aluguel
        </v-btn>

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

                        <v-card-actions>
                            <v-btn flat @click="onClickEditarAnuncio(anuncio.idanuncio)">
                                <v-icon class="mr-1">edit</v-icon> Editar
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
        name: "AnuncioUsuario",
        data: () => ({
            loading: false,
            anuncios: []
        }),
        mounted: function () {
            this.fetchAnuncios();
        },
        methods: {
            fetchAnuncios: function () {
                this.loading = true;
                this.$http.get('/anuncio/usuario')
                    .then((data) => {
                        this.anuncios = data.body;
                        console.log(data);
                        this.loading = false;
                    });
            },
            onClickEditarAnuncio: function (id) {
                this.$router.push('/anuncio/edit/' + id);
            },
        }
    }
</script>