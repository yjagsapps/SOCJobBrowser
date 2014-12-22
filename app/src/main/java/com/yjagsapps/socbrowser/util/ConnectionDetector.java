package com.yjagsapps.socbrowser.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Jags on 12/17/2014.
 */
public class ConnectionDetector {

    private Context _context;

    public ConnectionDetector(Context _context) {
        this._context = _context;
    }

    public boolean isConnectionToInternet()
    {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(_context.CONNECTIVITY_SERVICE);
        if(connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if(info != null){
                for (int i=0;i<info.length; i++)
                {
                    if(info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
