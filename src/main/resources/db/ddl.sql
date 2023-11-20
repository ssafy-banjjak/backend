DROP TABLE IF EXISTS `attraction`;

CREATE TABLE `attraction`
(
    `attraction_id`      BIGINT PRIMARY KEY AUTO_INCREMENT,
    `region`             VARCHAR(255) NULL,
    `name`               VARCHAR(255) NULL,
    `description`        VARCHAR(255) NULL,
    `location_latitude`  DECIMAL(20, 17) NULL,
    `location_longitude` DECIMAL(20, 17) NULL,
    `type`               VARCHAR(255) NULL,
    `image`              VARCHAR(255) NULL,
    `tel`                VARCHAR(255) NULL
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `user_id`     BIGINT PRIMARY KEY AUTO_INCREMENT,
    `username`    VARCHAR(255) NULL,
    `password`    VARCHAR(255) NULL,
    `nickname`    VARCHAR(255) NULL,
    `name`        VARCHAR(255) NULL,
    `region`      VARCHAR(255) NULL,
    `create_date` TIMESTAMP NULL
);

DROP TABLE IF EXISTS `short`;

CREATE TABLE `short`
(
    `short_id`    BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id`     BIGINT NOT NULL,
    `region`      VARCHAR(255) NULL,
    `title`       VARCHAR(255) NULL,
    `content`     VARCHAR(255) NULL,
    `like`        INT NULL,
    `dislike`     INT NULL,
    `create_date` TIMESTAMP NULL,
    `file_path`   VARCHAR(255) NULL,
    `thumbnail`   VARCHAR(255) NULL
);

DROP TABLE IF EXISTS post_user;

CREATE TABLE `post_member`
(
    `post_member_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `post_id`        BIGINT NOT NULL,
    `user_id`        BIGINT NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post`
(
    `post_id`     BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id`     BIGINT NOT NULL,
    `region`      VARCHAR(255) NULL,
    `title`       VARCHAR(255) NULL,
    `content`     VARCHAR(255) NULL,
    `recruits`    INT NULL,
    `date_time`   TIMESTAMP NULL,
    `place`       VARCHAR(255) NULL,
    `create_date` TIMESTAMP NULL
);

DROP TABLE IF EXISTS `post_attraction`;

CREATE TABLE `post_attraction`
(
    `post_attraction_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `attraction_id`      BIGINT NOT NULL,
    `post_id`            BIGINT NOT NULL
);

ALTER TABLE `short`
    ADD CONSTRAINT `FK_user_TO_short_1` FOREIGN KEY (
                                                     `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );

ALTER TABLE post_user
    ADD CONSTRAINT `FK_post_TO_post_member_1` FOREIGN KEY (
                                                           `post_id`
        )
        REFERENCES `post` (
                           `post_id`
            );

ALTER TABLE post_user
    ADD CONSTRAINT `FK_user_TO_post_member_1` FOREIGN KEY (
                                                           `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );

ALTER TABLE `post`
    ADD CONSTRAINT `FK_user_TO_post_1` FOREIGN KEY (
                                                    `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );

ALTER TABLE `post_attraction`
    ADD CONSTRAINT `FK_attraction_TO_post_attraction_1` FOREIGN KEY (
                                                                     `attraction_id`
        )
        REFERENCES `attraction` (
                                 `attraction_id`
            );

ALTER TABLE `post_attraction`
    ADD CONSTRAINT `FK_post_TO_post_attraction_1` FOREIGN KEY (
                                                               `post_id`
        )
        REFERENCES `post` (
                           `post_id`
            );

