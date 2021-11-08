CREATE VIEW list_developers_of_project AS
select p.project_name, trim(d.last_name || ' ' || d.first_name || ' ' || d.surname) as developer_name
from projects p
join developer_project dp on dp.project_id = p.id
join developers d on dp.developer_id = d.id
group by p.project_name, trim(d.last_name || ' ' || d.first_name || ' ' || d.surname)
order by 1;