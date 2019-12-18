import { RepositoryFactory } from '../../services/RepositoryFactory';

const doctorsRepo = RepositoryFactory.get('doctors');

const state = {
    doctors: []
};

const getters = {
    allDoctors: state => state.doctors
};

const actions = {

    async fetchDoctors({ commit }) {        
        const response = await doctorsRepo.get();
        commit('setDoctors', response.data);
    },
    /*
    async deleteDoctors({ commit },id) {
        const response = await doctorsRepo.deleteTodo(id);
        commit('deleteTodo', id);
    },
    */
    async addDoctor({commit},d) {
        
         await doctorsRepo.createDoctor(d);
         commit('doctorAdded',d);
    },
    
    async updateDoctor({ commit },doctor) {
        const response = await doctorsRepo.updateDoctors(doctor);
        commit('doctorUpdate', response.data[0]);
    },
    
    
};

const mutations = {
    //setDoctors: (state, doctors) => state.doctors = doctors

    setDoctors: (state, doctors) => {
        state.doctors = doctors
    }/*,
    deleteTodo: (state, id) => {
        const index = state.doctors.findIndex(doctor => doctor.id === id);        
        state.doctors.splice(index,1);
    },
    doctorUpdate: (state,newDoctor) =>{
        const index = state.doctors.findIndex(doctor => doctor.id === newDoctor.id);        
        state.todos.splice(index, 1, newDoctor);
        state.selectedDoctor = {
            id:-1,
            title:'',
            description: '',
            priority:''
        };
    }*/
};

export default{
    state,
    getters,
    actions,
    mutations
}