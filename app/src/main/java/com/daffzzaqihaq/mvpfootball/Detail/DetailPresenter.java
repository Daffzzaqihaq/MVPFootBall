package com.daffzzaqihaq.mvpfootball.Detail;

import android.os.Bundle;

import com.daffzzaqihaq.mvpfootball.Model.FootballData;
import com.daffzzaqihaq.mvpfootball.Model.FootballResponse;
import com.daffzzaqihaq.mvpfootball.Network.ApiClient;
import com.daffzzaqihaq.mvpfootball.Network.ApiInterface;
import com.daffzzaqihaq.mvpfootball.Utils.Constant;
import com.daffzzaqihaq.mvpfootball.View.DetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    private int id;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataFootball(Bundle bundle) {
        if (bundle != null) {
            id = Integer.valueOf(bundle.getString(Constant.id));

            view.showProgress();

            Call<FootballResponse> call = apiInterface.getDetailResponse(id);
            call.enqueue(new Callback<FootballResponse>() {
                @Override
                public void onResponse(Call<FootballResponse> call, Response<FootballResponse> response) {
                    view.hideProgress();

                    if (response.body() != null) {
                        FootballResponse footballResponse = response.body();

                        if (footballResponse.getTeams() != null) {
                            view.showDataFootball(footballResponse.getTeams());
                        }
                    }

                }

                @Override
                public void onFailure(Call<FootballResponse> call, Throwable t) {
                    view.hideProgress();
                    view.showFailureMessage(t.getMessage());

                }
            });
        }

    }
}
