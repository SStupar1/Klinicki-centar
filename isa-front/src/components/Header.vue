<template>
    <div class = 'header'>
            <ul id="menu">
                <li><router-link :to="{name: 'doctors_route'}" class="white">Doctors</router-link></li>
                <li><router-link :to="{name: 'add_doctor_route'}" class="white">Add doctor</router-link></li>
            </ul>  

    </div>
</template>

<script>
import routeNames from '../route_names';


export default {
    name: 'Header',
    data() {
        return {
            routeNames
        }
    }
}
</script>

<style>
    ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #41b883;
    }
    .white{
        color: white;
        font-weight: bold;
    }

    li {
    float: left;
    }

    .header{
        margin-top: 1%;
    }

    li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    }

    li a:hover:not(.active) {
    background-color: #ddd;
    }

    li a.active {
    color: white;
    background-color: #4CAF50;
    }
</style>