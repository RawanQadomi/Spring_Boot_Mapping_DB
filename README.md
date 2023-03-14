# Spring_Boot_Mapping_DB

## Create the Database

### **Install Docker and open it**
Open terminal and run below commends

----
1. docker-compose exec  mysql-development mysql -uroot -phelloworld testapp
2. docker run --name=mk-mysql -p3306:3306 -v mysql-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql
Download excel sheet as csv files https://docs.google.com/spreadsheets/d/1q0cTH_bvofhrsPqAkciseXG4gDdUzk3qGlp44cRMFWc/edit#gid=457275569
----

----
Go to path 
/usr/local/var/lib/mysql-files
----
Add downloaded files

You should be installed DBeaver or MYSQLWorkBench
open any of them then run below queries
====
[source, mysql]
----
CREATE Table l2_services (order_type VARCHAR(225), product_type VARCHAR(225), dim_group_id int, order_no TEXT, dim_bookingdate_id int, dim_store_id int, service_fee_code text, product_code text, dim_customer_id VARCHAR(255),	dim_language VARCHAR(255),	dim_totals_currency VARCHAR(255), dim_status_id VARCHAR(255), phone VARCHAR(255),	payment_amount int,	discount_amount int,	service_fee_amount int,base_amount int,	inputvat int,	outputvat int,	product_vat	int, selling_price	int, selling_price_vat	int, ibv int, iov_usd int, gbv int, gbv_usd int);

CREATE Table l1_services (order_type VARCHAR(225), product_type VARCHAR(225), dim_group_id int, order_no TEXT, dim_bookingdate_id int, dim_store_id int,  product_code text, dim_customer_id VARCHAR(255),	dim_language VARCHAR(255),	dim_totals_currency VARCHAR(255), dim_status_id VARCHAR(255), phone VARCHAR(255),	payment_amount int,	discount_amount int,	base_amount int,	inputvat int,	outputvat int,	product_vat	int, selling_price	int, selling_price_vat	int, ibv int, gbv int, conversion_rate_usd);

SET GLOBAL local_infile=TRUE;
SET sql_mode = (SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));

----
====

====
Importing Data
----
open table from navigator right click and select import Data for each table selerately then it will import all Data
----
====


== Create the `application.properties` File

Spring Boot gives you defaults on all things. For example, the default database is `H2`.
Consequently, when you want to use any other database, you must define the connection
attributes in the `application.properties` file.

Create a resource file called `src/main/resources/application.properties`, as the
following listing shows:

====
[source, java]
----
include::complete/src/main/resources/application.properties[]
----
====

Here, `spring.jpa.hibernate.ddl-auto` can be `none`, `update`, `create`, or `create-drop`.
See the https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl[Hibernate documentation] for details.

* `none`: The default for `MySQL`. No change is made to the database structure.
* `update`: Hibernate changes the database according to the given entity structures.
* `create`: Creates the database every time but does not drop it on close.
* `create-drop`: Creates the database and drops it when `SessionFactory` closes.

You must begin with either `create` or `update`, because you do not yet have the database
structure. After the first run, you can switch it to `update` or `none`, according to
program requirements. Use `update` when you want to make some change to the database
structure.

The default for `H2` and other embedded databases is `create-drop`. For other databases,
such as `MySQL`, the default is `none`.

NOTE: It is a good security practice to, after your database is in a production state, set
this to `none`, revoke all privileges from the MySQL user connected to the Spring
application, and give the MySQL user only `SELECT`, `UPDATE`, `INSERT`, and `DELETE`. You
can read more about this at the end of this guide.

== Create the `@Entity` Model

You need to create the entity model, as the following listing
(in `src/main/java/com/seera/database/entity/L1_Services.java`) shows:

====
[source,java,tabsize=2]
----
include::src/main/java/com/seera/database/entity/L1_Services.java[]
----
====

Hibernate automatically translates the entity into a table.

== Create the Repository

You need to create the repository that holds user records, as the following listing
(in `src/main/java/com/seera/database/repository/ExpectedServiceRepo.java`) shows:

====
[source,java,tabsize=2]
----
include::src/main/java/com/seera/database/repository/ExpectedServiceRepo.java[]
----
====

Spring automatically implements this repository interface in a bean that has the same name
(with a change in the case -- it is called `userRepository`).


== Test the Application

Data Base Application updatd and added all details there how to run Application need to right click and run it will extract result from there

Spring Boot support integration with Cucumber and TestNG as well, will add that 
run it easily using 

----
maven install
----

