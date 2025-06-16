/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

/**
 *
 * @author jyche
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Rooster extends Character {

    public Rooster(PApplet p, int x, int y, int speed, String imagePath) {
        super(p, x, y, speed, imagePath);
    }

   
    public void drawAt(int x, int y, int width, int height) {
    app.image(image, x, y, width, height);
    }
    
    public boolean isCollidingWith(int otherX, int otherY, int range) {
    int centerX = x + (image.width / 2);
    int centerY = y + (image.height / 2);
    int otherCenterX = otherX + (range / 2);
    int otherCenterY = otherY + (range / 2);
    float d = PApplet.dist(centerX, centerY, otherCenterX, otherCenterY);
    return d < range;
}
    
}
