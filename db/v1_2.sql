ALTER TABLE professor ADD COLUMN nif varchar(255) not null;

CREATE TABLE picture(
    id serial primary key,
	designation varchar(255) not null,
    extension varchar(10) not null,
	created_at timestamp,
	updated_at timestamp
);

ALTER TABLE category ADD COLUMN picture_id int references picture(id);
ALTER TABLE category ADD COLUMN icon varchar(50);
ALTER TABLE category ADD COLUMN created_at timestamp;
ALTER TABLE category ADD COLUMN updated_at timestamp;