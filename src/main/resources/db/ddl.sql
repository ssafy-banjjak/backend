create table attraction
(
    attraction_id bigint auto_increment
        primary key,
    region        varchar(255)    null,
    name          varchar(255)    null,
    description   varchar(255)    null,
    latitude      decimal(20, 17) null,
    longitude     decimal(20, 17) null,
    type          varchar(255)    null,
    image         varchar(255)    null,
    tel           varchar(255)    null
);

create table user
(
    user_id       bigint auto_increment
        primary key,
    username      varchar(255) null,
    password      varchar(255) null,
    nickname      varchar(255) null,
    name          varchar(255) null,
    region        varchar(255) null,
    create_date   timestamp    null,
    refresh_token varchar(255) null
);

create table post
(
    post_id     bigint auto_increment
        primary key,
    user_id     bigint       not null,
    region      varchar(255) null,
    title       varchar(255) null,
    content     varchar(255) null,
    recruits    int          null,
    date_time   timestamp    null,
    place       varchar(255) null,
    create_date timestamp    null,
    constraint FK_user_TO_post_1
        foreign key (user_id) references user (user_id)
);

create table post_attraction
(
    post_attraction_id bigint auto_increment
        primary key,
    attraction_id      bigint not null,
    post_id            bigint not null,
    constraint FK_attraction_TO_post_attraction_1
        foreign key (attraction_id) references attraction (attraction_id),
    constraint FK_post_TO_post_attraction_1
        foreign key (post_id) references post (post_id)
);

create table post_user
(
    post_user_id bigint auto_increment
        primary key,
    post_id      bigint not null,
    user_id      bigint not null,
    constraint FK_post_TO_post_member_1
        foreign key (post_id) references post (post_id),
    constraint FK_user_TO_post_member_1
        foreign key (user_id) references user (user_id)
);

create table short
(
    short_id    bigint auto_increment
        primary key,
    user_id     bigint        not null,
    region      varchar(255)  null,
    title       varchar(255)  null,
    content     varchar(255)  null,
    `like`      int default 0 null,
    dislike     int default 0 null,
    create_date timestamp     null,
    file_path   varchar(255)  null,
    thumbnail   varchar(255)  null,
    constraint FK_user_TO_short_1
        foreign key (user_id) references user (user_id)
);

