<template>
    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm6 lg4>
            <v-form class="margin-bottom" ref="form" v-model="valid" lazy-validation>

                <v-text-field
                    v-model="email"
                    label="E-mail"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="senha"
                    :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                    :type="showPassword ? 'text' : 'password'"
                    label="Senha"
                    required
                    @click:append="showPassword = !showPassword"
                ></v-text-field>

                <v-btn
                    :disabled="!valid"
                    @click="submit"
                    color="primary"
                    class="pull-right"
                >
                    Entrar
                </v-btn>

                <v-btn router-link to="/usuario/add">
                    <v-icon>person_add</v-icon> Cadastrar-se
                </v-btn>

            </v-form>
        </v-flex>
    </v-layout>
</template>

<script>
    export default {
        name: 'Usuario',
        data: () => ({
            valid: true,
            email: '',
            senha: '',
            showPassword: false
        }),
        methods: {
            submit () {
                if (this.$refs.form.validate()) {
                    console.log(this);
                }
            }
        }
    }
</script>

<style scoped>
    .margin-bottom {
        margin-bottom: 15px;
    }

    .pull-right {
        float: right;
    }
</style>