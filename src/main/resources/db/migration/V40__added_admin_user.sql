WITH admin_user AS (
    INSERT INTO public.app_user
    (
        first_name,
        last_name,
        email,
        pwd,
        active,
        enabled,
        created_at,
        updated_at,
        fcm_token,
        picture_url,
        living_in,
        nationality,
        gender,
        birthday,
        phone_number_country,
        phone_number,
        referred_by,
        pwd_token
    )
    SELECT
        'Admin',
        'Admin',
        'email',
        'adminpass',
        true,
        true,
        current_timestamp,
        current_timestamp,
        null,
        'https://www.w3schools.com/howto/img_avatar.png',
        CO.id,
        CO.id,
        'MALE',
        current_timestamp,
        CO.id,
        '968039230',
        null,
        'dsgfgsfdgdfgf'
    FROM country CO WHERE CO.country_code = 'PT'
    RETURNING *
), link_to_admin AS (
    INSERT INTO public.admin_user
    (id)
    SELECT U.id FROM admin_user U
    RETURNING *
) select * FROM link_to_admin;