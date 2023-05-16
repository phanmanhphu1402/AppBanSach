package vn.name.admin.appbansach.retrofit;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import vn.name.admin.appbansach.model.NotiResponse;
import vn.name.admin.appbansach.model.NotiSendData;

public interface ApiPushNotification {
    @Headers(
            {
                    "Content-Type: application/json",
                    "Authorization: key=AAAAXiloklY:APA91bE4N9jLLlqkQuW_pXcsQWx8ec8JxAUcLekGrLxKNlK4ME14hJjXSqqXTwHAFjfvTCqHmlWDw0fSoIm4Xp-HldvfEwEx6Tjj3rMvSBKwc4__mLGckZqCI_TX2EHvu00g7tWzLeBI"
            }
    )
    @POST("fcm/send")
    Observable<NotiResponse> sendNofitication(@Body NotiSendData data);
}
