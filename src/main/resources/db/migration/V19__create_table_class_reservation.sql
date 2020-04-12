CREATE TABLE class_reservation (
    id serial primary key,
    discipline_class int references "class"(id),
    student int references student(id),
    created_at timestamp not null,
    updated_at timestamp
);

ALTER TABLE discipline ADD COLUMN max_attendants int default 0;
ALTER TABLE app_user ADD COLUMN picture_url varchar(255);