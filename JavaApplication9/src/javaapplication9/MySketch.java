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

public class MySketch extends PApplet {
    private Dragon dragon;
    private Rooster rooster, roosterRight;
    private Background background;
    private Cloud cloud;
    private boolean startClicked = false;
    private int x, y;
    private Menu menu;
    int stage = 0;
    private boolean isBlown;
    String selectedCharacter = "";
    
    
    public void settings(){
	   //sets the size of the window
        size (1000,1000);
    }
    
    public void setup(){
	//sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255);
        dragon = new Dragon(this, 50, 100, 5, "images/dragon.png");
        rooster = new Rooster(this, 150, 100, 1, "images/rooster.png");
        roosterRight = new Rooster(this, x, y, 1, "images/roosterRight.png");
        background = new Background(this, 1, 1, "images/background.png");
        menu = new Menu (this, 50, 50);
        cloud = new Cloud(this, 100, 100, 1, "images/cloud.png");
        
    }
    
    public void draw(){
        //background 
        background.draw();
        if (keyPressed) {
            if (keyCode == LEFT) {
            background.move(4, 0);
            } else if (keyCode == RIGHT) {
            background.move(-4, 0);
            } else if (keyCode == UP) {
            background.move(0, 4);
            } else if (keyCode == DOWN) {
            background.move(0, -4);
            }
        }
        
        
        //dragon movement
        if (keyPressed) {
            if (keyCode == LEFT) {
            dragon.move(-1, 0);
            } else if (keyCode == RIGHT) {
            dragon.move(1, 0);
            } else if (keyCode == UP) {
            dragon.move(0, -1);
            } else if (keyCode == DOWN) {
            dragon.move(0, 1);
            }
        }
        
        
        //Rooster movement
        rooster.draw();
        if (keyPressed) {
            if (keyCode == LEFT) {
            rooster.move(-1, 0);
            } else if (keyCode == RIGHT) {
            //roosterRight.draw();
            rooster.move(1,0);
            //roosterRight.move(1, 0);
            } else if (keyCode == UP) {
            rooster.move(0, -1);
            } else if (keyCode == DOWN) {
            rooster.move(0, 1);
            }
        }
        
        
        
        //cloud elements
//        cloud.draw();
//        if(dragon.isCollidingWith(cloud)){
//            fill(225, 0, 0);
//        }
        
        
        //menu screen
        if (stage == 0) {
            // draw menu screen
            menu.start();
            textSize(100);
            fill(0);
            text("START", 375, 445);
            
        } 
        else if (stage == 1) {
            // charcter selection screen
            menu.drawRect();
            textAlign(CENTER);
            textSize(32);
            fill(0);
            text("Choose your character", width/2, 100);

            dragon.drawAt(150, 200, 300, 170);
            rooster.drawAt(630, 200, 200, 180);
            
            textSize(20);
            text("Dragon", 325, 400);
            text("Rooster", 700, 400);
        } 
        else if (stage == 2) {
            // if user chooses dragon character, it displays dragon
            background.draw();
            if (selectedCharacter.equals("dragon")){
                dragon.draw();
            }
        }else if (stage ==3){
            // if user chooses rooster character, it displays rooster
            if (selectedCharacter.equals("rooster")){
                rooster.draw();
            }
    }

//        
    }//closes draw
    
    public void mousePressed() {
    if (stage == 0 && menu.isStartClicked(mouseX, mouseY)) {
        stage = 1;
    } else if (stage == 1) {
        if (menu.isDragonSelected(mouseX, mouseY)) {
            selectedCharacter = "dragon";
            stage = 2;
        } else if (menu.isRoosterSelected(mouseX, mouseY)) {
            selectedCharacter = "rooster";
            stage = 3;
        }
    }
}
    
    
}//closes mySketch class 
