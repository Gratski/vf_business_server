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

CREATE TABLE discipline_repetition (
    id serial primary key,
    discipline_id int not null references discipline(id),
    professor_id int not null references professor(id),
    starts_at timestamp,
    ends_at timestamp,
    enabled boolean default false,
    approved boolean default false,
    created_at timestamp,
	updated_at timestamp
);

ALTER TABLE "class" ADD COLUMN started_at timestamp not null;
ALTER TABLE "class" ADD COLUMN ended_at timestamp;
ALTER TABLE "class" ADD COLUMN created_at timestamp;
ALTER TABLE "class" ADD COLUMN updated_at timestamp;

ALTER TABLE discipline ADD COLUMN enabled boolean default false;

ALTER TABLE class_attendant ADD COLUMN updated_at timestamp;
ALTER TABLE class_attendant ADD COLUMN left_at timestamp;

ALTER TABLE category DROP COLUMN parent;
ALTER TABLE category ADD COLUMN parent_id int references category(id);