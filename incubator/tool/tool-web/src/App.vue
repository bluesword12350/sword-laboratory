<template>
  <a-layout id="utils-layout">
    <a-layout-sider id="utils-sider" v-model="collapsed">
      <div class="logo">
        <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
        />
      </div>
      <a-menu theme="dark" mode="inline">
        <a-menu-item key="json-editor">
          <a-icon type="video-camera"/>
          <span>Json编辑器</span>
          <router-link to="/json-editor"></router-link>
        </a-menu-item>
        <a-menu-item key="url-editor">
          <a-icon type="video-camera"/>
          <span>URL编码</span>
          <router-link to="/url-editor"></router-link>
        </a-menu-item>
        <a-menu-item key="timestamp">
          <a-icon type="video-camera"/>
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
#utils-sider .trigger {
  font-size: 18px;
  color: white;
}

#utils-sider .logo {
  height: 32px;
  margin: 16px;
}

#utils-layout, #utils-sider {
  height: 100%;
}
</style>
