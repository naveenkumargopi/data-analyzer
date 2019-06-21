package com.exoplanet.utils;

import com.exoplanet.config.AppConfig;
import com.exoplanet.domain.ExoPlanet;
import com.exoplanet.exception.AppException;

import java.io.IOException;
import java.net.URL;

public class CatalogUtil {

    private static ExoPlanet[] exoPlanets;

    public static ExoPlanet[] getExoPlanetCatalog() {
        if (exoPlanets == null) {
            URL url;
            try {
                url = new URL(AppConfig.EXO_PLANET_JSON_CATALOG_URL);
                exoPlanets = JsonUtils.getObjectMapper().readValue(url, ExoPlanet[].class);
            } catch (IOException e) {
                throw AppException.technicalError(AppConfig.NETWORK_ERROR);
            }
        }
        return exoPlanets;
    }

}
