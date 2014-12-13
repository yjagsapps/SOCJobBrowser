package com.android.yjagsapps.jobssynd;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yjagsapps.jobssynd.parser.DummyFeed;
import com.android.yjagsapps.jobssynd.services.SOCRssService;
import com.android.yjagsapps.jobssynd.util.Feed;
import java.util.List;
import  java.util.ArrayList;


public class SOCareersActivity extends Activity {

    private ListView list;
    private JobListAdaptor adaptor;
    private LayoutInflater layoutInflater;

    //private String[] finalURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the message from intent
        Intent intent = getIntent();
        String messageSearchTerm = intent.getStringExtra("searchTerm");
        String messageLocation = intent.getStringExtra("location");
        refreshListView(messageSearchTerm,messageLocation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_socareers, menu);
        return true;
    }

    /**
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    **/
    private void refreshListView(String urlSearchTerm, String urlSearchLocation){
        setContentView(R.layout.activity_socareers);
        list = (ListView) findViewById(R.id.listView);
        //SOCRssService service = new SOCRssService(list);
        SOCRssService service = new SOCRssService(this);

        if(urlSearchTerm != "" || urlSearchLocation != "")
        {
            service.execute(new String[]{"http://careers.stackoverflow.com/jobs/feed" + "?" + "searchTerm=" + urlSearchTerm + "&" + "location=" + urlSearchLocation});
        }
        else
        {
            service.execute(new String[]{"http://careers.stackoverflow.com/jobs/feed"});
        }


    }



    public ListView getList() {
        return list;
    }

    public void setList(ListView list) {
        this.list = list;
    }
}
