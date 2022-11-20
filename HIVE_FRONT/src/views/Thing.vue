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
      <el-button style="display: inline" @click.native="findname">确认查找</el-button>
      <el-button style="display: inline" @click.native="findall">复原全部</el-button>
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
                : scope.row.group == 'BabyProduct'
                ? 'success'
                : scope.row.group == 'Toy'
                ? 'danger'
                : scope.row.group == 'CE'
                ? 'warning'
                : scope.row.group == 'DVD'
                ? 'info'
                : scope.row.group == 'Sports'
                ? 'primary'
                : scope.row.group == 'Video'
                ? ''
                : scope.row.group == 'Music'
                ? 'primary'
                : scope.row.group == 'Book'
                ? 'info'
                : scope.row.group == 'Software'
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
          <el-button type="info" size="mini" @click="viewdetail(scope.$index, scope.row)"
            >查看详情</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="评论详情" :visible.sync="dialogTableVisible" width="78%">
      <el-table :data="gridData">
        <el-table-column property="id" label="id" width="150"></el-table-column>
        <el-table-column property="userid" label="userid" width="200"></el-table-column>
        <el-table-column property="votes" label="votes" width="100"></el-table-column>
        <el-table-column property="rating" label="rating" width="100"></el-table-column>
        <el-table-column property="helpful" label="helpful" width="100"></el-table-column>
        <el-table-column property="year" label="year" width="100"></el-table-column>
        <el-table-column property="month" label="month" width="100"></el-table-column>
        <el-table-column property="day" label="day" width="100"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import Navigation from "@/components/Navigation";
export default {
  components: { Navigation },
  data() {
    return {
      input: "",
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
      gridData: [
        {
          id: "0",
          userid: "A2JW67OY8U6HHK",
          votes: "10",
          rating: "5",
          helpful: "9",
          year: "2000",
          month: "7",
          day: "28",
        },
      ],
      dialogTableVisible: false,
    };
  },
  created() {
    this.getdata();
  },
  methods: {
    filterTag(value, row) {
      return row.group === value;
    },
    getdata() {
      let vm = this;
      this.$axios.post("/findallthing").then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },

    findname() {
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios({
        url: "/findbytitle",
        method: "post",
        data: vm.input,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },

    findall() {
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios.post("/findallthing").then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },

    viewdetail(index, row) {
      let vm = this;
      vm.gridData = undefined;
      vm.gridData = new Array(); //先清空再进行筛选
      this.dialogTableVisible = true;

      this.$axios({
        url: "/findbythingid",
        method: "post",
        data: row.id,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data) {
          vm.gridData.push(item);
        }
      });
      //console.log(row.id);
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
