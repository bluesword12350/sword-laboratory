<template>
  <a-layout id="App">
    <a-layout-sider id="address-sider" style="flex: 0 0 15%; max-width: 300px">
      <AddressBook/>
    </a-layout-sider>
    <a-layout>
      <a-layout-header>
        <UserInfo/>
      </a-layout-header>
      <a-layout-content></a-layout-content>
      <a-layout-footer>
        <SendMessage />
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>

<script>
  import {service} from "./config";
  import AddressBook from "./component/AddressBook";
  import UserInfo from "./component/UserInfo"
  import SendMessage from "./component/SendMessage";

  export default {
    name: 'App',
    components: {
      AddressBook,UserInfo,SendMessage
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
  #App .ant-layout-header {
    border-bottom: solid #ff7d05 1px;
  }
  #App .ant-layout-footer {
    height: 25%;
    border-top: solid #ff7d05 1px;
  }
</style>
