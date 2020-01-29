package org.sergei.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InfoServiceImpl infoService;

    @Override
    public String getUserName() {
        return "Hardcoded user name";
    }

    public String getMetaInfo() {
        infoService.trace();
        return infoService.getInfo();
    }
}
