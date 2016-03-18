package org.sergei.injectproperty;

import org.sergei.injectproperty.injector.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sergei on 3/18/16.
 */
@Component
public class MyInjectTestBean {

    @Property("custom.test.property")
    private String rootFolder;

    @Value("${root.folder.key.here}")
    private String rootFolder2;

    @Override
    public String toString() {
        return "TestBean{" +
                "rootFolder='" + rootFolder + '\'' +
                ", rootFolder2='" + rootFolder2 + '\'' +
                '}';
    }
}
