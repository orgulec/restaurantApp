CREATE TABLE IF NOT EXISTS restaurants
(
    id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(128) NOT NULL,
    user_id    BIGINT,
    address_id    BIGINT,
--     reservations BIGINT ARRAY,
    type    ENUM('POLISH','AMERICAN','CHINESE','ARABIC','FRENCH','JAPANESE','VIETNAMESE','MEXICAN','PIZZA','KEBAB','SUSHI','BURGER','ITALIAN','OTHER'),
    description TEXT,
    seats_number  INT,
    tables_number  INT,
    open_from  VARCHAR(128),
    open_to  VARCHAR(128),
    phone  VARCHAR(12),
--     ratings BIGINT ARRAY,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (address_id) REFERENCES address (id)
    );