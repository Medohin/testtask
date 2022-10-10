# testtask
<h3>Задание 1</h3><p>
Необходимо разработать веб-приложение для хранения и поиска данных сотрудников компании.   Сущность   сотрудника   должна   состоять   как минимум из следующих полей:   </p>
<li>	Фамилия  </li>
<li>	Имя  </li>
<li>	Отчество  </li>
<li>	Номер мобильного телефона – номер может быть не казахстанским, сотрудник может работать из другой страны удаленно  </li>
<li>	Адрес электронного почтового ящика  </li>
<li>	Страна –  должна   выбираться   из   списка (5-6   стран, нет необходимости перечислять все страны)  </li>
<li>	Город – должен выбираться   из   списка   в зависимости   от    выбранной   страны Дополнительные поля сотрудника   могут быть    добавлены при желании.   </li>
 <p> Для хранения данных может использоваться любая из популярных СУБД: MySQL, Postgres, MS SQL Server, Oracle и другие.
При сохранении данных необходимо производить проверку на правильность (валидация). Правила валидации могут быть разными. 
К примеру, при попытке сохранить некорректный номер телефона, содержащий буквы, необходимо выдавать ошибку. </p>

<br>
<h3>Реализация проекта</h3>
<p> Создание БД на Postgre SQL
</p>
<h4>1. Создаем схему test </h4>
<h4>2. Выполяем скрипты для создания таблиц </h4>
<b>/* Таблица стран */</b>
<div>
CREATE TABLE public.country (
  id SERIAL,
  country_name VARCHAR(100) DEFAULT NULL::character varying,
  CONSTRAINT country_pkey PRIMARY KEY(id)
) 
WITH (oids = false);

CREATE INDEX country_idx ON public.country
  USING btree (id);

INSERT INTO public.country ("id", "country_name")
VALUES 
  (1, E'Казахстан'),
  (2, E'Россия'),
  (3, E'Канада'),
  (4, E'Китай'),
  (5, E'США');</div>
  
 <b>/* Таблица городов */</b>
 <div>
 CREATE TABLE public.city (
  id SERIAL,
  city_name VARCHAR(200) DEFAULT NULL::character varying,
  country_id SMALLINT NOT NULL,
  CONSTRAINT city_pkey PRIMARY KEY(id)
) 
WITH (oids = false);

CREATE INDEX city_idx ON public.city
  USING btree (id);

INSERT INTO public.city ("id", "city_name", "country_id")
VALUES 
  (1, E'Астана', 1),
  (2, E'Алматы', 1),
  (3, E'Шымкент', 1),
  (4, E'Москва', 2),
  (5, E'Санкт-Петербург', 2),
  (6, E'Новосибирск', 2),
  (7, E'Торонто', 3),
  (8, E'Монреаль', 3),
  (9, E'Оттава', 3),
  (10, E'Пекин', 4),
  (11, E'Шанхай', 4),
  (12, E'Чэнду', 4),
  (13, E'Вашингтон', 5),
  (14, E'Нью‑Йорк', 5),
  (15, E'Лос‑Анжелес', 5);
  </div>
  
  <b>/* Таблица списка сотрудников */</b>
  <div>
  CREATE TABLE public.persons (
  id SERIAL,
  last_name VARCHAR,
  first_name VARCHAR,
  patronymic VARCHAR,
  phone VARCHAR(20),
  email VARCHAR(250),
  country_id SMALLINT,
  city_id SMALLINT NOT NULL,
  CONSTRAINT users_id_key UNIQUE(id)
) 
WITH (oids = false);
  </div>
  <h2> При содания проекта Backend используется Spring Boot, а интерфеса вывда (Frontend) реализован на Thymeleaf </h2>
  <h4><a href="http://www.youtube.com/watch?feature=player_embedded&v=nTQUwghvy5Q" target="_blank">
 <img src="http://img.youtube.com/vi/nTQUwghvy5Q/mqdefault.jpg" alt="Watch the video" width="240" height="180" border="10" />
</a></h4>

