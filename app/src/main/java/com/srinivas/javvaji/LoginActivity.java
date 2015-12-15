package com.srinivas.javvaji;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.srinivas.javvaji.R;

/**
 * 
 * Login Activity Class 
 *
 */
public class LoginActivity extends Activity {
	// Progress Dialog Object
	ProgressDialog prgDialog;
	// Error Msg TextView Object
	TextView errorMsg;
	// Email Edit View Object
	EditText mobileNoET;
	// Passwprd Edit View Object
	EditText pwdET;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		// Find Error Msg Text View control by ID
		errorMsg = (TextView)findViewById(R.id.login_error);
		// Find Email Edit View control by ID
		mobileNoET = (EditText)findViewById(R.id.loginEmail);
		// Find Password Edit View control by ID
		pwdET = (EditText)findViewById(R.id.loginPassword);
		// Instantiate Progress Dialog object
		prgDialog = new ProgressDialog(this);
		// Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);


		// GET DEVICE ID
		final String deviceId = Settings.Secure.getString(getContentResolver(),
				Settings.Secure.ANDROID_ID);

// GET IMEI NUMBER
		TelephonyManager tManager = (TelephonyManager) getBaseContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		String deviceIMEI = tManager.getDeviceId();

		Toast.makeText(getBaseContext(),"deviceId ---> "+deviceId + "deviceIMEI --> " + deviceIMEI, Toast.LENGTH_SHORT);
		System.out.println("deviceId ---> "+deviceId +"deviceIMEI --> "+deviceIMEI);
	}
	
	/**
	 * Method gets triggered when Login button is clicked
	 * 
	 * @param view
	 */
	public void loginUser(View view){
		// Get Email Edit View Value
		String mobileNo = mobileNoET.getText().toString();
		// Get Password Edit View Value
		String password = pwdET.getText().toString();

		String deviceId = getDeviceId(getApplicationContext());
		System.out.println("device id --> "+ deviceId);

		// Instantiate Http Request Param Object
		RequestParams params = new RequestParams();
		// When Email Edit View and Password Edit View have values other than Null
		if(Utility.isNotNull(mobileNo) && Utility.isNotNull(password)){
			// When Email entered is Valid
			if(Utility.validate(mobileNo)){
				// Put Http parameter username with value of Email Edit View control
				params.put("username", mobileNo);
				// Put Http parameter password with value of Password Edit Value control
				params.put("password", password);
				// Put Http parameter deviceId with value of deviceId from Program
				params.put("deviceId", deviceId);
				// Invoke RESTful Web Service with Http parameters
				invokeWS(params);
			} 
			// When Email is invalid
			else{
				Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_LONG).show();
			}
		} 
		// When any of the Edit View control left blank
		else{
			Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
		}
		
	}
	
	/**
	 * Method that performs RESTful webservice invocations
	 * 
	 * @param params
	 */
	public void invokeWS(RequestParams params){
		// Show Progress Dialog
		 prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get("http://1.0.0.12:8080/useraccount/login/dologin", params, new AsyncHttpResponseHandler() {
			 // When the response returned by REST has Http response code '200'
			 @Override
			 public void onSuccess(String response) {
				 // Hide Progress Dialog
				 prgDialog.hide();
				 try {
					 // JSON Object
					 JSONObject obj = new JSONObject(response);
					 // When the JSON response has status boolean value assigned with true
					 if (obj.getBoolean("status")) {
						 Toast.makeText(getApplicationContext(), "You are successfully logged in!", Toast.LENGTH_LONG).show();
						 // Navigate to Home screen
						 navigatetoHomeActivity();
					 }
					 // Else display error message
					 else {
						 errorMsg.setText(obj.getString("error_msg"));
						 Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
					 }
				 } catch (JSONException e) {
					 // TODO Auto-generated catch block
					 Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
					 e.printStackTrace();

				 }
			 }

			 // When the response returned by REST has Http response code other than '200'
			 @Override
			 public void onFailure(int statusCode, Throwable error,
								   String content) {
				 // Hide Progress Dialog
				 prgDialog.hide();
				 // When Http response code is '404'
				 if (statusCode == 404) {
					 Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
				 }
				 // When Http response code is '500'
				 else if (statusCode == 500) {
					 Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
				 }
				 // When Http response code other than 404, 500
				 else {
					 Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
				 }
			 }
		 });
	}

	public static String getDeviceId(Context context) {

		try {
			return Settings.Secure.getString(context.getContentResolver(),
					Settings.Secure.ANDROID_ID);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Method which navigates from Login Activity to Home Activity
	 */
	public void navigatetoHomeActivity(){
		Intent homeIntent = new Intent(getApplicationContext(),HomeActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
	}
	

	
}
