package com.example.jurij.player.data;

public class ListItem {


    private Long id;
    private String author;
    private String title;
    private int color;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ListItem(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public ListItem(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public ListItem(Long id, String author, String title, int color, String path) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.color = color;
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getColor() {
        return color;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String toString(){
        return this.title;
    }

}
