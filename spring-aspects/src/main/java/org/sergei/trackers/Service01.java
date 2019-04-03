package org.sergei.trackers;

import org.springframework.stereotype.Service;

@Service
public class Service01 {

    @Tracked @Metrics
    public String getMessage() {
        return "Message";
    }

    @Tracked
    public String getAnotherMessage() {
        return "Another";
    }

    @Metrics
    public String getBullShit() {
        return "BullShit";
    }
}
