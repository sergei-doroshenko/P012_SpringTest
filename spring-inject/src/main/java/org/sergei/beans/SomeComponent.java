package org.sergei.beans;

import org.springframework.stereotype.Component;

@Component
public class SomeComponent {

    private String name = "Some";

    public String getName() {
        return name;
    }
}
