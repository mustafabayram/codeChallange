package com.obilet.android.kariyernetchallange.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mustafa Bayram on 19.12.2018.
 */
public class ArrayUtils {

    public static <TSource, TDestination> List<TDestination> map(List<TSource> list, Mapping<? super TSource, ? extends TDestination> mapping) {

        List<TDestination> items = new ArrayList<>();

        for (TSource item : list) {
            items.add(mapping.map(item));
        }

        return items;
    }

    public interface Mapping<TSource, TDestination> {
        TDestination map(TSource source);
    }

}
