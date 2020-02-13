package com.kiran2kirve.riteshsirassignment.network;

import com.kiran2kirve.riteshsirassignment.models.UserResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NetworkInterface {

//working only one field
/*
   @GET("/?")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<UserResult> fetchUserListRequestApi();
    */

    @GET("/?results=10&nat=en")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<UserResult> fetchUserListRequestApi();



/*
    @GET("/?")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<UserResult> fetchUserListRequestApi(@Field("results") int str, @Field("nat") String str2);

*/


/*
    @FormUrlEncoded
    @POST("login/changePassword")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<ChangePasswordModel> changePasswordRequestApi(@Field("username") String str, @Field("oldpassword") String str2, @Field("newpassword") String str3);

    @FormUrlEncoded
    @POST("appStatus/applicationStatusDetails")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<String> fetchServerHealthRequestApi(@Field("applicationId") String str);

    @FormUrlEncoded
    @POST("login/loginAction")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<LoginResponseModel> loginRequestApi(@Field("username") String str, @Field("password") String str2, @Field("regId") String str3, @Field("operatingSystem") String str4);
*/

}
