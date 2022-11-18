import csv  # 调用数据保存文件
import pandas as pd  # 用于数据输出
#这里是存储review的数据库的脚本
datas = pd.read_csv("/Users/zhouzilei/PyCharm/pythonProject/reviews.csv", encoding="utf-8", keep_default_na=False)
data = datas['userid']
user=set(data)
# 将数据存入表格中
column = ['userid']  # 列表头名称
test = pd.DataFrame(columns=column, data=user)  # 将数据放进表格
test.to_csv('user.csv')  # 数据存入csv,存储位置及文件名称
