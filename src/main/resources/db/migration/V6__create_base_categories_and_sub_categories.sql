WITH insert_parent_category AS (
    INSERT INTO public.category
    (designation, description, image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('HIT', 'Treino de Alta Intensidade', 'https://vfitbucket.s3.eu-west-2.amazonaws.com/pictures/system/categories/images.squarespace-cdn.com.jpeg', null, 'icon', current_timestamp, current_timestamp, null)
    RETURNING *
), insert_sub_category AS (
    INSERT INTO public.category
    (designation, description, image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'Insanity', 'Treino para queimar calorias!', 'https://vfitbucket.s3.eu-west-2.amazonaws.com/pictures/system/categories/gettyimages-609743531.jpg', null, 'icon', current_timestamp, current_timestamp, p.id
    FROM insert_parent_category p
    RETURNING *
) select * FROM insert_sub_category;

WITH insert_parent_category AS (
    INSERT INTO public.category
    (designation, description, image_url, picture_id, icon, created_at, updated_at, parent_id)
    VALUES('MIND', 'Equilibrio entre o Corpo e a Mente', 'https://vfitbucket.s3.eu-west-2.amazonaws.com/pictures/system/categories/mind.jpg', null, 'icon', current_timestamp, current_timestamp, null)
    RETURNING *
), insert_sub_category AS (
    INSERT INTO public.category
    (designation, description, image_url, picture_id, icon, created_at, updated_at, parent_id)
    SELECT 'YOGA', 'Relaxar, libertar e respirar', 'https://vfitbucket.s3.eu-west-2.amazonaws.com/pictures/system/categories/yoga.jpg', null, 'icon', current_timestamp, current_timestamp, p.id
    FROM insert_parent_category p
    RETURNING *
) select * FROM insert_sub_category;