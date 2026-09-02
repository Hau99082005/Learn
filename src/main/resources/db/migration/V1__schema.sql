-- Create users_catalogues table first (referenced by users table)
CREATE TABLE users_catalogues(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE(name),
    CHECK(CHAR_LENGTH(name) >= 3 AND CHAR_LENGTH(name) <= 50)
);

-- Create users table
CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firebase_uid VARCHAR(255) NOT NULL,
    user_catalogue_id BIGINT DEFAULT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    images VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE(email),
    UNIQUE(username),
    UNIQUE(phone),
    UNIQUE(images),
    UNIQUE(firebase_uid),
    CHECK (CHAR_LENGTH(phone) >= 10 AND CHAR_LENGTH(phone) <= 20),
    CHECK (CHAR_LENGTH(username) >= 3 AND CHAR_LENGTH(username) <= 255),
    CHECK (CHAR_LENGTH(password) >= 8 AND CHAR_LENGTH(password) <= 255),
    CHECK (CHAR_LENGTH(address) >= 5 AND CHAR_LENGTH(address) <= 255),
    CHECK (CHAR_LENGTH(images) >= 5 AND CHAR_LENGTH(images) <= 255),
    CHECK (CHAR_LENGTH(firebase_uid) >= 5 AND CHAR_LENGTH(firebase_uid) <= 255),
    CONSTRAINT fk_user_catalogue_id FOREIGN KEY(user_catalogue_id) REFERENCES users_catalogues(id) ON DELETE SET NULL ON UPDATE CASCADE
);