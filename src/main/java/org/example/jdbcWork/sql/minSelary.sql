select * from worker w
where w.selary  = (select min (w.selary) from worker w);