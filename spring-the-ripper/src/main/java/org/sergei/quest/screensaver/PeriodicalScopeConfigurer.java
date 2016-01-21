package org.sergei.quest.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergei_Doroshenko on 12/17/2014.
 * Custom scope
 */
public class PeriodicalScopeConfigurer implements Scope {
    private Map<String, Pair<Date, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        if (map.containsKey(name)){
            Pair<Date, Object> pair = map.get(name);
            Date date = new Date();
            long lastRequest = date.getTime() - pair.getKey().getTime();
            if (lastRequest > 5_000){
                map.put(name, new Pair<Date, Object>(new Date(), objectFactory.getObject()));
            } else {
                map.put(name, new Pair<Date, Object>(new Date(), objectFactory.getObject()));
            }

        } else {
            map.put(name, new Pair<Date, Object>(new Date(), objectFactory.getObject()));
        }

        return map.get(name).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
