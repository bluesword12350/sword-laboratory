<template>
  <a-layout id="layout-demo-custom-trigger">
    <a-layout-sider id="layout-sider-demo">
      <a-menu theme="dark" mode="inline">
        <a-menu-item key="2">
          <FieldTimeOutlined />
          <span>时间</span>
          <router-link to="/timestamp"></router-link>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout-content>
      <router-view></router-view>
    </a-layout-content>
  </a-layout>
</template>

<script>
import MenuFoldOutlined from '@ant-design/icons-vue/MenuFoldOutlined';
import FieldTimeOutlined from '@ant-design/icons-vue/FieldTimeOutlined';

export default {
  name: "App",
  data() {
    return {
    };
  },
  components: {
    MenuFoldOutlined,
    FieldTimeOutlined
  }
};
</script>

<style>

#layout-demo-custom-trigger a {
  color: white;
}

#layout-demo-custom-trigger, #layout-sider-demo {
  height: 100%;
}
</style>
