package org.sergei.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UserServiceImpl implements UserService {

    private final MetaInfoServiceImpl infoService;

    @Autowired
    public UserServiceImpl(MetaInfoServiceImpl infoService) {
        this.infoService = infoService;
    }

    @Override
    public String getUserName() {
        System.out.println(infoService.metaInfo(this.getClass()));
        System.out.println(infoService.getInfo() + " UserService");
        return "Hardcoded user name";
    }
}
