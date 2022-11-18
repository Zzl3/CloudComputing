<template>
  <div>
    <Navigation></Navigation>
    <div>
      <el-input
        placeholder="请输入模糊查找标题"
        v-model="input"
        clearable
        class="inputclass"
      >
      </el-input>
      <el-button style="display: inline">确认查找</el-button>
    </div>

    <el-table
      class="tableclass"
      :data="tableData"
      style="width: 100%"
      :default-sort="{ order: 'descending' }"
    >
      <el-table-column prop="id" label="id" sortable width="100"> </el-table-column>
      <el-table-column prop="asin" label="asin" sortable width="150"> </el-table-column>
      <el-table-column prop="title" label="title" sortable width="200"> </el-table-column>
      <el-table-column
        prop="group"
        label="group"
        width="100"
        :filters="[
          { text: 'VideoGame', value: 'VideoGame' },
          { text: 'BabyProduct', value: 'BabyProduct' },
          { text: 'Toy', value: 'Toy' },
          { text: 'CE', value: 'CE' },
          { text: 'DVD', value: 'DVD' },
          { text: 'Sports', value: 'Sports' },
          { text: 'Video', value: 'Video' },
          { text: 'Music', value: 'Music' },
          { text: 'Book', value: 'Book' },
          { text: 'Software', value: 'Software' },
        ]"
        :filter-method="filterTag"
        filter-placement="bottom-end"
      >
        <template slot-scope="scope">
          <el-tag
            :type="
              scope.row.group == 'VideoGame'
                ? ''
                : scope.row.auditstatus == 'BabyProduct'
                ? 'success'
                : scope.row.auditstatus == 'Toy'
                ? 'danger'
                : scope.row.auditstatus == 'CE'
                ? 'warning'
                : scope.row.auditstatus == 'DVD'
                ? 'info'
                : scope.row.auditstatus == 'Sports'
                ? 'primary'
                : scope.row.auditstatus == 'Video'
                ? ''
                : scope.row.auditstatus == 'Music'
                ? 'primary'
                : scope.row.auditstatus == 'Book'
                ? 'info'
                : scope.row.auditstatus == 'Software'
                ? 'warning'
                : 'danger'
            "
            size="mini"
          >
            {{ scope.row.group }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="salesrank" label="salesrank" sortable width="130">
      </el-table-column>
      <el-table-column prop="reviews" label="reviews" sortable width="130">
      </el-table-column>
      <el-table-column prop="downloaded" label="downloaded" sortable width="130">
      </el-table-column>
      <el-table-column prop="avgrating" label="avgrating" sortable width="130">
      </el-table-column>
      <el-table-column label="查看详情" width="100px">
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)"
            >查看详情</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import Navigation from "@/components/Navigation";
export default {
  components: { Navigation },
  data() {
    return {
      tableData: [
        {
          id: "1",
          asin: "828229534",
          title: "PatternsofPreaching",
          group: "Book",
          salesrank: "396585",
          categories: "2",
          reviews: "2",
          downloaded: "2",
          avgrating: "5",
        },
      ],
    };
  },
  mounted() {
    this.getdata();
  },
  methods: {
    filterTag(value, row) {
      return row.group === value;
    },
      getdata() {
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

<style scoped>
.inputclass {
  width: 350px;
  margin-bottom: 30px;
  margin-top: 10px;
}
.tableclass {
  margin-left: 40px;
}
</style>
