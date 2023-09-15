package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.Filters.BlueprintRedundancyFiltering;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RedundancyTest {

    @Test
    public void shouldDeleteRepeatedPoints(){
        BlueprintRedundancyFiltering blueprintRedundancyFiltering= new BlueprintRedundancyFiltering();

        Point[] pts0 = new Point[] { new Point(40, 40), new Point(40, 40) , new Point(15,15)};
        Blueprint bp0 = new Blueprint("mack", "mypaint", pts0);

        blueprintRedundancyFiltering.filter(bp0);
        assertNotEquals(pts0, bp0.getPoints().toArray());

    }

    @Test
    public void shouldNotDeletePoints(){
        BlueprintRedundancyFiltering blueprintRedundancyFiltering= new BlueprintRedundancyFiltering();

        Point[] pts1 = new Point[] { new Point(50, 50), new Point(40, 40) , new Point(15,15)};
        Blueprint bp1 = new Blueprint("mack", "mypaint", pts1);

        blueprintRedundancyFiltering.filter(bp1);

        List<Point> points= Arrays.asList(pts1);
        assertTrue(bp1.getPoints().equals(points));

    }
}
