package com.exoplanet.controller;

import com.exoplanet.config.AppConfig;
import com.exoplanet.domain.ExoPlanet;
import com.exoplanet.exception.AppException;
import com.exoplanet.service.DataAnalyzeService;
import com.exoplanet.service.DataAnalyzeServiceImpl;
import com.exoplanet.utils.CatalogUtil;

import java.util.*;

public class ExoPlanetDataAnalyzeController {

    private DataAnalyzeService dataAnalyzeService = new DataAnalyzeServiceImpl();

    public ExoPlanet[] loadCatalog() {
        return CatalogUtil.getExoPlanetCatalog();
    }

    public long getOrphanPlanetsCount() {
        return dataAnalyzeService.getNumberOfOrphanPlanets();
    }

    public String getPlanetNameOrbittingHottestStar() {
        return dataAnalyzeService.getPlanetNameOrbitingHottestStar();
    }

    public Map<String, Long> getPlanetGroupsInfoBy(int year) {
        if (year < AppConfig.MIN_YEAR || year > AppConfig.MAX_YEAR)
            throw AppException.invalidRequest(AppConfig.INVALID_INPUT);
        return dataAnalyzeService.getPlanetGroupsInfoBy(year);
    }
}
