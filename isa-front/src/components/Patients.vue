<template>
    <div>
        <h3>Patients</h3>
        <div class="patients">
            <div v-for="patient in allPatients" :key="patient.id" class="patient">
                {{ patient.id }}

                
                <table>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                
                <tr>
                    <td>
                        Email:
                    </td>

                    <td>
                        <input type="text" v-model="patient.email">
                    </td> 
                </tr>
                <tr>
                    <!-- <td>
                            Password:
                        </td> -->
    
                        <!-- <td>
                            <input type="password" v-model="patient.password">
                        </td>  -->
                </tr>

                <tr>
                        <td>
                            First name:
                        </td>
    
                        <td>
                            <input type="text" v-model="patient.firstName">
                        </td> 
                    </tr>

                    <tr>
                    <td>
                        Last name:
                    </td>

                    <td>
                        <input type="text" v-model="patient.lastName">
                    </td> 
                </tr>

                <tr>
                        <td>
                            Address:
                        </td>
    
                        <td>
                            <input type="text" v-model="patient.address">
                        </td> 
                </tr>

                <tr>
                        <td>
                            City:
                        </td>
    
                        <td>
                            <input type="text" v-model="patient.city">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Country:
                        </td>
    
                        <td>
                            <input type="text" v-model="patient.country">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Phone:
                        </td>
    
                        <td>
                            <input type="number" v-model="patient.phone">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Identification number:
                        </td>
    
                        <td>
                            <input type="number" v-model="patient.jmbg">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Unique insurance number:
                        </td>
    
                        <td>
                            <input type="text" v-model="patient.uni">
                        </td> 
                </tr>

                <tr>

                        <td> </td>
                        <td> <input class="btn" type="submit" value="Change patient" v-on:click="changePatient(patient)"/> </td> 
                </tr>

            </table>


            </div>
        </div>


        <div class="main container">
        <form>
            <!-- <table>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                
                <tr>
                    <td>
                        Email:
                    </td>

                    <td>
                        <input type="text">
                    </td> 
                </tr>
                <tr>
                    <td>
                            Password:
                        </td>
    
                        <td>
                            <input type="password">
                    </td> 
                </tr>

                <tr>
                        <td>
                            First name:
                        </td>
    
                        <td>
                            <input type="text">
                        </td> 
                    </tr>

                    <tr>
                    <td>
                        Last name:
                    </td>

                    <td>
                        <input type="text">
                    </td> 
                </tr>

                <tr>
                        <td>
                            Address:
                        </td>
    
                        <td>
                            <input type="text">
                        </td> 
                </tr>

                <tr>
                        <td>
                            City:
                        </td>
    
                        <td>
                            <input type="text">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Country:
                        </td>
    
                        <td>
                            <input type="text">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Phone:
                        </td>
    
                        <td>
                            <input type="number">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Identification number:
                        </td>
    
                        <td>
                            <input type="number">
                        </td> 
                </tr>

                <tr>
                        <td>
                            Unique insurance number:
                        </td>
    
                        <td>
                            <input type="text" class="btn">
                            
                        </td> 
                </tr>

            </table> -->

        </form>
    </div>



    </div>

</template>

<script>
import { mapGetters, mapActions } from 'vuex';
export default {
    name: "Patients",
    methods: {
        ...mapActions(['fetchPatients']),
        ...mapActions(['changePatient'])
    },
    computed: mapGetters(['allPatients']),
    created() {
        this.fetchPatients();
    }
};
</script>

<style scoped>
    .patients {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        grid-gap: 1rem;
    }

    .patient {
        border: 1px solid #ccc;
        background: #41b883;
        padding: 1rem;
        border-radius: 5px;
        text-align: center;
        position: relative;
        cursor: pointer;
    }

    .btn {
    background-color: #108bea;
    border-radius: 2px;
    color: white;
    user-select: none;
    border: none;
    cursor: pointer;
    opacity: 1;
    height: 35px;
    width: 120px;
}

.btn:hover {
    background-color: #0f6cb2;
}

.btn:active {
    opacity: 0.8;
}
</style>