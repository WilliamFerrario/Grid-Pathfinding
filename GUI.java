import javax.swing.JFrame;


public class GUI extends JFrame{

    public GUI(){

        this.setTitle("Grid-Pathfinding");
        this.setSize(1020, 810);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Grid grid = new Grid();
        this.setContentPane(grid);

    }
}

