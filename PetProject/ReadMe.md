# Итоговая контрольная работа
## Выполнила Сисенина А.С. группа 4589
<br>
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).      

``` bash
as@as-VirtualBox:~/PetProject$ cat > HomePets
-Cats
-Dogs
-Hamsters

as@as-VirtualBox:~/PetProject$ cat > PackAnimals
-Horses
-Camels
-Donkeys

as@as-VirtualBox:~/PetProject$ cat PackAnimals HomePets > FriendsOfMan

as@as-VirtualBox:~/PetProject$ cat FriendsOfMan 
-Horses
-Camels
-Donkeys
-Cats
-Dogs
-Hamsters
```
<br>

2.  Создать директорию, переместить файл туда  

``` bash
as@as-VirtualBox:~/PetProject$ mkdir newFolder
as@as-VirtualBox:~/PetProject$ mv PackAnimals newFolder/
```

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
``` bash
root@as-VirtualBox:/home/as# sudo apt update
root@as-VirtualBox:/home/as# sudo apt install mysql-server
root@as-VirtualBox:/home/as# systemctl status mysql.service
root@as-VirtualBox:/home/as# snap install mysql-workbench-community
```
4. Установить и удалить deb-пакет с помощью dpkg.
``` bash
wget https://download.virtualbox.org/virtualbox/7.0.10/virtualbox-7.0_7.0.10-158379~Ubuntu~jammy_amd64.deb
dpkg -i virtualbox-7.0_7.0.10-158379~Ubuntu~jammy_amd64.deb
apt -f install  	
dpkg -l 
dpkg -r virtualbox-7.0 

```
5. Выложить историю команд в терминале ubuntu

![Скриншот истории команд](/images/dpkg.png)
![Скриншот истории команд](/images/mySQL.png)

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.

![Диаграмма](/images/diagram.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
``` SQL
mysql> CREATE DATABASE IF NOT EXISTS FriendsOfMan;

```
8. Создать таблицы с иерархией из диаграммы в БД

![Скриншот списка таблиц из БД](/images/tables_list.png)

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

![Скриншот таблиц 1-3 из БД](/images/tables1.png)
![Скриншот таблиц 4-6 из БД](/images/tables2.png)
![Скриншот таблиц 7-9 из БД](/images/tables3.png)

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу. 

![Скриншот таблиц 1-3 из БД](/images/delete_camels.png)
![Скриншот таблиц 1-3 из БД](/images/horse_donkey_union.png)

11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

``` SQL
CREATE TABLE `young_animals` (
  `id_animals` int NOT NULL,
  `name` char(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `age_month` int DEFAULT NULL,
  PRIMARY KEY (`id_animals`),
  UNIQUE KEY `id_animals_UNIQUE` (`id_animals`)
)

INSERT INTO young_animals (id_animals, name, date_of_birth, age_month)
    SELECT id, name, date_of_birth, TIMESTAMPDIFF(MONTH, date_of_birth, curdate()) AS age_month 
    FROM animals
    WHERE TIMESTAMPDIFF(MONTH, date_of_birth, curdate()) BETWEEN 12 AND 36;
```
![Скриншот таблицs young_animals из БД](/images/young_animals.png)

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
``` SQL
SELECT * FROM animals
LEFT JOIN domestic_animals ON id = domestic_animals.id_animals
LEFT JOIN cats ON id = cats.id_animals
LEFT JOIN dogs ON id = dogs.id_animals
LEFT JOIN hamsters ON id = dogs.id_animals
LEFT JOIN pack_animals ON id = pack_animals.id_animals
LEFT JOIN horses ON id = horses.id_animals
LEFT JOIN young_animals ON id = young_animals.id_animals;
```

![Скриншот таблицs young_animals из БД](/images/all_in_one.png)