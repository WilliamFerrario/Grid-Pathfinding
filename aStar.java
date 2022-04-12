import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class aStar {

    List <Node> finalPath = new ArrayList<Node>();
    public int startX;
    public int startY;
    public int goalX;
    public int goalY;

    public boolean inClosed (Node temp, Node[] arr){
        boolean tf = false;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == temp)
            return true;
        }
        return tf;
    }

    void pathTrace (Node start, Node end){
        List <Node> path = new ArrayList<Node>();
        Node current = end;

        while (current != start){
            path.add(current);
            current = current.parent;
        }
        finalPath = path;
    }


    public int calculateDistance(int currentX, int currentY, int goalX, int goalY){
        int distance = ((Math.abs(currentX - goalX) + Math.abs(currentY - goalY))*10);
        return distance;
    }
    
    public void findBestPath(Node [][] nGrid, int startX, int startY, int goalX, int goalY){

        Node start = new Node(true, startX, startY);
        Node goal = new Node(true, startX, startY);

        //*** creating PQ
        PriorityQueue<Node> open = new PriorityQueue<Node>();

        //*** closed array is size of dist
        Node[] closed = new Node[calculateDistance(startX, startY, goalX, goalY)];

        //*** Adding start pos to open PQ
        open.add(start);

        while (!open.isEmpty()){

            int c = 0;
            Node current = open.peek();

            //*** Creating an iterator to run through PQ
            Iterator <Node> iter = open.iterator();

            //may need to only use .next every iteration
            while (iter.hasNext()){
                if (((Node) iter.next()).getF() < current.getF() || ((Node) iter.next()).getF() == current.getF() && ((Node) iter.next()).getH() == current.getH()){
                    current = (Node) iter.next();
                }
            }

            //current = open.peek();
            closed[c] = current;
            open.poll();
            c++;

            
            //*** if node ends up on goal we are done
            if(current == goal){
                pathTrace(start, goal);
                return;
            }

            List <Node> nbrs = new ArrayList <Node>();

            nbrs.add(nGrid[current.xPos + 1][current.yPos]);
            nbrs.add(nGrid[current.xPos - 1][current.yPos]);
            nbrs.add(nGrid[current.xPos][current.yPos + 1]);
            nbrs.add(nGrid[current.xPos][current.yPos - 1]);

            for(int i = 0; i < 4; i++){
                if(nbrs.get(i).isVisitable() && !inClosed(nbrs.get(i), closed)){
                    if(current.getG() + calculateDistance(current.xPos, current.yPos, nbrs.get(i).xPos, nbrs.get(i).yPos) < nbrs.get(i).getG() || open.contains(nbrs.get(i))){
                        nbrs.get(i).setG(current.getG() + calculateDistance(current.xPos, current.yPos, nbrs.get(i).xPos, nbrs.get(i).yPos));
                        nbrs.get(i).setH(calculateDistance(nbrs.get(i).xPos, nbrs.get(i).yPos, goalX, goalY));
                        nbrs.get(i).parent = current; //might not work

                        if (!open.contains(nbrs.get(i))){
                            open.add(nbrs.get(i));
                        }
                    }
                }
            }
        }
    }
}
