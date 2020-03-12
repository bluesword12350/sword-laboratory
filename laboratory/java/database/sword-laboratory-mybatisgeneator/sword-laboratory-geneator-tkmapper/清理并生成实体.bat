rd /s /q dao
rd /s /q entity
del /s /q mapper\*
mvn mybatis-generator:generate
pause