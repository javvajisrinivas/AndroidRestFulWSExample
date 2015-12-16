package loginAction;

import android.app.ProgressDialog;
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


    public static String BASE_URL = "http://1.0.0.12:8080/useraccount/";



    public static String getLoginURL()
    {

        return BASE_URL + "login/dologin";
    }




}
