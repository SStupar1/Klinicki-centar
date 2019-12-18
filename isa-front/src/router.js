import Vue from 'vue';
import Doctors from './components/Doctors';
import AddDoctor from './components/AddDoctor';
import routes from './route_names'; 
import Router from 'vue-router';

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [
      {
        path: routes.DOCTOR_ROUTE.path,
        name: routes.DOCTOR_ROUTE.name,
        component: Doctors,
        meta: {
          requiresAuth: true
        }
      },
      {
        path: routes.ADD_DOCTOR_ROUTE.path,
        name: routes.ADD_DOCTOR_ROUTE.name,
        component: AddDoctor,
        meta: {
          requiresAuth: true
        }
      }
    ]
  })
  router.beforeEach((to, from, next) => {        
      next();
    
  })


  export default router;