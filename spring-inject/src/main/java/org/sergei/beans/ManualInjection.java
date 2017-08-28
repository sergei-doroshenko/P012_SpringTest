package org.sergei.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class ManualInjection {

    @Autowired
    private SomeComponent someComponent;

    public String getNameFromInjected() {
        return someComponent.getName();
    }
}
