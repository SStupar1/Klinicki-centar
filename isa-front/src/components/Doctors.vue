<template>
    <div>
        <h3>Doctors</h3>
        <div v-if="editMode === false" class="doctors">
            <table id="customers">    
                <tr v-for="doctor in allDoctors" :key="doctor.id" class="doctor">
                    <td>{{ doctor.id }}</td>
                    <td>{{ doctor.email }}</td>
                    <td>{{ doctor.firstName }}</td>
                    <td>{{ doctor.lastName }}</td>
                    <td>{{ doctor.address }}</td>
                    <td>{{ doctor.city }}</td>
                    <td>{{ doctor.country }}</td>
                    <td>{{ doctor.phone }}</td>
                    <td>{{ doctor.jmbg }}</td>

                    <td><button @click="handleIzmeniClick(doctor)">izmeni</button></td>
                </tr>
            </table>
        </div>
        <div v-else>
            <form @submit.prevent='handleEditSubmit'> 
            <label for="ftitle">Email</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.email" placeholder="title">

            <label for="ftitle">First name</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.firstName" placeholder="title">
          
            <label for="ftitle">Last name</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.lastName" placeholder="title">
          
            <label for="ftitle">Address</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.address" placeholder="title">
          
            <label for="ftitle">City</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.city" placeholder="title">
          
            <label for="ftitle">Country</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.country" placeholder="title">
          
            <label for="ftitle">Phone</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.phone" placeholder="title">

            <label for="ftitle">JMBG</label>
            <input type="text" id="ftitle" name="title" v-model="selectedDoctor.jmbg" placeholder="title">
          

            <input type="submit" value="Submit">
        </form>
        </div>
    </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex'; 

export default {
    name: "Doctors",
    data() {
      return {
        editMode: false,
        selectedDoctor: null
      }
    },

    methods: {
        ...mapActions(['fetchDoctors', 'updateDoctor']),
        handleIzmeniClick(doctor){
            this.selectedDoctor = doctor;
            this.editMode = true;
            //poziv repoa
        },
        async handleEditSubmit(){
            await this.updateDoctor(this.selectedDoctor);            
            this.editMode = false;
        }
    },
    computed: mapGetters(['allDoctors']),
    created(){
        this.fetchDoctors();
    }
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

    .custom-select select {
    display: none; /*hide original SELECT element: */
    }

    .select-selected {
    background-color: DodgerBlue;
    }

    /* Style the arrow inside the select element: */
    .select-selected:after {
    position: absolute;
    content: "";
    top: 14px;
    right: 10px;
    width: 0;
    height: 0;
    border: 6px solid transparent;
    border-color: #fff transparent transparent transparent;
    }

    /* Point the arrow upwards when the select box is open (active): */
    .select-selected.select-arrow-active:after {
    border-color: transparent transparent #fff transparent;
    top: 7px;
    }

    /* style the items (options), including the selected item: */
    .select-items div,.select-selected {
    color: #ffffff;
    padding: 8px 16px;
    border: 1px solid transparent;
    border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
    cursor: pointer;
    }

    /* Style items (options): */
    .select-items {
    position: absolute;
    background-color: DodgerBlue;
    top: 100%;
    left: 0;
    right: 0;
    z-index: 99;
    }

    /* Hide the items when the select box is closed: */
    .select-hide {
    display: none;
    }

    .select-items div:hover, .same-as-selected {
    background-color: rgba(0, 0, 0, 0.1);
    }
@media (max-width: 500px) {
      form{
        width: 90%;
        margin-left: 5%;
    }
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

</style>