t_group
t_published_task
t_published_activity

t_user_msg 插入可触发 
r_user__user_msg

t_org 插入可触发(最复杂的)
r_user__org 
t_org_role(可能创建角色)
r_org_role__auz (若创建角色需创建组角色权限关系)
r_org_role__menu(若创建角色需创建组角色菜单关系)
r_user__org_role
t_user_org_info(用户组信息)

t_group 插入可触发
r_user__group

t_role 插入可触发
r_role__menu
r_role__auz

t_org_role 插入可触发
r_org_role__menu
r_org_role__auz



powerdesigner 没有找到在改成聚集索引的。

所有代码建议环成mysql8的innoDB，好像是在创建表后面跟一句engineering...
t_data_dictonary 考虑建聚集索引





修改记录

1.删除了所有外键

2.建表方式全部修改为 ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

3.group是关键字，修改表**gourp**表名为**org_group**

2020/3/27