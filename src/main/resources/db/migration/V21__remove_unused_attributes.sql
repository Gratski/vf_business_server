ALTER TABLE app_user DROP COLUMN country_code;

ALTER TABLE language_countries ADD COLUMN created_at timestamp;
ALTER TABLE language_countries ADD COLUMN updated_at timestamp;

ALTER TABLE professor_context_details ADD COLUMN quote varchar(255);

ALTER TABLE app_user ADD COLUMN living_in int references country(id);
ALTER TABLE app_user ADD COLUMN nationality int references country(id);

ALTER TABLE language_context ADD COLUMN is_native bool default false;

CREATE TABLE user_language (
    id serial primary key,
    language_id int references "language"(id),
    app_user_id int references app_user(id),
    created_at timestamp,
    updated_at timestamp
);

ALTER TABLE discipline DROP COLUMN professor;