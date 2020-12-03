-- Adminer 4.7.7 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `emoji`;
CREATE TABLE `emoji` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `characters` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `emoji`;
INSERT INTO `emoji` (`id`, `code`, `characters`) VALUES
(1,	'grin',	'😀'),
(2,	'sweat',	'😅'),
(3,	'joy',	'😂'),
(4,	'rofl',	'🤣'),
(5,	'smile',	'🙂'),
(6,	'wink',	'😉'),
(7,	'innocent',	'😇'),
(8,	'heart_eyes',	'😍'),
(9,	'kissing_heart',	'😘'),
(10,	'yum',	'😋'),
(11,	'tongue',	'😛'),
(12,	'crazy',	'🤪'),
(13,	'hug',	'🤗'),
(14,	'shush',	'🤫'),
(15,	'thinking',	'🤔'),
(16,	'raised_eyebrow',	'🤨'),
(17,	'neutral',	'😐'),
(18,	'smirk',	'😏'),
(19,	'unamused',	'😒'),
(20,	'rolling_eyes',	'🙄'),
(21,	'relieved',	'😌'),
(22,	'pensive',	'😔'),
(23,	'sleepy',	'😪'),
(24,	'confused',	'😕');

DROP TABLE IF EXISTS `emoji_tags`;
CREATE TABLE `emoji_tags` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emoji_id` int(10) unsigned NOT NULL,
  `tag_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `emoji_id` (`emoji_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `emoji_tags_ibfk_1` FOREIGN KEY (`emoji_id`) REFERENCES `emoji` (`id`) ON DELETE CASCADE,
  CONSTRAINT `emoji_tags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `emoji_tags`;
INSERT INTO `emoji_tags` (`id`, `emoji_id`, `tag_id`) VALUES
(1,	1,	1),
(2,	2,	1),
(3,	3,	1),
(4,	4,	1),
(5,	5,	1),
(6,	6,	1),
(7,	7,	1),
(8,	8,	1),
(9,	9,	1),
(10,	10,	1),
(11,	11,	1),
(12,	12,	1),
(13,	13,	1),
(14,	14,	1),
(15,	15,	1),
(16,	16,	1),
(17,	17,	1),
(18,	18,	1),
(19,	19,	1),
(20,	20,	1),
(21,	21,	1),
(22,	22,	1),
(23,	23,	1),
(24,	24,	1),
(25,	1,	2),
(26,	2,	2),
(27,	3,	2),
(28,	4,	2),
(29,	5,	2),
(30,	6,	2),
(31,	7,	2),
(32,	8,	2),
(33,	9,	2),
(34,	10,	2),
(35,	11,	2),
(36,	12,	2),
(37,	13,	2),
(38,	1,	3),
(39,	2,	3),
(40,	3,	3),
(41,	4,	3),
(42,	5,	3),
(43,	6,	3),
(44,	7,	3),
(45,	8,	3),
(46,	9,	3),
(47,	10,	3),
(48,	13,	3),
(49,	18,	3),
(50,	3,	4),
(51,	4,	4),
(52,	11,	4),
(53,	12,	4),
(54,	8,	5),
(55,	9,	5),
(56,	13,	5),
(57,	14,	6),
(58,	15,	6),
(59,	16,	6),
(60,	17,	6),
(61,	18,	6),
(62,	19,	6),
(63,	20,	6),
(64,	21,	6),
(65,	22,	6),
(66,	23,	6),
(67,	24,	6);

DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tags`;
INSERT INTO `tags` (`id`, `name`) VALUES
(1,	'face'),
(2,	'happy'),
(3,	'smile'),
(4,	'laugh'),
(5,	'love'),
(6,	'sad');

-- 2020-12-02 16:15:36