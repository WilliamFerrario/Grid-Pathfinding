import java.awt.*;

import javax.swing.JPanel;

public class Grid extends JPanel{

    int cellSize = 30;
    int cellPadding = 3;

    public static int mouseX = 100;
    public static int mouseY = 100;
    public static int mouseClicked = 0;
    public boolean oneTimeMove = true;

    public void paintComponent(Graphics g){

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1020, 810);

        if (oneTimeMove == true){
            Move move = new Move();
            this.addMouseMotionListener(move);
            Click click = new Click();
            this.addMouseListener(click);

            oneTimeMove = false;
        }
        
        int mouseX = Move.getMouseX();
        int mouseY = Move.getMouseY();

        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                g.setColor(Color.lightGray);
                if(mouseX >= 241 + ((i * cellSize) + cellPadding) && (mouseX <  272 + (i * cellSize)) && mouseY >= 12 + ((j * cellSize) + cellPadding) && (mouseY <  40 + (j * cellSize))){
                    g.setColor(Color.red);
                    if(Move.mouseClicked == 1){
                        g.fillRect(241 + (cellPadding + i * cellSize), 12 + cellPadding + j * cellSize, cellSize - 2 * cellPadding,  cellSize - 2 * cellPadding);
                    }
                }
                g.fillRect(241 + (cellPadding + i * cellSize), 12 + cellPadding + j * cellSize, cellSize - 2 * cellPadding,  cellSize - 2 * cellPadding);
            }
        }
    }
}
