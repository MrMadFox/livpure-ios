package com.livpure.safedrink.utils;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
/* loaded from: classes3.dex */
public class MyVolleySingleton {
    private static Context mCtx;
    private static MyVolleySingleton mInstance;
    private final ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;

    private MyVolleySingleton(Context context) {
        mCtx = context;
        this.mRequestQueue = getRequestQueue();
        this.mImageLoader = new ImageLoader(this.mRequestQueue, new ImageLoader.ImageCache() { // from class: com.livpure.safedrink.utils.MyVolleySingleton.1
            private final LruCache<String, Bitmap> cache = new LruCache<>(20);

            @Override // com.android.volley.toolbox.ImageLoader.ImageCache
            public Bitmap getBitmap(String url) {
                return this.cache.get(url);
            }

            @Override // com.android.volley.toolbox.ImageLoader.ImageCache
            public void putBitmap(String url, Bitmap bitmap) {
                this.cache.put(url, bitmap);
            }
        });
    }

    public static synchronized MyVolleySingleton getInstance(Context context) {
        MyVolleySingleton myVolleySingleton;
        synchronized (MyVolleySingleton.class) {
            if (mInstance == null) {
                mInstance = new MyVolleySingleton(context);
            }
            myVolleySingleton = mInstance;
        }
        return myVolleySingleton;
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return this.mImageLoader;
    }
}
