SnowFlake [] snow;

void setup()
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
void draw()
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

void mouseDragged(){
  strokeWeight(10);
  if(mouseButton==RIGHT)
  {
    stroke(0);
  }
  else
  {
    stroke(255,208,0);
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
  void show()
  {
    //your code here
    noStroke();
    fill(255,0,0);
    ellipse(myX,myY,10,10);
    fill(255);
    arc(myX,myY,10,10,0,PI);
    fill(0);
    ellipse(myX,myY,6,6);
    fill(255);
    ellipse(myX,myY,4,4);
  }
  void lookDown()
  {
    //your code here
    int pixel = get(myX,myY+11);
    if (myY < 600 && myY >= 0 && pixel != color(0)){
      isMoving = false;
    }
     else {
      isMoving = true;
    }
  }
  void eraseStroke()
  {
    //your code here
    fill(0);
    ellipse(myX,myY,12,12);
  }
  void move()
  {
    //your code here
    if (isMoving == true){
      myY = myY + 1;
    } 
  }
  void wrap()
  {
    //your code here
    if (myY > 585){
      myY = 0;
      myX = (int)(Math.random()*1200);      
    }
  }
}


