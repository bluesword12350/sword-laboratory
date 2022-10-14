# 说明 #
----------
- 工具实验室


# 目录说明
- sword-laboratory【各语言少依赖测试项目，以Java为主】
- laboratory【分包实验项目，每个叶子项目都有一个主要测试的工具包】
  - java
    - api-document【接口文档】
    - compile【压缩】
      - laboratory-apache-compress【org.apache.commons.commons-compress】
      - laboratory-zstandard【com.github.luben.zstd-jni】
    - encode【编码/加密】
      - laboratory-tink【com.google.crypto.tink.tink】
    - office-document【办公文档】
      - laboratory-easypoi【cn.afterturn.easypoi-base】
    - template【模板】
      - laboratory-spring-expression【org.springframework.spring-expression】
    - testing【测试】
      - laboratory-jacoco【org.jacoco.jacoco-maven-plugin】
    - util【工具目录（暂时未分类的工具）】
      - laboratory-guava【com.google.guava.guava】【java小工具集】