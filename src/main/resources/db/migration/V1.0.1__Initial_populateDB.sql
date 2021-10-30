--======================================================================================================--
insert into projects (project_name, created)
values ('Проект1', to_date('07.02.2020', 'dd.mm.yyyy hh24:mi:ss'));
insert into projects (project_name, created)
values ('Проект2', to_date('10.08.2019', 'dd.mm.yyyy hh24:mi:ss'));
insert into projects (project_name, created)
values ('Проект3', to_date('05.05.2021', 'dd.mm.yyyy hh24:mi:ss'));
insert into projects (project_name, created)
values ('Проект4', to_date('19.03.2020', 'dd.mm.yyyy hh24:mi:ss'));
insert into projects (project_name, created)
values ('Проект5', to_date('25.10.2021', 'dd.mm.yyyy hh24:mi:ss'));
--======================================================================================================--
insert into companies (company_name)
values ('Компания1');
insert into companies (company_name)
values ('Компания2');
insert into companies (company_name)
values ('Компания3');
insert into companies (company_name)
values ('Компания4');
--======================================================================================================
insert into customers (customer_name)
values ('Заказчик1');
insert into customers (customer_name)
values ('Заказчик2');
insert into customers (customer_name)
values ('Заказчик3');
insert into customers (customer_name)
values ('Заказчик4');
--======================================================================================================--
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Сидоров', 'Валентин', 'Константинович', 27, to_date('21.02.1994', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 1);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Петров', 'Григорий', 'Антонович', 40, to_date('12.11.1981', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 1);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Самойлов', 'Валентин', 'Петрович', 30, to_date('05.07.1991', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 1);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Васильев', 'Анатолий', 'Константинович', 35, to_date('02.01.1986', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 1);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Маслова', 'Елена', 'Александровна', 29, to_date('12.11.1981', 'dd.mm.yyyy hh24:mi:ss'), 'женщина', 1);
------------------------------------------------------------------------------------------------------------
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Разработчик6', '', '', 27, to_date('12.11.1994', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 2);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Разработчик7', '', '', 40, to_date('30.12.1981', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 2);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Разработчик8', '', '', 30, to_date('11.03.1991', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 2);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Разработчик9', '', '', 35, to_date('22.09.1986', 'dd.mm.yyyy hh24:mi:ss'), 'мужчина', 2);
insert into developers(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id)
values('Разработчик10', '', '', 29, to_date('14.06.1981', 'dd.mm.yyyy hh24:mi:ss'), 'женщина', 3);
------------------------------------------------------------------------------------------------------------
insert into developers(last_name, first_name, surname, developer_age, gender, company_id)
values('Разработчик11', '', '', 29, 'мужчина', 3);
insert into developers(last_name, first_name, surname, developer_age, gender, company_id)
values('Разработчик12', '', '', 31, 'мужчина', 3);
insert into developers(last_name, first_name, surname, developer_age, gender, company_id)
values('Разработчик13', '', '', 31, 'мужчина', 3);
insert into developers(last_name, first_name, surname, developer_age, gender, company_id)
values('Разработчик14', '', '', 26, 'мужчина', 3);
insert into developers(last_name, first_name, surname, developer_age, gender, company_id)
values('Разработчик15', '', '', 38, 'мужчина', 3);
--======================================================================================================--
insert into skills(industry, level_skills)
values('Java', 'Junior');
insert into skills(industry, level_skills)
values('Java', 'Middle');
insert into skills(industry, level_skills)
values('Java', 'Senior');
insert into skills(industry, level_skills)
values('C++', 'Junior');
insert into skills(industry, level_skills)
values('C++', 'Middle');
insert into skills(industry, level_skills)
values('C++', 'Senior');
insert into skills(industry, level_skills)
values('C#', 'Junior');
insert into skills(industry, level_skills)
values('C#', 'Middle');
insert into skills(industry, level_skills)
values('C#', 'Senior');
insert into skills(industry, level_skills)
values('JS', 'Junior');
insert into skills(industry, level_skills)
values('JS', 'Middle');
insert into skills(industry, level_skills)
values('JS', 'Senior');
--======================================================================================================--
insert into developer_skill(developer_id, skill_id)
values(2, 3);
insert into developer_skill(developer_id, skill_id)
values(1, 5);
insert into developer_skill(developer_id, skill_id)
values(5, 7);
insert into developer_skill(developer_id, skill_id)
values(4, 12);
insert into developer_skill(developer_id, skill_id)
values(3, 1);
insert into developer_skill(developer_id, skill_id)
values(11, 3);
insert into developer_skill(developer_id, skill_id)
values(15, 2);
insert into developer_skill(developer_id, skill_id)
values(8, 3);
-----------------------------------------------------------------------------------------------
insert into developer_project(developer_id, project_id)
values(1, 3);
insert into developer_project(developer_id, project_id)
values(2, 3);
insert into developer_project(developer_id, project_id)
values(3, 3);
insert into developer_project(developer_id, project_id)
values(4, 3);
insert into developer_project(developer_id, project_id)
values(5, 3);
-----------------------------------------------------------------------------------------------
insert into developer_project(developer_id, project_id)
values(6, 2);
insert into developer_project(developer_id, project_id)
values(7, 2);
insert into developer_project(developer_id, project_id)
values(8, 2);
insert into developer_project(developer_id, project_id)
values(9, 2);
insert into developer_project(developer_id, project_id)
values(10, 2);
-----------------------------------------------------------------------------------------------
insert into developer_project(developer_id, project_id)
values(11, 1);
insert into developer_project(developer_id, project_id)
values(12, 1);
insert into developer_project(developer_id, project_id)
values(13, 1);
insert into developer_project(developer_id, project_id)
values(14, 1);
insert into developer_project(developer_id, project_id)
values(15, 1);
--======================================================================================================--
insert into customer_project(customer_id, project_id)
values(1, 5);
insert into customer_project(customer_id, project_id)
values(2, 4);
insert into customer_project(customer_id, project_id)
values(3, 3);
insert into customer_project(customer_id, project_id)
values(4, 2);
insert into customer_project(customer_id, project_id)
values(4, 1);
--======================================================================================================--
insert into company_project(company_id, project_id)
values(4, 5);
insert into company_project(company_id, project_id)
values(3, 4);
insert into company_project(company_id, project_id)
values(2, 3);
insert into company_project(company_id, project_id)
values(1, 2);
insert into company_project(company_id, project_id)
values(2, 1);
--======================================================================================================--