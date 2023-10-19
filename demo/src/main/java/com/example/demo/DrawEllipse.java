package com.example.demo;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class DrawEllipse {

    public void drawEllipse(GraphicsContext graphicsContext, int centerX, int centerY, int a, int b) {
        int x = 0; //  текущее горизонтальное смещение относительно центра эллипса
        int y = b;

        double p1 = Math.pow(b,2) - Math.pow(a,2) * b + (Math.pow(a,2) / 4);
        double p2 = Math.pow(b,2) * (x + 0.5) * (x + 0.5) + Math.pow(a,2) * (y - 1) * (y - 1) - Math.pow(a,2) * Math.pow(b,2);


        while (2 * Math.pow(b,2) * x < 2 * Math.pow(a,2) * y) {
            plotEllipsePoints( centerX, centerY, x, y, graphicsContext);
            x++;

            if (p1 < 0) {
                p1 += 2 * Math.pow(b,2) * x + Math.pow(b,2);
            } else {
                y--;
                p1 += 2 * Math.pow(b,2) * x - 2 * Math.pow(a,2) * y + Math.pow(b,2);
                // Параметр p1 используется для определения, какой пиксель
                // выбрать на каждом шаге в верхней половине эллипса
                // p2 - в нижней половине
            }
        }



        while (y > 0) {
            plotEllipsePoints(centerX, centerY, x, y, graphicsContext );
            y--;

            if (p2 > 0) {
                p2 += Math.pow(a,2) - 2 * Math.pow(a,2) * y;
            } else {
                x++;
                p2 += 2 * Math.pow(b,2) * x - 2 * Math.pow(a,2) * y + Math.pow(a,2);
            }
        }
    }
    public void plotEllipsePoints(int centerX, int centerY, int x, int y,final GraphicsContext graphicsContext) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        pixelWriter.setColor( centerX + x,  centerY + y, Color.BLACK);
        pixelWriter.setColor( centerX - x,  centerY + y, Color.BLACK); // нижняя половина
        pixelWriter.setColor( centerX + x,  centerY - y, Color.BLACK);
        pixelWriter.setColor( centerX - x,  centerY - y, Color.BLACK); // верхняя половина
    }

}
