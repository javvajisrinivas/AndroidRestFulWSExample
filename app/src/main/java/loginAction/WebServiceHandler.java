package loginAction;

import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Srinivas Javvaji on 12/15/2015.
 */
public class WebServiceHandler {


//    /**
//     * Method that performs RESTful webservice invocations
//     *
//     * @param params
//     */
//    public void invokeWS(RequestParams params){
//        // Show Progress Dialog
//        prgDialog.show();
//        // Make RESTful webservice call using AsyncHttpClient object
//        AsyncHttpClient client = new AsyncHttpClient();
//        //1.0.0.12
//        //192.168.2.10
//        client.get("http://1.0.0.12:8080/useraccount/login/dologin", params, new AsyncHttpResponseHandler() {
//            // When the response returned by REST has Http response code '200'
//            @Override
//            public void onSuccess(String response) {
//                // Hide Progress Dialog
//                prgDialog.hide();
//                try {
//                    // JSON Object
//                    JSONObject obj = new JSONObject(response);
//                    // When the JSON response has status boolean value assigned with true
//                    if (obj.getBoolean("status")) {
//                        Toast.makeText(getApplicationContext(), "You are successfully logged in!", Toast.LENGTH_LONG).show();
//                        // Navigate to Home screen
//                        navigatetoHomeActivity();
//                    }
//                    // Else display error message
//                    else {
//                        errorMsg.setText(obj.getString("error_msg"));
//                        Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
//                    }
//                } catch (JSONException e) {
//                    // TODO Auto-generated catch block
//                    Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//
//                }
//            }
//
//            // When the response returned by REST has Http response code other than '200'
//            @Override
//            public void onFailure(int statusCode, Throwable error,
//                                  String content) {
//                // Hide Progress Dialog
//                prgDialog.hide();
//                // When Http response code is '404'
//                if (statusCode == 404) {
//                    Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
//                }
//                // When Http response code is '500'
//                else if (statusCode == 500) {
//                    Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
//                }
//                // When Http response code other than 404, 500
//                else {
//                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }

}
