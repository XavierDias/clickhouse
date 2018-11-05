<template>
    <div id="anucnio-venda">

        <v-flex xs12 sm6>

            <v-select
                :items="templates"
                v-model="ordem"
                :menu-props="{ maxHeight: '400' }"
                label="Template"
                multiple
                chips
                hint="Escolha elementos do relatório"
                persistent-hint
            ></v-select>

            <v-btn @click="exportCsv()">
                Exportar para csv
            </v-btn>

        </v-flex>

        <v-data-table
            :headers="headers"
            :items="anuncios"
            hide-actions
            class="elevation-1"
            :no-data-text="'Nenhuma venda encontrada'"
        >
            <template slot="items" slot-scope="props">
                <td>{{ props.item.descricao }}</td>
                <td class="text-xs-right">{{ props.item.valor }}</td>
            </template>
        </v-data-table>

    </div>
</template>

<script>
    export default {
        name: "AnuncioVenda",
        data: () => {
            return {
                templates: [
                  'header',
                  'body',
                  'footer'
                ],
                ordem: [
                    'header',
                    'body',
                    'footer'
                ],
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
                this.$http.get('/anuncio/usuario/venda')
                    .then((data) => {
                        this.anuncios = data.body;
                    });
            },
            exportCsv: function () {
                this.$http.get('/anuncio/usuario/venda/csv/[{ordem*}]', {params: {ordem: this.ordem}})
                    .then((data) => {
                        let blob = new Blob([data.bodyText], {type: "text/plain;charset=utf-8"});
                        window.saveAs(blob, "vendas.csv");
                    });
            },
        }
    }
</script>