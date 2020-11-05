<template>
  <a-layout id="layout-demo-custom-trigger">
    <a-layout-sider id="layout-sider-demo" v-model="collapsed">
      <div class="logo">
        <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
        />
      </div>
      <a-menu theme="dark" mode="inline">
        <a-menu-item key="2">
          <a-icon type="video-camera"/>
          <span>时间戳</span>
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
export default {
  name: "App",
  data() {
    return {
      collapsed: false,
    };
  }
};
</script>

<style>
#layout-demo-custom-trigger .trigger {
  font-size: 18px;
  color: white;
}

#layout-demo-custom-trigger .logo {
  height: 32px;
  margin: 16px;
}

#layout-demo-custom-trigger a {
  color: white;
}

#layout-demo-custom-trigger, #layout-sider-demo {
  height: 100%;
}
</style>
