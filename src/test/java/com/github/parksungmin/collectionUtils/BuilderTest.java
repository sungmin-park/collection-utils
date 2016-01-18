package com.github.parksungmin.collectionUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static com.github.parksungmin.collectionUtils.Builder.mapOf;

public class BuilderTest {

    @Test
    public void testMapOf() throws Exception {
        Assert.assertEquals(new HashMap<String, Integer>() {
            {
                put("first", 1);
            }
        }, mapOf("first", 1));

        Assert.assertEquals(new HashMap<String, Integer>() {
            {
                put("first", 1);
                put("second", 2);
            }
        }, mapOf("first", 1, "second", 2));
    }
}