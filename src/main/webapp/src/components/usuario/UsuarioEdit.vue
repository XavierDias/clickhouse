<template>

    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm8 md6 lg4>
            <v-card class="pa-4">
                <v-form ref="form" v-model="valid" lazy-validation>

                    <h1 class="mb-4">Editar dados do usuário</h1>

                    <v-text-field
                            v-model="usuario.nome"
                            :rules="nameRules"
                            :counter="32"
                            label="Nome"
                            required
                    ></v-text-field>

                    <v-text-field
                            v-model="usuario.email"
                            :rules="emailRules"
                            label="E-mail"
                            required
                            disabled="true"
                    ></v-text-field>

                    <v-text-field
                            v-model="usuario.telefone"
                            :mask="'(##) ##### - ####'"
                            :rules="telefoneRules"
                            label="Telefone"
                            required
                    ></v-text-field>

                    <v-btn
                            :disabled="!valid"
                            @click="salvar"
                            color="primary"
                            class="pull-right"
                    >
                        <v-icon class="mr-1">save</v-icon> Salvar
                    </v-btn>

                    <v-btn
                            @click="cancelar"
                    >
                        <v-icon class="mr-1">clear</v-icon> Cancelar
                    </v-btn>

                </v-form>
            </v-card>
        </v-flex>
    </v-layout>

</template>

<script>
    export default {
        name: "UsuarioEdt",
        data: function () {
            return {
                valid: true,
                usuario: {
                    nome: '',
                    email: '',
                    telefone: ''
                },
                nameRules: [
                    v => !!v || 'Nome é obrigatório',
                    v => (v && v.length <= 32) || 'Nome pode ter nomáximo 32 caracteres'
                ],
                emailRules: [
                    v => !!v || 'E-mail é obrigatório',
                    v => /.+@.+/.test(v) || 'E-mail inválido'
                ],
                telefoneRules: [
                    v => !!v || 'Telefone é obrigatório',
                ]
            };
        },

        mounted: function () {{
            this.$http.get("/usuario")
                .then(resposta => resposta.json())
                .then((resposta) => {
                    console.log("Recebido!");
                    this.usuario = resposta;
                }
            );
        }},

        methods: {
            salvar () {
                if (this.$refs.form.validate()) {
                    this.$http.put('/usuario/edit/' + this.usuario.idusuario, this.usuario)
                        .then(
                            () => {
                                localStorage.setItem('username', this.usuario.nome);
                                this.$router.push('/');
                            },
                            (data) => console.log(data)
                        );
                }
            },
            cancelar () {
                this.$router.push('/');
            }
        }
    }
</script>

<style scoped>
    .pull-right {
        float: right;
    }
</style>