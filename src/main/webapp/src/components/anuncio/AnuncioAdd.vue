<template>

    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm8 md6 lg4>
            <v-card class="pa-4">
                <v-form ref="form" v-model="valid" lazy-validation>

                    <h1 class="mb-4">Anúncio</h1>

                    <v-select
                        :items="tipoAnuncio"
                        label="Tipo de Anúncio"
                    ></v-select>

                    <v-text-field
                        v-model="anuncio.cidade"
                        :rules="cidadeRules"
                        label="Cidade"
                        required
                    ></v-text-field>

                    <v-select
                        :items="anuncioEstado"
                        label="Estado"
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
                            v-model="anuncio.areaTotal"
                            :rules="areatotalRules"
                            label="Area Total"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="anuncio.areaConstruida"
                            :rules="areaconstruidaRules"
                            label="Area Construída"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="anuncio.descricao"
                            :rules="descricaoRules"
                            label="Descrição"
                            required
                    ></v-text-field>

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
    data: () => ({
        tipoAnuncio: [
                    {label: 'Residencial', options: ['Apartamento', 'Casa', 'Terreno']},
                    {label: 'Comercial', options: ['Loja', 'Depósito', 'Hotel']},
                    {label: 'Rural', options: ['Chácara', 'Fazenda', 'Sítio']}
               ]
    })
  }
</script>

<script>
    export default {
        name: "Anuncio",
        data: function () {
            return {
                valid: true,
                anuncio: {
                    tipoAnuncio: '',
                    cidade: '',
                    estado: '',
                    rua: '',
                    bairro: '',
                    areaTotal: '',
                    areaConstruida: '',
                    descricao: '',
                    valor: '',
                },
                cidadeRules: [
                    v => !!v || 'Nome da cidade é obrigatório',
                    v => (v && v.length <= 32) || 'Cidade pode ter no máximo 32 caracteres'
                ],
                telefoneRules: [
                    v => !!v || 'Telefone é obrigatório',
                ],
                passwordRules: {
                    required: value => !!value || 'Senha é obrigatória',
                    min: v => v.length >= 8 || 'Mínimo de 8 carecteres',
                },
                passwordConfirmRules: {
                    required: value => this.usuario.senha === value || 'Precisa ser igual a senha',
                },
                showPassword: false
            };
        },

        methods: {
            submit () {
                if (this.$refs.form.validate()) {
                    this.$http.post('/usuario', this.usuario)
                        .then(
                            () => this.$router.push('/usuario'),
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