package me.suanmiao.example.util;

import android.content.Intent;

/**
 * Created by suanmiao on 14/12/29.
 */
public class ShareUtil {


    public static Intent getSystemShareIntent(String title,String text){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TITLE, title);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        return sendIntent;
    }
}
