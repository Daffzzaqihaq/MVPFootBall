package com.daffzzaqihaq.mvpfootball.Main;

import com.daffzzaqihaq.mvpfootball.Model.FootballData;

import java.util.List;

public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();

        void showDataListUser(List<FootballData> footballDataList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListUser();
    }
}
