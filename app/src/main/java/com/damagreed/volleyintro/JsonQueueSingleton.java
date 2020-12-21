package com.damagreed.volleyintro;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class JsonQueueSingleton {
    private static JsonQueueSingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mContext;

    private JsonQueueSingleton(Context context){
        mContext = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue ==  null){
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized JsonQueueSingleton getInstance(Context context){
        if (mInstance == null){
            mInstance = new JsonQueueSingleton(context);
        }
        return mInstance;
    }

    public<T> void AddToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }

}
