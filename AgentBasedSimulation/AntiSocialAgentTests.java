package AgentBasedSimulation;
import java.util.Objects;

public class AntiSocialAgentTests {
    public static void main(String[] args) {
        // case 1: testing getX()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(32, 0, 10);

            // verify
            System.out.println((int) a.getX() + " == 32");

            // test
            assert (int) a.getX() == 32 : "Error in AntiSocialAgent::getX()";
        }
        // case 2: testing setX()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(32, 0, 10);
            a.setX(199);
            // verify
            System.out.println((int) a.getX() + " == 199");

            // test
            assert (int) a.getX() == 199 : "Error in AntiSocialAgent::setX()";
        }
        // case 3: testing getY()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(32, 100, 10);
            // verify
            System.out.println((int) a.getY() + " == 100");

            // test
            assert (int) a.getY() == 100 : "Error in AntiSocialAgent::getY()";
        }
        // case 4: testing setY()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(0, 100, 10);
            a.setY(29);
            // verify
            System.out.println((int) a.getY() + " == 29");

            // test
            assert (int) a.getY() == 29 : "Error in AntiSocialAgent::setY()";
        }
        // case 5: testing getRadius()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(0, 100, 10);

            // verify
            System.out.println((int) a.getRadius() + " == 10");

            // test
            assert (int) a.getRadius() == 10 : "Error in AntiSocialAgent::getRadius()";
        }
        // case 6: testing setRadius()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(0, 100, 10);
            a.setRadius(100);
            // verify
            System.out.println((int) a.getRadius() + " == 100");

            // test
            assert (int) a.getRadius() == 100 : "Error in AntiSocialAgent::setRadius()";
        }
        // case 7: testing toString()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(0, 100, 10);
            // verify
            System.out.println(a + " == (0.0, 100.0)");

            // test
            assert Objects.equals(a.toString(), "(0.0, 100.0)") : "Error in AntiSocialAgent::toString()";
        }
        // case 8: testing getNewMovementCoords()
        {
            // setup
            AntiSocialAgent a = new AntiSocialAgent(20, 100, 10);
            a.getNewMovementCoords(new Landscape(1000, 1000));
            // verify
            System.out.println(a.getX() + " != 20");
            System.out.println(a.getY() + " != 100");

            // test
            assert a.getX() != 20 : "Error in AntiSocialAgent::getNewMovementCoords()";
            assert a.getX() != 100 : "Error in AntiSocialAgent::getNewMovementCoords()";
        }
    }
}