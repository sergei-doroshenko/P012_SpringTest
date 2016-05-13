package org.sergei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergei_Doroshenko on 5/5/2016.
 */
@Service
public class MainService {
    private Map<String, Strategy> strategies;


    @Autowired
    public MainService( List<Strategy> strList )
    {
        strategies = new HashMap<>();
        for (Strategy s : strList) {
            strategies.put(s.getName(), s);
        }
    }

    public Strategy getStrategy(String name)
    {
        return strategies.get(name);
    }
}
