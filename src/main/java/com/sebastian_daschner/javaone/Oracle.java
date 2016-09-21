package com.sebastian_daschner.javaone;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Stateless
public class Oracle {

    public List<Cloud> getClouds() {
        return Arrays.asList(new Cloud("database", 1), new Cloud("artificial_intelligence", 10));
    }

    public void createCloud(final Cloud cloud) {
        System.out.println("cloud: " + cloud);
    }

    public boolean isCloudTaken(final String name) {
        return "java".equals(name);
    }

    public Cloud getCloud(final String name) {
        return new Cloud(name, new Random().nextInt(10));
    }
}
