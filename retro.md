# 关于重构

发掘坏味道 -> 找一个解决方案 -> 重构 -> 测试 -> 提交代码

## Part 1
* 过长方法 -> 抽取方法 -> Refactor/Extract/Method
* 冗余的临时变量(灰色的波浪线) -> 移除 -> Alt+Enter, 手工
* 变量名、方法名不够表意 -> 改名 -> Refactor/Rename

## Part 2
* 特性依恋 -> 移动方法
	* 完全依恋 -> Refactor/Move
	* 一半/一半依恋 -> Refactor/Extract/Method+Parameter + Refactor/Move
* 充血模型

## 安全重构
* 添加自动化测试案例
* 每次重构之后，重复多次运行测试案例
* 尽量使用重构菜单，减少人工操作带来的风险
* 小步提交，关注流水线状况