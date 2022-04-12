public class Node {
    
    public boolean visitable;
    public int xPos;
    public int yPos;
    public Node[][] nGrid;
    public Node parent;

    //*** costs
    public int g;
    public int h;
    public int f;

    public Node(boolean tVisitable, int x, int y){
        tVisitable = visitable;
        x = xPos;
        y = yPos;
    }

    
    
    public Node getCoord (int x, int y){
        return nGrid[x][y];
    }

    //************************************************
    //** Assigning f may make issues for enemies/walls
    //************************************************
    public int getF(){
        return g + h;
    }

    public int getH(){
        return h;
    }

    public int getG(){
        return g;
    }

    public void setG(int ng){
        g = ng;
    }

    public void setH(int nh){
        g = nh;
    }

    public boolean isVisitable(){
        return visitable;
    }
}
