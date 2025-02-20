# sql1

# Student Training Center Database
 # Task Overview
I created a Student Training Center Database using MySQL and wrote SQL scripts for database setup, data manipulation, and queries. Additionally, I completed a Java console application that connects to the database and performs specific tasks.

Database Implementation (MySQL)
# 1. Database Schema (DDL Statements)
Created tables with appropriate PRIMARY KEY, FOREIGN KEY, UNIQUE, DEFAULT, CHECK constraints.
Ensured integrity rules as per the provided ERD.
# 2. Views
Created a view to fetch student enrollment details.
Included a test query to check data constraints.
# 3. Stored Procedure
Implemented a procedure to schedule modules for a course based on course_id and course_name.
Used CURSOR, LOOP, and SIGNAL for control flow.
# 4. Triggers
Developed an audit trigger to log any updates to module_cost.
# 5. Data Manipulation (DML Statements)
Inserted sample data from the given file.
# Implemented queries:
Fetch all delegate details.
Fetch delegate details ordered by name.
Fetch course details where course_name starts with 'A'.
Find highest module cost.
Modify queries using INNER JOIN, Sub-Queries.
Calculate and display total module cost.
Java Console Application (NetBeans)
Connected to MySQL using JDBC.
Fetched module cost where cost > 200.
Took user input for course_id and course_name and triggered the stored procedure to schedule modules.
# Files Included:
sql_script.sql → Contains all DDL & DML statements.
database_app.java → Java program for MySQL connectivity.
README.md → This document.
Tools Used
MySQL Server 8.x
MySQL Workbench
NetBeans 8.x
Microsoft Word (for documentation)
