<template>
  <div>
    <Navigation></Navigation>
    这里是索引界面
    <el-input v-model="input" placeholder="请输入用户姓名"></el-input>
    <el-button @click="test">默认按钮</el-button>
  </div>
</template>

<script>
import Navigation from '@/components/Navigation'
export default {
  data() {
    return {
      input: "",
    };
  },
  components:{Navigation},
  methods: {
    test() {
      var _this = this;
      this.$axios
        .post("/finduser", {
          name: _this.input,
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            alert("成功！");
          }
        })
        .catch((failResponse) => {});
    },
  },
};
</script>

<style></style>
