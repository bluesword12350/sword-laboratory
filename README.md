# 说明 #
----------
- 工具实验室
  对各编程语言的工具包学习、使用、测试。以java，javascript为主


# 目录说明
- sword-laboratory【各语言少依赖测试项目，以Java为主】
- laboratory【分包实验项目，每个叶子项目都有一个主要测试的工具包】
  - [java](laboratory/java/)
    - [api-document](laboratory/java/api-document/)【接口文档】
    - compile【压缩】
      - laboratory-apache-compress【org.apache.commons.commons-compress】
      - laboratory-zstandard【com.github.luben.zstd-jni】
    - [database](laboratory/java/database/)【数据库】
      - [client](laboratory/java/database/client/)【数据库客户端技术】
        - [laboratory-spring-jpa](laboratory/java/database/client/laboratory-spring-jpa/)
    - encode【编码/加密】
      - laboratory-tink【com.google.crypto.tink.tink】
    - office-document【办公文档】
      - laboratory-easypoi【cn.afterturn.easypoi-base】
    - template【模板】
      - laboratory-spring-expression【org.springframework.spring-expression】
    - [testing](laboratory/java/testing)【测试】
      - laboratory-jacoco
      - [laboratory-jmh](laboratory\java\testing\laboratory-jmh)【微基准性能测试】
    - util【工具目录（暂时未分类的工具）】
      - laboratory-guava [com.google.guava.guava]【google-java小工具集】
      - laboratory-lombok [org.projectlombok.lombok]【java类注解增强工具】
  - [javascript](laboratory/javascript/)
    - [component-library](laboratory/javascript/component-library/)【组件库】
      - [laboratory-antdv](laboratory/javascript/component-library/laboratory-antdv/)【Ant Design组件库 的 Vue 实现】
    - [office-document](laboratory/javascript/office-document/)【办公文档】
      - [laboratory-marked](laboratory/javascript/office-document/laboratory-marked/)【markedjs/marked】【markdown解析工具】