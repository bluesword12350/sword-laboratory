<template>
  <div id="app">
    <UrlEditor />
  </div>
</template>

<script>
  import JsonEditor from "./editor/JsonEditor";
  import UrlEditor from "./editor/UrlEditor";
  export default {
    name: "App",
    components: {
      JsonEditor,UrlEditor
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
