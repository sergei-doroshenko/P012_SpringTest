package org.sergei.service.impl.strategies;

import org.sergei.service.Strategy;
import org.springframework.stereotype.Component;

/**
 * Created by Sergei_Doroshenko on 5/5/2016.
 */
@Component
public class TaskStrategy extends AccountStrategy {

    @Override
    public String getName() {
        return "TaskStrategy";
    }
}
