ALTER TABLE category DROP COLUMN designation;
ALTER TABLE category DROP COLUMN description;

CREATE TABLE category_translation (
    id serial primary key,
    category_id int not null references category(id),
    language_id int not null references "language"(id),
    designation varchar(150) not null,
    description varchar(255) not null,
    created_at timestamp,
    updated_at timestamp
);

ALTER TABLE "language" DROP COLUMN language_name;
ALTER TABLE "language" ADD COLUMN code varchar(10) unique not null;
ALTER TABLE "language" ADD COLUMN system_language boolean default false;

CREATE TABLE language_translation(
    id serial primary key,
    language_id int not null references "language"(id),
    code varchar(10) not null,
    designation varchar(100) not null
);