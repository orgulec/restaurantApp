CREATE TABLE IF NOT EXISTS users
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname    VARCHAR(128) NOT NULL,
    lastname    VARCHAR(128) NOT NULL,
    login    VARCHAR(128) NOT NULL,
    password    VARCHAR(128) NOT NULL,
    email    VARCHAR(128) NOT NULL,
    restaurant_owner    BOOLEAN NOT NULL DEFAULT FALSE,
    restaurant_id  BIGINT
--     FOREIGN KEY (restaurant_id) REFERENCES restaurans (id)
    );