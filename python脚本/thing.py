import csv  # 调用数据保存文件
import pandas as pd  # 用于数据输出

datas = open("/Users/zhouzilei/Desktop/data.txt", "r", encoding="utf-8")
lines = datas.readlines()
list = []
lists = []
for line in lines:
    line = line.replace(' ', '')  # 先把空格去掉
    if line.split(':')[0] == "Id":
        Id = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得id
        if (list != []):
            lists.append(list)
        list = []
        list.append(Id)
    if line.split(':')[0] == "ASIN":
        ASIN = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得ASIN
        list.append(ASIN)
    if line.split(':')[0] == "title":
        title = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得title
        list.append(title)
    if line.split(':')[0] == "group":
        group = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得group
        list.append(group)
    if line.split(':')[0] == "salesrank":
        salesrank = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得salesrank
        list.append(salesrank)
    if line.split(':')[0] == "categories":
        categoriesnum = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得categoriesnum
        list.append(categoriesnum)
    if line.split(':')[0] == "reviews":
        total = line.split(':')[2].replace('downloaded', '')
        downloaded = line.split(':')[3].replace('avgrating', '')
        avgrating = line.split(':')[4].replace('\n', '')
        list.append(total)
        list.append(downloaded)
        list.append(avgrating)
# print(lists)
# 将数据存入表格中
column = ['Id', 'ASIN', 'title', 'group', 'salesrank', 'categories', 'reviews', 'downloaded', 'avgrating']  # 列表头名称
test = pd.DataFrame(columns=column, data=lists)  # 将数据放进表格
test.to_csv('thing.csv')  # 数据存入csv,存储位置及文件名称
