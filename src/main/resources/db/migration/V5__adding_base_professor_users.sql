-- Adding correct pwd user professor
WITH add_correct_pwd_user AS (
    INSERT INTO public.app_user
    (first_name, last_name, email, pwd, active, enabled, created_at, updated_at)
    VALUES('Correct', 'Professional 1', 'correct_pwd_pro1@email.com', 'gK4/XJRdHXemoeZxeNRcZDjSjdt5bQegge3ACVo5mJHyL9wXTaU/6QQWHYXOuMMtgyiuDL07scr90HvL+slMkg==', true, true, current_timestamp, current_timestamp)
    RETURNING *
), insert_correct_pwd_professional AS (
    INSERT INTO public.professor (id, description, nif)
    SELECT u.id, 'description 1', 'nif1'
    FROM add_correct_pwd_user u
    RETURNING *
) select * from insert_correct_pwd_professional;