package com.daffzzaqihaq.mvpfootball.Detail;

import android.os.Bundle;

import com.daffzzaqihaq.mvpfootball.Model.FootballData;

import java.util.List;

public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataFootball(List<FootballData> footballData);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataFootball(Bundle bundle);
    }
}
