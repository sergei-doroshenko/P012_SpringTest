package org.sergei.action;

import org.springframework.stereotype.Component;

@Component
public class ActionServiceTracker implements Traceable {

    @Override
    public boolean isAllowed(String data) {
        return data.length() > 4;
    }
}
