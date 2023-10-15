package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        int width = 1000; // Ширина холста
        int height = 800; // Высота холста
        int a = 100; // Большая полуось
        int b = 60; // Малая полуось
        DrawOval drawOval = new DrawOval();

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawOval.drawEllipse(gc, width / 2, height / 2, a, b);

        Group root = new Group(canvas);
        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("Midpoint Ellipse Algorithm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
