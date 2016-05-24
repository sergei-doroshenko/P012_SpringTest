package org.sergei.converter.impl;

import org.sergei.converter.Converter;
import org.sergei.domain.Beta;
import org.sergei.domain.a.BetaA;
import org.springframework.stereotype.Component;

/**
 * Created by Sergei_Doroshenko on 5/24/2016.
 */
@Component("betaConverter")
public class ConverterBetaImpl<T, S> implements Converter<BetaA, Beta>
{
    @Override
    public BetaA convert(Beta src)
    {
        return new BetaA();
    }
}
