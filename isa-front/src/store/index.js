import Vuex from 'vuex';
import Vue from 'vue';
import patients from './modules/patients';

//Load Vuex
Vue.use(Vuex);

//Create store
export default new Vuex.Store({
    modules: {
        patients
    }
});