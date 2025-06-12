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

public class Background {
    private int x;
    private int y;
    private int speed;
    private PApplet app;
    private PImage image;
    
    public Background (PApplet p, int x, int y, String imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = app.loadImage(imagePath);
    }
    
    public void move(int dx, int dy){
        x += dx;
        y += dy;
        
        // stops moving too far to the left or top
        if (x > 0) {
            x = 0;
        }    
        if (y > 0) {
            y = 0;
        }
        
        // stops moving too far to the right or bottom
        //1000-1500 = -500 
        int maxX = app.width - image.width;
        int maxY = app.height - image.height;

        if (x < maxX) {
            x = maxX;
        }
        if (y < maxY) {
            y = maxY;
        }
    }
    
    public void position(int x, int y){
        this.x = x;
        this.y=y;
    }
    
    public void draw(){
        app.image(image, x, y);
    }
}
