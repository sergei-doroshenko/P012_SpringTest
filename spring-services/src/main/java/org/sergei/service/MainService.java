package org.sergei.service;

import org.sergei.converter.Converter;
import org.sergei.domain.Alpha;
import org.sergei.domain.Beta;
import org.sergei.domain.a.AlphaA;
import org.sergei.domain.a.BetaA;
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
public class MainService
{
    private Map<String, Strategy> strategies;

    private final Converter<AlphaA, Alpha> alphaConverter;
    private final Converter<BetaA, Beta> betaConverter;

    @Autowired
    public MainService(                              List<Strategy>            strList       ,
                        @Qualifier("alphaConverter") Converter<AlphaA, Alpha>  alphaConverter,
                        @Qualifier("betaConverter")  Converter<BetaA, Beta>    betaConverter  )
    {
        strategies = new HashMap<>();
        for (Strategy s : strList) {
            strategies.put(s.getName(), s);
        }

        this.alphaConverter = alphaConverter;
        this.betaConverter = betaConverter;
    }

    public Strategy getStrategy(String name)
    {
        return strategies.get(name);
    }
}
