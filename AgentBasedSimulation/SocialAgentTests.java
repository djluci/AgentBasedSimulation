package AgentBasedSimulation;

import java.util.Objects;

public class SocialAgentTests {
    public static void main(String[] args) {
        // case 1: testing getX()
        {
            // setup
            SocialAgent a = new SocialAgent(32, 0, 10);

            // verify
            System.out.println((int) a.getX() + " == 32");

            // test
            assert (int) a.getX() == 32 : "Error in SocialAgent::getX()";
        }
        // case 2: testing setX()
        {
            // setup
            SocialAgent a = new SocialAgent(32, 0, 10);
            a.setX(199);
            // verify
            System.out.println((int) a.getX() + " == 199");

            // test
            assert (int) a.getX() == 199 : "Error in SocialAgent::setX()";
        }
        // case 3: testing getY()
        {
            // setup
            SocialAgent a = new SocialAgent(32, 100, 10);
            // verify
            System.out.println((int) a.getY() + " == 100");

            // test
            assert (int) a.getY() == 100 : "Error in SocialAgent::getY()";
        }
        // case 4: testing setY()
        {
            // setup
            SocialAgent a = new SocialAgent(0, 100, 10);
            a.setY(29);
            // verify
            System.out.println((int) a.getY() + " == 29");

            // test
            assert (int) a.getY() == 29 : "Error in SocialAgent::setY()";
        }
        // case 5: testing getRadius()
        {
            // setup
            SocialAgent a = new SocialAgent(0, 100, 10);

            // verify
            System.out.println((int) a.getRadius() + " == 10");

            // test
            assert (int) a.getRadius() == 10 : "Error in SocialAgent::getRadius()";
        }
        // case 6: testing setRadius()
        {
            // setup
            SocialAgent a = new SocialAgent(0, 100, 10);
            a.setRadius(100);
            // verify
            System.out.println((int) a.getRadius() + " == 100");

            // test
            assert (int) a.getRadius() == 100 : "Error in SocialAgent::setRadius()";
        }
        // case 7: testing toString()
        {
            // setup
            SocialAgent a = new SocialAgent(0, 100, 10);
            // verify
            System.out.println(a + " == (0.0, 100.0)");

            // test
            assert Objects.equals(a.toString(), "(0.0, 100.0)") : "Error in SocialAgent::toString()";
        }
        // case 8: testing getNewMovementCoords()
        {
            // setup
            SocialAgent a = new SocialAgent(20, 100, 10);
            a.getNewMovementCoords(new Landscape(1000,1000));
            // verify
            System.out.println(a.getX() + " != 20");
            System.out.println(a.getY() + " != 100");

            // test
            assert a.getX() != 20 : "Error in SocialAgent::getNewMovementCoords()";
            assert a.getX() != 100 : "Error in SocialAgent::getNewMovementCoords()";
        }
    }
}