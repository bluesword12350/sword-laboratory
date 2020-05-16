package top.bluesword.laboratory.verticle;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

class MyVerticleTest {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        DeploymentOptions options = new DeploymentOptions().setWorker(true);
        vertx.deployVerticle("verticle/MyVerticle.java", options);
    }

}