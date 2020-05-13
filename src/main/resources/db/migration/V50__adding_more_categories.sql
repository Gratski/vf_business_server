-- MIND AND BODY
WITH mind_and_body AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), mind_and_body_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mente & Corpo', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mente y Cuerpo', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Mind & Body', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Esprit et Corps', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- ALONGAMENTOS
mind_and_body_alongamentos AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_alongamentos_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Alongamentos', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_alongamentos CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_alongamentos_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Estiramientos', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_alongamentos CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_alongamentos_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Stretches', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_alongamentos CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_alongamentos_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Étirements', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_alongamentos CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- PILATES
mind_and_body_pilates AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_pilates_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pilates', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_pilates CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_pilates_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pilates', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_pilates CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_pilates_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pilates', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_pilates CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_pilates_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pilates', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_pilates CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- YOGA
mind_and_body_yoga AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_yoga_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_yoga CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_yoga_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_yoga CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_yoga_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_yoga CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_yoga_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_yoga CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CHI FLOW
mind_and_body_chi_flow AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_chi_flow_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Chi Flow', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_chi_flow CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_chi_flow_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Chi Flow', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_chi_flow CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_chi_flow_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Chi Flow', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_chi_flow CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_chi_flow_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Chi Flow', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_chi_flow CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- REEDUCATION POSTURAL
mind_and_body_reeducacao_postural AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_reeducacao_postural_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Reeducação Postural', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_reeducacao_postural CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_reeducacao_postural_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Reeducación Postural', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_reeducacao_postural CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_reeducacao_postural_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Postural Reeducation', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_reeducacao_postural CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_reeducacao_postural_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'La Rééducation Posturale', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_reeducacao_postural CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CONSCIENCIA CORPORAL
mind_and_body_consciencia_corporal AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_consciencia_corporal_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Consciência Corporal', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_consciencia_corporal CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_consciencia_corporal_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'La Conciencia del Cuerpo', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_consciencia_corporal CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_consciencia_corporal_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Body Consciousness', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_consciencia_corporal CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_consciencia_corporal_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'La Conscience du Corps', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_consciencia_corporal CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TAI CHI
mind_and_body_tai_chi AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM mind_and_body d
    RETURNING *
),mind_and_body_tai_chi_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tai-Chi', 'Descrição', current_timestamp, current_timestamp
    FROM mind_and_body_tai_chi CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), mind_and_body_tai_chi_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tai-Chi', 'Descricion', current_timestamp, current_timestamp
    FROM mind_and_body_tai_chi CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), mind_and_body_tai_chi_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tai-Chi', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_tai_chi CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), mind_and_body_tai_chi_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tai-Chi', 'Description', current_timestamp, current_timestamp
    FROM mind_and_body_tai_chi CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from mind_and_body_tai_chi_fr;


-- KIDS
WITH kids AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), kids_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Crianças', 'Descrição', current_timestamp, current_timestamp
    FROM kids CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kids', 'Description', current_timestamp, current_timestamp
    FROM kids CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BALLET ENFANTS
kids_ballet AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_ballet_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_ballet CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_ballet_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_ballet CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_ballet_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_ballet CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_ballet_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Ballet Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_ballet CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CROSS JUNIOR
kids_cross_junior AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_cross_junior_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Júnior', 'Descrição', current_timestamp, current_timestamp
    FROM kids_cross_junior CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_cross_junior_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Junior', 'Descricion', current_timestamp, current_timestamp
    FROM kids_cross_junior CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_cross_junior_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Junior', 'Description', current_timestamp, current_timestamp
    FROM kids_cross_junior CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_cross_junior_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Junior', 'Description', current_timestamp, current_timestamp
    FROM kids_cross_junior CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- JUDO KIDS
kids_judo AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_judo_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Judo Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_judo CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_judo_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Judo Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_judo CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_judo_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kids Judo', 'Description', current_timestamp, current_timestamp
    FROM kids_judo CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_judo_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Enfants Judo', 'Description', current_timestamp, current_timestamp
    FROM kids_judo CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- FUNCTIONAL KIDS
kids_funcional AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_funcional_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funcional Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_funcional CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_funcional_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Niños Funcionales', 'Descricion', current_timestamp, current_timestamp
    FROM kids_funcional CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_funcional_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Functional Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_funcional CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_funcional_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Enfants Fonctionnels', 'Description', current_timestamp, current_timestamp
    FROM kids_funcional CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- POP DANCE KIDS
kids_pop_kids AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_pop_kids_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pop Dance Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_pop_kids CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_pop_kids_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pop Dance Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_pop_kids CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_pop_kids_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pop Dance Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_pop_kids CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_pop_kids_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Pop Dance Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_pop_kids CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- YOGA KIDS
kids_yoga_kids AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_yoga_kids_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_yoga_kids CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_yoga_kids_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_yoga_kids CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_yoga_kids_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_yoga_kids CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_yoga_kids_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Yoga Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_yoga_kids CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- DANCE KIDS
kids_dance AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_dance_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dança Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_dance CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_dance_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Baile Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_dance CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_dance_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_dance CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_dance_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Dance Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_dance CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- GLOBAL KIDS
kids_global AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_global_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Treino Global Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_global CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_global_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Entrenamiento General Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_global CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_global_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GLobal Kids Training', 'Description', current_timestamp, current_timestamp
    FROM kids_global CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_global_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Global Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_global CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- KARATE KIDS
kids_karate AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_karate_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Karaté Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_karate CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_karate_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Karate Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_karate CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_karate_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kids Karate', 'Description', current_timestamp, current_timestamp
    FROM kids_karate CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_karate_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Karate Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_karate CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- ZUMBA KIDS
kids_zumba AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_zumba_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_zumba CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_zumba_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_zumba CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_zumba_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_zumba CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_zumba_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Zumba Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_zumba CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- FITNESS KIDS
kids_fitness AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_fitness_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fitness Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_fitness CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_fitness_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fitness Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_fitness CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_fitness_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fitness Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_fitness CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_fitness_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fitness Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_fitness CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- HIP HOP KIDS
kids_hip_hop AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_hip_hop_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_hip_hop CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_hip_hop_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_hip_hop CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_hip_hop_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_hip_hop CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_hip_hop_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Hip Hop Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_hip_hop CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- KICKBOXING KIDS
kids_kickboxing AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_kickboxing_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_kickboxing CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_kickboxing_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_kickboxing CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_kickboxing_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_kickboxing CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_kickboxing_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_kickboxing CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TAEKWONDO KIDS
kids_taekwondo AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM kids d
    RETURNING *
),kids_taekwondo_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Taekwondo Kids', 'Descrição', current_timestamp, current_timestamp
    FROM kids_taekwondo CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), kids_taekwondo_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Taekwondo Niños', 'Descricion', current_timestamp, current_timestamp
    FROM kids_taekwondo CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), kids_taekwondo_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Taekwondo Kids', 'Description', current_timestamp, current_timestamp
    FROM kids_taekwondo CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), kids_taekwondo_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Taekwondo Enfants', 'Description', current_timestamp, current_timestamp
    FROM kids_taekwondo CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from kids_taekwondo_fr;

-- MARTIAL ARTS
WITH martial_arts AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), martial_arts_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Artes Marciais', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Artes Marciales', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Martial Arts', 'Description', current_timestamp, current_timestamp
    FROM martial_arts CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Arts Martiaux', 'Description', current_timestamp, current_timestamp
    FROM martial_arts CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- WARRIOR
martial_arts_warrior AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_warrior_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Warrior', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_warrior CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_warrior_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Warrior', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_warrior CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_warrior_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Warrior', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_warrior CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_warrior_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Warrior', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_warrior CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- MUAY THAI
martial_arts_muay_thai AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_muay_thai_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Muay Thai', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_muay_thai CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_muay_thai_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Muay Thai', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_muay_thai CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_muay_thai_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Muay Thai', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_muay_thai CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_muay_thai_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Muay Thai', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_muay_thai CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- KRAV MAGA
martial_arts_krav_maga AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_krav_maga_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krav Maga', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_krav_maga CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_krav_maga_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krav Maga', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_krav_maga CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_krav_maga_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krav Maga', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_krav_maga CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_krav_maga_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Krav Maga', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_krav_maga CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- KICKBOXING
martial_arts_kickboxing AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_kickboxing_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_kickboxing CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_kickboxing_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_kickboxing CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_kickboxing_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_kickboxing CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_kickboxing_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Kickboxing', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_kickboxing CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- JIU_JITSU
martial_arts_jiu_jitsu AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_jiu_jitsu_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jiu-Jitsu', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_jiu_jitsu CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_jiu_jitsu_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jiu-Jitsu', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_jiu_jitsu CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_jiu_jitsu_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jiu-Jitsu', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_jiu_jitsu CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_jiu_jitsu_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Jiu-Jitsu', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_jiu_jitsu CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- PERSONAL DEFENCE
martial_arts_personal_defence AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_personal_defence_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Defesa Pessoal - Hapkido', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_personal_defence CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_personal_defence_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Defesa Personal - Hapkido', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_personal_defence CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_personal_defence_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Self-Defense - Hapkido', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_personal_defence CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_personal_defence_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Défense Personnelle - Hapkido', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_personal_defence CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BOXE
martial_arts_boxe AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM martial_arts d
    RETURNING *
),martial_arts_boxe_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Boxe', 'Descrição', current_timestamp, current_timestamp
    FROM martial_arts_boxe CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), martial_arts_boxe_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Boxeo', 'Descricion', current_timestamp, current_timestamp
    FROM martial_arts_boxe CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), martial_arts_boxe_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Boxing', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_boxe CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), martial_arts_boxe_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Boxer', 'Description', current_timestamp, current_timestamp
    FROM martial_arts_boxe CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from martial_arts_boxe_fr;

-- LES MILLS
WITH les_milles AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), les_milles_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Les Mills', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Les Mills', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Les Mills', 'Description', current_timestamp, current_timestamp
    FROM les_milles CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Les Mills', 'Description', current_timestamp, current_timestamp
    FROM les_milles CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODYPUMP
les_milles_body_pump AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_body_pump_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyPump', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_body_pump CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_body_pump_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyPump', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_body_pump CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_body_pump_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyPump', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_pump CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_body_pump_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyPump', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_pump CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY BALANCE
les_milles_body_balance AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_body_balance_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_body_balance CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_body_balance_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_body_balance CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_body_balance_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_balance CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_body_balance_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_balance CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY ATTACK
les_milles_body_attack AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_body_attack_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_body_attack CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_body_attack_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_body_attack CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_body_attack_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_attack CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_body_attack_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_attack CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SH BAM
les_milles_shbam AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_shbam_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_shbam CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_shbam_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_shbam CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_shbam_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam', 'Description', current_timestamp, current_timestamp
    FROM les_milles_shbam CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_shbam_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam', 'Description', current_timestamp, current_timestamp
    FROM les_milles_shbam CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODYSTEP
les_milles_body_step AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_body_step_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyStep', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_body_step CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_body_step_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyStep', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_body_step CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_body_step_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyStep', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_step CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_body_step_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyStep', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_step CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BARRE
les_milles_barre AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_barre_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barre', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_barre CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_barre_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barre', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_barre CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_barre_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barre', 'Description', current_timestamp, current_timestamp
    FROM les_milles_barre CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_barre_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Barre', 'Description', current_timestamp, current_timestamp
    FROM les_milles_barre CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- GRIT CARDIO
les_milles_grit_cardio AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_grit_cardio_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Cardio', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_grit_cardio CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_grit_cardio_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Cardio', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_grit_cardio CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_grit_cardio_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Cardio', 'Description', current_timestamp, current_timestamp
    FROM les_milles_grit_cardio CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_grit_cardio_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Cardio', 'Description', current_timestamp, current_timestamp
    FROM les_milles_grit_cardio CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY COMBAT
les_milles_bodycombat AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_bodycombat_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_bodycombat CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_bodycombat_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_bodycombat CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_bodycombat_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat', 'Description', current_timestamp, current_timestamp
    FROM les_milles_bodycombat CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_bodycombat_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat', 'Description', current_timestamp, current_timestamp
    FROM les_milles_bodycombat CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CX WORX
les_milles_cx_worx AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_cx_worx_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'CXWORX', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_cx_worx CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_cx_worx_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'CXWORX', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_cx_worx CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_cx_worx_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'CXWORX', 'Description', current_timestamp, current_timestamp
    FROM les_milles_cx_worx CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_cx_worx_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'CXWORX', 'Description', current_timestamp, current_timestamp
    FROM les_milles_cx_worx CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- RPM
les_milles_rpm AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_rpm_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_rpm CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_rpm_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_rpm CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_rpm_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM', 'Description', current_timestamp, current_timestamp
    FROM les_milles_rpm CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_rpm_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM', 'Description', current_timestamp, current_timestamp
    FROM les_milles_rpm CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODYJAM
les_milles_body_jam AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_body_jam_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyJam', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_body_jam CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_body_jam_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyJam', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_body_jam CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_body_jam_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyJam', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_jam CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_body_jam_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyJam', 'Description', current_timestamp, current_timestamp
    FROM les_milles_body_jam CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TONE
les_milles_tone AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_tone_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tone', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_tone CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_tone_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tone', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_tone CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_tone_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tone', 'Description', current_timestamp, current_timestamp
    FROM les_milles_tone CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_tone_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Tone', 'Description', current_timestamp, current_timestamp
    FROM les_milles_tone CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SPRINT
les_milles_sprint AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_sprint_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sprint', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_sprint CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_sprint_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sprint', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_sprint CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_sprint_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sprint', 'Description', current_timestamp, current_timestamp
    FROM les_milles_sprint CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_sprint_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sprint', 'Description', current_timestamp, current_timestamp
    FROM les_milles_sprint CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- GRIT ATHLETIC
les_milles_grit_athletic AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM les_milles d
    RETURNING *
),les_milles_grit_athletic_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Athletic', 'Descrição', current_timestamp, current_timestamp
    FROM les_milles_grit_athletic CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), les_milles_grit_athletic_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Athletic', 'Descricion', current_timestamp, current_timestamp
    FROM les_milles_grit_athletic CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), les_milles_grit_athletic_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Athletic', 'Description', current_timestamp, current_timestamp
    FROM les_milles_grit_athletic CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), les_milles_grit_athletic_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Grit Athletic', 'Description', current_timestamp, current_timestamp
    FROM les_milles_grit_athletic CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from les_milles_grit_athletic_fr;

-- CARDIO
WITH cardio AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), cardio_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio', 'Descrição', current_timestamp, current_timestamp
    FROM cardio CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio', 'Descricion', current_timestamp, current_timestamp
    FROM cardio CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio', 'Description', current_timestamp, current_timestamp
    FROM cardio CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio', 'Description', current_timestamp, current_timestamp
    FROM cardio CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- Cardio Boxe
cardio_boxe AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_boxe_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio Boxe', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_boxe CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_boxe_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio Boxeo', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_boxe CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_boxe_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio Boxing', 'Description', current_timestamp, current_timestamp
    FROM cardio_boxe CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_boxe_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cardio Boxer', 'Description', current_timestamp, current_timestamp
    FROM cardio_boxe CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- Box Fit
cardio_fit_box AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_fit_box_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fit Boxe', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_fit_box CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_fit_box_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fit Boxeo', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_fit_box CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_fit_box_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fit Boxing', 'Description', current_timestamp, current_timestamp
    FROM cardio_fit_box CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_fit_box_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fit Boxer', 'Description', current_timestamp, current_timestamp
    FROM cardio_fit_box CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TREINO FUNCIONAL
cardio_functional_training AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_functional_training_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Treino Funcional', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_functional_training CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_functional_training_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Entrenamiento Funcional', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_functional_training CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_functional_training_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Functional Training', 'Description', current_timestamp, current_timestamp
    FROM cardio_functional_training CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_functional_training_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Entraînement Fonctionnel', 'Description', current_timestamp, current_timestamp
    FROM cardio_functional_training CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- STEP
cardio_step AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_step_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Step', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_step CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_step_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Step', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_step CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_step_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Step', 'Description', current_timestamp, current_timestamp
    FROM cardio_step CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_step_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Step', 'Description', current_timestamp, current_timestamp
    FROM cardio_step CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- POWER JUMP
cardio_power_jump AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_power_jump_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Power Jump', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_power_jump CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_power_jump_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Power Jump', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_power_jump CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_power_jump_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Power Jump', 'Description', current_timestamp, current_timestamp
    FROM cardio_power_jump CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_power_jump_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Power Jump', 'Description', current_timestamp, current_timestamp
    FROM cardio_power_jump CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TOTAL BODY
cardio_total_body AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_total_body_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Total Body', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_total_body CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_total_body_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Total Cuerpo', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_total_body CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_total_body_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Total Body', 'Description', current_timestamp, current_timestamp
    FROM cardio_total_body CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_total_body_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Corps Total', 'Description', current_timestamp, current_timestamp
    FROM cardio_total_body CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SWISS BALL
cardio_swiss_ball AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_swiss_ball_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Swiss Ball', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_swiss_ball CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_swiss_ball_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bola Suiza', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_swiss_ball CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_swiss_ball_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Swiss Ball', 'Description', current_timestamp, current_timestamp
    FROM cardio_swiss_ball CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_swiss_ball_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Boule Suisse', 'Description', current_timestamp, current_timestamp
    FROM cardio_swiss_ball CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BOSU
cardio_bosu AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_bosu_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bosu', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_bosu CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_bosu_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bosu', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_bosu CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_bosu_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bosu', 'Description', current_timestamp, current_timestamp
    FROM cardio_bosu CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_bosu_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Bosu', 'Description', current_timestamp, current_timestamp
    FROM cardio_bosu CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- FLEXIBILITY
cardio_flexibility AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_flexibility_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Flexibilidade', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_flexibility CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_flexibility_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Flexibilidad', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_flexibility CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_flexibility_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Flexibility', 'Description', current_timestamp, current_timestamp
    FROM cardio_flexibility CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_flexibility_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Flexibilité', 'Description', current_timestamp, current_timestamp
    FROM cardio_flexibility CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SPINNING
cardio_spinning AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_spinning_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Spinning', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_spinning CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_spinning_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Spinning', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_spinning CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_spinning_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Spinning', 'Description', current_timestamp, current_timestamp
    FROM cardio_spinning CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_spinning_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Spinning', 'Description', current_timestamp, current_timestamp
    FROM cardio_spinning CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- AEROBICA
cardio_aerobica AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM cardio d
    RETURNING *
),cardio_aerobica_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Aeróbica', 'Descrição', current_timestamp, current_timestamp
    FROM cardio_aerobica CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), cardio_aerobica_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Aeróbica', 'Descricion', current_timestamp, current_timestamp
    FROM cardio_aerobica CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), cardio_aerobica_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Aerobics', 'Description', current_timestamp, current_timestamp
    FROM cardio_aerobica CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), cardio_aerobica_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Aérobic', 'Description', current_timestamp, current_timestamp
    FROM cardio_aerobica CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from cardio_aerobica_fr;

-- STRENGTH
WITH strength AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), strength_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Força', 'Descrição', current_timestamp, current_timestamp
    FROM strength CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fuerza', 'Descricion', current_timestamp, current_timestamp
    FROM strength CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Strength', 'Description', current_timestamp, current_timestamp
    FROM strength CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Force', 'Description', current_timestamp, current_timestamp
    FROM strength CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- LOCALIZED
strength_localized AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_localized_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Localizada', 'Descrição', current_timestamp, current_timestamp
    FROM strength_localized CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_localized_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Localizada', 'Descricion', current_timestamp, current_timestamp
    FROM strength_localized CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_localized_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Localized', 'Description', current_timestamp, current_timestamp
    FROM strength_localized CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_localized_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Localisé', 'Description', current_timestamp, current_timestamp
    FROM strength_localized CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- GAP
strength_gap AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_gap_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP', 'Descrição', current_timestamp, current_timestamp
    FROM strength_gap CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_gap_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP', 'Descricion', current_timestamp, current_timestamp
    FROM strength_gap CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_gap_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP', 'Description', current_timestamp, current_timestamp
    FROM strength_gap CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_gap_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP', 'Description', current_timestamp, current_timestamp
    FROM strength_gap CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TRX
strength_trx AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_trx_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'TRX', 'Descrição', current_timestamp, current_timestamp
    FROM strength_trx CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_trx_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'TRX', 'Descricion', current_timestamp, current_timestamp
    FROM strength_trx CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_trx_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'TRX', 'Description', current_timestamp, current_timestamp
    FROM strength_trx CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_trx_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'TRX', 'Description', current_timestamp, current_timestamp
    FROM strength_trx CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CALISTENIA
strength_calistenia AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_calistenia_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Calistenia', 'Descrição', current_timestamp, current_timestamp
    FROM strength_calistenia CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_calistenia_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Calistenia', 'Descricion', current_timestamp, current_timestamp
    FROM strength_calistenia CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_calistenia_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Calistenia', 'Description', current_timestamp, current_timestamp
    FROM strength_calistenia CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_calistenia_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Calistenia', 'Description', current_timestamp, current_timestamp
    FROM strength_calistenia CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- TARGET ABS
strength_target_abs AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_target_abs_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Target de Abdominais', 'Descrição', current_timestamp, current_timestamp
    FROM strength_target_abs CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_target_abs_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Blanco Abdominal', 'Descricion', current_timestamp, current_timestamp
    FROM strength_target_abs CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_target_abs_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Abdominal Target', 'Description', current_timestamp, current_timestamp
    FROM strength_target_abs CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_target_abs_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cible Abdominale', 'Description', current_timestamp, current_timestamp
    FROM strength_target_abs CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- HITT STRENGTH
strength_hiit AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_hiit_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'HIIT de Força', 'Descrição', current_timestamp, current_timestamp
    FROM strength_hiit CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_hiit_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'HIIT de Fuerza', 'Descricion', current_timestamp, current_timestamp
    FROM strength_hiit CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_hiit_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'HIIT Strength', 'Description', current_timestamp, current_timestamp
    FROM strength_hiit CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_hiit_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'HIIT Force', 'Description', current_timestamp, current_timestamp
    FROM strength_hiit CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CROSS TRAINING
strength_cross_training AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_cross_training_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Training', 'Descrição', current_timestamp, current_timestamp
    FROM strength_cross_training CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_cross_training_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Entrenamiento Transversal', 'Descricion', current_timestamp, current_timestamp
    FROM strength_cross_training CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_cross_training_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Cross Training', 'Description', current_timestamp, current_timestamp
    FROM strength_cross_training CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_cross_training_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Entraînement Croisé', 'Description', current_timestamp, current_timestamp
    FROM strength_cross_training CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY FITNESS
strength_body_fitness AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM strength d
    RETURNING *
),strength_body_fitness_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Body Fitness', 'Descrição', current_timestamp, current_timestamp
    FROM strength_body_fitness CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), strength_body_fitness_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Body Fitness', 'Descricion', current_timestamp, current_timestamp
    FROM strength_body_fitness CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), strength_body_fitness_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Body Fitness', 'Description', current_timestamp, current_timestamp
    FROM strength_body_fitness CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), strength_body_fitness_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Body Fitness', 'Description', current_timestamp, current_timestamp
    FROM strength_body_fitness CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from strength_body_fitness_fr;