package com.example.vikram.forwebservice;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by vikram on 11/2/17.
 */

public class Singletone {

    private static RequestQueue queue;

    public static RequestQueue q(Context context){
        return queue == null ? Volley.newRequestQueue(context) : queue;
    }
}
