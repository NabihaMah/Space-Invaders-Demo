import java.awt.*;

public class Alien {

    private int x,y,vx,vy; // x, y position of alien and increases in x and y
    private Image pic; // picture of the alien

    // constructor for the Alien
    public Alien(int xx, int yy, Image p, int vxx){
        pic = p;
        x=xx;
        y=yy;
        vx=vxx;
        vy=25;
    }

    // moves the Alien
    public void move(){
        x+=vx;
    }

    // changes the direction of the Alien
    public void changeDirection(){
            vx *= -1;
            y += vy;
    }

    // draws the alien
    public void draw(Graphics g){
    g.drawImage(pic,x,y,50,50, null);
    }

    // returns the hit box for the alien
    public Rectangle getRect(){
        return new Rectangle(x+5, y+5, 40, 40);
    }


    // returns the aliens x position
    public int getX(){
        return x;
    }

    // returns the aliens y position
    public int getY(){
        return y;
    }
}
