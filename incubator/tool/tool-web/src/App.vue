<template>
  <div id="app">
    <JsonEditor />
  </div>
</template>

<script>
  import JsonEditor from "./editor/JsonEditor";
  export default {
    name: "App",
    components: {
      JsonEditor
    },
  };
</script>

<style>
html {
  height: 98%;
}
body,#app {
  height: 100%;
}
</style>
