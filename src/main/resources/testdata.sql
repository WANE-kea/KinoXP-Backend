use KinoDatabase;

INSERT INTO role(role_name)
VALUES ('ADMIN');

INSERT INTO role(role_name)
VALUES ('USER');

-- Inserting action category
INSERT INTO categories (id, name)
VALUES (1, 'Action');

-- Inserting drama category
INSERT INTO categories (id, name)
VALUES (2, 'Drama');

-- Inserting comedy category
INSERT INTO categories (id, name)
VALUES (3, 'Comedy');

-- Inserting sci-fi category
INSERT INTO categories (id, name)
VALUES (4, 'Sci-Fi');

-- Inserting horror category
INSERT INTO categories (id, name)
VALUES (5, 'Horror');

-- Inserting romance category
INSERT INTO categories (id, name)
VALUES (6, 'Romance');

-- Inserting documentary category
INSERT INTO categories (id, name)
VALUES (7, 'Documentary');

INSERT INTO theaters (id, name)
VALUES (1, 'Theater 1');

INSERT INTO theaters (id, name)
VALUES (2, 'Theater 2');

INSERT INTO theaters (id, name)
VALUES (3, 'IMAX');

-- Inserting movie data
INSERT INTO movies (age_limit, duration, id, description, poster_base64, poster_url, title, trailer_url)
VALUES (12, 120, 1, 'An action-packed adventure', 'base64encodedimage1', 'https://example.com/poster1.jpg', 'Movie 1', 'https://example.com/trailer1.mp4');

-- Inserting another movie data
INSERT INTO movies (age_limit, duration, id, description, poster_base64, poster_url, title, trailer_url)
VALUES (16, 150, 2, 'A gripping drama', 'base64encodedimage2', 'https://example.com/poster2.jpg', 'Movie 2', 'https://example.com/trailer2.mp4');

-- Inserting a third movie data
INSERT INTO movies (age_limit, duration, id, description, poster_base64, poster_url, title, trailer_url)
VALUES (18, 180, 3, 'A hilarious comedy', 'base64encodedimage3', 'https://example.com/poster3.jpg', 'Movie 3', 'https://example.com/trailer3.mp4');

INSERT INTO movies_categories (categories_id, movies_id)
VALUES (7, 1);

INSERT INTO movies_categories (categories_id, movies_id)
VALUES (5, 2);

INSERT INTO movies_categories (categories_id, movies_id)
VALUES (2, 3);

INSERT INTO movies_categories (categories_id, movies_id)
VALUES (3, 1);

INSERT INTO movies_categories (categories_id, movies_id)
VALUES (3, 2);

-- Inserting a user with roles
INSERT INTO user_with_roles (enabled, created, edited, discriminator_type, email, username, password, country, first_name, last_name, middle_name, phone, street_address, street_no, zip)
VALUES (1, CURRENT_TIMESTAMP, NULL, 'user', 'user1@example.com', 'user1@example.com', 'password123', 'USA', 'John', 'Doe', NULL, '123-456-7890', '123 Main St', 'Apt 101', '12345');

-- Inserting another user with roles
INSERT INTO user_with_roles (enabled, created, edited, discriminator_type, email, username, password, country, first_name, last_name, middle_name, phone, street_address, street_no, zip)
VALUES (1, CURRENT_TIMESTAMP, NULL, 'admin', 'admin@example.com', 'admin@example.com', 'adminpass', 'Canada', 'Admin', 'User', 'X', '987-654-3210', '456 Oak St', 'Suite 202', '56789');

-- Inserting a third user with roles
INSERT INTO user_with_roles (enabled, created, edited, discriminator_type, email, username, password, country, first_name, last_name, middle_name, phone, street_address, street_no, zip)
VALUES (1, CURRENT_TIMESTAMP, NULL, 'user', 'user2@example.com', 'user2@example.com', 'securepass', 'UK', 'Jane', 'Smith', 'E', '345-678-9012', '789 Elm St', NULL, '67890');

-- Inserting show data
INSERT INTO shows (id, movie_id, theater_id, end_time, start_time)
VALUES (1, 1, 1, '2024-03-13 18:30:00', '2024-03-13 15:30:00');

-- Inserting another show data
INSERT INTO shows (id, movie_id, theater_id, end_time, start_time)
VALUES (2, 2, 2, '2024-03-14 21:00:00', '2024-03-14 18:30:00');

-- Inserting a third show data
INSERT INTO shows (id, movie_id, theater_id, end_time, start_time)
VALUES (3, 3, 3, '2024-03-15 15:45:00', '2024-03-15 12:30:00');

INSERT INTO bookings (show_id, id, customer_username)
VALUES (3,'00000000-0000-3100-0000-000000000000', 'user1@example.com');

INSERT INTO bookings (show_id, id, customer_username)
VALUES (1, '00000000-0000-3100-0000-000000000001', 'user1@example.com');

INSERT INTO bookings (show_id, id, customer_username)
VALUES (2, '00000000-0000-3100-0000-000000000002', 'admin@example.com');

INSERT INTO bookings (show_id, id, customer_username)
VALUES (3, '00000000-0000-3100-0000-000000000005', 'user2@example.com');

INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 1, 1, 1, 1);

-- Inserting another seat data
INSERT INTO seats (available,  seat_nr, seat_row, theater_id, type)
VALUES (1, 5, 2, 1, 1);

-- Inserting a third seat data
INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 3, 3, 1, 2);

INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 2, 1, 1, 3);

-- Inserting another seat data
INSERT INTO seats (available,  seat_nr, seat_row, theater_id, type)
VALUES (1, 1, 2, 1, 1);

-- Inserting a third seat data
INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 2, 3, 1, 1);

INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 4, 1, 1, 1);

-- Inserting another seat data
INSERT INTO seats (available,  seat_nr, seat_row, theater_id, type)
VALUES (1, 5, 2, 1, 2);

-- Inserting a third seat data
INSERT INTO seats (available, seat_nr, seat_row, theater_id, type)
VALUES (1, 3, 3, 1, 1);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 1);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 2);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 3);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 4);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 5);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 6);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 7);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 8);

INSERT INTO theaters_seats (theater_id, seats_id)
VALUES (1, 9);

INSERT INTO theaters_shows (theater_id, shows_id)
VALUES (1, 1);

INSERT INTO theaters_shows (theater_id, shows_id)
VALUES (2, 2);

INSERT INTO theaters_shows (theater_id, shows_id)
VALUES (3, 3);

INSERT INTO user_roles (user_username, role_role_name)
VALUES ('user1@example.com', 'USER');

INSERT INTO user_roles (user_username, role_role_name)
VALUES ('user2@example.com', 'USER');

INSERT INTO user_roles (user_username, role_role_name)
VALUES ('admin@example.com', 'ADMIN');

INSERT INTO bookings_seats (booking_id, seats_id)
VALUES ('00000000-0000-3100-0000-000000000000', 1);

INSERT INTO bookings_seats (booking_id, seats_id)
VALUES ('00000000-0000-3100-0000-000000000000', 2);

INSERT INTO bookings_seats (booking_id, seats_id)
VALUES ('00000000-0000-3100-0000-000000000001', 3);

INSERT INTO user_with_roles_bookings (customer_username, bookings_id)
VALUES ('user1@example.com', '00000000-0000-3100-0000-000000000000');

INSERT INTO user_with_roles_bookings (customer_username, bookings_id)
VALUES ('user2@example.com', '00000000-0000-3100-0000-000000000001');