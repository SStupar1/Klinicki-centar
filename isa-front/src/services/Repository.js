import axios from 'axios';

const baseDomain = 'http://localhost:8080';
const baseURL = `${baseDomain}/api`;

class Repository {
    constructor(){
        this.client = axios.create({
            baseURL
        })
        this.setInterceptor();
    }
    setInterceptor = () => {
        this.client.interceptors.request.use(config => {
        //console.log('interceptor');
        
        const token = window.localStorage.getItem("token");
    
        if (!token) {
            Object.assign(config.headers, {
                Authorization: `Bearer ${token}`
            });
        }

        return config;
        });
      };
    
    attachHeaders(headers) {
        Object.assign(this.client.defaults.headers, headers);
    }

    detachHeader(headerKey) {
        delete this.client.defaults.headers[headerKey];
    }

    getApiClient() {
        return this.client;
    }
}

export default Repository;