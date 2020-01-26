import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;;
import java.util.*;
/**
 * Chasing bombs game
 *
 * @author (Jack Oliver - jo343)
 * @version (19/03/2019)
 */
public class Game extends JFrame

{
    /**
     * Variables needed for the game construction and management
     */

    private JFrame gameFrame;
    private JPanel gamePanel = new JPanel(new GridLayout(2, 5));
    private JPanel difficultyPanel = new JPanel();
    private JPanel startPanel = new JPanel();
    private JPanel foundation = new JPanel(new GridLayout(1, 3));
    private JPanel [] bombPanel = new JPanel[10];
    private Color color1 = Color.RED; // Panel colors
    private Color color2 = Color.BLUE;
    private Color color3 = Color.GREEN;
    private Color clickedColor = Color.YELLOW; // Clicked panel color
    private int bomb = 0;
    private int score = 0;
    private int moves = 5; //Easy is the default difficulty
    private int newMoves = 0;
    private int currentClicked = 0;
    private JButton playButton = new JButton("Play a game"); // Play button
    private JButton exitButton = new JButton("Exit"); // Exit button
    private JButton easyButton = new JButton("Easy"); // Difficulty buttons
    private JButton intermediateButton = new JButton("Intermediate");
    private JButton hardButton = new JButton("Difficult");
    private JLabel scoreLabel = new JLabel("");
    private boolean clicked[] = new boolean[10];
    private boolean isActive = false; // Check if clicking is allowed, defaulted off
    /**
     * Constructor for objects of the chasing bombs game
     */
    public Game()
    {
        setSize(600,600);
        setVisible(true);
        add(foundation);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        manageGame();
    }

    /**
     * Manage the game and all its parts;
     * Create the layout for the interface of the game
     * Add in the correct buttons and labels to the correct pannels
     * Assign the bomb for the game when started
     * Listen for click events, and execute required methods for the game
     */

    public void manageGame()
    {
        gamePanel.setBackground(color1);
        difficultyPanel.setBackground(color3);
        startPanel.setBackground(color2);

        scoreLabel.setForeground(Color.WHITE);

        bombLayout();

        startPanel.add(playButton);
        startPanel.add(exitButton);
        startPanel.add(scoreLabel);

        difficultyPanel.add(easyButton);
        difficultyPanel.add(intermediateButton);
        difficultyPanel.add(hardButton);

        playButton.addMouseListener(new MouseAdapter() // start the game
            {
                public void mousePressed(MouseEvent e)
                {
                    if(isActive)
                    {
                        moves = newMoves;
                    }

                    isActive = true;
                    score = 0;
                    for(int x = 0; x < 10; x++)
                    {
                        bombPanel[x].setBackground(color1);
                        clicked[x] = false;
                    }
                    
                    Random rand = new Random();
                    bomb = rand.nextInt(10);
                    scoreLabel.setText("Current score: " + score);
                }
            });

        exitButton.addMouseListener(new MouseAdapter() // close the game
            {
                public void mousePressed(MouseEvent e)
                {
                    System.exit(0);
                }
            });

        easyButton.addMouseListener(new MouseAdapter() // close the game
            {
                public void mousePressed(MouseEvent e)
                {
                    if(!isActive)
                    {
                        moves = 5;
                    }
                    else
                    {
                        newMoves = 5;
                    }
                }
            });

        intermediateButton.addMouseListener(new MouseAdapter() // close the game
            {
                public void mousePressed(MouseEvent e)
                {
                    if(!isActive)
                    {
                        moves = 7;
                    }
                    else
                    {
                        newMoves = 7;
                    }                
                }
            });

        hardButton.addMouseListener(new MouseAdapter() // close the game
            {
                public void mousePressed(MouseEvent e)
                {
                    if(!isActive)
                    {
                        moves = 9;
                    }
                    else
                    {
                        newMoves = 9;
                    }
                }
            });

        foundation.setVisible(true);
        foundation.add(gamePanel);
        foundation.add(startPanel);
        foundation.add(difficultyPanel);

    }

    /**
     * Create the initial layout for the game
     * 10 panels in the game section of the interface created
     * Mouse listeners for when the panels are clicked to complete
     * the correct formatting and increment score for every successful click
     * Check if the game has been won or lost
     */

    public void bombLayout()
    {
        for(int x = 0; x < 10; x++) {
            bombPanel[x] = new JPanel();
            gamePanel.add(bombPanel[x]);
            bombPanel[x].setBackground(color1);
            bombPanel[x].setBorder(BorderFactory.createLineBorder(Color.black));

            bombPanel[x].addMouseListener(new MouseAdapter()
                {
                    public void mousePressed(MouseEvent e)
                    {
                        if (isActive)
                        {
                            JPanel currentPanel = (JPanel)e.getSource();

                            int index = Arrays.asList(bombPanel).indexOf(currentPanel);

                            if (index == bomb)
                            {
                                gameLost();
                            }
                            else if (!clicked[index])
                            {
                                currentPanel.setBackground(clickedColor);    
                                score++;
                                clicked[index] = true;
                                scoreLabel.setText("Current score: " + score);
                                if(moves == score)
                                {
                                    gameWon();
                                }                            
                            }
                        }

                    }
                });

        }
    }

    /**
     *Print a winning message and stop clickling of the game board
     */
    public void gameWon()
    {
        scoreLabel.setText("You win! You scored " + score + " points");      
        isActive = false;        
    }

    /**
     * Print a losing message and stop clicking of the game board
     */
    public void gameLost()
    {
        scoreLabel.setText("You lose! You scored " + score + " points");      
        isActive = false;
    }
}

