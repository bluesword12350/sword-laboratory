package verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;

/**
 * @author 李林峰
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startFuture) {
        System.out.println("v1");
        EventBus eb = vertx.eventBus();
        eb.consumer("news.uk.sport", message -> System.out.println("I have received a message: " + message.body()));
    }
}