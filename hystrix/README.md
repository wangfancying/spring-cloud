### Hystrix的简单使用
主要代码都在`consumer-server`项目里面，对`consumer-server`项目里面代码结构做简单的说明
* `config`: fastJson的配置
* `context`: 主要是用户信息上下文的定义
* `controller`: 这里是对hystrix简单使用
* `filter`: 定义了一个获取用户信息的filter并保存到上下文中
* `hystrix`: 主要是完成自定义并发策略
* `threadlocal`: 主要是模拟一下子线程获取不到父线程的上下文
