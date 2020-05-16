package io.vertx.ext.web;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李林峰
 */
class VertxWebTest {

    private static final Map<String, JsonObject> products = new HashMap<>();

    public static void main(String[] args) {
        setUpInitialData();
        Vertx vertx = Vertx.vertx();
        Router router = configRouter(vertx);
        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

    private static Router configRouter(Vertx vertx) {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/products/:productId").handler(VertxWebTest::handleGetProduct);
        router.put("/products/:productId").handler(VertxWebTest::handleAddProduct);
        router.get("/products").handler(VertxWebTest::handleListProducts);
        return router;
    }

    private static void handleGetProduct(RoutingContext routingContext) {
        String productId = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productId == null) {
            sendError(400, response);
        } else {
            JsonObject product = products.get(productId);
            if (product == null) {
                sendError(404, response);
            } else {
                response.putHeader("content-type", "application/json").end(product.encodePrettily());
            }
        }
    }

    private static void handleAddProduct(RoutingContext routingContext) {
        String productId = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productId == null) {
            sendError(400, response);
        } else {
            JsonObject product = routingContext.getBodyAsJson();
            if (product == null) {
                sendError(400, response);
            } else {
                products.put(productId, product);
                response.end();
            }
        }
    }

    private static void handleListProducts(RoutingContext routingContext) {
        JsonArray arr = new JsonArray();
        products.forEach((k, v) -> arr.add(v));
        routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());
    }

    private static void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

    private static void setUpInitialData() {
        addProduct(new JsonObject().put("id", "prod3568").put("name", "Egg Whisk").put("price", 3.99).put("weight", 150));
        addProduct(new JsonObject().put("id", "prod7340").put("name", "Tea Cosy").put("price", 5.99).put("weight", 100));
        addProduct(new JsonObject().put("id", "prod8643").put("name", "Spatula").put("price", 1.00).put("weight", 80));
    }

    private static void addProduct(JsonObject product) {
        products.put(product.getString("id"), product);
    }
}
