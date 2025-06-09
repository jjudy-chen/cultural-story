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

public class Menu {
    private PApplet app;
    private PImage image;
    int x, y;
    int width, height;
    
    
    public Menu (PApplet p, int x, int y){
        this.app = p;
//        this.image = app.loadImage(imagePath);
        this.x = x;
        this.y = y;
    }
    
    //draws menu 
    public void draw(){
        //draws menu rectangle
        app.fill(225);
        app.rect(x, y, 900, 700);
        
        //draws start button
        app.fill(255, 255, 255);
        app.rect(200, 100, 80, 60);
    }
    
    //if mouse is colliding with the start button
    public boolean isCollidingWith(Menu other){
        boolean isLeftOfOtherRight = x<other.x + other.width;
        boolean isRightOfOtherLeft = x+width>other.x;
        boolean isAboveOtherBottom = y<other.y+other.height;
        boolean isBelowOtherTop = y+height>other.y;
        
        return isLeftOfOtherRight && isRightOfOtherLeft && isAboveOtherBottom && isBelowOtherTop;
    }
    
    //if mouse is clicking start button
    public boolean isClicked(int mouseX, int mouseY){
        int centerX = x+(180);
        int centerY = y+(60);
        float d = PApplet.dist(mouseX, mouseY, centerX, centerY);
        
        return d<16;
    }
    
    //if mouse is clicked, the start button disapears
    public void startClicked(PApplet p){
        app.fill(225, 225, 225);
        app.rect(200, 100, 80, 60);
    }
}
