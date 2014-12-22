package com.yjagsapps.socbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yjagsapps.socbrowser.R;
import com.yjagsapps.socbrowser.util.ConnectionDetector;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jags on 12/4/2014.
 */
public class SOSearchActivity extends Activity{

    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch);

        cd = new ConnectionDetector(getApplicationContext());
    }

    public void listAllJobs(View view) {
        Intent intent = new Intent(this, SOCareersActivity.class);
        String message = "";

        //If there is internet Connection for the device, go to job display activity.
        if (checkInternetConnection()) {
            intent.putExtra("searchTerm", message);
            intent.putExtra("location", message);
            startActivity(intent);
        }
        else
        {
            //Display message that there is no internet connection.
            Toast toast = Toast.makeText(getApplicationContext(), "There is no Internet Connection..Please Try Later..!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void searchJobs(View view){

        //If there is internet Connection for the device, go to job display activity.
        if(checkInternetConnection()) {
            Intent intent = new Intent(this, SOCareersActivity.class);
            String messageSearchTerm = "";
            String messageLocation = "";
            EditText editTextJobKeyword = (EditText) findViewById(R.id.TextViewJobKeyword);
            EditText editTextJobLocation = (EditText) findViewById(R.id.TextViewJobLocation);
            try {
                messageSearchTerm = URLEncoder.encode(editTextJobKeyword.getText().toString(), "UTF-8");
                messageLocation = URLEncoder.encode(editTextJobLocation.getText().toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Log.e("NOT OK", "Some error");
            }

            intent.putExtra("searchTerm", messageSearchTerm);
            intent.putExtra("location", messageLocation);
            startActivity(intent);
        }
        else
        {
            //Display message that there is no internet connection.
            Toast toast = Toast.makeText(getApplicationContext(), "There is no Internet Connection..Please Try Later..!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean checkInternetConnection()
    {
        if(cd.isConnectionToInternet())
            return true;
        else
            return false;
    }
}
