package org.sergei.converter.impl;

import org.sergei.converter.Converter;
import org.sergei.domain.Alpha;
import org.sergei.domain.a.AlphaA;
import org.springframework.stereotype.Component;

/**
 * Created by Sergei_Doroshenko on 5/24/2016.
 */
@Component("alphaConverter")
public class ConverterAlphaImpl<T, S> implements Converter<AlphaA, Alpha>
{
    @Override
    public AlphaA convert(Alpha src)
    {
        return new AlphaA();
    }
}
