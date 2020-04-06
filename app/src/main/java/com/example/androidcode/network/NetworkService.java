package com.example.androidcode.network;

import com.example.androidcode.config.APIConstant;
import com.example.androidcode.home.domain.FactsApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * NetworkService class will have method to create retrofit instance
 */
public class NetworkService {

    private Retrofit mRetrofit;

    /**
     * This method creates a new instance of the API interface.
     *
     * @return API Interface
     */
    public FactsApiService getAPIInterface() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(APIConstant.apiBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit.create(FactsApiService.class);
    }
}
