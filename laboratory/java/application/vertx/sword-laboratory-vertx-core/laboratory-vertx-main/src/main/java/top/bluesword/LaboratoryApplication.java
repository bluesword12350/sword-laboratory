package top.bluesword;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

/**
 * @author 李林峰
 */
public class LaboratoryApplication {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        DeploymentOptions options = new DeploymentOptions().setWorker(true);
        vertx.deployVerticle("verticle/MyVerticle.java", options);
        vertx.deployVerticle("verticle/MyVerticle2.java", options);
    }

}
