<template>
  <div id="app">
    <v-app id="inspire">
      <v-toolbar dark color="primary">
        <router-link to="/">
          <v-btn icon>
            <v-icon>home</v-icon>
          </v-btn>
        </router-link>
        <v-toolbar-title class="white--text">ClickHouse</v-toolbar-title>
        <v-spacer></v-spacer>
        <router-link to="/usuario">
          <v-btn icon>
            <v-icon>person</v-icon>
          </v-btn>
        </router-link>
      </v-toolbar>
      <v-content>
        <v-container fluid>
          <router-view></router-view>
        </v-container>
      </v-content>
      <v-footer app></v-footer>
    </v-app>
  </div>
</template>
