package com.example.jurij.player.data;

import android.content.Context;

import java.util.List;

public interface IDataSource {

    List<ListItem> getListOfData(Context context);


}
