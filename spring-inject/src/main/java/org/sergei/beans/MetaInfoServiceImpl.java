package org.sergei.beans;

import org.springframework.stereotype.Service;

@Service
public class MetaInfoServiceImpl implements MetaInfo {

    public String getInfo() {
        return "[==>INFO<==]";
    }

    @Override
    public <T> String metaInfo(Class<T> clazz) {
        return "[==>META<==]";
    }
}
