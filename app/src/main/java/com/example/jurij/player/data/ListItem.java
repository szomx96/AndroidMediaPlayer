package com.example.jurij.player.data;

import android.net.Uri;

public class ListItem {


    private Long id;
    private String author;
    private String title;
    private int color;
    private Uri uri;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
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

    public ListItem(Long id, String author, String title, int color, Uri uri) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.color = color;
        this.uri = uri;
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
