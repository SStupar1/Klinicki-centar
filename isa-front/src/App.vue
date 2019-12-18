<template>
  <div id="app">
    <div class="container">
          <Header/>
          <router-view/>

    </div>
  </div>
</template>

<script>

import Header from './components/Header.vue';

export default {
  name: 'app',
  components: {
    Header
  }
}
</script>

<style>

</style>
