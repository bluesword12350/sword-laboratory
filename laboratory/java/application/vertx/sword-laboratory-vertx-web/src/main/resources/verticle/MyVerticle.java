package verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;

/**
 * @author 李林峰
 */
public class MyVerticle extends AbstractVerticle {

    private static void handle(HttpServerRequest req) {
        req.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!");
    }

    @Override
    public void start(Promise<Void> startFuture) {
        HttpServer server = vertx.createHttpServer().requestHandler(MyVerticle::handle);
        server.listen(8080, res -> {
            if (res.succeeded()) {
                startFuture.complete();
            } else {
                startFuture.fail(res.cause());
            }
        });
    }
}