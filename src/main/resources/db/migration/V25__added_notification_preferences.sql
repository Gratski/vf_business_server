CREATE TABLE notification_preference (
    id serial primary key,
    notification_type varchar(20) not null,
    app_user_id int not null references app_user(id),
    enabled boolean not null default false,
    created_at timestamp not null,
    updated_at timestamp not null
);