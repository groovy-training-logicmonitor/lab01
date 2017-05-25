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
    static final String API_KEY = "<API KEY goes here>"
}

interface TrackRPurchasesService {
    @Headers(Constants.API_KEY)
    @GET("purchases/{id}")
    Call<ResponseBody> getPurchases(@Path("id") int id)
}

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("<URL Goes Here>")
        .build()

TrackRPurchasesService service = retrofit.create(TrackRPurchasesService.class)
Call<ResponseBody> purchasesCall = service.getPurchases(4)

Response<ResponseBody> response = purchasesCall.execute()

def body = response.body().string().replaceAll("\"", "")
def lines = body.tokenize("\n")
//iterate through each line
lines.each {
    line ->
        def fields = line.tokenize(',')
        //some entries have more than 2 fields, we want the field with epoch time
        if (fields.size > 2)
        {
            date = new Date(fields[2].toLong())

        }
        else
        {
            date = new Date(fields[1].toLong())
        }
        println "${fields[0]}##${date.format("dd-MMM-yyyy hh:mm")}"
}
