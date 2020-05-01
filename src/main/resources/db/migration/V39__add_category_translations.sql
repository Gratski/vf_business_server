DELETE FROM category_translation;
DELETE FROM category;
WITH mind AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), yoga AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, m.id
    FROM mind m
    RETURNING *
), mind_translation_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mente e Corpo', 'Descrição de mente e corpo', current_timestamp, current_timestamp
    FROM mind CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_translation_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mente y Cuerpo', 'Descricion', current_timestamp, current_timestamp
    FROM mind CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_translation_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mind and Body', 'Description', current_timestamp, current_timestamp
    FROM mind CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_translation_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Esprit et corps', 'Description FR', current_timestamp, current_timestamp
    FROM mind CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
), yoga_translation_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Descrição', current_timestamp, current_timestamp
    FROM yoga CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), yoga_translation_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Descricion', current_timestamp, current_timestamp
    FROM yoga CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), yoga_translation_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Description', current_timestamp, current_timestamp
    FROM yoga CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), yoga_translation_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Description FR', current_timestamp, current_timestamp
    FROM yoga CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from yoga_translation_fr;