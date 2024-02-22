select * from project p
where p.month_count  = (select max (p.month_count) from project p );