CREATE TABLE IF NOT EXISTS country_translations(
    id serial primary key not null,
    country_id int not null references country(id),
    language_id int not null references "language"(id),
    language_code varchar(5) not null
);