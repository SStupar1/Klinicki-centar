<template>
    <form @submit.prevent='handleAddSubmit'> 
            <label for="ftitle">Email</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.email" placeholder="enter email">

            <label for="ftitle">Password</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.password" placeholder="enter password">
          
            <label for="ftitle">First name</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.firstName" placeholder="enter first name">
          
            <label for="ftitle">Last name</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.lastName" placeholder="enter last name">
          
            <label for="ftitle">Address</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.address" placeholder="enter address">
          
            <label for="ftitle">City</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.city" placeholder="enter city">

            <label for="ftitle">Country</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.country" placeholder="enter country">
          
            <label for="ftitle">Phone</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.phone" placeholder="enter phone number">
          
            <label for="ftitle">JMBG</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.jmbg" placeholder="enter jmbg">
          

            <input type="submit" value="Submit">
        </form>
</template>

<script>
import { mapActions} from 'vuex'; 

export default {
     name: "AddDoctor",
    data() {
      return {
        selectedDoctor:{
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            address: '',
            city: '',
            country: '',
            phone: '',
            jmbg: ''
        }
      }
    },

    methods: {
        ...mapActions(['addDoctor', 'updateDoctor']),
        async handleAddSubmit(){

            await this.addDoctor(this.selectedDoctor);
        }

    },

}
</script>

<style>
    input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    }


    input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    }
    form{
        width: 70%;
        margin-left: 15%;
    }

    input[type=submit]:hover {
    background-color: #45a049;
    }

    #addtodo.div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
    .custom-select {
    position: relative;
    font-family: Arial;
    }

</style>