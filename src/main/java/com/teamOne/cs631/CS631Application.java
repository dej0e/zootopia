package com.teamOne.cs631;

import com.teamOne.cs631.application.SpringbootJavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FxWeaverSpringBootStarterSampleApplication.
 *
 * @author Rene Gielen
 */
@SpringBootApplication
public class CS631Application {

    public static void main(String[] args) {
        Application.launch(SpringbootJavaFxApplication.class, args);
    }

}
