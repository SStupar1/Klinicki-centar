import Vuex from 'vuex'
import Vue from 'vue'
import doctors from './modules/doctors'

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        doctors
    }
});
