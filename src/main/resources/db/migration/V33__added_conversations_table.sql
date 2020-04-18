CREATE TABLE conversation(
    id bigserial primary key,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE conversation_correspondent(
    id bigserial primary key,
    conversation_id bigint not null references conversation(id),
    app_user_id int not null references app_user(id),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE conversation_message(
    id bigserial primary key,
    conversation_id bigint not null references conversation(id),
    sender_id int not null references app_user(id),
    body varchar not null,
    seen boolean default false,
    seen_at timestamp,
    created_at timestamp,
    updated_at timestamp
);