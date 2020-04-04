create table app_user(
	id serial primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	email varchar(255) not null unique,
	pwd varchar(255) not null,
	active bool default false,
	enabled bool default true,
	created_at timestamp,
	updated_at timestamp
);

create table student(
	id integer primary key not null references app_user(id)
);


create table student_preferences(
	id integer primary key not null references student(id),
	start_notifications_active bool default false
);

create table professor(
	id integer primary key not null references app_user(id),
	description varchar(255)
);

create table category(
	id serial primary key,
	designation varchar(255) not null,
	description varchar(255) not null,
	image_url varchar(255)
);

alter table category add column parent integer not null references category(id);

create table discipline(
	id serial primary key,
	category integer not null references category(id),
	professor integer not null references professor(id),
	designation varchar(255) not null,
	description varchar(255) not null,
	scheduled_to timestamp not null,
	on_repeat bool default false,
	image_url varchar(255) not null,
	active bool default true
);

create table "class" (
	id serial primary key,
	discipline integer not null references discipline(id),
	professor integer not null references professor(id)
);

create table class_attendant(
	id serial primary key,
	student integer not null references student(id),
	"class" integer not null references "class"(id),
	created_at timestamp not null
);

create table class_review (
	id bigserial primary key,
	class_attendant integer not null references class_attendant(id),
	"class" integer not null references "class"(id),
	review integer not null,
	created_at timestamp not null
);

create table professor_review (
	id bigserial primary key,
	class_attendant integer not null references class_attendant(id),
	professor integer not null references professor(id),
	review int not null,
	created_at timestamp
);

create table class_comment (
	id bigserial primary key,
	attendant integer not null references class_attendant(id),
	comment_value varchar(255) not null,
	created_at timestamp
);

create table discipline_like (
	id bigserial primary key,
	student integer not null references student(id),
	discipline integer not null references discipline(id),
	created_at timestamp
);

create table save_seat(
	id serial primary key,
	student integer not null references student(id),
	"class" integer not null references "class"(id),
	created_at timestamp
);

create table class_report(
	id serial primary key,
	app_user integer not null references app_user(id),
	"class" integer not null references "class"(id),
	motive varchar(255) not null,
	reviewed bool default false,
	created_at timestamp
);

create table class_comment_report (
	id serial primary key,
	app_user integer not null references app_user(id),
	class_comment integer not null references class_comment(id),
	motive varchar(255) not null,
	reviewed bool default false,
	created_at timestamp
);


create table recover_token(
	app_user integer not null references app_user(id),
	active_token varchar(255) not null,
	created_at timestamp
);