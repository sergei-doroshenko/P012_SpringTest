package org.sergei.converter;


public interface Converter<T, S>
{
    T convert (S src);
}
