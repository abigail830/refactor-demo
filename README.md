# refactor-demo
[![Build Status](https://travis-ci.org/abigail830/refactor-demo.svg?branch=master)](https://travis-ci.org/abigail830/refactor-demo)

## 关于重构的那些事。。。

### 要点
* 发现坏味道
* 测试保护
* 小步提交

### 代码介绍
有一个能获取客户账单的功能，账单里面会统计客户租电影名称、价格、积分

* intro.plantuml
* ori_flow.plantuml

**影片出租价格计算方式：**

* REGULAR：起步价2元，租超过2天后，每天1.5元
* NEW_RELEASE：每天3元，不设起步价
* CHILDRENS：起步价1.5元，租超过3天后，每天1.5元

**常客积分计算方式：**
* 每租1张影碟得1积分
* 如果是新片而且租超过1天的话，再加1积分

##步骤
###Part 1 （过长函数、测试保护、抽取方法、变量命名、减少临时变量）

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



