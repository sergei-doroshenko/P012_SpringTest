package org.sergei.beans;

public interface MetaInfo {
    <T> String metaInfo(Class<T> clazz);
}
