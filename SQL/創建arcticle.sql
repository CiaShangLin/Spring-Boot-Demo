CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(30) NOT NULL COMMENT '文章標題',
  `content` varchar(10000) NOT NULL COMMENT '文章內容',
  `cover_img` varchar(128) NOT NULL COMMENT '文章封面',
  `state` varchar(3) DEFAULT '草稿' COMMENT '文章狀態',
  `category_id` int unsigned DEFAULT NULL COMMENT '文章分類id',
  `create_user` int unsigned NOT NULL COMMENT '創建人id',
  `create_time` datetime NOT NULL COMMENT '創建時間',
  `update_time` datetime NOT NULL COMMENT '修改時間',
  PRIMARY KEY (`id`),
  KEY `fk_article_category` (`category_id`),
  KEY `fk_article_user` (`create_user`),
  CONSTRAINT `fk_article_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_article_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci