<template>

    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm8 md6 lg4>
            <v-card class="pa-4">
                <v-form ref="form" v-model="valid" lazy-validation>

                    <h1 class="mb-4">Cadastro</h1>

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
                    ></v-text-field>

                    <v-text-field
                        v-model="usuario.telefone"
                        :mask="'(##) #### - ####'"
                        :rules="telefoneRules"
                        label="Telefone"
                        required
                    ></v-text-field>

                    <v-text-field
                        v-model="usuario.senha"
                        :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                        :rules="[passwordRules.required, passwordRules.min]"
                        :type="showPassword ? 'text' : 'password'"
                        label="Senha"
                        hint="Mínimo de 8 carecteres"
                        counter
                        @click:append="showPassword = !showPassword"
                    ></v-text-field>

                    <v-text-field
                        v-model="usuario.senhaConfirmacao"
                        :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                        :rules="[passwordConfirmRules.required]"
                        :type="showPassword ? 'text' : 'password'"
                        label="Confirmar senha"
                        hint="Repita a senha"
                        @click:append="showPassword = !showPassword"
                        class="mb-4"
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
        name: "User",
        data: function () {
            return {
                valid: true,
                usuario: {
                    nome: '',
                    email: '',
                    telefone: '',
                    senha: '',
                    senhaConfirmacao: '',
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