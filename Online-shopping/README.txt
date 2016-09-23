Project web app for online shopping.
--------------------------------------------------------------------------------------------
Phone number: +375(29) 293884624
E-mail: alexeydruzik@inbox.ru
--------------------------------------------------------------------------------------------
On this website you can choice with criteria your goods and put required amount
in cart (in user interface you will see quantity and sum), also you can make order with
relationship many to many. The goods, orders and goods in orders will be store in a
separate table. You can choice your language - English or French. On the separate
page, you will can see properies of goods.

If you are an administrator, you can view all additional elements, it's realized with
Spring Security. You can navigate on sate pages free.
--------------------------------------------------------------------------------------------
The project was developed using the  technologies MAVEN, HIBERNATE, SPRING, MYSQL, APACHE TOMCAT

--------------------------------------------------------------------------------------------
USED VERSIONS
--------------------------------------------------------------------------------------------
Maven: 3.3.9
Hibernate: 4.2.6.Final
Spring: 4.2.6.RELEASE
Spring security: 4.2.5.RELEASE
MYSQL 6.3.6
JDK 1.8.74 x64
Tomcat 8.0.33
JNDI
JUnit, Cobertura

----------------------------------------------------------------------------------------------
INSTALLATION
----------------------------------------------------------------------------------------------
1. MYSQL http://dev.mysql.com/
Database settings you can find on the way /dao/src/main/resources/daoApplication.properties
Change settings:
db.username = root
db.password = root
db.url = jdbc:mysql://localhost:3306/internetshop
If you  have anather username and parol, please change in /dao/src/main/resources/daoApplication.properties
and username and parol in ExecuteBuild.bat on your username and parol

2.MAVEN http://maven.apache.org/
Open the file settings.xml in your maven(...\maven3.3.9\conf\settings.xml)
and write inside the tag <servers>

<server>
<id>TomcatServer</id>
<username>root</username>
<password>root</password>
</server>

3.APACHE TOMCAT http://tomcat.apache.org/

Open the file tomcat-users.xml in your tomcat(...\apache-tomcat-8.0.33\conf\tomcat-users.xml)
and write inside the tag

<tomcat-users>
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<user username="user" password="user" roles="manager-gui,manager-script" />
</tomcat-users>

4. Check registration of the environment variables
Use command line: write command "set"
Check whether the registered variables:
-CATALINA_HOME
-JAVA_HOME
-M2_HOME
-PATH (TOMCAT,MAVEN,MYSQL,JDK)

Windows 7:
For registration -CATALINA_HOME:
GO My Computer ->Select Properties->Advanced setting->Environment Variables
Under System Variables, click New.
Enter the variable name as CATALINA_HOME.
Enter the variable value as the installation path for the Tomcat.
Click OK.
Set Tomcat Path under system variable
PATH= ..\apache-tomcat 8.0.33\bin

For registration -JAVA_HOME:
You must do the same actions as for -CATALINA_HOME:
the variable name as JAVA_HOME
PATH= C:\Program Files\Java\jdk1.8.74

For registration -M2_HOME:
You must do the same actions as for -CATALINA_HOME:
the variable name as M2_HOME
PATH= ..\apache-maven-3.3.9\bin

5. Create on disc C, folder with name - PvtProject1

6. Download project from GitHub github.com/Alexis-Dk/internet-store, and put his in this folder PvtProject1.

7. Run ExecuteBuild.bat in root folder of project.

8. If shell ask you access to replace file, please press 'Y' twice in shell to access change.

9. Go to http://localhost:8080/Internet-store/

---------------------------------------------------------------------------
DEFAULT USER:
login: user
password: user
--------------------
DEFAULT ADMIN
login: admin
password: admin
-----------------------------------------------------------------------------
Contact GitHub API Training Shop Blog About
© 2016 GitHub, Inc. Terms Privacy Security Status Help