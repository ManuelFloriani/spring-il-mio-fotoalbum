-- PHOTOS
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Afghan Girl', 'Beautiness in poor condition', 'https://richardsonphotos.files.wordpress.com/2016/09/afghan-girl.jpg?w=840', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Famous Hill', 'It could be a memorable wallpaper', 'https://www.hwupgrade.it/i/n/windowsxp_bliss4k_720.jpg', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('War is over', 'Happiness for the end of the war', 'https://phototraces.b-cdn.net/wp-content/uploads/2019/10/id_Iconic_Images_Alfred_Eisenstaedt_V-J_Day_in_Times_Square.jpg', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Cross on the stripes', '4 random people cross the road', 'https://cdn.catawiki.net/assets/marketing/uploads-files/46881-a1b23282e88b18c0f713b0ddd2cf2e6785c19267-story_inline_image.jpg', true);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('Tongue out', 'What a physic!', 'https://www.invaluable.com/blog/wp-content/uploads/sites/77/2023/01/Einstein-670x981.jpg', false);
INSERT INTO photos (title, description, image_url, visibility) VALUES ('History was made', 'And then sadly deleted', 'https://zupimages.net/up/21/32/wpxw.jpg', true);



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

-- MESSAGES
INSERT INTO messages (body, sender_email) VALUES ('Ciao!', 'ciao@mail.it');