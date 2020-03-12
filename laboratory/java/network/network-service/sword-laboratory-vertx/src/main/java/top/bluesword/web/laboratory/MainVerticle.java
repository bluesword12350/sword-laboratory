package top.bluesword.web.laboratory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * @author 李林峰
 */
public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) {
    Vertx.vertx().createHttpServer()
            .requestHandler(req -> req.response().end("Hello World!"))
            .listen(8080);
  }
}
