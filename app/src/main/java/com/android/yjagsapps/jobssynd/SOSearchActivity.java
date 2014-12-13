package com.android.yjagsapps.jobssynd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jags on 12/4/2014.
 */
public class SOSearchActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch);
    }

    public void listAllJobs(View view){
        Intent  intent = new Intent(this,SOCareersActivity.class);
        String message = "";

        //EditText editTextJobSkill = (EditText) findViewById(R.id.TextViewJobSkill);
        //try {
        //
        //    message = URLEncoder.encode(editTextJobSkill.getText().toString(),"UTF-8");
        //}
        //catch (UnsupportedEncodingException e){
        //    Log.e("NOT OK","Some error");
        //}

        intent.putExtra("searchTerm", message);
        intent.putExtra("location", message);
        startActivity(intent);
    }

    public void searchJobs(View view){

        Intent  intent = new Intent(this,SOCareersActivity.class);
        String messageSearchTerm = "";
        String messageLocation = "";
        EditText editTextJobKeyword = (EditText) findViewById(R.id.TextViewJobKeyword);
        EditText editTextJobLocation = (EditText) findViewById(R.id.TextViewJobLocation);
        try {

            messageSearchTerm = URLEncoder.encode(editTextJobKeyword.getText().toString(),"UTF-8");
            messageLocation = URLEncoder.encode(editTextJobLocation.getText().toString(),"UTF-8");
        }
        catch (UnsupportedEncodingException e){
            Log.e("NOT OK","Some error");
        }

        intent.putExtra("searchTerm", messageSearchTerm);
        intent.putExtra("location", messageLocation);
        startActivity(intent);

    }
}
