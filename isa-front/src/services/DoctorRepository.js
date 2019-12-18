import Repository from './Repository';

const resource = '/doctors';

class DoctorRepository extends Repository{
    get() {
        return this.getApiClient().get(`${resource}`);
    }
    getDoctors(todoId) {
        return this.getApiClient().get(`${resource}/${todoId}`);
    }
    createDoctor(todo) {
        return this.getApiClient().post(`${resource}`, todo);
    }
    updateDoctors(todo) {
        return this.getApiClient().put(`${resource}/${todo.id}`,todo);
    }
    deleteDoctors(id) {
        return this.getApiClient().delete(`${resource}/${id}`);
    }
}

export default DoctorRepository;

