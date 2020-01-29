package org.sergei.beans;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName() {
        return "Hardcoded user name";
    }

    public String getMetaInfo() {
        return "Meta Info from UserService";
    }
}
