<template>
  <div id="app">
    <v-app id="inspire">
      <v-toolbar flat="true" dense="true" dark color="teal">
        <v-btn router-link to="/" icon>
          <v-icon>home</v-icon>
        </v-btn>
        <v-toolbar-title>
          ClickHouse
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn router-link to="/usuario" icon>
          <v-icon>person</v-icon>
        </v-btn>
      </v-toolbar>
      <v-content>
        <v-container fluid>
          <router-view></router-view>
        </v-container>
      </v-content>
      <v-footer dark class="grey lighten-1 justify-center" app>
        &copy;2018 &nbsp; <strong>ClickHouse</strong>
      </v-footer>
    </v-app>
  </div>
</template>
