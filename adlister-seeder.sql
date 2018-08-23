USE adlister_db;

TRUNCATE users;

INSERT INTO users (username, email, password)
  VALUES ('Carl', 'carl@email.com', '1111'),
         ('Nick', 'nick@email.com', '2222'),
         ('Kelly', 'kelly@email.com', '3333');

