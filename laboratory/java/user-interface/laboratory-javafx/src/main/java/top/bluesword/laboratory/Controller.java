package top.bluesword.laboratory;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.Objects;

/**
 * @author 李林峰
 */
public class Controller {

    public Scene indexScene() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label label = new Label("你好, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        return new Scene(new StackPane(label), 640, 480);
    }

    public Scene webScene() {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        String url = Objects.requireNonNull(getClass().getClassLoader().getResource("持有基金2021-09-17报告.html")).toExternalForm();
        webEngine.load(url);
        return new Scene(new StackPane(webView), 640, 480);
    }

}
