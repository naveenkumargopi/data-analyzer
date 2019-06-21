package com.exoplanet.service;

import java.util.Map;

public interface DataAnalyzeService {

    long getNumberOfOrphanPlanets();

    String getPlanetNameOrbitingHottestStar();

    Map<String, Long> getPlanetGroupsInfoBy(int year);

}
