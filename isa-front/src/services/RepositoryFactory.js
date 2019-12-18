import DoctorRepository from './DoctorRepository';

const doctorRepo = new DoctorRepository();

const repositories = {
    doctors: doctorRepo
};

export const RepositoryFactory = {
    get: name => repositories[name]
};