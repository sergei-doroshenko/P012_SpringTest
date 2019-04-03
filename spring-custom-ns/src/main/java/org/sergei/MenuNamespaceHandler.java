package org.sergei;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by sergei on 1/20/16.
 */
public class MenuNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("menu", new MenuDefinitionParser());
    }
}
