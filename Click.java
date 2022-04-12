import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class Click extends Grid implements MouseInputListener{

    public static int[][] updatedBoard = Grid.getBoard();
    public static boolean goalButtonPressed = false;
    public static boolean startButtonPressed = false;
    public static int goalX, goalY;
    public static int startX, startY;
    

    int dragStartPointX = inCellX();
    int dragStartPointY = inCellY();
    boolean pressed = false;

    int dragEndPointX = inCellX();
    int dragEndPointY = inCellY();
    boolean released = true;


    /****************************************************************
     * Mouse Clicked - deals with marking cells as entitys & updates*
     ****the game board array; 0 - open space, 1 - wall, 3 - goal****
     ***************************************************************/
    @Override
    public void mouseClicked(MouseEvent e) {

        int[][] updatedBoard = Grid.getBoard();

        if(inCellX() != -1 && inCellY() != -1){

            if(goalButtonPressed == true){
                updatedBoard[inCellX()][inCellY()] = 3;
                goalButtonPressed = false;
            }
            else if(startButtonPressed == true){
                updatedBoard[inCellX()][inCellY()] = 2;
                startButtonPressed = false;
            }
            else if(updatedBoard[inCellX()][inCellY()] == 0){
                updatedBoard[inCellX()][inCellY()] = 1;
            }
            else{
                updatedBoard[inCellX()][inCellY()] = 0;
            }
        }

        if(inCellX() != -1 && inCellY() != -1){
            System.out.println("The mouse is in cell " + inCellX() + ", " + inCellY());
        }    
        else{
            System.out.println("The pointer is not in any box");
        }

        /*********************************************************
        ****************Menu Button Click Events******************
        *********************************************************/

        //execute algorithm
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 15 && mouseY <  98){
            //excecute
        }

        //clear all placed entities
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 105 && mouseY <  188){
            for (int i = 0; i < 25; i++){
                for (int j = 0; j < 25; j++){
                    updatedBoard[i][j] = 0;
                }
            }
        }

        //set goal state of algorithm
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 194 && mouseY <  279 && goalButtonPressed == false){
            goalButtonPressed = true;
        }
        else if(mouseX >= 15 && mouseX < 228 && mouseY >= 194 && mouseY <  279){
            goalButtonPressed = false;
        }

        //set start state of algorithm
        if(mouseX >= 15 && mouseX < 228 && mouseY >= 285 && mouseY <  368 && startButtonPressed == false){
            startButtonPressed = true;
        }
        else if(mouseX >= 15 && mouseX < 228 && mouseY >= 285 && mouseY <  368){
            startButtonPressed = false;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragStartPointX = inCellX();
        dragStartPointY = inCellY();
        pressed = true;      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragEndPointX = inCellX();
        dragEndPointY = inCellY();
        released = true;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        //System.out.println("DRAGGED");
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    /*********************************************************
    ************Mouse Positions for local mthds***************
    *********************************************************/
    public int inCellX(){
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                if(Move.getMouseX() >= 241 + ((i * 30) + 3) && (Move.getMouseX() <  272 + (i * 30)) && Move.getMouseY() >= 12 + ((j * 30) + 3) && (Move.getMouseY() <  40 + (j * 30))){
                    return i;                    
                }
            }
        }
        return -1;
    }

    public int inCellY(){
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 25; j++){
                if(Move.getMouseX() >= 241 + ((i * 30) + 3) && (Move.getMouseX() <  272 + (i * 30)) && Move.getMouseY() >= 12 + ((j * 30) + 3) && (Move.getMouseY() <  40 + (j * 30))){
                    return j;                    
                }
            }
        }
        return -1;
    }
}