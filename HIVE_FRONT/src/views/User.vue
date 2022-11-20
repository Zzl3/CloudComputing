<template>
  <div>
    <Navigation></Navigation>
    <div>
      <el-input
        placeholder="请输入模糊查找用户"
        v-model="name"
        clearable
        class="inputclass"
      >
      </el-input>
      <el-button style="display: inline" @click="finduser">确认查找</el-button>
      <el-date-picker
        v-model="date"
        type="daterange"
        value-format="yyyy-MM-dd"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
      >
      </el-date-picker>
      <el-button style="display: inline" @click="finddate">确认查找</el-button>
      <el-button style="display: inline" @click.native="findall">复原全部</el-button>
    </div>

    <el-table
      class="tableclass"
      :data="tableData"
      style="width: 100%"
      :default-sort="{ order: 'descending' }"
    >
      <el-table-column prop="id" label="id" sortable width="80"> </el-table-column>
      <el-table-column prop="thingid" label="thingid" sortable width="100">
      </el-table-column>
      <el-table-column prop="userid" label="userid" sortable width="200">
      </el-table-column>
      <el-table-column prop="votes" label="votes" sortable width="100"> </el-table-column>
      <el-table-column
        prop="rating"
        label="rating"
        width="100"
        :filters="[
          { text: '5', value: '5' },
          { text: '4', value: '4' },
          { text: '3', value: '3' },
          { text: '2', value: '2' },
          { text: '1', value: '1' },
          { text: '0', value: '0' },
        ]"
        :filter-method="filterTag"
        filter-placement="bottom-end"
      >
        <template slot-scope="scope">
          <el-tag
            :type="
              scope.row.rating == '5'
                ? ''
                : scope.row.rating == '4'
                ? 'success'
                : scope.row.rating == '3'
                ? 'danger'
                : scope.row.rating == '2'
                ? 'warning'
                : scope.row.rating == '1'
                ? 'info'
                : scope.row.rating == '0'
                ? 'primary'
                : 'danger'
            "
            size="mini"
          >
            {{ scope.row.rating }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="helpful" label="helpful" sortable width="100">
      </el-table-column>
      <el-table-column prop="year" label="year" sortable width="100"> </el-table-column>
      <el-table-column prop="month" label="month" sortable width="100"> </el-table-column>
      <el-table-column prop="day" label="day" sortable width="100"> </el-table-column>
      <el-table-column label="查看用户" width="120px">
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="viewuser(scope.$index, scope.row)"
            >查看用户</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="查看商品" width="120px">
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="viewthing(scope.$index, scope.row)"
            >查看商品</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="用户详情" :visible.sync="dialogTableVisible1" width="70%">
      <el-table :data="gridData1">
        <el-table-column property="id" label="id" width="100"></el-table-column>
        <el-table-column property="thingid" label="thingid" width="150"></el-table-column>
        <el-table-column property="votes" label="votes" width="100"></el-table-column>
        <el-table-column property="rating" label="rating" width="100"></el-table-column>
        <el-table-column property="helpful" label="helpful" width="100"></el-table-column>
        <el-table-column property="year" label="year" width="100"></el-table-column>
        <el-table-column property="month" label="month" width="100"></el-table-column>
        <el-table-column property="day" label="day" width="100"></el-table-column>
      </el-table>
    </el-dialog>
    <el-dialog title="物品详情" :visible.sync="dialogTableVisible2" width="90%">
      <el-table :data="gridData2">
        <el-table-column property="id" label="id" width="100"></el-table-column>
        <el-table-column property="asin" label="asin" width="150"></el-table-column>
        <el-table-column property="title" label="title" width="250"></el-table-column>
        <el-table-column property="group" label="group" width="130"></el-table-column>
        <el-table-column
          property="salesrank"
          label="salesrank"
          width="125"
        ></el-table-column>
        <el-table-column property="reviews" label="reviews" width="125"></el-table-column>
        <el-table-column
          property="downloaded"
          label="downloaded"
          width="125"
        ></el-table-column>
        <el-table-column
          property="avgrating"
          label="avgrating"
          width="125"
        ></el-table-column>
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
      dialogTableVisible1: false,
      dialogTableVisible2: false,
      date: "",
      name: "",
      tableData: [
        {
          id: "0",
          thingid: "1",
          userid: "A2JW67OY8U6HHK",
          votes: "10",
          rating: "5",
          helpful: "9",
          year: "2000",
          month: "7",
          day: "28",
        },
      ],
      gridData1: [
        {
          id: "0",
          thingid: "1",
          votes: "10",
          rating: "5",
          helpful: "9",
          year: "2000",
          month: "7",
          day: "28",
        },
      ],
      gridData2: [
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
  created() {
    this.getdata();
  },
  methods: {
    filterTag(value, row) {
      return row.rating === value;
    },
    getdata() {
      let vm = this;
      this.$axios.post("/findallreview").then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },

    finduser() {
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios({
        url: "/findbyuserlike",
        method: "post",
        data: vm.name,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },

    finddate() {
      let vm = this;
      // console.log(this.date[0].split("-")[0]);
      // console.log(this.date[1].split("-")[0]);
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios
        .post("/findbyyear", {
          a: vm.date[0].split("-")[0],
          b: vm.date[1].split("-")[0],
        })
        .then((res) => {
          for (let item of res.data) {
            vm.tableData.push(item);
          }
        });
    },

    findall() {
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios.post("/findallreview").then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
    },
    viewuser(index, row) {
      let vm = this;
      vm.gridData1 = undefined;
      vm.gridData1 = new Array(); //先清空再进行筛选
      this.dialogTableVisible1 = true;
      this.$axios({
        url: "/findbyuser",
        method: "post",
        data: row.userid,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data) {
          vm.gridData1.push(item);
        }
      });
    },

    viewthing(index, row) {
      let vm = this;
      vm.gridData2 = undefined;
      vm.gridData2 = new Array(); //先清空再进行筛选
      this.dialogTableVisible2 = true;
      this.$axios({
        url: "/findbyid",
        method: "post",
        data: row.thingid,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
       // console.log(res.data)
        vm.gridData2.push(res.data);
      });
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
