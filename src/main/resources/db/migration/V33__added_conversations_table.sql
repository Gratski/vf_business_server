CREATE TABLE conversation(
    id serial primary key,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE conversation_correspondent(
    id serial primary key,
    conversation_id int not null references conversation(id),
    app_user_id int not null references app_user(id),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE conversation_message(
    id serial primary key,
    conversation_id int not null references conversation(id),
    sender_id int not null references app_user(id),
    body varchar not null,
    seen boolean default false,
    seen_at timestamp,
    created_at timestamp,
    updated_at timestamp
);