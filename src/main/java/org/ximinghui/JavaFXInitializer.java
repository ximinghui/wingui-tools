package org.ximinghui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

class JavaFXInitializer {

    private JavaFXInitializer() {
    }

    public static final class App extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Platform.exit();
        }
    }

    public static void init() {
        Application.launch(App.class);
    }

}
