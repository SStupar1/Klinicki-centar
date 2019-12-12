<template>
  <div id="app">
    <div class="container">
      <Patients/>
    </div>
  </div>
</template>

<script>
import Patients from './components/Patients.vue'

export default {
  name: 'app',
  components: {
    Patients
  }
}
</script>

<style>
  body {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
    line-height: 1.6;
    background: #eBf7f0;
  }
  .container {
    max-width: 1100px;
    margin: auto;
    overflow: auto;
    padding: 0 2rem;
  }
</style>
