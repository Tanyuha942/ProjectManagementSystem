CREATE VIEW sum_salary_developers_of_project AS
SELECT p.project_name, sum(d.salary) AS sum_salary
FROM developers d
JOIN developer_project dp ON dp.developer_id = d.id
JOIN projects p ON p.id = dp.project_id
GROUP BY p.project_name;