CREATE VIEW list_of_projects AS
SELECT to_char(p.created, 'dd.mm.yyyy') || ' - ' || p.project_name || ' - ' || count(dp.developer_id) as list_projects
FROM projects p
JOIN developer_project dp on dp.project_id = p.id
GROUP BY created, project_name;