WITH pt_lang AS (
    INSERT INTO "language"(created_at, updated_at, code, system_language)
    VALUES(current_timestamp, current_timestamp , 'pt', false)
    RETURNING *
), link_pt_to_countries AS (
    INSERT INTO language_countries
    (language_id, country_id, created_at, updated_at)
    SELECT L.id, CO.id, current_timestamp, current_timestamp
    FROM pt_lang L, country CO
    WHERE
    CO.country_code = 'PT'
    OR CO.country_code = 'BR'
    OR CO.country_code = 'AO'
    OR CO.country_code = 'CV'
), add_pt_language_translation_to_pt AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'pt', 'Português'
    FROM pt_lang L
    RETURNING *
), add_pt_language_translation_to_en AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'en', 'Portuguese'
    FROM pt_lang L
    RETURNING *
), add_pt_language_translation_to_es AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'es', 'Portugues'
    FROM pt_lang L
    RETURNING *
), add_pt_language_translation_to_fr AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'fr', 'Portugais'
    FROM pt_lang L
    RETURNING *
) select * from add_pt_language_translation_to_fr;


WITH es_lang AS (
    INSERT INTO "language"(created_at, updated_at, code, system_language)
    VALUES(current_timestamp, current_timestamp , 'es', false)
    RETURNING *
), link_es_to_countries AS (
    INSERT INTO language_countries
    (language_id, country_id, created_at, updated_at)
    SELECT L.id, CO.id, current_timestamp, current_timestamp
    FROM es_lang L, country CO
    WHERE
    CO.country_code = 'ES'
    OR CO.country_code = 'AR'
    OR CO.country_code = 'BO'
    OR CO.country_code = 'CL'
    OR CO.country_code = 'CO'
    OR CO.country_code = 'CR'
    OR CO.country_code = 'DO'
    OR CO.country_code = 'EC'
    OR CO.country_code = 'SV'
    OR CO.country_code = 'GT'
    OR CO.country_code = 'HN'
    OR CO.country_code = 'MX'
    OR CO.country_code = 'NI'
    OR CO.country_code = 'PA'
    OR CO.country_code = 'PY'
    OR CO.country_code = 'PE'
    OR CO.country_code = 'PR'
    OR CO.country_code = 'UY'
    OR CO.country_code = 'VE'
), add_es_language_translation_to_es AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'es', 'Español'
    FROM es_lang L
    RETURNING *
), add_es_language_translation_to_pt AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'pt', 'Espanhol'
    FROM es_lang L
    RETURNING *
), add_es_language_translation_to_en AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'en', 'Spanish'
    FROM es_lang L
    RETURNING *
), add_es_language_translation_to_fr AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'fr', 'Espagnol'
    FROM es_lang L
    RETURNING *
) select * from add_es_language_translation_to_fr;

WITH en_lang AS (
    INSERT INTO "language"(created_at, updated_at, code, system_language)
    VALUES(current_timestamp, current_timestamp , 'en', false)
    RETURNING *
), link_en_to_countries AS (
    INSERT INTO language_countries
    (language_id, country_id, created_at, updated_at)
    SELECT L.id, CO.id, current_timestamp, current_timestamp
    FROM en_lang L, country CO
    WHERE
    CO.country_code = 'AU'
    OR CO.country_code = 'BZ'
    OR CO.country_code = 'CA'
    OR CO.country_code = 'IE'
    OR CO.country_code = 'JM'
    OR CO.country_code = 'NZ'
    OR CO.country_code = 'ZA'
    OR CO.country_code = 'TT'
    OR CO.country_code = 'GB'
    OR CO.country_code = 'US'
), add_en_language_translation_to_pt AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'pt', 'Inglês'
    FROM en_lang L
    RETURNING *
), add_en_language_translation_to_es AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'es', 'Inglés'
    FROM en_lang L
    RETURNING *
), add_en_language_translation_to_en AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'en', 'English'
    FROM en_lang L
    RETURNING *
), add_en_language_translation_to_fr AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'fr', 'Inglais'
    FROM en_lang L
    RETURNING *
) select * from add_en_language_translation_to_fr;

WITH fr_lang AS (
    INSERT INTO "language"(created_at, updated_at, code, system_language)
    VALUES(current_timestamp, current_timestamp , 'fr', false)
    RETURNING *
), link_fr_to_countries AS (
    INSERT INTO language_countries
    (language_id, country_id, created_at, updated_at)
    SELECT L.id, CO.id, current_timestamp, current_timestamp
    FROM fr_lang L, country CO
    WHERE
    CO.country_code = 'BE'
    OR CO.country_code = 'CA'
    OR CO.country_code = 'LU'
    OR CO.country_code = 'CH'
    OR CO.country_code = 'MC'
), add_fr_language_translation_to_pt AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'pt', 'Francês'
    FROM fr_lang L
    RETURNING *
), add_fr_language_translation_to_es AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'es', 'Francés'
    FROM fr_lang L
    RETURNING *
), add_fr_language_translation_to_en AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'en', 'French'
    FROM fr_lang L
    RETURNING *
), add_fr_language_translation_to_fr AS (
    INSERT INTO language_translation
    (language_id, code, designation)
    SELECT L.id, 'fr', 'Français'
    FROM fr_lang L
    RETURNING *
) select * from add_fr_language_translation_to_fr;
