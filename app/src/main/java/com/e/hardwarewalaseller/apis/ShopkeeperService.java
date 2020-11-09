package com.e.hardwarewalaseller.apis;
import com.e.hardwarewalaseller.beans.Shopkeeper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class ShopkeeperService {


    public static ShopkeeperApi shopkeeperApi;

    public static  ShopkeeperApi getShopkeeperApiInstance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerAddress.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        if(shopkeeperApi==null) {
            shopkeeperApi = retrofit.create(ShopkeeperApi.class);
        }
        return shopkeeperApi;
    }

    public interface ShopkeeperApi
    {
        @Multipart
        @POST("shopkeeper/")
        public Call<Shopkeeper>saveShopkeeper(@Part MultipartBody.Part file,
                                              @Part("name") RequestBody name,
                                              @Part("shopName") RequestBody shopName,
                                              @Part("contactNumber") RequestBody contactNumber,
                                              @Part("address") RequestBody address,
                                              @Part("email") RequestBody email,
                                              @Part("token") RequestBody token
                                              );
    }
}