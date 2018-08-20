<template>

    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm6 lg4>
            <v-form ref="form" v-model="valid" lazy-validation>

                <v-text-field
                    v-model="nome"
                    :rules="nameRules"
                    :counter="32"
                    label="Nome"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    label="E-mail"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="senha"
                    :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                    :rules="[passwordRules.required, passwordRules.min]"
                    :type="showPassword ? 'text' : 'password'"
                    label="Senha"
                    hint="Mínimo de 8 carecteres"
                    counter
                    @click:append="showPassword = !showPassword"
                ></v-text-field>

                <v-text-field
                    v-model="senhaConfirmacao"
                    :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                    :rules="[passwordConfirmRules.required]"
                    :type="showPassword ? 'text' : 'password'"
                    label="Confirmar senha"
                    hint="Repita a senha"
                    @click:append="showPassword = !showPassword"
                ></v-text-field>

                <v-btn
                    :disabled="!valid"
                    @click="submit"
                    color="primary"
                    class="pull-right"
                >
                    <v-icon class="margin-right">save</v-icon> Salvar
                </v-btn>

                <v-btn @click="clear">
                    <v-icon class="margin-right">clear</v-icon> Limpar
                </v-btn>

            </v-form>
        </v-flex>
    </v-layout>

</template>

<script>
    export default {
        name: "User",
        data: function () {
            return {
                valid: true,
                nome: '',
                nameRules: [
                    v => !!v || 'Nome é obrigatório',
                    v => (v && v.length <= 32) || 'Nome pode ter nomáximo 32 caracteres'
                ],
                email: '',
                emailRules: [
                    v => !!v || 'E-mail é obrigatório',
                    v => /.+@.+/.test(v) || 'E-mail inválido'
                ],
                senha: '',
                passwordRules: {
                    required: value => !!value || 'Senha é obrigatória',
                    min: v => v.length >= 8 || 'Mínimo de 8 carecteres',
                },
                senhaConfirmacao: '',
                passwordConfirmRules: {
                    required: value => this.senha === value || 'Precisa ser igual a senha',
                },
                showPassword: false
            };
        },

        methods: {
            submit () {
                if (this.$refs.form.validate()) {
                    console.log('foi');
                }

                console.log(this);
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
    .margin-right {
        margin-right: 5px;
    }
</style>