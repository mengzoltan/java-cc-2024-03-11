package org.training;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.function.Supplier;

/*
    Example
    not too clean
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("Clean code samples");

        int[] ages = {24, 35, 55, 12};
        int maxAge = getMaximum(ages);

        log.info("Maximum age: {}", maxAge);

//        var getMaxAge = createMinMax("Max");

//        log.info("Maximum age: {}", getMaxAge.apply(ages));
    }

    private static int getMaximum(int[] ages) {
        return Arrays.stream(ages).max().getAsInt();
    }


//    private static Function<int[], Integer> createMinMax(String mode) {
//        if(mode.equals("Max")) {
//            return App::getMaxElement;
//        } else if (mode.equals("Min")) {
//            return App::getMinElement;
//        }
//
//    }
//
//    private static int getMaxElement(int[] arr){
//        return Arrays.stream(arr).max().getAsInt();
//    }
//
//    private static int getMinElement(int[] arr){
//        return Arrays.stream(arr).min().getAsInt();
//    }

    /**
     * Create
     *
     *
     *
     * @param f
     * @param i
     * @return
     */
    private static Supplier<Integer> create(String f, int... i) {
        if(f == "Max") {
            return () -> function(i);
        }
        return () -> function2(i);
    }
    private static int function(int[] a){
        return Arrays.stream(a).max().getAsInt();
    }
    private static int function2(int[] a){
        return Arrays.stream(a).min().getAsInt();
    }

}
