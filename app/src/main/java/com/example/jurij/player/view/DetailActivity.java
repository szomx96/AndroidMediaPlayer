package com.example.jurij.player.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.jurij.player.R;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_AUTHOR = "EXTRA_AUTHOR";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private static final String EXTRA_PATH = "EXTRA_PATH";

    private TextView author;
    private TextView title;
    private View coloredBackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String authorExtra = i.getStringExtra(EXTRA_AUTHOR);
        String titleExtra = i.getStringExtra(EXTRA_TITLE);
        int drawableResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);
        String path = i.getStringExtra(EXTRA_PATH);

        author = (TextView) findViewById(R.id.txt_author);
        author.setText(authorExtra);

        title = (TextView) findViewById(R.id.txt_title);
        title.setText(titleExtra);



        coloredBackground = findViewById(R.id.imv_colored_background);
        coloredBackground.setBackgroundResource(
                drawableResourceExtra
        );


    }
}
