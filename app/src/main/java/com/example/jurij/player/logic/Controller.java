package com.example.jurij.player.logic;

import android.content.Context;
import com.example.jurij.player.data.IDataSource;
import com.example.jurij.player.data.ListItem;
import com.example.jurij.player.view.IView;

public class Controller {

    private IView view;
    private IDataSource dataSource;

    public Controller(IView view, IDataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource(view.getContext());
    }

    public void getListFromDataSource(Context context){
        view.setUpAdapterAndView(
                dataSource.getListOfData(context)
        );
    }

    public void onListItemClick(ListItem item){
        view.startDetailActivity(
                item.getAuthor(),
                item.getTitle(),
                item.getColor(),
                item.getUri()
        );
    }

}
