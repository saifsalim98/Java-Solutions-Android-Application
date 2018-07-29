package com.engineeringsolutions2019.javasolutions;

/**
 * Created by saif on 1/22/2018.
 */

class Chapter {
    private String name;
    private String chapter;

    Chapter(String name, String chapter) {

        this.name = name;
        this.chapter = chapter;
    }
    String getChapterNumber() { return chapter;}
    String getName() { return  name;}
}
