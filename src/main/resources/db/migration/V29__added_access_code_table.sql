CREATE TABLE access_code(
    id serial primary key,
    email varchar(255) unique not null,
    code varchar(50) not null,
    created_at timestamp,
    updated_at timestamp
);

ALTER TABLE app_user ADD COLUMN referred_by int references app_user(id);