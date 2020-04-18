CREATE TABLE feed_notification (
    id bigserial primary key,
    seen boolean default false,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE class_feed_notification (
    id bigint not null references feed_notification(id),
    notification_type varchar(25) not null,
    class_id int not null references "class"(id),
    app_user_id int not null references app_user(id),
    message varchar(255)
);

CREATE TABLE message_feed_notification (
    id bigint not null references feed_notification(id),
    app_user_id int not null references app_user(id),
    conversation_id bigint not null references conversation(id),
    message varchar(255) not null
);

CREATE TABLE system_feed_notification (
    id bigint not null references feed_notification(id),
    title varchar(150) not null,
    sub_title varchar(150),
    body varchar(255) not null
);