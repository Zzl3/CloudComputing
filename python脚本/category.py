import csv  # 调用数据保存文件
import pandas as pd  # 用于数据输出
datas = open("/Users/zhouzilei/Desktop/data.txt", "r", encoding="utf-8")
lines = datas.readlines()
list=[]
for line in lines:
    line = line.replace(' ', '')  # 先把空格去掉
    if line.split(':')[0] == "group":
        group = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得group
        list.append(group)
all=set(list)
column = ['group']
test = pd.DataFrame(columns=column,data=all)  # 将数据放进表格
test.to_csv('category.csv')  # 数据存入csv,存储位置及文件名称
