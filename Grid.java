import java.awt.*;
import javax.swing.JPanel;

public class Grid extends JPanel{

    Color mutedRed = new Color(192, 76, 83); 
    Color mutedGreen = new Color(61, 154, 61);
    Color mutedGrey = new Color(154, 154, 154);
    
    int cellSize = 30;
    int cellPadding = 3;

    //Creating 20 x 20 game board arrays//

    //0 representing free space, 1 = walls//
    public static int [][] gameBoard = 
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    //neighbors for a* and djiskstra's alg//
    int [][] neighbors = new int [25][25];

    //May not be necessary to use//
    int [][] revealed = new int [25][25];
    int [][] flagged = new int [25][25];

    public static int mouseX = 100;
    public static int mouseY = 100;
    public boolean oneTimeMove = true;

    public void paintComponent(Graphics g){

        if (oneTimeMove == true){
            Move move = new Move();
            this.addMouseMotionListener(move);
            Click click = new Click();
            this.addMouseListener(click);

            oneTimeMove = false;
        }
        
        int mouseX = Move.getMouseX();
        int mouseY = Move.getMouseY();

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1020, 810);

        /**********************************************************
         * ***************Creating Menu Buttons********************
         *********************************************************/

        //execute button
        g.setColor(mutedGrey);
        g.fillRect(15, 15, 212, 84);
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 15 && mouseY <  98){
            g.setColor(Color.gray);  
            g.fillRect(15, 15, 212, 84);
        }

        //clear button
        g.setColor(mutedGrey);
        g.fillRect(15, 105, 212, 84);
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 105 && mouseY <  188){
            g.setColor(Color.gray); 
            g.fillRect(15, 105, 212, 84);
        }

        //place goal button
        boolean goalButton = Click.goalButtonPressed;
        g.setColor(mutedGrey);
        g.fillRect(15, 195, 212, 84);
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 195 && mouseY <  278){
            g.setColor(Color.gray);
            g.fillRect(15, 195, 212, 84);
        }
        if(goalButton == true){
            g.setColor(mutedGreen);
            g.fillRect(15, 195, 212, 84);
            g.setColor(Color.gray);
        }

        //randomize button
        g.setColor(mutedGrey);
        g.fillRect(15, 285, 212, 84);
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 285 && mouseY <  368){
            g.setColor(Color.gray); 
            g.fillRect(15, 285, 212, 84);
        }

        /**********************************************************
         *********Displaying walls, open spaces and goals**********
         *****alongside displaying type of entity over cursor******
         *********************************************************/

        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                g.setColor(mutedGrey);

                if(gameBoard[i][j] == 1){
                    g.setColor(new Color(236, 26, 40));
                }
                if(gameBoard[i][j] == 3){
                    g.setColor(mutedGreen);
                }
                if(gameBoard[i][j] == 0){
                    g.setColor(mutedGrey);
                }
                if(mouseX >= 241 + ((i * cellSize) + cellPadding) && (mouseX <  272 + (i * cellSize)) && mouseY >= 12 + ((j * cellSize) + cellPadding) && (mouseY <  40 + (j * cellSize))){
                    g.setColor(mutedRed);
                }
                if(goalButton == true && mouseX >= 241 + ((i * cellSize) + cellPadding) && (mouseX <  272 + (i * cellSize)) && mouseY >= 12 + ((j * cellSize) + cellPadding) && (mouseY <  40 + (j * cellSize))){
                    g.setColor(new Color(102, 172, 102));
                }

                g.fillRect(241 + (cellPadding + i * cellSize), 12 + cellPadding + j * cellSize, cellSize - 2 * cellPadding,  cellSize - 2 * cellPadding);
            }
        }
    }

    public static int[][] getBoard(){
        return gameBoard;
    }
}
