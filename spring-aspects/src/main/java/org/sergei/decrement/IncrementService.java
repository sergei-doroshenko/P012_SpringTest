package org.sergei.decrement;

import org.springframework.stereotype.Service;

/**
 * Created by sergei on 11/23/15.
 */
@Service("incrementalService")
public class IncrementService {
    public int inc(int i){
        return i+1;
    }
}
