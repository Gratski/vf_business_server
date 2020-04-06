-- Adding correct pwd user student
WITH add_correct_pwd_user AS (
    INSERT INTO public.app_user
    (first_name, last_name, email, pwd, active, enabled, created_at, updated_at)
    VALUES('Correct', 'Student', 'correct_pwd_stu@email.com', 'gK4/XJRdHXemoeZxeNRcZDjSjdt5bQegge3ACVo5mJHyL9wXTaU/6QQWHYXOuMMtgyiuDL07scr90HvL+slMkg==', true, true, current_timestamp, current_timestamp)
    RETURNING *
), insert_correct_pwd_student AS (
    INSERT INTO public.student (id)
    SELECT u.id
    FROM add_correct_pwd_user u
    RETURNING *
) select * from insert_correct_pwd_student;

-- Adding correct pwd user professional
WITH add_correct_pwd_user AS (
    INSERT INTO public.app_user
    (first_name, last_name, email, pwd, active, enabled, created_at, updated_at)
    VALUES('Correct', 'Professional', 'correct_pwd_pro@email.com', 'gK4/XJRdHXemoeZxeNRcZDjSjdt5bQegge3ACVo5mJHyL9wXTaU/6QQWHYXOuMMtgyiuDL07scr90HvL+slMkg==', true, true, current_timestamp, current_timestamp)
    RETURNING *
), insert_correct_pwd_professional AS (
    INSERT INTO public.student (id)
    SELECT u.id
    FROM add_correct_pwd_user u
    RETURNING *
) select * from insert_correct_pwd_professional;