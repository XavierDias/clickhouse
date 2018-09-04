<template>
    <v-layout align-center justify-center row fill-height>
        <v-flex xs12 sm8 md6 lg4>

            <v-card class="pa-4">
                <v-form ref="form" v-model="valid" lazy-validation>

                    <h1 class="mb-4">Login</h1>

                    <v-text-field
                        v-model="username"
                        label="E-mail"
                        required
                        class="margin-bottom"
                    ></v-text-field>

                    <v-text-field
                        v-model="password"
                        :append-icon="showPassword ? 'visibility_off' : 'visibility'"
                        :type="showPassword ? 'text' : 'password'"
                        label="Senha"
                        required
                        @click:append="showPassword = !showPassword"
                        class="mb-4"
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
                        <v-icon class="mr-1">person_add</v-icon> Cadastre-se
                    </v-btn>

                </v-form>
            </v-card>

        </v-flex>
    </v-layout>
</template>

<script>
    export default {
        name: 'Usuario',
        data: () => ({
            valid: true,
            username: '',
            password: '',
            showPassword: false
        }),
        methods: {
            submit () {
                if (this.$refs.form.validate()) {
                    this.$http.get(
                        '/user',
                        { headers: { authorization : 'Basic ' + btoa(this.username + ':' + this.password) } }
                    )
                        .then(
                            (data) => {
                                console.log(data);
                                this.$router.push('/');

                                localStorage.setItem('isLoged', true);
                                localStorage.setItem('username', this.username);
                            },
                            (data) => console.log(data)
                        );
                }
            },
        }
    }
</script>

<style scoped>
    .pull-right {
        float: right;
    }
</style>