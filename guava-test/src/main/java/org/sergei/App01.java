package org.sergei;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import java.util.*;

/**
 * Created by Sergei_Doroshenko on 10/17/2016.
 */
public class App01 {
    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item(10L, "John", "California"),
                new Item(20L, "Mark", "California"),
                new Item(30L, "Jessika", "New-Jersey"),
                new Item(40L, "Karl", "New-Jersey"),
                new Item(50L, "Ivan", "New-Jersey"),
                new Item(60L, "Andrew", "Texes"),
                new Item(70L, "Sara", "Texes")
        );

        Multimap<String, Item> map = Multimaps.index(items, new Function<Item, String>() {
            @Override
            public String apply(Item input) {
                return input.getDomain();
            }
        });

        System.out.println("Multimap:" + map);

        Map<String, Collection<Item>> mm = map.asMap();
        Collection<Item> v0 = map.values();



        System.out.println("values():" + v0 );

        List<Result> res = new ArrayList<>();
        for ( String key : mm.keySet() ) {
            Collection<Item> collection = mm.get( key );
            Result result = new Result();
            result.setDomain( collection.iterator().next().getDomain() );

            result.setNames( Lists.transform( new ArrayList(collection), new Function<Item, String>(){

                @Override
                public String apply(Item input) {
                    return input.getName();
                }
            } ) );

            res.add( result );
        }

        for ( Map.Entry<String, Collection<Item>> entry : mm.entrySet() ) {
            Collection<Item> collection = entry.getValue();
            Result result = new Result();
            result.setDomain( collection.iterator().next().getDomain() );

            result.setNames( Lists.transform( new ArrayList(collection), new Function<Item, String>(){

                @Override
                public String apply(Item input) {
                    return input.getName();
                }
            } ) );

            res.add( result );
        }


        System.out.println( res );
    }
}
