package com.example.jurij.player.view;

import android.content.Context;
import com.example.jurij.player.data.ListItem;

import java.util.List;

public interface IView {

    void startDetailActivity(String author, String title, int color, String path);
    void setUpAdapterAndView(List<ListItem> listOfData);
    Context getContext();

}
