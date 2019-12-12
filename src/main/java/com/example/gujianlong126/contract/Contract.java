package com.example.gujianlong126.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/8
 *@Time:13:38
 *@Description:
 * */


import java.util.Map;

public interface Contract {
    interface MyCallBack<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IModel {
        void doGetParams(String url, Class cls, MyCallBack myCallBack);

        void doPostParams(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void onGetParams(String url, Class cls);

        void onPostParams(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }
}
