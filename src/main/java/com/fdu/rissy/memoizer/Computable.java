package com.fdu.rissy.memoizer;

/**
 * Created by lruihan on 4/29/17.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
