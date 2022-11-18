<template>
  <div>
    这里是索引界面
    <el-input v-model="input" placeholder="请输入用户姓名"></el-input>
    <el-button @click="test">默认按钮</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      input: "",
    };
  },
  methods: {
    test() {
      var _this = this;
      this.$axios
        .post("/test", {
          name: _this.input,
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            alert("成功！")
          }
        })
        .catch((failResponse) => {});
    },
  },
};
</script>

<style>
</style>