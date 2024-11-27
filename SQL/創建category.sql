CREATE TABLE `category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_alisa` varchar(32) NOT NULL COMMENT '分類名稱',
  `create_user` int unsigned NOT NULL COMMENT '創建人ID',
  `create_time` datetime NOT NULL COMMENT '創建時間',
  `update_time` datetime NOT NULL COMMENT '修改時間',
  PRIMARY KEY (`id`),
  KEY `fk_category_user` (`create_user`),
  CONSTRAINT `fk_category_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci