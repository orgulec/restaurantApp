CREATE TABLE IF NOT EXISTS ratings
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id    BIGINT,
    user_id BIGINT,
    rating    INT NOT NULL,
    opinion    TEXT,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
    );