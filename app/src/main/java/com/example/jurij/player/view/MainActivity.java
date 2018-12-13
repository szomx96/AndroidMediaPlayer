package com.example.jurij.player.view;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.jurij.player.R;
import com.example.jurij.player.data.DataSource;
import com.example.jurij.player.data.ListItem;
import com.example.jurij.player.logic.Controller;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{

    private static final String EXTRA_AUTHOR = "EXTRA_AUTHOR";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private static final String EXTRA_PATH = "EXTRA_PATH`";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    private Context context;

    public Context getContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        101);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }


//
        recyclerView = findViewById(R.id.rec_main_activity);
        layoutInflater = getLayoutInflater();

        controller = new Controller(this, new DataSource());

    }

    @Override
    public void startDetailActivity(String author, String title, int color, String path) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_AUTHOR, author);
        i.putExtra(EXTRA_TITLE, title);
        i.putExtra(EXTRA_COLOR, color);
        i.putExtra(EXTRA_PATH, path);

        startActivity(i);
    }

//    public void startPlayerActivity(String path){
//        Intent i = new Intent(this, PlayerActivity.class);
//        i.putExtra(EXTRA_PATH, path);
//
//        startActivity(i);
//
//    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);

            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            ListItem curItem = listOfData.get(position);

            //holder.coloredCircle.setBackgroundResource(curItem.getColor());

            holder.author.setText(
                    curItem.getAuthor()
            );

            holder.title.setText(
                    curItem.getTitle()
            );

        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private View coloredCircle;
            private TextView author;
            private TextView title;
            private ViewGroup container;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.author = (TextView) itemView.findViewById(R.id.txt_author);
                this.title = (TextView) itemView.findViewById(R.id.txt_title);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(listItem);

            }
        }
    }

}
