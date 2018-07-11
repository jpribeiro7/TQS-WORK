package ua.pt.clienteexterno;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Pedro on 10/07/2018.
 */

public class LoginPost extends AsyncTask<User,Void,String> {

    private final String REST_URL = "http://deti-tqs-11.ua.pt:8090/login";
    private int code;
    private String response;

    @Override
    protected String doInBackground(User... users) {
        code = 0;
        User user = users[0];
        response = "";

        try {
            URL url = new URL(REST_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("username",user.getUsername());
            jsonParam.put("password", user.getPassword());

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.writeBytes(jsonParam.toString());

            Log.d("TAG",jsonParam.toString());
            os.flush();
            os.close();
            conn.connect();
            code = conn.getResponseCode();


            String result = null;
            StringBuffer sb = new StringBuffer();
            InputStream is = null;

            is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
            response = result;



        } catch (IOException e) {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("response",response);
        return code==200 && !response.equals("No user in the system")? "Welcome":"Credentials are wrong";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
