import java.awt.*;
import java.awt.image.BufferedImage;

public class Barrier {

    private BufferedImage barrier;
    private Graphics barrierG; // graphics of the buffered image
    private int barrierX, barrierY; // x, y position

    // contructer for the barrier, takes in the x to set it
    public Barrier(int xx){
        barrier = new BufferedImage(91,91, BufferedImage.TYPE_INT_ARGB);
        barrierG = barrier.getGraphics();
        barrierG.setColor(Color.GREEN);
        barrierG.fillRect(15, 0, 60, 30);
        barrierG.fillRect(0, 35, 20, 30);
        barrierG.fillRect(70, 35, 20, 30);
        barrierG.fillRect(10, 10, 20, 10);
        barrierG.fillRect(5, 20, 20, 10);
        barrierG.fillRect(0, 30, 20, 15);
        barrierG.fillRect(60, 10, 20, 10);
        barrierG.fillRect(65, 20, 20, 10);
        barrierG.fillRect(70, 30, 20, 15);

        barrierG.fillRect(15, 30, 30, 10);
        barrierG.fillRect(15, 35, 25, 10);
        barrierG.fillRect(15, 40, 20, 10);
        barrierG.fillRect(15, 45, 15, 10);
        barrierG.fillRect(15, 50, 10, 10);

        barrierG.fillRect(45, 30, 30, 10);
        barrierG.fillRect(50, 35, 25, 10);
        barrierG.fillRect(55, 40, 20, 10);
        barrierG.fillRect(60, 45, 15, 10);
        barrierG.fillRect(65, 50, 10, 10);
        barrierX = xx;
        barrierY = 550;
    }

    // draws the barrier
    public void draw(Graphics g){
        g.drawImage(barrier, barrierX, barrierY,null);
    }

    // gets the colour of the x and y position entered
    public int getColour(int x, int y){
        if(x<0||y<0||x>=barrier.getWidth()||y>=barrier.getHeight()){
            return -1;
        }
        return barrier.getRGB(x,y);
    }

    // sets the position at the x and y position
    public void setColour(int x, int y, int rgb){
        if(x<0||y<0||x>=barrier.getWidth()||y>=barrier.getHeight()){
        }
        else {
            barrier.setRGB(x, y, rgb);
        }
    }

    // returns the barrier's hit box
    public Rectangle getRect(){
        return new Rectangle(barrierX, barrierY, 81, 81);
    }

    // returns the x position
    public int getX(){
        return barrierX;
    }

    // returns the y position
    public int getY(){
        return barrierY;
    }


}
