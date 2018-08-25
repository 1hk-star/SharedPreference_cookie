package com.example.a1hk_s.retrofit_test;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {

    private SharedPreferenceBase mSharedPreferenceBase;

    public ReceivedCookiesInterceptor(Context context) {
        mSharedPreferenceBase = SharedPreferenceBase.getInstanceOf(context);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            mSharedPreferenceBase.putSharedPreference(SharedPreferenceBase.SHARED_PREFERENCE_NAME_COOKIE, cookies);
        }
        return originalResponse;
    }
}
