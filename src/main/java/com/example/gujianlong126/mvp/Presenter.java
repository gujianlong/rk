package com.example.gujianlong126.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/8
 *@Time:13:49
 *@Description:
 * */




import com.example.gujianlong126.base.BasePresenter;
import com.example.gujianlong126.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void onGetParams(String url, Class cls) {
        iModel.doGetParams(url, cls, new Contract.MyCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void onPostParams(String url, Class cls, Map<String, Object> map, Contract.MyCallBack myCallBack) {

    }
}
