# trivial-daoYun
Engeering practice
2048-

关系表是不是联合主键+单独索引都建起来比较好？



### 功能更新 2020/4/8

---

- 新增手机绑定用户名，可以通过手机，用户名登录。登录成功返回用户ID（验证码认证暂时关闭）
- 新增用户名合法性检查
- 新增注销功能
- 改用logger，在关键点设置了日志
- 新增数据字典增加、删除、模糊查询（需要提供字典ID）
- 新增创建班课，更新班课信息，删除班课
- 新增加入班课，退出班课
- 新增 ”我加入的班课“ ”我创建的班课“

---

需要加一个请求页面记录总数的



### 功能更新 2020/4/4

---

- 后端+数据库部署上服务器
- 目前的功能：登录，注册，安全控制
- 暂不支持https协议
---

##### 1，待测试功能

---

* 注册流程（初步）：填写用户名，密码，邮箱，邮箱验证码(2mins)，验证码(1min) -> 验证通过，返回注册成功。
* 登录流程（初步）：填写用户名（**暂不支持邮箱登录**），密码，验证码（1min）->验证通过，返回登录成功
* **暂不支持登出**，只能用另一台设备强行挤下线。
* 移动端和PC端**各**支持最多一台设备同时在线（需要你们测试一下是否有bug）。
* /signup ; /signin ; /verification/code (获取验证码) ; /verification/mail (获取邮件) ； /device (获取设备类型) ; /userExist (判断用户是否存在) ;  以上几个页面允许**未登录**时访问。
* /getRoleList 获取数据库中角色类型 ; /hello 测试用 ； /test1 测试用 ； /halo.html 静态页面 以上仅允许**登录后访问**。

##### 2，post/get 示例 (未注明提交于body的都是参数提交)

---

- /signup: （post）

  提交信息于body中

  {
  	"userName":"xxx",
  	"password":"xx",
  	"email":"xxx", （必须和请求邮件验证码时的邮箱时一样）
  	"mailVerificationCode":"xxx",
  	"verificationCode":"xxx"

  }
  
- /signin: （post）

  提交信息于body中

  {
  	"userName":"xxx",
  	"password":"xxx",
  	"verificationCode":"xxx"
  }

- /userExist：（get）

  例子：http://47.95.120.250:8080/userExist?userName=superAdmin

- /verification/mail：（get)

  例子：http://47.95.120.250:8080/verification/mail?email=123@gmail.com

**其他服务目前直接访问即可**

---







