DROP INDEX `account_unique_index_passport` ON `acmedcare_account`;
DROP INDEX `account_query_index_status` ON `acmedcare_account`;

DROP TABLE `acmedcare_account`;

CREATE TABLE `acmedcare_account` (
`pkid` bigint(32) NOT NULL COMMENT '代理主键',
`passport` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '通行证账号',
`username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
`password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码(加密)',
`salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码加密盐',
`status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'ENABLED' COMMENT '账户状态',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`upgrade_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`pkid`) ,
UNIQUE INDEX `account_unique_index_passport` (`passport` ASC),
INDEX `account_query_index_status` (`status` ASC)
)
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci
COMMENT = 'Acmedcare+ Account Table';
