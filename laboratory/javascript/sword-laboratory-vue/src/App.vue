<template>
  <div id="app">
    <p>
      <router-link to="/timestamp">Go to Bar</router-link>
    </p>
    <router-view></router-view>
  </div>
</template>

<script>
import Timestamp from "./component/Timestamp";

export default {
  name: "App",
  components: {
    Timestamp
  },
};
</script>

<style>
</style>
