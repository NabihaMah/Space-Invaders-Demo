import java.awt.*;

public class AlienShot {

    //x and y location of the alien bullet
    private int x, y;

    //the starting location of the alien bullet
    public AlienShot(){
        x= 400;
        y= 820;
    }

    // draws the alien's bullet
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,5,15);

    }

    // move the alien's bullet
    public void move(){
        y+=10;
    }

    // removes the aliens bullet off screen
    public void remove(){
        y=820;
    }

    // checks if the alien's bullet is on screen
    public boolean onScreen(){
        if (x<0 || x>800 || y<0 || y>1000) {
            return false;
        }
        return true;
    }

    // if the alien's bullet is not on screen it shoots again
    public void reshoot(int xx, int yy){
        if(onScreen()==false){
//            x=a.getX();
//            y=a.getY();
            x=xx+20;
            y=yy+40;
        }
    }

    // returns the location of the alien's shot
    public Rectangle getRect(){
        return new Rectangle(x, y, 5, 15);
    }

    //returns the alien's shot's x position
    public int getX() {
        return x;
    }

    //returns the alien's shot's y position
    public int getY(){
        return y;
    }
}
