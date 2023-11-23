-- PHOTOS
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Afghan Girl', 'Beautiness in poor condition', 'https://richardsonphotos.files.wordpress.com/2016/09/afghan-girl.jpg?w=840', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Famous Hill', 'It could be a memorable wallpaper', 'https://www.hwupgrade.it/i/n/windowsxp_bliss4k_720.jpg', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('The Moon', 'Moon and stars in bright night', 'https://www.hwupgrade.it/i/n/windowsxp_moon_720.jpg', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('The Beach', 'A beautiful beach', 'https://www.hwupgrade.it/i/n/windowsxp_beach_720.jpg', true);

-- USERS
INSERT INTO users (first_name, last_name, email, password) VALUES ('admin', 'test', 'admintest@mail.com', '{noop}password');
INSERT INTO users (first_name, last_name, email, password) VALUES ('user', 'test', 'usertest@mail.com', '{noop}password');

-- ROLES
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

-- USERS_ROLES
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);

-- CATEGORIES
INSERT INTO categories (name) VALUES ('Nature');
INSERT INTO categories (name) VALUES ('Animals');
INSERT INTO categories (name) VALUES ('People');
INSERT INTO categories (name) VALUES ('Cities');
INSERT INTO categories (name) VALUES ('HDR');
INSERT INTO categories (name) VALUES ('Black and White');
INSERT INTO categories (name) VALUES ('Macro');
INSERT INTO categories (name) VALUES ('4K');
INSERT INTO categories (name) VALUES ('Space');
INSERT INTO categories (name) VALUES ('Cars');
INSERT INTO categories (name) VALUES ('Motorcycles');

-- PHOTOS_CATEGORIES
INSERT INTO photos_categories (photo_id, categories_id) VALUES (1, 1);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (2, 1);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (3, 1);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (4, 3);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (2, 3);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (3, 3);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (2, 6);
INSERT INTO photos_categories (photo_id, categories_id) VALUES (3, 6);