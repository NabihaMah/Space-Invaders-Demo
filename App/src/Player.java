import java.awt.*;

// creates the player
public class Player {

    // x and y coordinates and which way it moves
    private int x, y, right, left;

    // sets the players location and movement
    public Player(int xx, int r, int l){
    x=xx;
    y=700;
    right=r;
    left=l;
    }

    //controls the movement of the player
    public void move(boolean[] keys){
        if (keys[right]) { // if the right key is pressed the player moves right
            if(x>=0 && x <=700){
                x+=10;
            }
            else if (x<0){
                x=0;
            }
            else if (x>700){
                x=700;
            }
        }
        if (keys[left]) { // if the left key is pressed the player moves left
            if(x>=0 && x<=700){
                x-=10;
            }
            else if (x<0){
                x=0;
            }
            else if (x>700){
                x=700;
            }
        }
    }

    //draws the player
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 60, 18);
        g.fillRect(x+5, y-6, 50, 6);
        g.fillRect(x+23, y-14, 14, 8);
        g.fillRect(x+28, y-18, 4, 4);
    }

    //returns the area of the player
    public Rectangle getRect(){
        return new Rectangle(x, y, 60, 20);
    }

    // sets the x position
    public void setX(int x) {
        this.x = x;
    }

    // returns the player's x location
    public int getX(){
        return x;
    }
}
