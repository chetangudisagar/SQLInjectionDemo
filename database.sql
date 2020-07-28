CREATE DATABASE demo;

CREATE TABLE login (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL,
  Password varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY username (username)
);


INSERT INTO login (username,Password) VALUES ('user1','password1');
INSERT INTO login (username,Password) VALUES ('user2','password2');
INSERT INTO login (username,Password) VALUES ('user3','password3');
INSERT INTO login (username,Password) VALUES ('user4','password4');
INSERT INTO login (username,Password) VALUES ('user5','password5');