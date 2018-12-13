package com.example.jurij.player.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.jurij.player.R;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;




public class DataSource extends AppCompatActivity implements IDataSource {



    @Override
    public List<ListItem> getListOfData(Context context) {

        ArrayList listOfData = new ArrayList<ListItem>();
        ContentResolver contentResolver = context.getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);

        if(songCursor != null && songCursor.moveToFirst())
        {
        String path = songUri.getPath();
        int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
        int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int songAuthor = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        int picture = songCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART);


        do {

        long currentId = songCursor.getLong(songId);
        String currentTitle = songCursor.getString(songTitle);
        String currentArtist = songCursor.getString(songAuthor);
        int currentPicture;
        try {
            currentPicture = songCursor.getInt(picture);
        } catch(Exception e){
            currentPicture = 0;
        }

        listOfData.add(new ListItem(currentId, currentArtist, currentTitle, currentPicture, path));
        } while(songCursor.moveToNext());
        }
        return listOfData;
    }


}
