package services;

import model.BuildingResponse;
import model.FleetResponse;
import model.ShipResponse;
import model.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by gcalori on 26/03/2018.
 */

public interface ApiService {

    String API_URL = "https://outer-space-manager-staging.herokuapp.com/api/v1/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("auth/create")
    Call<SignUpResponseBody> signUp(
            @Body SignUpRequestBody body
    );

    @POST("auth/login")
    Call<SignUpResponseBody> signIn(
            @Body SignInRequestBody body
    );


    @GET("users/get")
    Call<User> getUser(
            @Header("x-access-token") String token
    );

    @GET("buildings/list")
    Call<BuildingResponse> getBuildings(
            @Header("x-access-token") String token
    );

    @GET("ships")
    Call<ShipResponse> getShips(
            @Header("x-access-token") String token
    );

    @GET("fleet/list")
    Call<FleetResponse> getFleet(
            @Header("x-access-token") String token
    );

    @POST("buildings/create/{buildingId}")
    Call<BuildingResponse> createBuilding(
            @Path("buildingId") Long buildingId,
            @Header("x-access-token") String token
    );

    @POST("ships/create/{shipId}")
    Call<ShipResponse> createShip(
            @Path("shipId") Long shipId,
            @Body ShipRequestBody body,
            @Header("x-access-token") String token
    );


}
