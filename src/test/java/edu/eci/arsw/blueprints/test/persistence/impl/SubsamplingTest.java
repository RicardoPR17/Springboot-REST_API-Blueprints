package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filters.BlueprintSubsamplingFiltering;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SubsamplingTest {

    @Test
    public void shouldDeletePoints(){
        BlueprintSubsamplingFiltering blueprintSubsamplingFiltering = new BlueprintSubsamplingFiltering();

        Point[] pts0 = new Point[] { new Point(40, 40), new Point(40, 40) , new Point(15,15)};
        Blueprint bp0 = new Blueprint("mack", "mypaint", pts0);

        blueprintSubsamplingFiltering.filter(bp0);
        assertNotEquals(pts0, bp0.getPoints().toArray());

    }
}
