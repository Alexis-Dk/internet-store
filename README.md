# internet-store
<br>Project web app for online shopping.
<br>--------------------------------------------------------------------------------------------
<br>Phone number: +375(29) 3884624
<br>E-mail: alexeydruzik@inbox.ru
<br>--------------------------------------------------------------------------------------------
<br>On this website you can choice with criteria your goods and put required amount
<br>in cart (in user interface you will see quantity and sum), also you can make order with
<br>relationship many to many. The goods, orders and goods in orders will be store in a
<br>separate table. You can choice your language - English or French. On the separate
<br>page, you will can see properies of goods.
<br>
<br>If you are an administrator, you can view all additional elements, it's realized with
<br>Spring Security. You can navigate on sate pages free.
<br>--------------------------------------------------------------------------------------------
<br>The project was developed using the  technologies MAVEN, HIBERNATE, SPRING, MYSQL, APACHE TOMCAT
<br>
<br>--------------------------------------------------------------------------------------------
<br>USED VERSIONS
<br>--------------------------------------------------------------------------------------------
<br>Maven: 3.3.9
<br>Hibernate: 4.2.6.Final
<br>Spring: 4.2.6.RELEASE
<br>Spring security: 4.2.5.RELEASE
<br>MYSQL 6.3.6
<br>JDK 1.8.74 x64
<br>Tomcat 8.0.33
<br>JNDI
<br>JUnit, Cobertura
<br>
<br>----------------------------------------------------------------------------------------------
<br>INSTALLATION
<br>----------------------------------------------------------------------------------------------
<br>1. MYSQL http://dev.mysql.com/
<br>Database settings you can find on the way /dao/src/main/resources/daoApplication.properties
<br>Change settings:
<br>db.username = root
<br>db.password = root
<br>db.url = jdbc:mysql://localhost:3306/internetshop
<br>If you  have anather username and parol, please change in /dao/src/main/resources/daoApplication.properties
<br>and username and parol in ExecuteBuild.bat on your username and parol
<br>
<br>2.MAVEN http://maven.apache.org/
<br>Open the file settings.xml in your maven(...\maven3.3.9\conf\settings.xml)
<br>and write inside the tag <servers>
<br>
<br><server>
<br><id>TomcatServer</id>
<br><username>root</username>
<br><password>root</password>
<br></server>
<br>
<br>3.APACHE TOMCAT http://tomcat.apache.org/
<br>
<br>Open the file tomcat-users.xml in your tomcat(...\apache-tomcat-8.0.33\conf\tomcat-users.xml)
<br>and write inside the tag
<br>
<br><tomcat-users>
<br>	<role rolename="manager-gui"/>
<br>	<role rolename="manager-script"/>
<br>	<user username="user" password="user" roles="manager-gui,manager-script" />
<br></tomcat-users>
<br>
<br>4. Check registration of the environment variables
<br>Use command line: write command "set"
<br>Check whether the registered variables:
<br>-CATALINA_HOME
<br>-JAVA_HOME
<br>-M2_HOME
<br>-PATH (TOMCAT,MAVEN,MYSQL,JDK)
<br>
<br>Windows 7:
<br>For registration -CATALINA_HOME:
<br>GO My Computer ->Select Properties->Advanced setting->Environment Variables
<br>Under System Variables, click New.
<br>Enter the variable name as CATALINA_HOME.
<br>Enter the variable value as the installation path for the Tomcat.
<br>Click OK.
<br>Set Tomcat Path under system variable
<br>PATH= ..\apache-tomcat 8.0.33\bin
<br>
<br>For registration -JAVA_HOME:
<br>You must do the same actions as for -CATALINA_HOME:
<br>the variable name as JAVA_HOME
<br>PATH= C:\Program Files\Java\jdk1.8.74
<br>
<br>For registration -M2_HOME:
<br>You must do the same actions as for -CATALINA_HOME:
<br>the variable name as M2_HOME
<br>PATH= ..\apache-maven-3.3.9\bin
<br>
<br>5. Create on disc C, folder with name - PvtProject1
<br>
<br>6. Download project from GitHub github.com/Alexis-Dk/internet-store, and put his in this folder PvtProject1.
<br>Like here C:\PvtProject1\Online-shopping
<br>
<br>7. Run ExecuteBuild.bat in root folder of project.
<br>
<br>8. If shell ask you access to replace file, please press 'Y' twice in shell to access change.
<br>
<br>9. For greater reliability, please copy the Internet-store.war to the folder 'webapps' on your server.
<br>
<br>10. Go to http://localhost:8080/Internet-store/
<br>
<br>11. To see cobertura reports, go to root - ..applfolder/web/target/site/cobertura/index
<br>
<br>---------------------------------------------------------------------------
<br>DEFAULT USER:
<br>login: user
<br>password: user
<br>--------------------
<br>DEFAULT ADMIN
<br>login: admin
<br>password: admin
<br>-----------------------------------------------------------------------------
<br>Contact GitHub API Training Shop Blog About
<br>© 2016 GitHub, Inc. Terms Privacy Security Status Help
