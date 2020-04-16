CREATE TABLE support_contact (
    id varchar(255) primary key not null,
    sent_by int not null references app_user(id),
    message varchar(255) not null,
    subject varchar(50) not null,
    viewed boolean default false,
    solved boolean default false,
    comment varchar,
    created_at timestamp,
    update_at timestamp
);