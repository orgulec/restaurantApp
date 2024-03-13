CREATE TABLE IF NOT EXISTS reservations
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT NOT NULL,
    restaurant_id    BIGINT NOT NULL,
    reservation_date    DATE NOT NULL,
    reservation_hour  INT,
    reservation_status  ENUM('ACCEPTED','REJECTED','WAITING','CLOSED'),
    seats_number  INT,
    tables_number  INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id)
    );