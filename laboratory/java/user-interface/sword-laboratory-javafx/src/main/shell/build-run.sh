#maven 运行
mvn clean javafx:run

#maven 打包镜像
mvn clean javafx:jlink

#镜像运行
image/bin/java -m top.bluesword.laboratory.HelloFx

#打包镜像为可执行文件
jpackage --type app-image -n HelloFx -m HelloFx/top.bluesword.laboratory.HelloFx --runtime-image .