package org.sergei.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {

    Traceable traceable;

    @Autowired
    public ActionServiceImpl(Traceable traceable) {
        this.traceable = traceable;
    }

    @Override
    public String doAction(String actionName) {
        if (traceable.isAllowed(actionName)) {
            return "Do: " + actionName;
        }

        return "Not allowed";
    }
}
