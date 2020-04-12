CREATE TABLE country(
    id serial primary key,
    country_code varchar(2) unique not null default '',
    country_name varchar(100) not null default '',
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE "language"(
    id serial primary key,
    language_name varchar(150) not null,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE language_countries(
    id serial primary key,
    language_id int references "language"(id),
    country_id int references country(id)
);

CREATE TABLE professor_context_details (
    id serial primary key,
    designation varchar(255) not null,
    description varchar(255),
    picture_url varchar(255),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE language_context(
    id serial primary key,
    language_id int references "language"(id),
    professor_id int references professor(id),
    created_at timestamp,
    updated_at timestamp
);

ALTER TABLE professor_context_details ADD COLUMN language_context_id int references language_context(id);

-- Add language_context to Discilpine
ALTER TABLE discipline ADD COLUMN language_context_id int references language_context(id);

INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AF', 'Afghanistan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AL', 'Albania', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DZ', 'Algeria', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DS', 'American Samoa', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AD', 'Andorra', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AO', 'Angola', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AI', 'Anguilla', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AQ', 'Antarctica', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AG', 'Antigua and Barbuda', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AR', 'Argentina', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AM', 'Armenia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AW', 'Aruba', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AU', 'Australia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AT', 'Austria', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AZ', 'Azerbaijan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BS', 'Bahamas', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BH', 'Bahrain', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BD', 'Bangladesh', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BB', 'Barbados', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BY', 'Belarus', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BE', 'Belgium', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BZ', 'Belize', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BJ', 'Benin', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BM', 'Bermuda', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BT', 'Bhutan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BO', 'Bolivia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BA', 'Bosnia and Herzegovina', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BW', 'Botswana', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BV', 'Bouvet Island', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BR', 'Brazil', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IO', 'British Indian Ocean Territory', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BN', 'Brunei Darussalam', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BG', 'Bulgaria', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BF', 'Burkina Faso', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('BI', 'Burundi', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KH', 'Cambodia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CM', 'Cameroon', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CA', 'Canada', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CV', 'Cape Verde', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KY', 'Cayman Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CF', 'Central African Republic', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TD', 'Chad', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CL', 'Chile', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CN', 'China', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CX', 'Christmas Island', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CC', 'Cocos (Keeling) Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CO', 'Colombia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KM', 'Comoros', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CD', 'Democratic Republic of the Congo', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CG', 'Republic of Congo', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CK', 'Cook Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CR', 'Costa Rica', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HR', 'Croatia (Hrvatska)', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CU', 'Cuba', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CY', 'Cyprus', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CZ', 'Czech Republic', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DK', 'Denmark', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DJ', 'Djibouti', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DM', 'Dominica', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DO', 'Dominican Republic', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TP', 'East Timor', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('EC', 'Ecuador', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('EG', 'Egypt', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SV', 'El Salvador', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GQ', 'Equatorial Guinea', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ER', 'Eritrea', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('EE', 'Estonia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ET', 'Ethiopia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FK', 'Falkland Islands (Malvinas)', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FO', 'Faroe Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FJ', 'Fiji', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FI', 'Finland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FR', 'France', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FX', 'France, Metropolitan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GF', 'French Guiana', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PF', 'French Polynesia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TF', 'French Southern Territories', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GA', 'Gabon', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GM', 'Gambia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GE', 'Georgia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('DE', 'Germany', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GH', 'Ghana', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GI', 'Gibraltar', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GK', 'Guernsey', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GR', 'Greece', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GL', 'Greenland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GD', 'Grenada', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GP', 'Guadeloupe', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GU', 'Guam', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GT', 'Guatemala', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GN', 'Guinea', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GW', 'Guinea-Bissau', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GY', 'Guyana', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HT', 'Haiti', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HM', 'Heard and Mc Donald Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HN', 'Honduras', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HK', 'Hong Kong', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('HU', 'Hungary', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IS', 'Iceland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IN', 'India', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IM', 'Isle of Man', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ID', 'Indonesia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IR', 'Iran (Islamic Republic of)', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IQ', 'Iraq', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IE', 'Ireland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IL', 'Israel', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('IT', 'Italy', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CI', 'Ivory Coast', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('JE', 'Jersey', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('JM', 'Jamaica', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('JP', 'Japan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('JO', 'Jordan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KZ', 'Kazakhstan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KE', 'Kenya', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KI', 'Kiribati', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KP', 'Korea, Democratic People''s Republic of', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KR', 'Korea, Republic of', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('XK', 'Kosovo', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KW', 'Kuwait', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KG', 'Kyrgyzstan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LA', 'Lao People''s Democratic Republic', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LV', 'Latvia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LB', 'Lebanon', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LS', 'Lesotho', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LR', 'Liberia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LY', 'Libyan Arab Jamahiriya', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LI', 'Liechtenstein', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LT', 'Lithuania', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LU', 'Luxembourg', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MO', 'Macau', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MK', 'North Macedonia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MG', 'Madagascar', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MW', 'Malawi', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MY', 'Malaysia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MV', 'Maldives', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ML', 'Mali', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MT', 'Malta', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MH', 'Marshall Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MQ', 'Martinique', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MR', 'Mauritania', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MU', 'Mauritius', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TY', 'Mayotte', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MX', 'Mexico', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('FM', 'Micronesia, Federated States of', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MD', 'Moldova, Republic of', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MC', 'Monaco', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MN', 'Mongolia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ME', 'Montenegro', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MS', 'Montserrat', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MA', 'Morocco', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MZ', 'Mozambique', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MM', 'Myanmar', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NA', 'Namibia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NR', 'Nauru', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NP', 'Nepal', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NL', 'Netherlands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AN', 'Netherlands Antilles', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NC', 'New Caledonia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NZ', 'New Zealand', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NI', 'Nicaragua', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NE', 'Niger', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NG', 'Nigeria', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NU', 'Niue', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NF', 'Norfolk Island', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('MP', 'Northern Mariana Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('NO', 'Norway', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('OM', 'Oman', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PK', 'Pakistan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PW', 'Palau', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PS', 'Palestine', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PA', 'Panama', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PG', 'Papua New Guinea', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PY', 'Paraguay', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PE', 'Peru', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PH', 'Philippines', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PN', 'Pitcairn', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PL', 'Poland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PT', 'Portugal', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PR', 'Puerto Rico', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('QA', 'Qatar', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('RE', 'Reunion', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('RO', 'Romania', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('RU', 'Russian Federation', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('RW', 'Rwanda', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('KN', 'Saint Kitts and Nevis', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LC', 'Saint Lucia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VC', 'Saint Vincent and the Grenadines', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('WS', 'Samoa', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SM', 'San Marino', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ST', 'Sao Tome and Principe', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SA', 'Saudi Arabia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SN', 'Senegal', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('RS', 'Serbia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SC', 'Seychelles', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SL', 'Sierra Leone', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SG', 'Singapore', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SK', 'Slovakia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SI', 'Slovenia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SB', 'Solomon Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SO', 'Somalia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ZA', 'South Africa', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GS', 'South Georgia South Sandwich Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SS', 'South Sudan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ES', 'Spain', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('LK', 'Sri Lanka', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SH', 'St. Helena', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('PM', 'St. Pierre and Miquelon', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SD', 'Sudan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SR', 'Suriname', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SJ', 'Svalbard and Jan Mayen Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SZ', 'Swaziland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SE', 'Sweden', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('CH', 'Switzerland', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('SY', 'Syrian Arab Republic', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TW', 'Taiwan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TJ', 'Tajikistan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TZ', 'Tanzania, United Republic of', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TH', 'Thailand', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TG', 'Togo', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TK', 'Tokelau', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TO', 'Tonga', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TT', 'Trinidad and Tobago', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TN', 'Tunisia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TR', 'Turkey', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TM', 'Turkmenistan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TC', 'Turks and Caicos Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('TV', 'Tuvalu', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('UG', 'Uganda', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('UA', 'Ukraine', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('AE', 'United Arab Emirates', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('GB', 'United Kingdom', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('US', 'United States', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('UM', 'United States minor outlying islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('UY', 'Uruguay', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('UZ', 'Uzbekistan', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VU', 'Vanuatu', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VA', 'Vatican City State', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VE', 'Venezuela', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VN', 'Vietnam', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VG', 'Virgin Islands (British)', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('VI', 'Virgin Islands (U.S.)', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('WF', 'Wallis and Futuna Islands', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('EH', 'Western Sahara', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('YE', 'Yemen', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ZM', 'Zambia', current_timestamp, current_timestamp);
INSERT INTO country(country_code, country_name, created_at, updated_at) VALUES ('ZW', 'Zimbabwe', current_timestamp, current_timestamp);