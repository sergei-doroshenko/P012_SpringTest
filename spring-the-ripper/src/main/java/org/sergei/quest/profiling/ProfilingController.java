package org.sergei.quest.profiling;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
