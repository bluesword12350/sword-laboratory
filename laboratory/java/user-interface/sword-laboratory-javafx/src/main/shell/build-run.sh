#maven 运行
mvn clean javafx:run

#maven 打包镜像
mvn clean javafx:jlink

#镜像运行
target/image/bin/java -m helloFx/top.bluesword.laboratory.HelloFx

#打包镜像为可执行文件
cd target
jpackage --type app-image -n HelloFx -m helloFx/top.bluesword.laboratory.HelloFx --runtime-image image