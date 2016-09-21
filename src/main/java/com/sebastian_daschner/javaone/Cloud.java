package com.sebastian_daschner.javaone;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Cloud {

    @CloudNotTaken
    private String name;

    @Min(1)
    @Max(10)
    private int hype;

    public Cloud() {
    }

    public Cloud(final String name, final int hype) {
        this.name = name;
        this.hype = hype;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHype() {
        return hype;
    }

    public void setHype(final int hype) {
        this.hype = hype;
    }

    @Override
    public String toString() {
        return "Cloud{" +
                "name='" + name + '\'' +
                ", hype=" + hype +
                '}';
    }
}
