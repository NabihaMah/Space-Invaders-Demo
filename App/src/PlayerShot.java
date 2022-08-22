import java.awt.*;

public class PlayerShot {

    private int x, y, space; // x and y position of the player bullet

    // constructor
    public PlayerShot(Player player, int sp){
        x = player.getX();
        y=-50;
        space=sp;
    }

    // checks if the bullet is on screen
    public boolean checkScreen(){
        if (x<0 || x>800 || y<0 || y>800) {
            return false;
        }
        return true;
    }

    // draws the bullet
    public void draw(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(x +28, y, 5, 15);
            g.drawRect(x+28, y, 5, 10);
    }

    //moves the bullet off screen
    public void remove(){
        y=-50;
    }

    // shoots the bullet when the player presses space
    public void reshoot(boolean [] keys, Player player){
         if (checkScreen()==false && keys[space]){
             x = player.getX(); // shoots from the player x and y
             y=700;
         }

    }

    // moves the bullet
    public void move() {
        y -= 10;
    }


    // returns the rectangle of the bullet
    public Rectangle getRect(){
        return new Rectangle(x+28, y, 5, 10);
    }

    // returns the y position of the bullet
    public int getY(){
        return y;
       }

    // returns the x position of the bullet
    public int getX(){
        return x+28;
    }



}
