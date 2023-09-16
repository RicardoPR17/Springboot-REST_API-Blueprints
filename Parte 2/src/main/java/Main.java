import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);

        Point[] pts = new Point[] { new Point(0, 0), new Point(10, 10), new Point(10,10) };
        Blueprint bp = new Blueprint("john", "thepaint", pts);
        Blueprint bp2 = new Blueprint("Carlos", "architecture");
        Blueprint bp3 = new Blueprint("Ana", "house");

        bps.addNewBlueprint(bp);
        bps.addNewBlueprint(bp2);
        bps.addNewBlueprint(bp3);
        System.out.println("The registered blueprints are: " + bps.getAllBlueprints());

        try {
            System.out.println(
                    "The blueprint created by Carlos and whose name is architecture: "
                            + bps.getBlueprint("Carlos", "architecture"));
        } catch (BlueprintNotFoundException e) {
        }

        try {
            System.out.println("The blueprint created by Ana: " + bps.getBlueprintsByAuthor("Ana"));
        } catch (BlueprintNotFoundException e) {
        }
    }
}
