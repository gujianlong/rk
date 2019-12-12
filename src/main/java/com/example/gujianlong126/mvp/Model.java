package com.example.gujianlong126.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/8
 *@Time:13:45
 *@Description:
 * */




import com.example.gujianlong126.contract.Contract;
import com.example.gujianlong126.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {

    @Override
    public void doGetParams(String url, Class cls, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onGet(url, cls, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                myCallBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }

    @Override
    public void doPostParams(String url, Class cls, Map<String, Object> map, Contract.MyCallBack myCallBack) {

    }
}
