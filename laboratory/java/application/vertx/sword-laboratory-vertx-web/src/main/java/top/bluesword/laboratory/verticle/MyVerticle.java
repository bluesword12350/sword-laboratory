package top.bluesword.laboratory.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

/**
 * @author 李林峰
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {
        HttpServer server = vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        });
        server.listen(8080, res -> {
            if (res.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(res.cause());
            }
        });
    }
}