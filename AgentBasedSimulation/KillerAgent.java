package AgentBasedSimulation;
import java.awt.*;

public class KillerAgent extends Agent {
    // monitors if the agent moved in the current iteration or not
    boolean moved;
    // the radius of the agent's sight (or how far it can see other agents)
    int radius;

    public KillerAgent(double x0, double y0, int radius) {
        super(x0, y0);
        // remainder of constructor code
        this.radius = radius;
        alive = true;
        infected = false;
        maxDaysLivedInfected = 100;
        daysLivedInfected = 0;
    }

    // setter for radius
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getter for radius
    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        if (infected) g.setColor(green);
        else if (!moved) g.setColor(lightGray);
        else g.setColor(black);

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        LinkedList<Agent> neighbors = scape.getNeighbors(x, y, radius);
        if (neighbors.size() == 2) {
            Agent neighbor1 = neighbors.get(0);
            Agent neighbor2 = neighbors.get(1);
            if ((neighbor1 instanceof KillerAgent) && (neighbor2 instanceof KillerAgent)) {
                getNewMovementCoords(scape);
                moved = true;
            } else {
                if (neighbor1.getAlive() && neighbor2.getAlive()) {
                    if (neighbor1.equals(this)) {
                        neighbor2.setAlive(false);
                    } else {
                        neighbor1.setAlive(false);
                    }
                }
                moved = false;
            }
        } else {
            getNewMovementCoords(scape);
            moved = true;
        }
    }
}