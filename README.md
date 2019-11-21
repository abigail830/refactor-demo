# 关于重构 [refactor-demo]
[![Build Status](https://travis-ci.org/abigail830/refactor-demo.svg?branch=master)](https://travis-ci.org/abigail830/refactor-demo)

## 重构要点与步骤
* 发现坏味道
* 安全地重构
  * 测试保护
  * 小步提交
  
![alt text](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuR9wkgVXQVz4QovTEuMdwtgUTKnusZN_HVFUfnFwhBdACp9pKXKqWFBF-cOysRtu-OB6ftFxdqxS_B9nigP2PZ5GQksCftDMm0NjDRcu51IidgxhVDgwucLxxxDvBTPWWGtzpzOkVTO_uSck9TPSgNafO9Evk8fByWku781ye5C0)

## 代码背景介绍

这是一个给客户提供电影出租的系统，其中系统需要提供一个功能：为客户输出他已租电影记录的报表。

这个功能牵涉到的对象就包括了客户(Customer)、租售记录(Rental)以及电影信息(Movie)，他们的关系如下：

* intro.plantuml

![alt text](http://www.plantuml.com/plantuml/png/TP9FgzD04C3l-oc6dDGIy7cqAkyHWmhn7HB4ewp9Fbb8DfBiAnGHUcXhYms8Vn14hFLWFKZiGIZQVfpkffxy2axIcDTBSyXCPd-J-Kt8SIff8i-Za139PSZWpujCV-g3oyweB-E4a9OLqZG5wpoLSSGIU4R0z6J2nHCGD6BuvF1Ktd2Pa3Iy1KaLon9vtZJVZpkSOIDUBHmekGzdND0Gk93WsdSUE2Skt8IhxGF8gVtmaMixzebd8tPq2BFktdDkk_QfXz2rDYcfnhNQhhqhbUpJXFlCYWEiNNZkbjY9cfKqH7ZVxmjeDoqn5bIDpMSnZWouOffWH5HqZVfDS1ty61CkKb9N6WvZDM6FQJmyt8n5sE2nf8EUQDIgzq1l8PlpIyrylqukevM89OF7iSG2qUCtAbke_8iUBOiF_UtFhofxztSzKSE1od-foK2__4vCAEPJzJRV_1uYKsbXLA-oOhvGhoURrL9_NglH--ti6x9wtDCVn_yftLlXELAO5FCVQZGiLjDjFYDC152Q44AECST_x1y0)


在输出的报表里面，需要能列出该客户的：
- 租售记录明细 （电影名称 和 对应价格）
- 全部租售记录的总价格
- 全部租售记录的总常客积分

* ori_flow.plantuml

![alt text](http://www.plantuml.com/plantuml/png/bLFFQnD15BxFN_6EAbH8YvSSfALTL8YbR10F7cJPl8I1oOxElWru4sqR5MCzI2j5srZKui543zgeQ_rdEhFhgV-2Bpy8QaEibzsPxttlUz_xs9sFAJ2Kr9KG94aX_6ostCug-5WDGj962C5lsGW8eKpyh6D4PJGD6Q8GDsOkda2X2BUCZ6YCdmcJc7GTpLaMEy6Ue524gZOGA0M6mK35KonC5FG7RKMe8LtL3ObY2FHBW_kWicAOlQWh-2-9fU1EtBzYvRJsmq25YM8KWhfE8XAHvhF2AWdx_MFsi6cRNxFztQDl1wwTvfrNMMVBRNwnwSPnkYtW7C0C-DwbQwK5du7yqu5x_uQvitRj_d7wc1lppslvZ-QiVVtEFdt2aEjkyBbm_W8pHltBtlMRlbVo5ieUQmm9SqE1eruhxnoEPKSDYvUlb9PyRxdy-qYM_6letEIX65MWlwJu_uYg1cydN1f4R5Qq_3ElNizszhBzhdsmFZafzi7k2ZPjzxFTsxM7MuKXdqsEEFRjFRVpmZtlkiqF77z-bqDuDjwfm7jaswjvzoLtsFMMVTGUAOptEkrQDIGm62UAG4OGav5HJOWAJlc0fnRdsG3_dBy0)




## 步骤
### Part 1 （过长函数、测试保护、抽取方法、变量命名、减少临时变量）

* 发倔坏味道 -> StatementService.printStatement 过长函数
* 找边界 -> 理解代码 + 留意有注释的地方
* 添加测试保护 -> given/when/then的套路
* 抽取方法getAmount -> 尽量使用IDEA的自动重构menu
* 修改变量名更表意 -> thisAmount to result
* 减少临时变量thisAmount
* 同理抽取getFrequentRenterPoints并把内部变为if/else
* 把Amt相关的移动到一起

### Part 2 （特性依恋、移动方法）

* 发倔坏味道 -> 特性依恋
* 移动getFrequentRenterPoints到Rental -> 并使用local变量
* 移动getAmount到Rental -> 并使用local变量
* 发倔坏味道 -> 特性依恋
* 移动printStatement到Customer -> 为了向后兼容，Service里面得保持原方法
* 发倔坏味道 -> 特性依恋
* 移动getFrequentRenterPoints到Movie -> 抽取方法，抽取入参，移动方法
* 移动getAmount到Movie -> 抽取方法，抽取入参，移动方法

改动后的类图示意：
![alt text](http://www.plantuml.com/plantuml/png/T99TI_im5CRlyoaElLh_fV2VbrR5KUiBr24jugLaRJOAQQB9wM28Tu9NVWK_ti1luMbJGXbk5tbvyikpvvpqqY8tsBMICMnG2lZv_Df_Vq0Xrhn2RHYBKicjXRIpg5jXu8r1NA9fr0OKRmNjyiRYMI4KSda1PfXxAM4GmKY-q8WbSXGjdS_2XBrxvtkzRGIvqY-oX3GLh1l59T0LABARntnHm3dyJuuWo-pfkSZoR55cXCsFOUdjNNvLPCkIe9E4zPGlP2WzSLBFKjnAfBeUDUSuk6m4kaeVD6tjhDTglhEzAEeGaf6jTRUI0Yek5wtk51w2qmOuGzU1UEW6j3HE0ark9fCmv5vragEuDkAre-C1CMEqy22BfyT4BeD_rs0UmByuXg3bQXUCeU0KAasBHbdc5C_Hx9vkmlYI_5ENmcofbrHSzFUduF-_6XSXfL8Q1Qmqai3sl-kS_BHtmzDrYvvrR7y-g-N5bcLFUwU-tzFpjAtrwRgTJtjQdtMluT9LUBvy_jCfwvxiQWEg0JiBI3-TqFjy-OQdatgUxDx-RC6UfntJNonS0LJxhBFXsPnEcAfd3Rk1ya1LGCRpvUkVThGztpt_nRg5NAbvAGeWbt1nSJa0sQ1C0W00)

### Part 3 (去除临时变量、步骤拆分）

* 发掘坏味道 -> 临时变量多，步骤不明显
* 把Customer.printStatement 拆分成明确的三部
* 发掘坏味道 -> 特性依恋
* 把相关方法移动到所属类里面
* 体验lambda8的威力

思考： 重构与性能优化的关系？

### Part 4 （Switch/Case， 多态）


