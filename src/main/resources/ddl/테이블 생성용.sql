USE jpa;

CREATE TABLE `user2` (
	`user_id` 	INT(11) 			NOT NULL AUTO_INCREMENT,
	`user_nm` 	VARCHAR(100) 	NULL 		DEFAULT NULL,
	`user_pwd` 	VARCHAR(255) 	NULL 		DEFAULT NULL,
	`del_yn`		BOOLEAN			NOT NULL DEFAULT 0,
	`reg_date` 	DATETIME 		NULL 		DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (`user_id`) USING BTREE,
	UNIQUE INDEX `iUser2UserNm` (`user_nm`) USING BTREE
);

CREATE TABLE `role2` (
	`role_no` 	INT(11) 		NOT NULL AUTO_INCREMENT,
	`role_nm` 	VARCHAR(20) NULL 		DEFAULT NULL,
	PRIMARY KEY (`role_no`) USING BTREE
);

CREATE TABLE `board2` (
	`board_no` 			INT(11) 			NOT NULL AUTO_INCREMENT,
	`board_title` 		VARCHAR(100) 	NOT NULL,
	`board_content` 	TINYTEXT 		NULL 		DEFAULT NULL,
	`del_yn`				BOOLEAN			NOT NULL DEFAULT 0,
	`reg_date` 			DATETIME 		NULL 		DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (`board_no`) USING BTREE
);

SHOW TABLES;

INSERT INTO role2 (`role_nm`) VALUES ('ADMIN');
INSERT INTO role2 (`role_nm`) VALUES ('DEVELOPER');
INSERT INTO role2 (`role_nm`) VALUES ('USER');

INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('관리자','ADMIN', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('개발자','DEV', NOW());
INSERT INTO user2 (`user_nm`, `user_pwd`,`reg_date`) VALUES ('사용자','USER', NOW());

COMMIT;

SELECT * FROM user2;
SELECT * FROM role2;
SELECT * FROM board2;
