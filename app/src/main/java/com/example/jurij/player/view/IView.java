package com.example.jurij.player.view;

import android.content.Context;
import android.net.Uri;
import com.example.jurij.player.data.ListItem;

import java.util.List;

public interface IView {

    void startDetailActivity(String author, String title, int color, Uri uri);
    void setUpAdapterAndView(List<ListItem> listOfData);
    Context getContext();

}
