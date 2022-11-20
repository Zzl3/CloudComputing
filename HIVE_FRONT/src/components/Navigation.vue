<template>
  <div>
    <el-menu
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
    <el-menu-item index="0" @click="goindex">总体概述</el-menu-item>
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
    goindex() {
      this.$router.push({
        path: "/index",
      });
    },
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
