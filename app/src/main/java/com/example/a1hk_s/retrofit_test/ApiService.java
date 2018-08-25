package com.example.a1hk_s.retrofit_test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //API Gateway Stage URL
    //호출할 기본적인 위치랄까?
    public static final String API_URL = "http://101.235.59.85:8080/board/";

    //특정 uri에 접근해서 데이터를 주고 받는걸 restful api라고 함
    //rest에 대한 설명, http://blog.naver.com/PostView.nhn?blogId=complusblog&logNo=220986337770
    //참고한 블로그, http://interconnection.tistory.com/73


    //1번
    //"https://www.naver.com/api/dogs?name=파라미터"에 GET형식 Request를 하는데
    //"name" query에 int name 파라미터롤 전달하여 요청
    @FormUrlEncoded
    @POST("v1/members/")
    Call<ResponseBody>postComment(@Field("name") String name, @Field("mail") String mail, @Field("age") int age);

    @FormUrlEncoded
    @PUT("v1/members/{path}/")
    Call<ResponseBody>putComment(@Path("path") String path, @Field("name") String name, @Field("mail") String mail);

    //2번
    //"https://www.naver.com/api/dogs" Path에 POST형식으로 요청을하는데
    //아무 요청 값 없이 요청을 하는 부분.
    //post는 균일하게 처리 될 요청의 경우 사용
    //@POST("v1/members")
    @GET("session_test.php")
    Call<ResponseBody>getComment();

    //3번
    //"https://www.naver.com/api/dogs/name2?testquery=[testquert 파라미터]"
    //path에 1번과 마찬가지로 GET 요청
    @GET("dogs/name2")
    Call<ResponseBody>getName2(@Query("testquery") String testquery);

    //4번
    //"https://www.naver.com/api/dogs/[testpath 파라미터]?query=[testquery 파라미터]"
    //로 get 요청하고, [name] 부분의 name은 변수로서 바뀜
    @GET("dogs/{name}")
    Call<ResponseBody>getName(@Path("name") String testpath, @Query("query") String testquery);

    //5번
    //"https://www.naver.com/api/dogs/[testpath 파라미터]"로 PUT 요청
    //마찬가지로 {name}부분은 변수로 바뀔 수 있음.
    @PUT("dogs/{name}")
    Call<ResponseBody>getName(@Path("name") String testpath);

}
