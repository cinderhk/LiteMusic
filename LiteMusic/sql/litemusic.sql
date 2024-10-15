/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : litemusic

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 16/10/2024 00:03:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int NOT NULL COMMENT '轮播图Id',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '轮播图地址',
  `priority` int NOT NULL COMMENT '优先级',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, 'https://kwimg4.kuwo.cn/star/upload/87/86/1727496158838_.jpg', 1, NULL);
INSERT INTO `banner` VALUES (2, 'https://kwimg4.kuwo.cn/star/upload/86/43/1727417034869_.jpg', 2, NULL);
INSERT INTO `banner` VALUES (3, 'https://kwimg3.kuwo.cn/star/upload/69/39/1706087266755_.jpg', 3, NULL);
INSERT INTO `banner` VALUES (4, 'https://kwimg1.kuwo.cn/star/upload/73/44/1677749209264_.png', 4, NULL);

-- ----------------------------
-- Table structure for cos_config
-- ----------------------------
DROP TABLE IF EXISTS `cos_config`;
CREATE TABLE `cos_config`  (
  `secretId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secretKey` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bucketName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`secretId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cos_config
-- ----------------------------
INSERT INTO `cos_config` VALUES ('AKID4MZfuor6T6thYen2Yks5HpNuUF1pjuDg', 'kU0b5fM8xw5JdAnJxa5sdSFxfJ7yyywq', 'cinderhk-music-1305037069', 'ap-nanjing');

-- ----------------------------
-- Table structure for music_url
-- ----------------------------
DROP TABLE IF EXISTS `music_url`;
CREATE TABLE `music_url`  (
  `musicrid` bigint NOT NULL COMMENT '音乐ID',
  `type` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型，区分普通用户和vip用户，默认：0，vip：1',
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '音乐url地址',
  PRIMARY KEY (`musicrid`) USING BTREE,
  CONSTRAINT `musicrid` FOREIGN KEY (`musicrid`) REFERENCES `musiclist` (`musicrid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music_url
-- ----------------------------
INSERT INTO `music_url` VALUES (23949811, '0', 'https://cinderhk-music-1305037069.cos.ap-nanjing.myqcloud.com/music/23949811.mp3?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKID4MZfuor6T6thYen2Yks5HpNuUF1pjuDg%26q-sign-time%3D1729007339%3B1729009138%26q-key-time%3D1729007339%3B1729009138%26q-header-list%3Dhost%26q-url-param-list%3Dresponse-cache-control%3Bresponse-content-language%3Bresponse-expires%26q-signature%3D9e87cc86db35b7b58f53f5a68e5684828c10e600&response-cache-control=no-cache&response-content-language=zh-CN&response-expires=Wed%2C%2016%20Oct%202024%2015%3A48%3A58%20GMT');
INSERT INTO `music_url` VALUES (412362550, '0', 'https://cinderhk-music-1305037069.cos.ap-nanjing.myqcloud.com/music/412362550.mp3?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKID4MZfuor6T6thYen2Yks5HpNuUF1pjuDg%26q-sign-time%3D1729007795%3B1729009595%26q-key-time%3D1729007795%3B1729009595%26q-header-list%3Dhost%26q-url-param-list%3Dresponse-cache-control%3Bresponse-content-language%3Bresponse-expires%26q-signature%3D829b337cbd0e3a4f5f2f3b6e0e94c46c238dcedc&response-cache-control=no-cache&response-content-language=zh-CN&response-expires=Wed%2C%2016%20Oct%202024%2015%3A56%3A35%20GMT');

-- ----------------------------
-- Table structure for musiclist
-- ----------------------------
DROP TABLE IF EXISTS `musiclist`;
CREATE TABLE `musiclist`  (
  `musicrid` bigint NOT NULL COMMENT '音乐id\r\n',
  `artist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '音乐家',
  `albumpic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '音乐家图片信息',
  `album` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专辑',
  `song_time_minutes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '播放时长',
  PRIMARY KEY (`musicrid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of musiclist
-- ----------------------------
INSERT INTO `musiclist` VALUES (23949811, '奇然&沈谧仁', 'https://img3.kuwo.cn/star/albumcover/500/94/98/994184522.jpg', '琵琶行', '05:35');
INSERT INTO `musiclist` VALUES (412362550, '清唯', 'http://img4.kuwo.cn/star/albumcover/500/s4s21/21/3423118090.jpg', '秋风吹起', '03:33');

-- ----------------------------
-- Table structure for playlistcard
-- ----------------------------
DROP TABLE IF EXISTS `playlistcard`;
CREATE TABLE `playlistcard`  (
  `id` bigint NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '播放列表卡片标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '播放列表卡片图片的URL',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '播放列表卡片记录的创建时间',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '播放列表卡片歌单信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of playlistcard
-- ----------------------------
INSERT INTO `playlistcard` VALUES (3001661381, '伤感情歌｜不眠夜里的孤单心事', 'https://img1.kuwo.cn/star/userpl2015/98/82/1587870043089_121006198_500.jpg', '2024-10-10 00:17:41', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3398951902, '抖音伤感热歌，留下了太多唏嘘', 'https://img1.kuwo.cn/star/userpl2015/39/46/1662323723429_560479339_500.jpg', '2024-10-09 23:35:42', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3435189575, '抖音甜蜜丨解药和救赎都是你', 'http://img1.kuwo.cn/star/userpl2015/15/52/1673230512699_581806915_500.jpg', '2024-10-02 11:09:07', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3438211961, '抖音热歌集｜超耐听！把美好在线分享', 'https://img1.kuwo.cn/star/userpl2015/79/59/1674029044233_579563879_500.jpg', '2024-10-09 23:33:55', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3460705218, '抖音热歌BGM：一秒心动，紧跟潮流脚步', 'https://img1.kuwo.cn/star/userpl2015/91/54/1681209783556_578116791_500.jpg', '2024-10-09 23:30:27', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3469442273, '抖音伤感｜要不然我们就这样一万年', 'https://img1.kuwo.cn/star/userpl2015/37/83/1684140559969_512270237_500.jpg', '2024-10-09 23:29:22', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3488222466, '旅行，抖音热歌伴游天涯', 'http://img1.kuwo.cn/star/userpl2015/39/70/1690928815658_579499639_500.jpg', '2024-10-02 11:09:44', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3489645011, '心动于前奏响起的一刹那！', 'http://img1.kuwo.cn/star/userpl2015/69/57/1691377851254_436321569_700.jpg', '2024-10-10 23:40:38', '一生只爱一次，一次就是一辈子！');
INSERT INTO `playlistcard` VALUES (3582427861, '[古风戏腔]一曲相思无尽处，戏里戏外无人说', 'http://img1.kuwo.cn/star/userpl2015/27/61/1726802710012_498745627_500.jpg', '2024-09-28 11:46:15', '一生只爱一次，一次就是一辈子！');

-- ----------------------------
-- Table structure for playlistinfo
-- ----------------------------
DROP TABLE IF EXISTS `playlistinfo`;
CREATE TABLE `playlistinfo`  (
  `id` bigint NULL DEFAULT NULL,
  `musicrid` bigint NOT NULL,
  INDEX `musicrid_`(`musicrid`) USING BTREE,
  CONSTRAINT `musicrid_` FOREIGN KEY (`musicrid`) REFERENCES `musiclist` (`musicrid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of playlistinfo
-- ----------------------------
INSERT INTO `playlistinfo` VALUES (3001661381, 412362550);
INSERT INTO `playlistinfo` VALUES (3001661381, 23949811);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户邮箱',
  `password_hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码哈希值',
  `gender` enum('male','female','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `signup_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册日期',
  `status` enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'active' COMMENT '用户账户状态',
  `type` int NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'dxy', 'dxy@gmail.com', '$2a$10$t49.EqzzZiQpTE/fosTVaeyNWjy3Nr5EbbPM9Nrsn/cdnjMRM5eQy', 'male', '2024-09-28 11:22:33', 'active', 0);

SET FOREIGN_KEY_CHECKS = 1;
