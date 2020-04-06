package com.example.androidcode.network;

import com.example.androidcode.config.APIConstant;
import com.example.androidcode.home.domain.ListApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitService class will have method to create retrofit instance
 */
public class RetrofitService {

    private Retrofit mRetrofit;

    /**
     * This method creates a new instance of the API interface.
     *
     * @return API Interface
     */
    public ListApiService getAPIInterface() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(APIConstant.apiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit.create(ListApiService.class);
    }
}
