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

## Part 3
* 临时变量 -> 移除 -> 抽取方法/调用方法，取代临时变量
* 业务意图不清晰 -> 业务细节抽取到方法
* Lambda8 重构

思考： 重构 vs 性能
* 关注点分离
* 性能不能凭感觉
	* 这个业务需求对性能有什么要求 ？
	* 有没有外部依赖？
	* 需要做具体的性能测试

## Part4
* 业务意图和计算细节混合 -> 把细节抽取（Refactor/Extract/Method Object + Move)
* 重复代码 -> 抽取父类 Refactor/Extract/Super Class
* 重复代码 -> 提前预设选好计算器，统一在构造函数

## 安全重构
* 添加自动化测试案例
* 每次重构之后，重复多次运行测试案例
* 尽量使用重构菜单，减少人工操作带来的风险
* 小步提交，关注流水线状况
