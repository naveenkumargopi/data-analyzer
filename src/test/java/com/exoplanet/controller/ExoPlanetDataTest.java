package com.exoplanet.controller;

import com.exoplanet.domain.ExoPlanet;
import com.exoplanet.exception.AppException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

public class ExoPlanetDataTest {

    private ExoPlanetDataAnalyzeController exoPlanetDataAnalyzeController;

    @Before
    public void init() {
        exoPlanetDataAnalyzeController = new ExoPlanetDataAnalyzeController();
    }

    @Test
    public void testPlanetCatalogLoad() {
        ExoPlanet[] exoPlanets = exoPlanetDataAnalyzeController.loadCatalog();
        Assert.assertNotNull(exoPlanets);
    }

    @Test
    public void testOrphanPlanetsCount() {
        long orphanPlanetsCount = exoPlanetDataAnalyzeController.getOrphanPlanetsCount();
        Assert.assertEquals(2, orphanPlanetsCount);
        System.out.println(orphanPlanetsCount+" orphan planets has been found");
    }

    @Test
    public void testPlanetOrbitingHottestStar() {
        String name = exoPlanetDataAnalyzeController.getPlanetNameOrbittingHottestStar();
        Assert.assertEquals("V391 Peg b", name);
    }

    @Test
    public void testPlanetGroupsByYear_1() {
        int year = 2014;
        Map<String, Long> discoveredPlanets = exoPlanetDataAnalyzeController.getPlanetGroupsInfoBy(year);
        Assert.assertNotNull(discoveredPlanets);
        Iterator<Map.Entry<String, Long>> itr = discoveredPlanets.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry entry = itr.next();
            System.out.println(entry.getValue()+" "+entry.getKey()+" planets discovered in "+year);
        }
    }

    @Test
    public void testPlanetGroupsByYear_2() {
        int year = 2020;
        Map<String, Long> discoveredPlanets = exoPlanetDataAnalyzeController.getPlanetGroupsInfoBy(year);
        Assert.assertNotNull(discoveredPlanets);
        Iterator<Map.Entry<String, Long>> itr = discoveredPlanets.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry entry = itr.next();
            System.out.println(entry.getValue()+" "+entry.getKey()+" planets discovered in "+year);
        }
    }

    @Test(expected = AppException.class)
    public void testPlanetGroupsByYear_invalidInput() {
        int year = 0;
        exoPlanetDataAnalyzeController.getPlanetGroupsInfoBy(year);
    }

}
