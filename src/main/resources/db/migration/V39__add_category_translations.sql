DELETE FROM category_translation;
DELETE FROM category;

-- DANCE
WITH danca AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), danca_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança', 'Descrição', current_timestamp, current_timestamp
    FROM danca CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danza', 'Descricion', current_timestamp, current_timestamp
    FROM danca CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance', 'Description', current_timestamp, current_timestamp
    FROM danca CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danse', 'Description', current_timestamp, current_timestamp
    FROM danca CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE SAMBA
danca_samba AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_samba_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Samba', 'Descrição', current_timestamp, current_timestamp
    FROM danca_samba CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_samba_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Samba', 'Descricion', current_timestamp, current_timestamp
    FROM danca_samba CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_samba_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Samba', 'Description', current_timestamp, current_timestamp
    FROM danca_samba CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_samba_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Samba', 'Description', current_timestamp, current_timestamp
    FROM danca_samba CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE SALSA
danca_salsa AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_salsa_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Salsa', 'Descrição', current_timestamp, current_timestamp
    FROM danca_salsa CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_salsa_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Salsa', 'Descricion', current_timestamp, current_timestamp
    FROM danca_salsa CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_salsa_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Salsa', 'Description', current_timestamp, current_timestamp
    FROM danca_salsa CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_salsa_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Salsa', 'Description', current_timestamp, current_timestamp
    FROM danca_salsa CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE LATIN DANCE
danca_latina AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_latina_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança Latina', 'Descrição', current_timestamp, current_timestamp
    FROM danca_latina CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_latina_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Baile Latino', 'Descricion', current_timestamp, current_timestamp
    FROM danca_latina CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_latina_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Latin Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_latina CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_latina_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danse Latine', 'Description', current_timestamp, current_timestamp
    FROM danca_latina CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE SEMBA
danca_semba AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_semba_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Semba', 'Descrição', current_timestamp, current_timestamp
    FROM danca_semba CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_semba_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Semba', 'Descricion', current_timestamp, current_timestamp
    FROM danca_semba CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_semba_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Semba', 'Description', current_timestamp, current_timestamp
    FROM danca_semba CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_semba_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Semba', 'Description', current_timestamp, current_timestamp
    FROM danca_semba CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE KRUMP
danca_krump AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_krump_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krump', 'Descrição', current_timestamp, current_timestamp
    FROM danca_krump CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_krump_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krump', 'Descricion', current_timestamp, current_timestamp
    FROM danca_krump CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_krump_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krump', 'Description', current_timestamp, current_timestamp
    FROM danca_krump CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_krump_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krump', 'Description', current_timestamp, current_timestamp
    FROM danca_krump CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE HITTING
danca_hitting AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_hitting_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hitting', 'Descrição', current_timestamp, current_timestamp
    FROM danca_hitting CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_hitting_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hitting', 'Descricion', current_timestamp, current_timestamp
    FROM danca_hitting CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_hitting_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hitting', 'Description', current_timestamp, current_timestamp
    FROM danca_hitting CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_hitting_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hitting', 'Description', current_timestamp, current_timestamp
    FROM danca_hitting CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE FLOOR WORK
danca_floor_work AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_floor_work_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Floor Work', 'Descrição', current_timestamp, current_timestamp
    FROM danca_floor_work CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_floor_work_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Floor Work', 'Descricion', current_timestamp, current_timestamp
    FROM danca_floor_work CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_floor_work_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Floor Work', 'Description', current_timestamp, current_timestamp
    FROM danca_floor_work CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_floor_work_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Floor Work', 'Description', current_timestamp, current_timestamp
    FROM danca_floor_work CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE FLOOR BAR
danca_floor_bar AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_floor_bar_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barra de Chão', 'Descrição', current_timestamp, current_timestamp
    FROM danca_floor_bar CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_floor_bar_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barra de Piso', 'Descricion', current_timestamp, current_timestamp
    FROM danca_floor_bar CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_floor_bar_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Floor Bar', 'Description', current_timestamp, current_timestamp
    FROM danca_floor_bar CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_floor_bar_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bar de Plancher', 'Description', current_timestamp, current_timestamp
    FROM danca_floor_bar CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE GIPSY
danca_ciganas AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_ciganas_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danças Ciganas', 'Descrição', current_timestamp, current_timestamp
    FROM danca_ciganas CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_ciganas_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bailes Gitanos', 'Descricion', current_timestamp, current_timestamp
    FROM danca_ciganas CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_ciganas_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Gispy Dances', 'Description', current_timestamp, current_timestamp
    FROM danca_ciganas CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_ciganas_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Gipsy Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_ciganas CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE ZUMBA
danca_zumba AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_zumba_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba', 'Descrição', current_timestamp, current_timestamp
    FROM danca_zumba CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_zumba_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba', 'Descricion', current_timestamp, current_timestamp
    FROM danca_zumba CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_zumba_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba', 'Description', current_timestamp, current_timestamp
    FROM danca_zumba CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_zumba_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba', 'Description', current_timestamp, current_timestamp
    FROM danca_zumba CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE SPATEADO
danca_sapateado AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_sapateado_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sapateado', 'Descrição', current_timestamp, current_timestamp
    FROM danca_sapateado CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_sapateado_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tap Dance', 'Descricion', current_timestamp, current_timestamp
    FROM danca_sapateado CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_sapateado_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tap Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_sapateado CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_sapateado_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tap Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_sapateado CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE KUDURO
danca_kuduro AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_kuduro_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kuduro', 'Descrição', current_timestamp, current_timestamp
    FROM danca_kuduro CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_kuduro_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kuduro', 'Descricion', current_timestamp, current_timestamp
    FROM danca_kuduro CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_kuduro_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kuduro', 'Description', current_timestamp, current_timestamp
    FROM danca_kuduro CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_kuduro_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kuduro', 'Description', current_timestamp, current_timestamp
    FROM danca_kuduro CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE Hip Hop Fusion
danca_fusion_hiphop AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_fusion_hiphop_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Fusão', 'Descrição', current_timestamp, current_timestamp
    FROM danca_fusion_hiphop CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_fusion_hiphop_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Fusión', 'Descricion', current_timestamp, current_timestamp
    FROM danca_fusion_hiphop CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_fusion_hiphop_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Fusion', 'Description', current_timestamp, current_timestamp
    FROM danca_fusion_hiphop CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_fusion_hiphop_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Fusion', 'Description', current_timestamp, current_timestamp
    FROM danca_fusion_hiphop CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE HALL
danca_hall AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_hall_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Hall', 'Descrição', current_timestamp, current_timestamp
    FROM danca_hall CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_hall_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Hall', 'Descricion', current_timestamp, current_timestamp
    FROM danca_hall CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_hall_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Hall', 'Description', current_timestamp, current_timestamp
    FROM danca_hall CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_hall_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Hall', 'Description', current_timestamp, current_timestamp
    FROM danca_hall CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE AFRO HOUSE
danca_afro_house AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_afro_house_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Afro House', 'Descrição', current_timestamp, current_timestamp
    FROM danca_afro_house CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_afro_house_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Afro House', 'Descricion', current_timestamp, current_timestamp
    FROM danca_afro_house CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_afro_house_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Afro House', 'Description', current_timestamp, current_timestamp
    FROM danca_afro_house CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_afro_house_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Afro House', 'Description', current_timestamp, current_timestamp
    FROM danca_afro_house CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE ORIENTAL
danca_oriental AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_oriental_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança Oriental', 'Descrição', current_timestamp, current_timestamp
    FROM danca_oriental CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_oriental_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danza Oriental', 'Descricion', current_timestamp, current_timestamp
    FROM danca_oriental CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_oriental_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Oriental Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_oriental CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_oriental_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danse Orientale', 'Description', current_timestamp, current_timestamp
    FROM danca_oriental CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE VENTRE
danca_ventre AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_ventre_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança do Ventre', 'Descrição', current_timestamp, current_timestamp
    FROM danca_ventre CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_ventre_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danza del Vientre', 'Descricion', current_timestamp, current_timestamp
    FROM danca_ventre CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_ventre_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Belly Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_ventre CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_ventre_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danse Femme', 'Description', current_timestamp, current_timestamp
    FROM danca_ventre CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE VENTRE
danca_waaking AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_waaking_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Waaking', 'Descrição', current_timestamp, current_timestamp
    FROM danca_waaking CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_waaking_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Waaking', 'Descricion', current_timestamp, current_timestamp
    FROM danca_waaking CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_waaking_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Waaking', 'Description', current_timestamp, current_timestamp
    FROM danca_waaking CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_waaking_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Waaking', 'Description', current_timestamp, current_timestamp
    FROM danca_waaking CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE POPPING
danca_popping AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_popping_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Popping', 'Descrição', current_timestamp, current_timestamp
    FROM danca_popping CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_popping_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Popping', 'Descricion', current_timestamp, current_timestamp
    FROM danca_popping CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_popping_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Popping', 'Description', current_timestamp, current_timestamp
    FROM danca_popping CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_popping_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Popping', 'Description', current_timestamp, current_timestamp
    FROM danca_popping CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE BACHATA
danca_bachata AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_bachata_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bachata', 'Descrição', current_timestamp, current_timestamp
    FROM danca_bachata CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_bachata_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bachata', 'Descricion', current_timestamp, current_timestamp
    FROM danca_bachata CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_bachata_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bachata', 'Description', current_timestamp, current_timestamp
    FROM danca_bachata CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_bachata_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bachata', 'Description', current_timestamp, current_timestamp
    FROM danca_bachata CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE Hip Hop
danca_hiphop AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_hiphop_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop', 'Descrição', current_timestamp, current_timestamp
    FROM danca_hiphop CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_hiphop_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop', 'Descricion', current_timestamp, current_timestamp
    FROM danca_hiphop CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_hiphop_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop', 'Description', current_timestamp, current_timestamp
    FROM danca_hiphop CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_hiphop_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop', 'Description', current_timestamp, current_timestamp
    FROM danca_hiphop CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE CONTEMPORANEO
danca_contemporaneo AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_contemporaneo_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Contemporâneo', 'Descrição', current_timestamp, current_timestamp
    FROM danca_contemporaneo CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_contemporaneo_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Contemporâneo', 'Descricion', current_timestamp, current_timestamp
    FROM danca_contemporaneo CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_contemporaneo_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Contemporary', 'Description', current_timestamp, current_timestamp
    FROM danca_contemporaneo CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_contemporaneo_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Contemporain', 'Description', current_timestamp, current_timestamp
    FROM danca_contemporaneo CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE FUNK
danca_funk AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_funk_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funk', 'Descrição', current_timestamp, current_timestamp
    FROM danca_funk CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_funk_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funk', 'Descricion', current_timestamp, current_timestamp
    FROM danca_funk CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_funk_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funk', 'Description', current_timestamp, current_timestamp
    FROM danca_funk CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_funk_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funk', 'Description', current_timestamp, current_timestamp
    FROM danca_funk CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE BALLET FLOW
danca_ballet_flow AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_ballet_flow_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Flow', 'Descrição', current_timestamp, current_timestamp
    FROM danca_ballet_flow CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_ballet_flow_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Flow', 'Descricion', current_timestamp, current_timestamp
    FROM danca_ballet_flow CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_ballet_flow_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Flow', 'Description', current_timestamp, current_timestamp
    FROM danca_ballet_flow CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_ballet_flow_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Flow', 'Description', current_timestamp, current_timestamp
    FROM danca_ballet_flow CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE BALLET
danca_ballet AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_ballet_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet', 'Descrição', current_timestamp, current_timestamp
    FROM danca_ballet CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_ballet_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet', 'Descricion', current_timestamp, current_timestamp
    FROM danca_ballet CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_ballet_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet', 'Description', current_timestamp, current_timestamp
    FROM danca_ballet CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_ballet_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet', 'Description', current_timestamp, current_timestamp
    FROM danca_ballet CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE TRIBAL
danca_tribal AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_tribal_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tribal', 'Descrição', current_timestamp, current_timestamp
    FROM danca_tribal CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_tribal_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tribal', 'Descricion', current_timestamp, current_timestamp
    FROM danca_tribal CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_tribal_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tribal', 'Description', current_timestamp, current_timestamp
    FROM danca_tribal CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_tribal_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tribal', 'Description', current_timestamp, current_timestamp
    FROM danca_tribal CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE POP
danca_pop AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_pop_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança Pop', 'Descrição', current_timestamp, current_timestamp
    FROM danca_pop CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_pop_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danza Pop', 'Descricion', current_timestamp, current_timestamp
    FROM danca_pop CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_pop_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pop Dance', 'Description', current_timestamp, current_timestamp
    FROM danca_pop CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_pop_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Danse Pop', 'Description', current_timestamp, current_timestamp
    FROM danca_pop CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE JAZZ
danca_jazz AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_jazz_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jazz', 'Descrição', current_timestamp, current_timestamp
    FROM danca_jazz CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_jazz_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jazz', 'Descricion', current_timestamp, current_timestamp
    FROM danca_jazz CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_jazz_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jazz', 'Description', current_timestamp, current_timestamp
    FROM danca_jazz CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_jazz_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jazz', 'Description', current_timestamp, current_timestamp
    FROM danca_jazz CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE HIGH HEELS
danca_high_heels AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_high_heels_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'High Heels', 'Descrição', current_timestamp, current_timestamp
    FROM danca_high_heels CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_high_heels_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'High Heels', 'Descricion', current_timestamp, current_timestamp
    FROM danca_high_heels CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_high_heels_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'High Heels', 'Description', current_timestamp, current_timestamp
    FROM danca_high_heels CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_high_heels_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'High Heels', 'Description', current_timestamp, current_timestamp
    FROM danca_high_heels CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE CLASSICA
danca_classica AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_classica_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Clássica', 'Descrição', current_timestamp, current_timestamp
    FROM danca_classica CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_classica_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Classic', 'Descricion', current_timestamp, current_timestamp
    FROM danca_classica CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_classica_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Classic', 'Description', current_timestamp, current_timestamp
    FROM danca_classica CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_classica_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Classique', 'Description', current_timestamp, current_timestamp
    FROM danca_classica CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE BOLLYWOOD
danca_bollywood AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_bollywood_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bollywood', 'Descrição', current_timestamp, current_timestamp
    FROM danca_bollywood CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_bollywood_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bollywood', 'Descricion', current_timestamp, current_timestamp
    FROM danca_bollywood CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_bollywood_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bollywood', 'Description', current_timestamp, current_timestamp
    FROM danca_bollywood CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_bollywood_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bollywood', 'Description', current_timestamp, current_timestamp
    FROM danca_bollywood CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE KIZOMBA
danca_kizomba AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_kizomba_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kizomba', 'Descrição', current_timestamp, current_timestamp
    FROM danca_kizomba CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_kizomba_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kizomba', 'Descricion', current_timestamp, current_timestamp
    FROM danca_kizomba CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_kizomba_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kizomba', 'Description', current_timestamp, current_timestamp
    FROM danca_kizomba CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_kizomba_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kizomba', 'Description', current_timestamp, current_timestamp
    FROM danca_kizomba CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE HOUSE
danca_house AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_house_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'House', 'Descrição', current_timestamp, current_timestamp
    FROM danca_house CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_house_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'House', 'Descricion', current_timestamp, current_timestamp
    FROM danca_house CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_house_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'House', 'Description', current_timestamp, current_timestamp
    FROM danca_house CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_house_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'House', 'Description', current_timestamp, current_timestamp
    FROM danca_house CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE STREET JAZZ
danca_street_jazz AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_street_jazz_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Street Jazz', 'Descrição', current_timestamp, current_timestamp
    FROM danca_street_jazz CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_street_jazz_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Street Jazz', 'Descricion', current_timestamp, current_timestamp
    FROM danca_street_jazz CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_street_jazz_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Street Jazz', 'Description', current_timestamp, current_timestamp
    FROM danca_street_jazz CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_street_jazz_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Street Jazz', 'Description', current_timestamp, current_timestamp
    FROM danca_street_jazz CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE LOCKING
danca_locking AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_locking_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Locking', 'Descrição', current_timestamp, current_timestamp
    FROM danca_locking CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_locking_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Locking', 'Descricion', current_timestamp, current_timestamp
    FROM danca_locking CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_locking_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Locking', 'Description', current_timestamp, current_timestamp
    FROM danca_locking CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_locking_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Locking', 'Description', current_timestamp, current_timestamp
    FROM danca_locking CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE GIRLIE
danca_girlie AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_girlie_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Girlie', 'Descrição', current_timestamp, current_timestamp
    FROM danca_girlie CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_girlie_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Girlie', 'Descricion', current_timestamp, current_timestamp
    FROM danca_girlie CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_girlie_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Girlie', 'Description', current_timestamp, current_timestamp
    FROM danca_girlie CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_girlie_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Girlie', 'Description', current_timestamp, current_timestamp
    FROM danca_girlie CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE BREAKDANCE
danca_breakdance AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM danca d
    RETURNING *
),danca_breakdance_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Breakdance', 'Descrição', current_timestamp, current_timestamp
    FROM danca_breakdance CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), danca_breakdance_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Breakdance', 'Descricion', current_timestamp, current_timestamp
    FROM danca_breakdance CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), danca_breakdance_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Breakdance', 'Description', current_timestamp, current_timestamp
    FROM danca_breakdance CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), danca_breakdance_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Breakdance', 'Description', current_timestamp, current_timestamp
    FROM danca_breakdance CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from danca_breakdance_fr;