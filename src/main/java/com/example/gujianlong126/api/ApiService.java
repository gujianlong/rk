package com.example.gujianlong126.api;
/*
 *@auther:谷建龙
 *@Date: 2019/12/8
 *@Time:13:20
 *@Description:
 * */


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> getInfoNoParams(@Url String url);

    @GET
    Observable<ResponseBody> getInfoParams(@Url String url, @HeaderMap Map<String, Object> map);
}
