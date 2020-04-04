/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/3/24 23:35:48                           */
/*==============================================================*/


drop table if exists activity_type;

drop index idx_org_id on announcement;

drop table if exists announcement;

drop table if exists authorization;

drop table if exists auz_type;

drop index idx_discussion_id on comment;

drop table if exists comment;

drop index idx_dict_code on data_dictionary;

drop table if exists data_dictionary;

drop index idx_task_id on discussion;

drop index idx_org_id on discussion;

drop table if exists discussion;

drop table if exists discussion_file;

drop table if exists file_type;

drop index idx_org_id on group;

drop index idx_group_plan_id on group;

drop table if exists group;

drop index idx_org_id on group_plan;

drop table if exists group_plan;

drop table if exists menu;

drop index uk_org_code on org;

drop table if exists org;

drop table if exists org_file;

drop index idx_org_id on org_msg;

drop table if exists org_msg;

drop table if exists org_role;

drop index idx_activity_id on participate_in_activity;

drop table if exists participate_in_activity;

drop index idx_org_id on published_activity;

drop table if exists published_activity;

drop index idx_org_id on published_task;

drop table if exists published_task;

drop index index_org_id on r_org__file;

drop index index_org_file_id on r_org__file;

drop table if exists r_org__file;

drop index index_org_role_id on r_org_role__auz;

drop index index_auz_id on r_org_role__auz;

drop table if exists r_org_role__auz;

drop index index_org_role_id on r_org_role__menu;

drop index index_menu_id on r_org_role__menu;

drop table if exists r_org_role__menu;

drop index index_role_id on r_role__auz;

drop index index_auz_id on r_role__auz;

drop table if exists r_role__auz;

drop index index_menu_id on r_role__menu;

drop index index_role_id on r_role__menu;

drop table if exists r_role__menu;

drop index Index_group_id on r_user__group;

drop index index_user_id on r_user__group;

drop table if exists r_user__group;

drop index Index_org_id on r_user__org;

drop index index_user_id on r_user__org;

drop table if exists r_user__org;

drop index index_user_id on r_user__org_role;

drop index index_org_role_id on r_user__org_role;

drop table if exists r_user__org_role;

drop index index_user_id on r_user__user_msg;

drop index index_umsg_id on r_user__user_msg;

drop table if exists r_user__user_msg;

drop table if exists rich_text;

drop table if exists role;

drop index idx_user_id on signin_history;

drop table if exists signin_history;

drop index idx_task_id on submit_task;

drop table if exists submit_task;

drop index idx_user_id on sys_log;

drop table if exists sys_log;

drop index idx_submit_task_id on task_file;

drop table if exists task_file;

drop table if exists task_type;

drop index idx_user_id on temp_file;

drop table if exists temp_file;

drop table if exists user;

drop table if exists user_msg;

drop index idx_user_id on user_org_info;

drop table if exists user_org_info;

/*==============================================================*/
/* Table: activity_type                                         */
/*==============================================================*/
create table activity_type
(
   activity_type_id     bigint not null auto_increment,
   activity_type_code   bigint not null,
   activity_type_order  int not null,
   activity_type_name   varchar(20) not null,
   activity_type_description varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (activity_type_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: announcement                                          */
/*==============================================================*/
create table announcement
(
   annc_id              bigint not null auto_increment,
   org_id               bigint not null,
   annc_content         varchar(200) not null,
   publihser            varchar(20) not null,
   publisher_nickname   varchar(20),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (annc_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on announcement
(
   org_id
);

/*==============================================================*/
/* Table: authorization                                         */
/*==============================================================*/
create table authorization
(
   authorization_id     bigint not null auto_increment,
   auz_type_id          bigint not null,
   auz_code             bigint not null,
   parent_auz_id        bigint,
   auz_level            int,
   auz_order            int not null,
   auz_name             varchar(20) not null,
   auz_url              varchar(200),
   auz_param            varchar(200),
   auz_description      varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (authorization_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: auz_type                                              */
/*==============================================================*/
create table auz_type
(
   auz_type_id          bigint not null auto_increment,
   auz_type_code        bigint not null,
   auz_type_order       int not null,
   auz_type_name        varchar(20) not null,
   auz_type_desc        varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (auz_type_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comment_id           bigint not null,
   discussion_id        bigint not null,
   reply_id             bigint,
   quote_id             bigint,
   rich_text            bigint not null,
   author_nickname      varchar(20),
   comment_level        int not null,
   comment_order        int not null,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (comment_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_discussion_id                                     */
/*==============================================================*/
create index idx_discussion_id on comment
(
   discussion_id
);

/*==============================================================*/
/* Table: data_dictionary                                       */
/*==============================================================*/
create table data_dictionary
(
   record_id            bigint not null auto_increment,
   dict_code            bigint not null,
   dict_name            varchar(20) not null,
   dict_description     varchar(200),
   data_code            bigint,
   data_name            varchar(20) not null,
   data_order           int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (record_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_dict_code                                         */
/*==============================================================*/
create index idx_dict_code on data_dictionary
(
   dict_code
);

/*==============================================================*/
/* Table: discussion                                            */
/*==============================================================*/
create table discussion
(
   discussion_id        bigint not null auto_increment,
   org_id               bigint,
   task_id              bigint,
   discussion_type_code bigint,
   discussion_type_name varchar(20),
   discussion_title     varchar(200) not null,
   author_nickname      varchar(20),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (discussion_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on discussion
(
   org_id
);

/*==============================================================*/
/* Index: idx_task_id                                           */
/*==============================================================*/
create index idx_task_id on discussion
(
   task_id
);

/*==============================================================*/
/* Table: discussion_file                                       */
/*==============================================================*/
create table discussion_file
(
   discussion_file_id   bigint not null,
   file_type_id         bigint not null,
   file_name            varchar(20) not null,
   file_url             varchar(200),
   file_binary          mediumblob,
   file_hash            varchar(200),
   uploader             varchar(20) not null,
   download_count       int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (discussion_file_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: file_type                                             */
/*==============================================================*/
create table file_type
(
   file_type_id         bigint not null,
   file_type_code       bigint not null,
   file_type_name       varchar(20) not null,
   file_type_desc       varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (file_type_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: group                                                 */
/*==============================================================*/
create table group
(
   group_id             bigint not null auto_increment,
   org_id               bigint not null,
   group_plan_id        bigint,
   group_code           bigint not null,
   parent_group_id      bigint,
   is_root              bool,
   group_name           varchar(20) not null,
   group_type_code      bigint,
   group_type_name      varchar(20),
   group_description    varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (group_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_group_plan_id                                     */
/*==============================================================*/
create index idx_group_plan_id on group
(
   group_plan_id
);

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on group
(
   org_id
);

/*==============================================================*/
/* Table: group_plan                                            */
/*==============================================================*/
create table group_plan
(
   group_plan_id        bigint not null,
   org_id               bigint not null,
   group_plan_name      varchar(20) not null,
   group_plan_order     int not null,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (group_plan_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on group_plan
(
   org_id
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_id              bigint not null auto_increment,
   menu_code            bigint not null,
   menu_type_code       int not null,
   parent_menu_id       bigint,
   menu_level           int,
   menu_order           int not null,
   is_root              bool,
   menu_name            varchar(20) not null,
   menu_url             varchar(200),
   menu_description     varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (menu_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   org_id               bigint not null auto_increment,
   org_code             bigint not null,
   parent_org_id        bigint,
   is_root              bool,
   org_name             varchar(20) not null,
   org_description      varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (org_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: uk_org_code                                           */
/*==============================================================*/
create unique index uk_org_code on org
(
   org_code
);

/*==============================================================*/
/* Table: org_file                                              */
/*==============================================================*/
create table org_file
(
   org_file_id          bigint not null auto_increment,
   file_type_id         bigint not null,
   parent_file_id       bigint,
   file_name            varchar(30) not null,
   file_url             varchar(200),
   file_binary          mediumblob,
   file_level           int,
   file_hash            varchar(200),
   uploader             varchar(20) not null,
   download_count       int not null,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (org_file_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: org_msg                                               */
/*==============================================================*/
create table org_msg
(
   omsg_id              bigint not null auto_increment,
   org_id               bigint not null,
   msg_content          bigint not null,
   sender               varchar(20) not null,
   sender_nickname      varchar(20),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (omsg_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on org_msg
(
   org_id
);

/*==============================================================*/
/* Table: org_role                                              */
/*==============================================================*/
create table org_role
(
   org_role_id          bigint not null auto_increment,
   org_role_template_id bigint,
   is_template          bool not null,
   org_role_template_order int,
   org_role_code        bigint not null,
   org_role_name        varchar(20) not null,
   org_role_description varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (org_role_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: participate_in_activity                               */
/*==============================================================*/
create table participate_in_activity
(
   participate_in_activity_id bigint not null auto_increment,
   activity_id          bigint not null,
   user_id              bigint,
   group_id             bigint,
   submit_param         varchar(200),
   edit_times           int not null,
   score                int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (participate_in_activity_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_activity_id                                       */
/*==============================================================*/
create index idx_activity_id on participate_in_activity
(
   activity_id
);

/*==============================================================*/
/* Table: published_activity                                    */
/*==============================================================*/
create table published_activity
(
   activity_id          bigint not null auto_increment,
   activity_type_id     bigint not null,
   org_id               bigint not null,
   group_plan_id        bigint,
   activity_name        varchar(20),
   is_active            bool not null,
   activity_description varchar(200),
   activity_param       varchar(200),
   begin_date           datetime not null,
   end_date             datetime,
   maxscore             int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (activity_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on published_activity
(
   org_id
);

/*==============================================================*/
/* Table: published_task                                        */
/*==============================================================*/
create table published_task
(
   task_id              bigint not null auto_increment,
   org_id               bigint not null,
   task_type_id         bigint not null,
   group_plan_id        bigint,
   task_name            varchar(20) not null,
   publisher_name       varchar(20) not null,
   begin_date           datetime not null,
   end_date             datetime not null,
   maxscore             int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (task_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_org_id                                            */
/*==============================================================*/
create index idx_org_id on published_task
(
   org_id
);

/*==============================================================*/
/* Table: r_org__file                                           */
/*==============================================================*/
create table r_org__file
(
   org__org_file_id     bigint not null,
   org_id               bigint not null,
   org_file_id          bigint not null,
   primary key (org__org_file_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_org_file_id                                     */
/*==============================================================*/
create index index_org_file_id on r_org__file
(
   org_file_id
);

/*==============================================================*/
/* Index: index_org_id                                          */
/*==============================================================*/
create index index_org_id on r_org__file
(
   org_id
);

/*==============================================================*/
/* Table: r_org_role__auz                                       */
/*==============================================================*/
create table r_org_role__auz
(
   org_role__auz_id     bigint not null,
   org_role_id          bigint not null,
   authorization_id     bigint not null,
   primary key (org_role__auz_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_auz_id                                          */
/*==============================================================*/
create index index_auz_id on r_org_role__auz
(
   authorization_id
);

/*==============================================================*/
/* Index: index_org_role_id                                     */
/*==============================================================*/
create index index_org_role_id on r_org_role__auz
(
   org_role_id
);

/*==============================================================*/
/* Table: r_org_role__menu                                      */
/*==============================================================*/
create table r_org_role__menu
(
   org_role__menu_id    bigint not null,
   org_role_id          bigint not null,
   menu_id              bigint not null,
   primary key (org_role__menu_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_menu_id                                         */
/*==============================================================*/
create index index_menu_id on r_org_role__menu
(
   menu_id
);

/*==============================================================*/
/* Index: index_org_role_id                                     */
/*==============================================================*/
create index index_org_role_id on r_org_role__menu
(
   org_role_id
);

/*==============================================================*/
/* Table: r_role__auz                                           */
/*==============================================================*/
create table r_role__auz
(
   role__auz_id         bigint not null,
   role_id              bigint not null,
   authorization_id     bigint not null,
   primary key (role__auz_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_auz_id                                          */
/*==============================================================*/
create index index_auz_id on r_role__auz
(
   authorization_id
);

/*==============================================================*/
/* Index: index_role_id                                         */
/*==============================================================*/
create index index_role_id on r_role__auz
(
   role_id
);

/*==============================================================*/
/* Table: r_role__menu                                          */
/*==============================================================*/
create table r_role__menu
(
   role__menu_id        bigint not null,
   role_id              bigint not null,
   menu_id              bigint not null,
   primary key (role__menu_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_role_id                                         */
/*==============================================================*/
create index index_role_id on r_role__menu
(
   role_id
);

/*==============================================================*/
/* Index: index_menu_id                                         */
/*==============================================================*/
create index index_menu_id on r_role__menu
(
   menu_id
);

/*==============================================================*/
/* Table: r_user__group                                         */
/*==============================================================*/
create table r_user__group
(
   user__group_id       bigint not null auto_increment,
   user_id              bigint not null,
   group_id             bigint not null,
   primary key (user__group_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_user_id                                         */
/*==============================================================*/
create index index_user_id on r_user__group
(
   user_id
);

/*==============================================================*/
/* Index: Index_group_id                                        */
/*==============================================================*/
create index Index_group_id on r_user__group
(
   group_id
);

/*==============================================================*/
/* Table: r_user__org                                           */
/*==============================================================*/
create table r_user__org
(
   user__org_id         bigint not null auto_increment,
   user_id              bigint not null,
   org_id               bigint not null,
   primary key (user__org_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_user_id                                         */
/*==============================================================*/
create index index_user_id on r_user__org
(
   user_id
);

/*==============================================================*/
/* Index: Index_org_id                                          */
/*==============================================================*/
create index Index_org_id on r_user__org
(
   org_id
);

/*==============================================================*/
/* Table: r_user__org_role                                      */
/*==============================================================*/
create table r_user__org_role
(
   user__org_role_id    bigint not null,
   user_id              bigint not null,
   org_role_id          bigint not null,
   primary key (user__org_role_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_org_role_id                                     */
/*==============================================================*/
create index index_org_role_id on r_user__org_role
(
   org_role_id
);

/*==============================================================*/
/* Index: index_user_id                                         */
/*==============================================================*/
create index index_user_id on r_user__org_role
(
   user_id
);

/*==============================================================*/
/* Table: r_user__user_msg                                      */
/*==============================================================*/
create table r_user__user_msg
(
   user__umsg_id        bigint not null,
   user_id              bigint not null,
   umsg_id              bigint not null,
   primary key (user__umsg_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: index_umsg_id                                         */
/*==============================================================*/
create index index_umsg_id on r_user__user_msg
(
   umsg_id
);

/*==============================================================*/
/* Index: index_user_id                                         */
/*==============================================================*/
create index index_user_id on r_user__user_msg
(
   user_id
);

/*==============================================================*/
/* Table: rich_text                                             */
/*==============================================================*/
create table rich_text
(
   rich_text_id         bigint not null,
   rich_text            text,
   rich_text_type_code  bigint,
   rich_text_type_name  varchar(20),
   primary key (rich_text_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              bigint not null auto_increment,
   role_template_id     bigint,
   is_template          bool not null,
   role_template_order  int,
   role_code            bigint not null,
   role_name            varchar(20) not null,
   role_description     varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (role_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: signin_history                                        */
/*==============================================================*/
create table signin_history
(
   signin_history_id    bigint not null auto_increment,
   user_id              bigint not null,
   signin_ip            varchar(20),
   signin_date          datetime not null,
   signout_date         datetime,
   device_type          int not null,
   device_mac           varchar(20),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (signin_history_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_user_id                                           */
/*==============================================================*/
create index idx_user_id on signin_history
(
   user_id
);

/*==============================================================*/
/* Table: submit_task                                           */
/*==============================================================*/
create table submit_task
(
   submit_task_id       bigint not null auto_increment,
   task_id              bigint not null,
   user_id              bigint,
   group_id             bigint,
   submit_content       varchar(500) not null,
   submit_type          int not null,
   uploader             varchar(20) not null,
   edit_times           int not null,
   score                int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (submit_task_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_task_id                                           */
/*==============================================================*/
create index idx_task_id on submit_task
(
   task_id
);

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   sys_log_id           bigint not null auto_increment,
   user_id              bigint not null,
   op_type              int not null,
   op_description       varchar(200),
   op_time              datetime not null,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (sys_log_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_user_id                                           */
/*==============================================================*/
create index idx_user_id on sys_log
(
   user_id
);

/*==============================================================*/
/* Table: task_file                                             */
/*==============================================================*/
create table task_file
(
   task_file_id         bigint not null,
   file_type_id         bigint not null,
   submit_task_id       bigint not null,
   file_name            varchar(20) not null,
   file_url             varchar(200),
   file_binary          mediumblob,
   file_hash            varchar(200),
   uploader             varchar(20) not null,
   download_count       int,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (task_file_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_submit_task_id                                    */
/*==============================================================*/
create index idx_submit_task_id on task_file
(
   submit_task_id
);

/*==============================================================*/
/* Table: task_type                                             */
/*==============================================================*/
create table task_type
(
   task_type_id         bigint not null auto_increment,
   task_type_code       bigint not null,
   task_type_order      int not null,
   task_name            varchar(20) not null,
   task_type_description varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (task_type_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: temp_file                                             */
/*==============================================================*/
create table temp_file
(
   temp_file_id         bigint not null,
   user_id              bigint not null,
   file_type_id         bigint not null,
   file_name            varchar(20) not null,
   file_url             varchar(200),
   file_binary          mediumblob,
   file_hash            varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (temp_file_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_user_id                                           */
/*==============================================================*/
create index idx_user_id on temp_file
(
   user_id
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              bigint not null auto_increment,
   role_id              bigint not null,
   username             varchar(20) not null,
   password             varchar(200) not null,
   nickname             varchar(20),
   phone                varchar(20),
   email                varchar(20),
   school               varchar(20),
   education            varchar(20),
   birth_date           varchar(20),
   major                varchar(20),
   gender               char(1),
   address              varchar(60),
   city                 varchar(20),
   province             varchar(20),
   nation               varchar(20),
   profile_photo        mediumblob,
   experience           int,
   coin                 int,
   signin_date          datetime,
   signup_date          datetime,
   last_signin_date     datetime,
   sign_count           int,
   continue_signin_count int,
   is_active            bool not null,
   unlock_date          datetime,
   is_signin            bool,
   mobile_token         varchar(100),
   mobile_token_create_date datetime,
   mobile_token_end_date datetime,
   web_token            varchar(100),
   web_token_create_date datetime,
   web_token_end_date   datetime,
   pc_token             varchar(100),
   pc_token_create_date datetime,
   pc_token_end_date    datetime,
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (user_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_email                                             */
/*==============================================================*/
create index idx_email on user
(
   email
);

/*==============================================================*/
/* Index: idx_phone                                             */
/*==============================================================*/
create index idx_phone on user
(
   phone
);

/*==============================================================*/
/* Index: idx_username                                          */
/*==============================================================*/
create unique index idx_username on user
(
   username
);


/*==============================================================*/
/* Table: user_msg                                              */
/*==============================================================*/
create table user_msg
(
   umsg_id              bigint not null auto_increment,
   msg_content          bigint not null,
   sender               varchar(20) not null,
   sender_nickname      varchar(20),
   receiver             varchar(20) not null,
   receiver_nickname    varchar(20),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (umsg_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Table: user_org_info                                         */
/*==============================================================*/
create table user_org_info
(
   user_org_info_id     bigint not null auto_increment,
   user_id              bigint not null,
   user_org_name        varchar(20),
   user_org_exp         int,
   use_org_coin         int,
   user_org_score       int,
   user_org_signin_score int,
   user_org_school      varchar(20),
   user_org_college     varchar(20),
   user_org_major       varchar(20),
   user_org_desc        varchar(200),
   extend_json          bigint,
   creation_date        datetime not null,
   creator              varchar(20),
   last_modification_date datetime,
   last_modifier        varchar(20),
   is_deleted           bool not null,
   deletion_date        datetime,
   deleter              varchar(20),
   primary key (user_org_info_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 ;

/*==============================================================*/
/* Index: idx_user_id                                           */
/*==============================================================*/
create index idx_user_id on user_org_info
(
   user_id
);


