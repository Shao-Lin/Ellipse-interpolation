package com.example.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class InterpolationEllipse {


    public static void drawEllipseWithColorInterpolation(int centerX, int centerY, int a, int b, Color startColor, Color endColor, GraphicsContext graphicsContext) {

        for (int y = -b; y <= b; y++) {
            int x = (int) (a * Math.sqrt(1 - (double) y * y / Math.pow(b,2)));
            double interpolationFactor = 1.0 - (Math.abs(y) / (double) b); // Интерполяционный фактор от 0 (startColor) до 1 (endColor)
            Color interpolatedColor = interpolateColor(startColor, endColor, interpolationFactor);
            final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
            for(int i = 0; centerX - x -1 + i <= centerX + x; i++) {
                pixelWriter.setColor( centerX - x - 1 + i, y + centerY, interpolatedColor);
            }
        }
    }

    public static Color interpolateColor(Color start, Color end, double factor) {
        double red = start.getRed() + (end.getRed() - start.getRed()) * factor;
        double green = start.getGreen() + (end.getGreen() - start.getGreen()) * factor;
        double blue = start.getBlue() + (end.getBlue() - start.getBlue()) * factor;
        return new Color(red, green, blue, 0.55);
    }

}
