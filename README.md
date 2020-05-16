# trivial-daoYun
Engeering practice
2048-

关系表是不是联合主键+单独索引都建起来比较好？

- controller层提供交互接口
- service层提供服务（service之间操作mapper层，同文件分为底层服务和逻辑控制服务，底层服务提供事务级数据库操作，逻辑控制做合法性检查，底层服务可能service之间存在共享，是否要将这两层完全剥离？再抽象一个事务级Dao层？）
- mapper层提供与数据库交互
- mapper层逐步取消exister，直接使用getter，如果为空返回null。



### 功能更新 2020/5/16

---

- 增加系统参数

- 新增组织树形索引

- 新增超级管理员控制用户

- 新增角色管理

#### post/get/put/delete示例

---
##### 角色管理
- **@PostMapping(value = "/role")  新增角色 **
  例子：http://47.95.120.250:8080/role
  **body参数**：
  
  ```java
    private Long roleCode; //不可重复
    private String roleName;
    private String roleDescription;
  ```
  
  
  
- **@PutMapping(value = "/role")  更新角色信息**
  例子：http://47.95.120.250:8080/role 
  **body参数**:
  
  ```java
  	private Long id;  		//指定更新目标的id
  	//具体更新信息选填
    private Long roleCode;  
    private String roleName;
    private String roleDescription;
  ```
  
  
  
- **@DeleteMapping(value = "/role")  删除角色信息**
  例子：http://47.95.120.250:8080/role?roleId=xxxx (利用get可以获取到role id)
  
  
  
- **@GetMapping(value = "/role")  获取角色信息**
  例子：http://47.95.120.250:8080/role?page=1&pageSize=10 (利用get可以获取到role id)

---
##### 系统参数
- **@PostMapping(value = "/params/class") 新增系统参数**
  例子：http://47.95.120.250:8080/params/class
  **body参数**：
  
  ```java
    private Long orgCode;   //同一班课下共享一套参数
    private Long paramCode; //同一班课下参数代码不能重复
    private String paramName;
    private String paramDesc;
  ```

  
  
- **@PutMapping(value = "/params/class")  更新系统参数**
  例子：http://47.95.120.250:8080/params/class 
  **body参数**
  
  ```java
    private Long id; 		//指定更新目标的id
  	//具体更新信息选填
    private Long paramCode; //同一班课下参数代码不能重复
    private String paramName;
    private String paramDesc;
  ```

  
  
- **@DeleteMapping(value = "/params/class")  删除系统参数**
  例子：http://47.95.120.250:8080/params/class?paramId=xxxx (利用get可以获取到paramId)
  
  
  
- **@GetMapping(value = "/params/class")  根据班课号获取系统参数**
  例子：http://47.95.120.250:8080/params/class?orgCode=xxx&page=1&pageSize=10 (指定orgCode班课号查询对应系统参数)

---

##### 用户管理(仅管理员可用)
- **@PostMapping(value = "/super/users") 新增用户**
  例子：http://47.95.120.250:8080/super/users
  **body参数**：
  
  ```java
    private Long roleId; 		//角色id，用get获取role信息得到
    private String username; 	//用户名 必填
    private String password; 	//密码 必填
    //剩下选填 
    private String nickname;
    private String studentId;
    private String phone;
    private String email;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private Integer experience,coin;
    private String profilePhotoUrl;
    private String college;
  ```




- **@PutMapping(value = "/super/users")  更新用户信息**
  例子：http://47.95.120.250:8080/params/class 
  **body参数**：
  
  ```java
    private Long id				//指定更新用户的id
  	//具体更新信息选填
    private Long roleId; 		
    private String username; 	
    private String password; 	
    private String nickname;
    private String studentId;
    private String phone;
    private String email;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private Integer experience,coin;
    private String profilePhotoUrl;
    private String college;
  ```





- **@DeleteMapping(value = "/super/users") 根据id删除用户**
  例子：http://47.95.120.250:8080/role?userId=xxxx (利用get可以获取到userId，之前也有引出根据userName查询userId的接口)
  
  
  
- **@GetMapping(value = "/super/users")  获取所有用户信息，分页显示**
  例子：http://47.95.120.250:8080/role&page=1&pageSize=10

---
##### 组织结构化信息
- **@PostMapping(value = "/structure/orgs/schools") 新增学校**
  例子：http://47.95.120.250:8080/structure/orgs/schools
  **body参数**：
  
  ```java
    private String schoolName;
    private String schoolDesc;
  ```





- **@PutMapping(value = "/structure/orgs/schools")  更新学校信息**
  例子：http://47.95.120.250:8080/structure/orgs/schools 
  **body参数**：
  
  ```java
    private Long id;			//指向更新对象id
    private String schoolName;
    private String schoolDesc;
  ```





- **@DeleteMapping(value = "/structure/orgs/schools") 删除学校**
  例子：http://47.95.120.250:8080/structure/orgs/schools?schoolId=xxxx 
  
  
  
- **@GetMapping(value = "/structure/orgs/schools")  获取所有学校**
  例子：http://47.95.120.250:8080/structure/orgs/schools&page=1&pageSize=10



- **@PostMapping(value = "/structure/orgs/colleges") 新增学院**
  例子：http://47.95.120.250:8080/structure/orgs/colleges
  **body参数**：
  
  ```java
    private Long schoolId;  	//表明该学院属于哪一个学校
    private String collegeName;
    private String collegeDesc;
  ```




- **@PutMapping(value = "/structure/orgs/colleges")  更新学院信息**
  例子：http://47.95.120.250:8080/structure/orgs/colleges 
  **body参数**：
  
  ```java
    private Long id;			//指向更新对象id
    private Long schoolId;		//表明该学院属于哪一个学校
    private String collegeName;
    private String collegeDesc;
  ```





- **@DeleteMapping(value = "/structure/orgs/colleges") 删除学院**
  例子：http://47.95.120.250:8080/structure/orgs/colleges?collegeId=xxxx 
  
  
  
- **@GetMapping(value = "/structure/orgs/colleges")  获取学院**
  例子：http://47.95.120.250:8080/structure/orgs/colleges?schoolId&page=1&pageSize=10
  (根据schoolId获取该学校下所有的学院)



- **@PostMapping(value = "/structure/orgs/majors") 新增专业**
  例子：http://47.95.120.250:8080/structure/orgs/majors
  **body参数**：
  
  ```java
    private Long collegeId;  	//表明该专业属于哪一个学院
    private String majorName;
    private String majorDesc;
  ```




- **@PutMapping(value = "/structure/orgs/majors")  更新专业信息**
  例子：http://47.95.120.250:8080/structure/orgs/majors 
  **body参数**：
  
  ```java
    private Long id;			//指向更新对象id
    private Long collegeId;  	//表明该专业属于哪一个学院
    private String majorName;
    private String majorDesc;
  ```



  

- **@DeleteMapping(value = "/structure/orgs/majors") 删除专业**
  例子：http://47.95.120.250:8080/structure/orgs/majors?majorId=xxxx 
  
  
  
- **@GetMapping(value = "/structure/orgs/majors")  获取专业**
  例子：http://47.95.120.250:8080/structure/orgs/majors?collegeId&page=1&pageSize=10
  (根据collegeId获取该学院下所有的专业)
  
  
  
- **@GetMapping(value = "/structure/orgs/classes")  获取某专业下的课程**
  例子：http://47.95.120.250:8080/structure/orgs/classes?majorId&page=1&pageSize=10
  (根据majorId获取该专业下所有的课程信息,对应的新建课程，更新课程信息时需要加入课程对应的majorId)
  
---
##### 班课创建与班课信息更新  (对之前的补充)

- **/cloudClass (post，创建班课)**
  例子：http://47.95.120.250:8080/cloudClass
  **body参数**：
  
  ```java
  private String className;
  private String teacherName;
  private String grade;
  private String teachingMateria;
  private String school;
  private String college;
  private String lessonStartDate;
  private String lessonEndDate;
  private String introduction;
  
  //以下三个为新增，其实填了majorId就可以，绑定一个课程到对应专业id下
  private Long schoolId;
  private Long collegeId;
  private Long majorId;
  ```

  

- **/cloudClass (put，更新班课信息)**
  例子：http://47.95.120.250:8080/cloudClass?orgCode=xxxx
  **body参数**：
  
  ```java
  private String className;
  private String teacherName;
  private String grade;
  private String teachingMateria;
  private String school;
  private String college;
  private String lessonStartDate;
  private String lessonEndDate;
  private String introduction;
  
  //以下三个为新增，其实填了majorId就可以，绑定一个课程到对应专业id下
  private Long schoolId;
  private Long collegeId;
  private Long majorId;
  ```

---



### 功能更新 2020/5/15
---

- 更新数据字典

- 更新签到功能

- 全部替换为软删除

- 重构了部分数据库表结构

- 引入mybatis-plus，新的代码都使用软删除

  

#### post/get/put/delete示例

---

- **/dataDictionary (delete，删除数据字典数据)**
  
  例子：http://47.95.120.250:8080/dataDictionary?dictName=xxx&dataName=xxx
  
  
  
- **/dataDictionary (put，更新数据字典数据)**
  
  例子：http://47.95.120.250:8080/dataDictionary
  
  **body参数**：
  
  ```java
  private String dictName;
  private String dataName;
  private Long dataOrder;
  private String newDictName;
  private String newDataName;
  ```
  
  
  
- **/dataDictionary (post，插入数据字典数据)**
  
  例子：http://47.95.120.250:8080/dataDictionary
  
  **body参数**：
  
  ```java
  private Long id;
  private String dictName;
  private String dataName;
  private Long dataOrder;
  private Boolean deleted;
  ```
  
  
  
- **/dataDictionary (GetMapping，获得数据字典数据)**
  
  例子：http://47.95.120.250:8080/dataDictionary?getAll=0&dictName=xxxx&dataName=xxxx&page=1&pageSize=10
  
  当**getAll=1**或**dictName为空**时，返回整个数据字典
  
  **dataName为空**时，返回**dictName定义**的整个字典类下的所有数据记录
  
  **dataName非空时**，返回**dictName定义**的整个字典类下的**对dataName模糊匹配**的数据记录



- **/activities (PostMapping，创建活动)**

  例子：http://47.95.120.250:8080/activitie
  
  **body参数**：
  
  ```java
  private Long activityTypeId;		//活动类型，签到为1
  private String answer;				//活动答案：可以是签到顺序，如123456789
  private Integer maxscore;			//活动分数
  private String activityDescription; //活动描述
  private Long orgCode; 				//活动对应的班课号
  ```



- **/activities (GetMapping，获得某班课下所有活动，返回信息包含活动id)**

  例子：http://47.95.120.250:8080/activitie?orgCode=xxxxx



- **/activities (PutMapping，关闭班课活动)**

  例子：http://47.95.120.250:8080/activitie?activityId=xxxxx



- **/activities/records (PostMapping，参加班课活动)**

  例子：http://47.95.120.250:8080/activities/records

  **body参数**：

  ```java
private Long activityId; //活动id
private String answer;   //提交的答案
  ```



- **/activities/records (GetMapping，获取班课活动的参加情况，包括回答错误的记录)**

  例子：http://47.95.120.250:8080/activities/records?activityId=xxxxx&page=1&pageSize=10



---










### 功能更新 2020/4/15
---
- 加入的班课，不再包括创建的班课
- 用户信息更新
- 用户信息查询，
- 加入班课的名片信息从全局用户信息处调取，没有再默认设置



#### 问题说明
---

- **软删除依然没更新**

- **上周signout(post)参数有误，已更新**



#### post/get/put/delete示例

---

- **/user/info (put，更新班级名片信息)**
  例子：http://47.95.120.250:8080/user/info
  
  ```java
  private String nickname;
  private String gender;
  private String profilePhotoUrl;
  private String studentId;
  
  private String school;
  private String major;
  private String education;
  private String college;
  private String birthDate;
  private String address,city,province,nation;
  /*
  * 注：更新头像时，先上传头像，服务器回返回一个头像的资源名，更新信息时将此资源名写入URL
  *（二进制数据没有直接存在SQL中）
  */
  ```
  
- **/user/createdClass (get，获取用户信息，若查询他人信息且他人非好友，则返回有限用户信息)**
  例子：http://47.95.120.250:8080/user/info?userName=somebody
  此处参数userName可不填，默认查询自己
  
---




### 功能更新 2020/4/10

---

- 新增手机绑定用户名，可以通过手机，用户名登录。登录成功返回用户ID（验证码认证暂时关闭，又开启了）

- 判断用户是否存在的接口转移到了/signup/user/下

- 新增用户名合法性检查

- 新增注销功能

- 改用logger，在关键点设置了日志

- 新增数据字典增加、删除、模糊查询（需要提供字典ID）

- 新增创建班课，更新班课信息，删除班课

- 新增加入班课，退出班课

- 新增 ”我加入的班课“ ”我创建的班课“

- 新增查看我加入的班课信息，查看我加入的班课成员信息

- 新增班课成员信息的分页请请求（需要加一个请求页面记录总数的）

  


#### 问题说明
---
- 上述权限控制并不完善，如普通用户可删除班课等等，等到**团**把其他的弄完了，统一补上。

- 部分还不是软删除实现，后面再统一成软删除。

  

#### post/get/put/delete示例

---

- **/signup/user：（get，判断用户是否存在）**
  例子：http://47.95.120.250:8080/signup/user?userName=superAdmin

- **/cloudClass/members (get，获取班课成员)**
  例子：http://47.95.120.250:8080/cloudClass/members?orgCode=10000

- **/cloudClass/members (get，获取班课成员,分页)**
  例子：http://47.95.120.250:8080/cloudClass/members?orgCode=10000&page=1&pageSize=10

- **/cloudClass/members (post，加入班课)**
  例子：http://47.95.120.250:8080/cloudClass/members?orgCode=10000
  
- **/cloudClass/members (delete，退出班课)**
  例子：http://47.95.120.250:8080/cloudClass/members?orgCode=10000
  
- **/cloudClass/members (put，修改成员信息)**
  例子：http://47.95.120.250:8080/cloudClass/members?orgCode=10000
  
  ```java
  private String userClassName;
  private String userClassSchool;
  private String userClassCollege;
  private String userClassMajor;  
  private String userClassNumber; //学号
  //可以任选其中n个，不一定要填满
  ```
  
- **/cloudClass (post，创建班课)**
  例子：http://47.95.120.250:8080/cloudClass
  
  ```java
  private String className;
  private String teacherName;
  private String grade;
  private String teachingMateria;
  private String school;
  private String college;
  private String lessonStartDate;
  private String lessonEndDate;
  private String introduction;
  //可以任选其中n个，不一定要填满
  //返回班课号
  ```
  
- **/cloudClass (get，查看班课信息)**
  例子：http://47.95.120.250:8080/cloudClass?orgCode=10000

- **/cloudClass (put，更新班课信息)**
  例子：http://47.95.120.250:8080/cloudClass?orgCode=10000
  
  ```java
  private String className;
  private String teacherName;
  private String grade;
  private String teachingMateria;
  private String school;
  private String college;
  private String lessonStartDate;
  private String lessonEndDate;
  private String introduction;
  //可以任选其中n个，不一定要填满
  ```
  
- **/cloudClass (delete，删除班课)**
  例子：http://47.95.120.250:8080/cloudClass?orgCode=10000
  
- **/dataDictionary (post，插入字典)**
  例子：http://47.95.120.250:8080/dataDictionary
  
  ```java
  private Long dictCode ;
  private String dictName;
  private Long dataCode;
  private String dataName;
  //可以任选其中n个，不一定要填满
  ```

- **/dataDictionary (get，查看字典)**
  例子：http://47.95.120.250:8080/dataDictionary?dictCode=1000
  
- **/dataDictionary (get，模糊查询字典)**
  例子：http://47.95.120.250:8080/dataDictionary?dictCode=1000&dataName=xxx
  
- **/dataDictionary (delete，删除字典数据)**
  例子：http://47.95.120.250:8080/dataDictionary??dictCode=1000&dataCode=10001
  
- **/profilePhoto (post，上传图片)**
  例子：http://47.95.120.250:8080/profilePhoto
  
  ```java
  private String profilePhoto:[要上传的文件]
  //注意，这个用form-data格式
  //返回图片名，根据这个去服务器下载对应资源
  ```

- **/profilePhoto (get，下载图片)**
  例子：http://47.95.120.250:8080/profilePhoto?profilePhotoName=一个名字

- **/signout (post，注销)**
  例子：http://47.95.120.250:8080/signout
  
  ```java
  private String userName
  ```

- **/user/joinedClass (get，查看加入的班级)**
  例子：http://47.95.120.250:8080/user/joinedClass
  
- **/user/createdClass (get，查看创建的班级)**
  例子：http://47.95.120.250:8080/user/createdClass
  
---





### 功能更新 2020/4/4

---

- 后端+数据库部署上服务器

- 目前的功能：登录，注册，安全控制

- 暂不支持https协议

  


#### 待测试功能

---

* 注册流程（初步）：填写用户名，密码，邮箱，邮箱验证码(2mins)，验证码(1min) -> 验证通过，返回注册成功。
* 登录流程（初步）：填写用户名（**暂不支持邮箱登录**），密码，验证码（1min）->验证通过，返回登录成功
* **暂不支持登出**，只能用另一台设备强行挤下线。
* 移动端和PC端**各**支持最多一台设备同时在线（需要你们测试一下是否有bug）。
* /signup ; /signin ; /verification/code (获取验证码) ; /verification/mail (获取邮件) ； /device (获取设备类型) ; /userExist (判断用户是否存在) ;  以上几个页面允许**未登录**时访问。
* /getRoleList 获取数据库中角色类型 ; /hello 测试用 ； /test1 测试用 ； /halo.html 静态页面 以上仅允许**登录后访问**。



#### post/get/put/delete 示例 (未注明提交于body的都是参数提交)

---

- **/signup: （post）**

  提交信息于body中

  ```java
  "userName":"xxx",
  "password":"xx",
  "email":"xxx", //（必须和请求邮件验证码时的邮箱时一样）
  "mailVerificationCode":"xxx",
  "verificationCode":"xxx"
  ```
- **/signin: （post）**

  提交信息于body中

  ```java
  "userName":"xxx",
  "password":"xxx",
  "verificationCode":"xxx"
  ```

- **/signup/user：（get）**

  例子：http://47.95.120.250:8080/signup/user?userName=superAdmin

- **/verification/mail：（get)**

  例子：http://47.95.120.250:8080/verification/mail?email=123@gmail.com

**其他服务目前直接访问即可**

---

