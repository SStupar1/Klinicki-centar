import axios from 'axios';

const state = {
    patients: [
        // {
        //     id: 1,
        //     title: 'Stupar'
        // },
        // {
        //     id: 2,
        //     title: 'Punisa'
        // }
    ]
};

const getters = {
    allPatients: (state) => state.patients
};

const actions = {
    async fetchPatients({ commit }) {
        const response = await axios.get('http://localhost:8080/patients');

        commit('setPatients', response.data);
    },

    async changePatients({ commit }) {
        const response = await axios.put('http://localhost:8080/patients/id');

        commit('setPatients', response.data);
    }
};

const mutations = {
    setPatients: (state, patients) => (state.patients = patients)
};

export default {
    state,
    getters,
    actions,
    mutations
};