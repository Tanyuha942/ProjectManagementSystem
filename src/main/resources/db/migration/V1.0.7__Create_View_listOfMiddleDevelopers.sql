CREATE VIEW list_of_middle_developers AS
SELECT trim(d.last_name || ' ' || d.first_name || ' ' || d.surname) as developer_name
FROM skills s
JOIN developer_skill ds on ds.skill_id = s.id
JOIN developers d on d.id = ds.developer_id
WHERE s.level_skills = 'Middle';