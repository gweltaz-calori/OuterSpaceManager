package main.Report;

import android.util.Log;

import main.AuthPresenterImpl;
import main.AuthView;
import model.FleetResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ApiService;
import services.ReportResponseBody;

import static android.content.ContentValues.TAG;

/**
 * Created by gcalori on 26/03/2018.
 */

public class ReportPresenterImpl extends AuthPresenterImpl implements ReportPresenter {

    private ReportView view;

    public ReportView getView() {
        return view;
    }

    ReportPresenterImpl(ReportView view) {
        this.view = view;
    }

    @Override
    protected AuthView getAuthView() {
        return view;
    }


    @Override
    public void getReports(String accessToken) {
        ApiService apiService = ApiService.retrofit
                .create(ApiService.class);

        Log.d("accessToken", "onResponseErr: "+accessToken);


        Call<ReportResponseBody> call = apiService.getReports(accessToken);

        call.enqueue(new Callback<ReportResponseBody>() {
            @Override
            public void onResponse(Call<ReportResponseBody> call, Response<ReportResponseBody> response) {
                Log.d("response", "onResponse: "+response);
                if(response.isSuccessful()) {
                    view.onReports(response.body().getReports());
                }
            }

            @Override
            public void onFailure(Call<ReportResponseBody> call, Throwable t) {
                Log.d("response", "onResponseErr: "+t);
            }
        });

    }
}
