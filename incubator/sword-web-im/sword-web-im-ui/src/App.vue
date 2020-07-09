<template>
  <a-layout id="App">
    <a-layout-sider id="address-sider" style="flex: 0 0 15%; max-width: 300px">
      <AddressBook/>
    </a-layout-sider>
    <a-layout>
      <a-layout-header></a-layout-header>
      <a-layout-content></a-layout-content>
      <a-layout-footer></a-layout-footer>
    </a-layout>
  </a-layout>
</template>

<script>
  import {service} from "./config";
  import AddressBook from "./component/AddressBook";
  let imSocket = new WebSocket("ws://"+service.domain+"/communicate");
  export default {
    name: 'App',
    components: {
      AddressBook
    }
  }
</script>

<style>
  #App {
    height: 100%;
  }
  #App .ant-layout-header,
  #App .ant-layout-sider {
    background: #ffffff;
  }
  #App .ant-layout-sider {
    border-right: solid #ff7d05 1px;
  }
</style>
