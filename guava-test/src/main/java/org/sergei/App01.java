package org.sergei;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.*;

/**
 * Created by Sergei_Doroshenko on 10/17/2016.
 */
public class App01 {
    public static void main(String[] args) {
        // Input data
        List<Item> items = Arrays.asList(
                new Item(10L, "John", "California"),
                new Item(20L, "Mark", "California"),
                new Item(30L, "Jessika", "New-Jersey"),
                new Item(40L, "Karl", "New-Jersey"),
                new Item(50L, "Ivan", "New-Jersey"),
                new Item(60L, "Andrew", "Texes"),
                new Item(70L, "Sara", "Texes")
        );

        // Map domain to Collection of Items
        Multimap<String, Item> multiMap = Multimaps.index(items, new Function<Item, String>() {
            @Override
            public String apply(Item input) {
                return input.getDomain();
            }
        });

        System.out.println("Multimap:" + multiMap);
        Collection<Item> multimapValues = multiMap.values();
        System.out.println("Multimap's values():" + multimapValues );

        Map<String, Collection<Item>> plainMap = multiMap.asMap();
        System.out.println("Plain map: " + plainMap);

        // Transform mapped
        List<Result> res = new ArrayList<>();
        for ( String key : plainMap.keySet() ) {
            Collection<Item> collection = plainMap.get( key );
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

        System.out.println("******************************************************************************************");
        System.out.println("Before sort:");
        // This transformation contains duplicates
        for ( Map.Entry<String, Collection<Item>> entry : plainMap.entrySet() ) {
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
        System.out.println();

        System.out.println("******************************************************************************************");
        System.out.println("After sort:");

        Collections.sort( res, new Ordering<Result>() {
            @Override
            public int compare ( Result left, Result right ) {
                return ComparisonChain.start()
                        .compare(left.getDomain(), right.getDomain())
//                        .compare(right.getNames(), left.getNames())
                        .result();
            }
        } );

        System.out.println( res );
    }
}
