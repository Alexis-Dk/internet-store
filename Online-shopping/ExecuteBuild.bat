mysql --user=root --password=root < CreateDB.sql

call "MvnCleanPackage.bat"

cd C:\PvtProject1\Online-shopping

xcopy C:\PvtProject1\Online-shopping\server.xml "%CATALINA_HOME%\conf" /s /e /i

xcopy C:\PvtProject1\Online-shopping\Web\target\Internet-store.war "%CATALINA_HOME%\webapps" /s /e /i

catalina start
