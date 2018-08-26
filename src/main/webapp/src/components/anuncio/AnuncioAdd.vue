<template>

    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm8 md6 lg4>
            <v-card class="pa-4">
                <v-form ref="form" v-model="valid" lazy-validation>

                    <h1 class="mb-4">Anúncio</h1>

                    <v-select
                        v-model="anuncio.tipoanuncio"
                        :items="tipoAnuncio"
                        label="Tipo de Anúncio"
                        :rules="tipoRules"
                    ></v-select>

                    <v-select
                            v-model="anuncio.tipoimovel"
                            :items="tipoImovel"
                            label="Tipo de Imóvel"
                            :rules="imovelRules"
                    ></v-select>

                    <v-text-field
                        v-model="anuncio.cidade"
                        :rules="cidadeRules"
                        label="Cidade"
                        required
                    ></v-text-field>

                    <v-select
                        v-model="anuncio.estado"
                        :items="anuncioEstado"
                        label="Estado"
                        :rules="estadoRules"
                    ></v-select>

                    <v-text-field
                            v-model="anuncio.rua"
                            :rules="ruaRules"
                            label="Rua"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="anuncio.bairro"
                            :rules="bairroRules"
                            label="Bairro"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="anuncio.areatotal"
                            :rules="areatotalRules"
                            label="Area Total"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="anuncio.areaconstruida"
                            :rules="areaconstruidaRules"
                            label="Area Construída"
                            required
                    ></v-text-field>

                    <v-textarea
                            v-model="anuncio.descricao"
                            label="Insira a descrição aqui"
                            value=""
                            :rules="descricaoRules"
                    ></v-textarea>

                    <v-text-field
                            v-model="anuncio.valor"
                            :rules="valorRules"
                            label="Valor"
                            required
                    ></v-text-field>

                    <v-btn
                        :disabled="!valid"
                        @click="submit"
                        color="primary"
                        class="pull-right"
                    >
                        <v-icon class="mr-1">save</v-icon> Salvar
                    </v-btn>

                    <v-btn @click="clear">
                        <v-icon class="mr-1">clear</v-icon> Limpar
                    </v-btn>

                </v-form>
            </v-card>
        </v-flex>
    </v-layout>

</template>

<script>
    export default {
        name: "Anuncio",
        data: function () {
            return {
                valid: true,
                anuncio: {
                    tipoanuncio: '',
                    tipoimovel: '',
                    cidade: '',
                    estado: '',
                    rua: '',
                    bairro: '',
                    areatotal: '',
                    areaconstruida: '',
                    descricao: '',
                    valor: '',
                },
                tipoRules: [
                    v => !!v || 'Tipo de anúncio é obrigatório'
                ],
                imovelRules: [
                    v => !!v || 'Tipo de imóvel é obrigatório'
                ],
                cidadeRules: [
                    v => !!v || 'Nome da cidade é obrigatório',
                    v => (v && v.length <= 32) || 'Cidade pode ter no máximo 32 caracteres'
                ],
                estadoRules: [
                    v => !!v || 'Estado é obrigatório',
                ],
                ruaRules: [
                    v => !!v || 'Nome da rua é obrigatório',
                    v => (v && v.length <= 32) || 'Rua pode ter no máximo 32 caracteres'
                ],
                bairroRules: [
                    v => !!v || 'Nome do bairro é obrigatório',
                    v => (v && v.length <= 32) || 'Bairro pode ter no máximo 32 caracteres'
                ],
                areatotalRules: [
                    v => !!v || 'Tamanho da área total é obrigatório',
                ],
                areaconstruidaRules: [
                    v => !!v || 'Tamanho da área construída é obrigatório',
                ],
                areatotalRules: [
                    v => !!v || 'Tamanho da área total é obrigatório',
                ],
                descricaoRules: [
                    v => !!v || 'Descrição é obrigatória',
                    v => (v && v.length <= 255) || 'A descrição pode ter no máximo 255 caracteres'
                ],
                valorRules: [
                    v => !!v || 'Valor é obrigatório'
                ],
                tipoAnuncio: ['Aluguel', 'Venda'],
                tipoImovel: ['Comercial', 'Residencial', 'Rural'],
                anuncioEstado: ['AC', 'AL', 'AM', 'AP', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MG', 'MS', 'MT', 'PA', 'PB',
                    'PE', 'PI', 'PR', 'RJ', 'RN', 'RO', 'RR', 'RS', 'SC', 'SE', 'SP', 'TO']
            };


        },

        methods: {
            submit () {
                if (this.$refs.form.validate()) {
                    this.$http.post('/anuncio/add', this.anuncio)
                        .then(
                            () => this.$router.push('/anuncio'),
                            (data) => console.log(data)
                        );
                }
            },
            clear () {
                this.$refs.form.reset();
            }
        }
    }
</script>

<style scoped>
    .pull-right {
        float: right;
    }
</style>