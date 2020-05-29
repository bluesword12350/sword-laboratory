package verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;

/**
 * @author 李林峰
 */
public class MyVerticle2 extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startFuture) {
        System.out.println("v2");
        EventBus eb = vertx.eventBus();
        eb.publish("news.uk.sport", "Yay! Someone kicked a ball");
    }
}