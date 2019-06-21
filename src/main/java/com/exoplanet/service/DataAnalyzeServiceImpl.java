package com.exoplanet.service;

import com.exoplanet.config.AppConfig;
import com.exoplanet.domain.ExoPlanet;
import com.exoplanet.utils.CatalogUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzeServiceImpl implements DataAnalyzeService {

    @Override
    public long getNumberOfOrphanPlanets() {
        return Arrays.stream(CatalogUtil.getExoPlanetCatalog()).parallel().filter(exoPlanet -> exoPlanet.getTypeFlag() == AppConfig.ORPHAN_TYPE_FLAG_VALUE).count();
    }

    @Override
    public String getPlanetNameOrbitingHottestStar() {
        ExoPlanet[] exoPlanets = CatalogUtil.getExoPlanetCatalog();
        PriorityQueue<ExoPlanet> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i < exoPlanets.length; i++) {
            priorityQueue.add(exoPlanets[i]);
        }
        ExoPlanet exoPlanet = priorityQueue.poll();
        System.out.println(exoPlanet.getPlanetIdentifier()+" orbits the hottest star with temp: "+exoPlanet.getHostStarTempK());
        return exoPlanet.getPlanetIdentifier();
    }

    @Override
    public Map<String, Long> getPlanetGroupsInfoBy(int year) {
        ExoPlanet[] exoPlanets = CatalogUtil.getExoPlanetCatalog();
        Stream<ExoPlanet> exoPlanetsByYear = Arrays.stream(exoPlanets).filter(exoPlanet -> exoPlanet.getDiscoveryYear() == year);
        Map<String, Long> map = exoPlanetsByYear.collect(Collectors.groupingBy(ExoPlanet::getSize, Collectors.counting()));
        return map;
    }
}
