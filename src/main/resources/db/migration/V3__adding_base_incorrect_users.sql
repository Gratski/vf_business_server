-- Adding wrong pwd user student
WITH add_wrong_pwd_user AS (
    INSERT INTO public.app_user
    (first_name, last_name, email, pwd, active, enabled, created_at, updated_at)
    VALUES('Wrong', 'Student', 'wrong_pwd_stu@email.com', 'wrong_pwd', true, true, current_timestamp, current_timestamp)
    RETURNING *
), insert_wrong_pwd_student AS (
    INSERT INTO public.student (id)
    SELECT u.id
    FROM add_wrong_pwd_user u
    RETURNING *
) select * from insert_wrong_pwd_student;

-- Adding wrong pwd user professional
WITH add_wrong_pwd_user AS (
    INSERT INTO public.app_user
    (first_name, last_name, email, pwd, active, enabled, created_at, updated_at)
    VALUES('Wrong', 'Professional', 'wrong_pwd_pro@email.com', 'wrong_pwd', true, true, current_timestamp, current_timestamp)
    RETURNING *
), insert_wrong_pwd_professional AS (
    INSERT INTO public.student (id)
    SELECT u.id
    FROM add_wrong_pwd_user u
    RETURNING *
) select * from insert_wrong_pwd_professional;