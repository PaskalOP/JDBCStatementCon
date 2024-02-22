select * from client c
where c.project_count = (select max(c.project_count) from client c );