/**
 * Lab 01. https://github.com/groovy-training-logicmonitor/lab01
 *
 * LogicMonitor Training, 2017
 */

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path



class Constants {
    static final String API_KEY = "Authentication:<api-key>"
}

interface TrackRPurchasesService {
    @Headers(Constants.API_KEY)
    @GET("purchases/{id}")
    Call<ResponseBody> getPurchases(@Path("id") int id);
}

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("<url>")
        .build()

TrackRPurchasesService service = retrofit.create(TrackRPurchasesService.class)
Call<ResponseBody> purchasesCall = service.getPurchases(4)

Response<ResponseBody> response = purchasesCall.execute()

def body = response.body().string()
def lines = body.split(/\s+/)

for (line in lines) {
    def fields = line.replace('"','').split(/,/)
    println fields[0] + "##" + fields[0]
}

