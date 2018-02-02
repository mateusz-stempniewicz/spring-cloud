/*CREATE TABLE oauth_access_token ( token_id VARCHAR(255), token LONG VARBINARY, authentication_id VARCHAR(255) PRIMARY KEY, user_name VARCHAR(255), client_id VARCHAR(255), authentication LONG VARBINARY, refresh_token VARCHAR(255) ); CREATE TABLE oauth_refresh_token ( token_id VARCHAR(255), token LONG VARBINARY, authentication LONG VARBINARY );*/

/*
CREATE TABLE `users` (
  `email` VARCHAR(254) NOT NULL PRIMARY KEY,
  `passwordHash` VARCHAR(60) NOT NULL,
  `token` VARCHAR(65) NULL,
  `active` BOOL NOT NULL DEFAULT 0,
  `deleted` BOOL NOT NULL DEFAULT 0
);

INSERT INTO `users` (`email`,`passwordHash`,`active`) VALUES 
	('admin@admin.pl', '$2a$10$d8gv6jyA/He8va6QMSEEmuwpQM1XFKgEgj8TTGxJ13lHBQ6ftT9Bm', 1), -- password is 'admin'
	('test@test.pl', '$2a$10$u3AJC2e8fQ7bapCZh6I6Re4siOLimyBkPp.E//Ae07CSdW1SrRrFu', 1); -- password is 'test'
*/