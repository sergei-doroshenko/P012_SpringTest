package org.sergei.bean;

//import org.apache.commons.beanutils.BeanUtils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by Sergei_Doroshenko on 10/19/2016.
 */
public class TransformerApp {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Src src = new Src( "here", 139L, new Date() );
        Out out = new Out();

        BeanUtils.copyProperties( src, out, "expireDate" );
        System.out.println("src: " + src);
        System.out.println("out: " + out);
    }

}
