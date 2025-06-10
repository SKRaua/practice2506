package com.cqupt.pojo;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

}
