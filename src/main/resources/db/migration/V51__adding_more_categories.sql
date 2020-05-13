-- CLASS EXPRESS
WITH express_classes AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp , current_timestamp , null)
    RETURNING *
), express_classes_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Aulas Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Clases Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Express Classes', 'Description', current_timestamp, current_timestamp
    FROM express_classes CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Classes Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SQA
express_classes_sqa AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_sqa_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'SQA', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_sqa CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_sqa_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'SQA', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_sqa CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_sqa_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'SQA', 'Description', current_timestamp, current_timestamp
    FROM express_classes_sqa CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_sqa_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'SQA', 'Description', current_timestamp, current_timestamp
    FROM express_classes_sqa CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- ABS
express_classes_abs AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_abs_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'ABS', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_abs CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_abs_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'ABS', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_abs CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_abs_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'ABS', 'Description', current_timestamp, current_timestamp
    FROM express_classes_abs CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_abs_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'ABS', 'Description', current_timestamp, current_timestamp
    FROM express_classes_abs CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODYBALANCE
express_classes_bodybalance AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_bodybalance_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_bodybalance CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_bodybalance_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_bodybalance CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_bodybalance_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodybalance CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_bodybalance_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyBalance', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodybalance CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- RPM
express_classes_rpm AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_rpm_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_rpm CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_rpm_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_rpm CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_rpm_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_rpm CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_rpm_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'RPM Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_rpm CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- Functional
express_classes_functional AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_functional_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funcional Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_functional CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_functional_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Funcional Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_functional CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_functional_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Functional Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_functional CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_functional_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Fonctionnelle Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_functional CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- SHBAM
express_classes_shbam AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_shbam_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_shbam CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_shbam_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_shbam CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_shbam_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_shbam CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_shbam_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Sh''Bam Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_shbam CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- STRETCH
express_classes_stretch AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_stretch_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Alongamentos Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_stretch CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_stretch_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Estiramientos Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_stretch CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_stretch_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Stretch Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_stretch CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_stretch_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Étendue Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_stretch CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODYCOMBAT
express_classes_bodycombat AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_bodycombat_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_bodycombat CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_bodycombat_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_bodycombat CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_bodycombat_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodycombat CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_bodycombat_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyCombat Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodycombat CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- GAP
express_classes_gap AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_gap_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_gap CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_gap_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_gap CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_gap_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_gap CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_gap_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'GAP Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_gap CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- ROLER
express_classes_roler AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_roler_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Roller Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_roler CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_roler_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Roller Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_roler CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_roler_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Roller Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_roler CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_roler_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Rouleau Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_roler CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- 3B
express_classes_three_b AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_three_b_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, '3B Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_three_b CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_three_b_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, '3B Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_three_b CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_three_b_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, '3B Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_three_b CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_three_b_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, '3B Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_three_b CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY ATTACK
express_classes_bodyattack AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_bodyattack_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_bodyattack CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_bodyattack_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_bodyattack CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_bodyattack_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodyattack CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_bodyattack_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_bodyattack CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- BODY PUMP
express_classes_body_pump AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_body_pump_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_body_pump CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_body_pump_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_body_pump CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_body_pump_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_body_pump CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_body_pump_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'BodyAttack Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_body_pump CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- CORE
express_classes_core AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_core_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Core Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_core CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_core_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Core Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_core CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_core_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Core Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_core CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_core_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'Core Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_core CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
),
-- Power Jump
express_classes_powerjump AS (
    INSERT INTO category
    (image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'https://d168rbuicf8uyi.cloudfront.net/wp-content/uploads/2017/12/18135732/11259_E-1.jpg', null, 'icon', current_timestamp, current_timestamp, d.id
    FROM express_classes d
    RETURNING *
),express_classes_powerjump_pt AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'PowerJump Express', 'Descrição', current_timestamp, current_timestamp
    FROM express_classes_powerjump CA, "language" L
    WHERE L.code = 'pt'
    RETURNING *
), express_classes_powerjump_es AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'PowerJump Express', 'Descricion', current_timestamp, current_timestamp
    FROM express_classes_powerjump CA, "language" L
    WHERE L.code = 'es'
    RETURNING *
), express_classes_powerjump_en AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'PowerJump Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_powerjump CA, "language" L
    WHERE L.code = 'en'
    RETURNING *
), express_classes_powerjump_fr AS (
    INSERT INTO category_translation
    (category_id, language_id, designation, description, created_at, updated_at)
    SELECT CA.id, L.id, 'PowerJump Express', 'Description', current_timestamp, current_timestamp
    FROM express_classes_powerjump CA, "language" L
    WHERE L.code = 'fr'
    RETURNING *
) select * from express_classes_powerjump_fr;