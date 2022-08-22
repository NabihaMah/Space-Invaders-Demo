// Space Invaders
// Nabiha Mahboob
// This is a game with the player( good guy) and a group of aliens. both parties can shoot bullets at each other
// the player must get rid of all the aliens to proceed to the next level. once they finish both levels, they win/
// If the player dies thrice or an alien hits the player physically the player loses. Each alien killed is 10 points.

import javax.swing.*;

// creates the game
public class SpaceInvaders extends JFrame{


    // creates frame and calls panel
    public SpaceInvaders(){
        super("Basic Frame");
        Panel pane = new Panel();
        add(pane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] arg){
        SpaceInvaders game = new SpaceInvaders();
    }
}


