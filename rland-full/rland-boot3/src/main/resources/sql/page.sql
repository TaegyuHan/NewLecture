-- 오라클
select * from (
    -- 2. 번호 붙이고
    select rownum as num, m.* from (
        -- 1. 정렬 하고
        select * from menu
        order by menu_id desc
    ) m
)
-- 2. 붙인 번호로 페이징을 한다.
where num between 5 and 10;


-- mariaDB
select * from menu
order by reg_date
limit 10 offset 10;