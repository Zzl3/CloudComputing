<template>
  <div>
    <el-menu
      :default-active="activeIndex2"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1" @click="gouser">用户方面</el-menu-item>
      <el-menu-item index="2" @click="gothing">商品方面</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    gouser() {
      this.$router.push({
        path: "/user",
      });
    },
    gothing() {
      this.$router.push({
        path: "/thing",
      });
    },
  },
};
</script>

<style>
</style>
