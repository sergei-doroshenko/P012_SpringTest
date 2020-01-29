package org.sergei.beans;

import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements Traceable {

    public String getInfo() {
        return "InfoServiceImpl";
    }

    @Override
    public void trace() {
        System.out.println("InfoServiceImpl - TRACE");
    }
}
