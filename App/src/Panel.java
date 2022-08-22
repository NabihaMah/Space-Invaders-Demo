import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {

    Timer timer;
    private Player player; // the player of the game
    private ArrayList<Barrier> barriers; // array list of all the barriers
    private PlayerShot playerShot; // the player's bullet
    private ArrayList<AlienShot> alienShots; // the aliens bullets
    private ArrayList<Alien> aliens; // all of the aliens
    private boolean win; // whether the player has won or not
    private String screen = "intro"; // what screen the game is on

    int GREEN = 0xFF00FF00; // the color green
    private int lives; // the player's lives
    private int score; // the player's score
    private int highScore; // the player's high score
    private int level;
    boolean [] keys; // used to get the key code when a key is pressed
    Image alienPics; // alien picture

    // creates the new panel for the game to be played
    public Panel(){
        super();
        player = new Player(380, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        keys = new boolean[2000];
        lives = 3; // starts with 3 lives
        score =0; // score starts at 0
        level=1; // first level is 0

        ArrayList<Barrier> bars = new ArrayList<Barrier>(); // array list of all the barriers
        Barrier barrier1 = new Barrier(50); // 4 barriers
        Barrier barrier2 = new Barrier(250);
        Barrier barrier3 = new Barrier(450);
        Barrier barrier4 = new Barrier(650);
        bars.add(barrier1); // the barriers are added to an array list of barriers
        bars.add(barrier2);
        bars.add(barrier3);
        bars.add(barrier4);
        barriers = bars;

        playerShot = new PlayerShot(player, KeyEvent.VK_SPACE); // creates a bullet for the player

        ArrayList<AlienShot> aliShots = new ArrayList<AlienShot>(); // creating and adding the alien's bullets
        AlienShot alienShot1 = new AlienShot();
        AlienShot alienShot2 = new AlienShot();
        AlienShot alienShot3 = new AlienShot();
        aliShots.add(alienShot1);
        aliShots.add(alienShot2);
        alienShots=aliShots;


        ArrayList<Alien> ali = new ArrayList<Alien>(); // creates an array list of aliens
        Image alienPic;
        for (int j=0; j<5; j++) {
            for (int i = 0; i < 8; i++) {
                if (j==0) {
                    alienPic = new ImageIcon("alien1.png").getImage();
                }
                else if (j==1 || j==2) {
                    alienPic = new ImageIcon("alien2.png").getImage();
                }
                else {
                    alienPic = new ImageIcon("alien3.png").getImage();
                }
                alienPics =alienPic;
                Alien alien = new Alien(i * 47 + 100, j*50, alienPic, 1);
                ali.add(alien);
            }
        }
        aliens=ali;
        setPreferredSize(new Dimension(800,800)); // sets the size of the panel
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocus();
        timer = new Timer(20, this);
        timer.start();
    }

    // draws the screen the game is on
    @Override
    public void paint(Graphics g){
        // if the screen is the intro it draws the intro
        if (screen=="intro"){
            g.setColor(Color.BLACK);
            g.fillRect(0,0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 100));
            g.drawString("Space", 250, 150);
            g.drawString("Invaders", 200, 300);
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 40));
            g.drawString("Start Game", 300, 500);
        }

        //if the screen is the game it draws the game
        if (screen == "game") {
            drawGame(g);
        }

        // if level 1 finishes level
        if (screen=="level2Intro"){
            g.setColor(Color.BLACK);
            g.fillRect(0,0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 80));
            g.drawString("Level 2", 300, 150);
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 20));
            g.drawString("Click to Continue", 350, 400);
        }

        if (screen=="level2"){
            drawGame(g);
        }

        if (screen=="end"){
            g.setColor(Color.BLACK);
            g.fillRect(0,0, getWidth(), getHeight());
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 40));
            if (win == true) {
                g.drawString("You Win!!", 300, 300);
            }
            else{
                g.drawString("You Lost, Better Luck Next Time", 100, 300);
            }
            g.setFont(new Font("Times New Roman MS", Font.BOLD, 25));
            g.drawString("Click to play again", 300, 500);
            if (score>highScore){
                g.drawString("New High Score:" + score, 300, 700);
            }
        }
    }

    // sets up level 2
    public void setupLevel(){
        player.setX(380);
        playerShot.remove(); // moves the player's bullet off screen
        for (AlienShot shot: alienShots){ // moves the alien's bullets off screen
            shot.remove();
        }
        lives = 3; // resets the lives

        ArrayList<Barrier> bars = new ArrayList<Barrier>(); // resets the barriers
        Barrier barrier1 = new Barrier(50);
        Barrier barrier2 = new Barrier(250);
        Barrier barrier3 = new Barrier(450);
        Barrier barrier4 = new Barrier(650);
        bars.add(barrier1);
        bars.add(barrier2);
        bars.add(barrier3);
        bars.add(barrier4);
        barriers = bars;

        ArrayList<Alien> ali = new ArrayList<Alien>(); // resets the aliens
        Image alienPic;
        for (int j=0; j<5; j++) {
            for (int i = 0; i < 10; i++) {
                if (j==0) {
                    alienPic = new ImageIcon("alien1.png").getImage();
                }
                else if (j==1 || j==2) {
                    alienPic = new ImageIcon("alien2.png").getImage();
                }
                else {
                    alienPic = new ImageIcon("alien3.png").getImage();
                }
                alienPics =alienPic;
                Alien alien = new Alien(i * 47 + 100, j*50, alienPic, 2);
                ali.add(alien);
            }
        }
        aliens=ali;
    }

    public void drawGame(Graphics g){
    g.setColor(Color.BLACK);
    g.fillRect(0,0,getWidth(), getHeight());
        for (Barrier b: barriers){
            b.draw(g);
        }
    playerShot.draw(g);
        for (AlienShot shot: alienShots){
            shot.draw(g);
        }
        for (AlienShot shot: alienShots){
            shot.draw(g);
        }
        player.draw(g);
    for (int i=0; i<aliens.size(); i++) {
    aliens.get(i).draw(g);
    g.setColor(Color.WHITE);
    g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    g.drawString("Lives: " + lives, 10, 700);
    g.drawString("Score: " + score, 10, 20);
    g.drawString("High Score: " + highScore, 200, 20);

    }
    }

    // runs the rules of the game
    public void playGame(){
        playerHit();
        playerShoot();
        alienShoot();
        barrierHit();
        removeAlien();
        move();
    }

    //restarts the game
    public void restart(){
        score=0; // resets score
        level=1; // starts at level 1
        player.setX(380); // resets player
        playerShot.remove(); // resets the player's bullet
        for (AlienShot shot: alienShots){ // restes the alien's bullets
            shot.remove();
        }
        lives = 3; // restes the lives

        ArrayList<Barrier> bars = new ArrayList<Barrier>(); // resets the barriers
        Barrier barrier1 = new Barrier(50);
        Barrier barrier2 = new Barrier(250);
        Barrier barrier3 = new Barrier(450);
        Barrier barrier4 = new Barrier(650);
        bars.add(barrier1);
        bars.add(barrier2);
        bars.add(barrier3);
        bars.add(barrier4);
        barriers = bars;

        ArrayList<Alien> ali = new ArrayList<Alien>(); // resets the aliens
        Image alienPic;
        for (int j=0; j<5; j++) {
            for (int i = 0; i < 8; i++) {
                if (j==0) {
                    alienPic = new ImageIcon("alien1.png").getImage();
                }
                else if (j==1 || j==2) {
                    alienPic = new ImageIcon("alien2.png").getImage();
                }
                else {
                    alienPic = new ImageIcon("alien3.png").getImage();
                }
                alienPics =alienPic;
                Alien alien = new Alien(i * 47 + 100, j*50, alienPic, 1);
                ali.add(alien);
            }
        }
        aliens=ali;

    }

    // moves all the objects
    public void move() {
        player.move(keys); // moves the player
        for (Alien ali: aliens){ // moves the aliens
                ali.move();
                if(ali.getX()<=0 || ali.getX()>=750){ // if an alien hits a wall all aliens change their direction
                    for(Alien a: aliens){
                        a.changeDirection();
                    }
                }
                if (ali.getRect().intersects(player.getRect())){ // if an alien hits the player, the player loses
                    win=false;
                    screen="end";
                }
         }
        playerShot.move(); // moves the player's bullet
        for (AlienShot shot: alienShots){ // moves the alien's bullets
            shot.move();
        }
    }

    // checks if a barrier has been hit and destroys it as needed
    public  void barrierHit() {

        // if the barrier is hit by the player bullet it is removed and the barrier becomes transparent
        if (barriers.size() > 0) {
            for (int k = 0; k < 4; k++) {
                Barrier thisBarrier = barriers.get(k);
                for (int w = 0; w < 5; w++) {
                    for (int u = 0; u < 15; u++) {
                        if (thisBarrier.getRect().contains(playerShot.getX() + w, playerShot.getY() - u)) {
                            int offx = playerShot.getX() + w - thisBarrier.getX();
                            int offy = playerShot.getY() - u - thisBarrier.getY();
                            int col = thisBarrier.getColour(offx, offy);
                            if (col == GREEN) {
                                playerShot.remove();
                                for (int i = -5; i < 5; i++) {
                                    for (int j = -5; j < 5; j++) {
                                        thisBarrier.setColour(offx + i, offy + j, 0x00000000);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // if the barrier is hit by the alien bullet it is removed and the barrier becomes transparent
        if (barriers.size() > 0) {
            for (int k = 0; k < 4; k++) {
                for (AlienShot shot : alienShots) {
                    Barrier thisBarrier = barriers.get(k);
                    for (int w = 0; w < 5; w++) {
                        for (int u = 0; u < 15; u++) {
                            if (thisBarrier.getRect().contains(shot.getX() + w, shot.getY() - u)) {
                                int offx = shot.getX() + w - thisBarrier.getX();
                                int offy = shot.getY() -u- thisBarrier.getY();
                                int col = thisBarrier.getColour(offx, offy);
                                if (col == GREEN) {
                                    shot.remove();
                                    for (int i = -5; i < 5; i++) {
                                        for (int j = -5; j < 5; j++) {
                                            thisBarrier.setColour(offx + i, offy + j, 0x00000000);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // shoots the bullet from the player
    public void playerShoot(){
        playerShot.reshoot(keys, player);
    }

    // checks if the player has been hit and sets lives
    public void playerHit(){
        for (AlienShot shot: alienShots) {
            if (player.getRect().intersects(shot.getRect())) {
                shot.remove();
                lives -= 1;
                player.setX(380);
                if (lives <= 0) {
                    screen = "end";
                    win = false;
                }
            }
        }
    }

    // control the aliens shooting
    public void alienShoot(){
        if (aliens.size() > 0) {
            for (AlienShot shot : alienShots) {
                int r = randint(0, aliens.size() - 1);
                Alien a = aliens.get(r);
                shot.reshoot(a.getX(), a.getY());
            }
        }
    }

    // removes the alien once they have been hit
    public void removeAlien(){
        ArrayList<Alien> remove = new ArrayList<Alien>();
        for (Alien ali:aliens){
            if (ali.getRect().intersects(playerShot.getRect())){
                score+=10;
                remove.add(ali);
                playerShot.remove();
            }
        }
        aliens.removeAll(remove);
        if(screen == "game" && aliens.size()<=0){
            barriers.removeAll(barriers);
            screen ="level2Intro";
        }
        if (aliens.size()<=0 && screen=="level2"){
            win=true;
            screen="end";
        }
    }

    // generates a random number
    public int randint(int low, int high){
        return (int)(Math.random()*(high-low+1))+low;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (screen == "game" ) {
            playGame();
        }
        if(screen == "level2"){
            playGame();
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
     public void keyPressed(KeyEvent e) {
        int k =e.getKeyCode();
        keys[k] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
        keys[k] = false;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // changes the screen
    @Override
    public void mousePressed(MouseEvent e) {
        if (screen=="intro"){
            screen="game";
        }
        if (screen=="level2Intro"){
            screen="level2";
            setupLevel();
        }
        if (screen == "end"){
            screen = "intro";
            if (score > highScore) {
                highScore = score;
            }

            restart();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
