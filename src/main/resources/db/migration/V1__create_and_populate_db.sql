# create database if not exists excity;

DROP TABLE IF EXISTS `activity_type`;
CREATE TABLE `activity_type`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `activity_type`
VALUES (1, 'diy'),
       (2, 'education'),
       (3, 'recreational'),
       (4, 'social'),
       (5, 'charity'),
       (6, 'cooking'),
       (7, 'relaxation'),
       (8, 'music'),
       (9, 'work'),
       (10, 'music');

DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`
(
    `id`              int          NOT NULL AUTO_INCREMENT,
    `description`     varchar(255) NOT NULL,
    `people_required` int          NOT NULL,
    `price`           double DEFAULT NULL,
    `type_id`         int    DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK7l4mcncnm7e79vrhklj7tnuox` (`type_id`),
    CONSTRAINT `FK7l4mcncnm7e79vrhklj7tnuox` FOREIGN KEY (`type_id`) REFERENCES `activity_type` (`id`)
);

INSERT INTO `activity`
VALUES (1, 'Learn JavaScript', 1, 0, 2),
       (2, 'Learn to greet someone in a new language', 1, 0, 2),
       (3, 'Learn to order food in a new language', 1, 0, 2),
       (4, 'Call a friend you have not talked to in a while', 2, 0, 4),
       (5, 'Do a DIY crafts project', 1, 100, 1),
       (6, 'Volunteer at a local blood donation drive', 1, 0, 5),
       (7, 'Volunteer at a local animal shelter', 1, 0, 5),
       (8, 'Volunteer at a local orphanage', 1, 0, 5),
       (9, 'Volunteer at a local old age home', 1, 0, 5),
       (10, 'Bake some biscuits for your friends and family', 1, 400, 6),
       (11, 'Make a chicken sandwich', 1, 30, 6),
       (12, 'Learn a new recipe', 1, 430, 6),
       (13, 'Make homemade ice cream', 1, 150, 6),
       (14, 'Cook something with your partner', 2, 600, 6),
       (15, 'Bake a cake with your friends', 3, 1000, 6),
       (16, 'Make a dish from a foreign culture', 1, 380, 6),
       (17, 'Prepare a meal plan for the next week', 1, 0, 6),
       (18, 'Take your pet on a walk', 2, 0, 7),
       (19, 'Go on a long drive with your partner', 2, 500, 7),
       (20, 'Go to the salon and treat yourself', 1, 1000, 7),
       (21, 'Learn how to play cricket', 1, 300, 3),
       (22, 'Go to a local concert with your friends', 3, 1500, 4),
       (23, 'Wash your car', 1, 20, 9),
       (24, 'Chop veggies for your meals for the entire week', 1, 330, 6),
       (25, 'Listen to your favourite song', 1, 14, 8),
       (26, 'Clean the refrigerator', 1, 0, 9),
       (27, 'Remove unused applications from your phone', 1, 0, 9),
       (28, 'Shred the old documents that you don\'t need anymore', 1, 0, 9),
       (29, 'Set up 2FA on all of your online accounts', 1, 0, 9),
       (30, 'Organize your books', 1, 0, 9),
       (31, 'Organize your drawer', 1, 0, 9),
       (32, 'Back up important files on your computer', 1, 0, 9),
       (33, 'Organize your cupboard', 1, 0, 9),
       (34, 'Donate your old clothes to a charity', 1, 50, 5),
       (35, 'Donate to your local food bank', 1, 90, 5),
       (36, 'Learn to play the flute', 1, 500, 8),
       (37, 'Visit your teachers at your old school', 1, 0, 4),
       (38, 'Watch a movie with your friends', 4, 1200, 4);