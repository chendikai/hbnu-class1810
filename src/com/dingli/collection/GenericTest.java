package com.dingli.collection;

public class GenericTest {
    public static void main(String[] args) {
        Generic generic = new Generic(4);

        generic.setData(0, "jixin1810");
        generic.setData(1, 1810);

        String data1 = (String) generic.getData(0);
        String data2 = (String) generic.getData(1);
    }
}
