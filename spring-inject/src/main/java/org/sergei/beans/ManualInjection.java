package org.sergei.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ManualInjection {

    @Autowired
    private SomeComponent someComponent;

    public String getNameFromInjected() {
        return someComponent.getName();
    }
}
