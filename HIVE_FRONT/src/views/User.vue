<template>
  <div>
    <Navigation></Navigation>
    <div>
      <el-input
        placeholder="请输入模糊查找用户"
        v-model="input"
        clearable
        class="inputclass"
      >
      </el-input>
      <el-button style="display: inline">确认查找</el-button>
    </div>

    <el-table
      max-height="700"
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
                : scope.row.auditstatus == '4'
                ? 'success'
                : scope.row.auditstatus == '3'
                ? 'danger'
                : scope.row.auditstatus == '2'
                ? 'warning'
                : scope.row.auditstatus == '1'
                ? 'info'
                : scope.row.auditstatus == '0'
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
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)"
            >查看用户</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="查看商品" width="120px">
        <template slot-scope="scope">
          <el-button type="info" size="mini" @click="handleEdit(scope.$index, scope.row)"
            >查看商品</el-button
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
    };
  },
  mounted() {
    this.getdata();
  },
  methods: {
    filterTag(value, row) {
      return row.rating === value;
    },
    getdata() {},
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
