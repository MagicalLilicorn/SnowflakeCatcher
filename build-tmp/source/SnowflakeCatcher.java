import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snow;

public void setup()
{
  //your code here
  background(0);
  size(1200,600);
  snow = new SnowFlake[100];
  //block = new Block(mouseX,mouseY);
  for (int i = 0; i < snow.length; i++){
    snow[i] = new SnowFlake();
  }  
}
public void draw()
{
  //your code here
  for (int i = 0; i < snow.length; i++){
    snow[i].eraseStroke();
    snow[i].lookDown();
    snow[i].move();
    snow[i].wrap();
    snow[i].show();
  }
}

public void mouseDragged(){
  strokeWeight(10);
  if(mouseButton==RIGHT)
  {
    stroke(0);
  }
  else
  {
    stroke(100,100,255);
  }
  line(mouseX,mouseY,pmouseX,pmouseY);
  noStroke();
}

class SnowFlake
{
  //class member variable declarations
  int myX;
  int myY;
  boolean isMoving;
  SnowFlake()
  {
    //class member variable initializations
    myX = (int)(Math.random()*1200);
    myY = (int)(Math.random()*600);
    isMoving = true;
  }
  public void show()
  {
    //your code here
    noStroke();
    fill(255);
    ellipse(myX,myY,5,5);
  }
  public void lookDown()
  {
    //your code here
    int pixel = get(myX,myY+6);
    if (myY < 600 && myY >= 0 && pixel != color(0)){
        isMoving = false;
    }
     else {
      isMoving = true;
    }
  }
  public void eraseStroke()
  {
    //your code here
    fill(0);
    ellipse(myX,myY,7,7);
  }
  public void move()
  {
    //your code here
    if (isMoving == true){
      myY = myY + 1;
    } 
  }
  public void wrap()
  {
    //your code here
    if (myY > 590){
      myY = 0;
      myX = (int)(Math.random()*1200);      
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
