import csv  # 调用数据保存文件
import pandas as pd  # 用于数据输出

#这里是存储review的数据库的脚本
datas = open("/Users/zhouzilei/Desktop/data.txt", "r", encoding="utf-8")
lines = datas.readlines()
list = []
lists = []

for i in range(len(lines)):
    line=lines[i].replace(' ', '')  # 先把空格去掉
    if line.split(':')[0] == "Id":
        Id = line.split(':')[1].replace('\n', '').replace(' ', '')  # 获得id
    if line.split(':')[0] == "reviews":
        total = line.split(':')[2].replace('downloaded', '')
        for j in range((int)(total)):
            list=[]
            i=i+1
            tem=lines[i].replace('\n', '')
            tems=tem.split(':')
            list.append(Id)
            for t in tems:
                list.append(t.replace(' ', '').replace('cutomer', '').replace('rating', '').replace('votes', '').replace('helpful', ''))
            lists.append(list)
            # time=tem.split(':')[0].replace(' ', '').replace('cutomer', '')
            # cutomerid = tem.split(':')[1].replace(' ', '').replace('rating', '')
            # rating = tem.split(':')[2].replace(' ', '').replace('votes', '')
            # votes = tem.split(':')[3].replace(' ', '').replace('helpful', '')
            # helpful = tem.split(':')[4].replace(' ', '')
            # list.append(Id)
            # list.append(time)
            # list.append(cutomerid)
            # list.append(rating)
            # list.append(votes)
            # list.append(helpful)
            # lists.append(list)
#print(lists)
# 将数据存入表格中
column = ['thingid', 'time', 'userid', 'rating', 'votes', 'helpful']  # 列表头名称
test = pd.DataFrame(columns=column, data=lists)  # 将数据放进表格
test.to_csv('reviews.csv')  # 数据存入csv,存储位置及文件名称
