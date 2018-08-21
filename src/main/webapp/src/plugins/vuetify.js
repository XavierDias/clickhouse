import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'

// Helpers
import colors from 'vuetify/es5/util/colors'

Vue.use(Vuetify, {
    theme: {
        primary: colors.teal.darken1, // #E53935
        secondary: colors.teal.lighten4, // #FFCDD2
        accent: colors.teal.accent3 // #3F51B5
    }
})
