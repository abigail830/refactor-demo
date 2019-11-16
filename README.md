# 关于重构 [refactor-demo]
[![Build Status](https://travis-ci.org/abigail830/refactor-demo.svg?branch=master)](https://travis-ci.org/abigail830/refactor-demo)

## 代码介绍
有一个能获取客户账单的功能，账单里面会统计客户租电影名称、价格、积分

* intro.plantuml

![alt text](http://www.plantuml.com/plantuml/png/TP9FgzD04C3l-oc6dDGIy7cqAkyHWmhn7HB4ewp9Fbb8DfBiAnGHUcXhYms8Vn14hFLWFKZiGIZQVfpkffxy2axIcDTBSyXCPd-J-Kt8SIff8i-Za139PSZWpujCV-g3oyweB-E4a9OLqZG5wpoLSSGIU4R0z6J2nHCGD6BuvF1Ktd2Pa3Iy1KaLon9vtZJVZpkSOIDUBHmekGzdND0Gk93WsdSUE2Skt8IhxGF8gVtmaMixzebd8tPq2BFktdDkk_QfXz2rDYcfnhNQhhqhbUpJXFlCYWEiNNZkbjY9cfKqH7ZVxmjeDoqn5bIDpMSnZWouOffWH5HqZVfDS1ty61CkKb9N6WvZDM6FQJmyt8n5sE2nf8EUQDIgzq1l8PlpIyrylqukevM89OF7iSG2qUCtAbke_8iUBOiF_UtFhofxztSzKSE1od-foK2__4vCAEPJzJRV_1uYKsbXLA-oOhvGhoURrL9_NglH--ti6x9wtDCVn_yftLlXELAO5FCVQZGiLjDjFYDC152Q44AECST_x1y0)

* ori_flow.plantuml

![alt text](http://www.plantuml.com/plantuml/png/bLFFQnD15BxFN_6EAbH8YvSSfALTL8YbR10F7cJPl8I1oOxElWru4sqR5MCzI2j5srZKui543zgeQ_rdEhFhgV-2Bpy8QaEibzsPxttlUz_xs9sFAJ2Kr9KG94aX_6ostCug-5WDGj962C5lsGW8eKpyh6D4PJGD6Q8GDsOkda2X2BUCZ6YCdmcJc7GTpLaMEy6Ue524gZOGA0M6mK35KonC5FG7RKMe8LtL3ObY2FHBW_kWicAOlQWh-2-9fU1EtBzYvRJsmq25YM8KWhfE8XAHvhF2AWdx_MFsi6cRNxFztQDl1wwTvfrNMMVBRNwnwSPnkYtW7C0C-DwbQwK5du7yqu5x_uQvitRj_d7wc1lppslvZ-QiVVtEFdt2aEjkyBbm_W8pHltBtlMRlbVo5ieUQmm9SqE1eruhxnoEPKSDYvUlb9PyRxdy-qYM_6letEIX65MWlwJu_uYg1cydN1f4R5Qq_3ElNizszhBzhdsmFZafzi7k2ZPjzxFTsxM7MuKXdqsEEFRjFRVpmZtlkiqF77z-bqDuDjwfm7jaswjvzoLtsFMMVTGUAOptEkrQDIGm62UAG4OGav5HJOWAJlc0fnRdsG3_dBy0)

## 要点
* 发现坏味道
* 安全地重构
  * 测试保护
  * 小步提交


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



