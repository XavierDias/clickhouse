<template>
    <v-data-table
        :headers="headers"
        :items="anuncios"
        hide-actions
        class="elevation-1"
        :no-data-text="'Nenhum aluguel encontrado'"
    >
        <template slot="items" slot-scope="props">
            <td>{{ props.item.descricao }}</td>
            <td class="text-xs-right">{{ props.item.valor }}</td>
        </template>
    </v-data-table>
</template>

<script>
    export default {
        name: "AnunciosAluguel",
        data: () => {
            return {
                headers: [
                    {
                        text: 'Descrição',
                        align: 'left',
                        sortable: false,
                        value: 'descricao   '
                    },
                    {
                        text: 'Valor',
                        align: 'right',
                        sortable: false,
                        value: 'valor'
                    }
                ],
                anuncios: [],
            }
        },
        mounted: function () {
            this.fetchAnuncios();
        },
        methods: {
            fetchAnuncios: function () {
                this.$http.get('/anuncio/usuario/aluguel')
                    .then((data) => {
                        this.anuncios = data.body;
                    });
            },
        }
    }
</script>