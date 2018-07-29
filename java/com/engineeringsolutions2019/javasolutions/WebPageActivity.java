package com.engineeringsolutions2019.javasolutions;

/**
 * Created by saif on 12/21/2017.*
 **/

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebPageActivity extends AppCompatActivity {

    Integer i;
    String URL;
    WebView myWebView;
    WebSettings websettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        Bundle bundle = getIntent().getExtras();
        try{
            i = bundle.getInt("name");
        }
        catch (Exception e){
            Log.d("Saif","NULL");
        }
        switch (i){
            case 0:
                URL="file:///android_asset/chapter0.html";
                break;
            case 1:
                URL="file:///android_asset/chapter1.html";
                break;
            case 2:
                URL="file:///android_asset/chapter2.html";
                break;
            case 3:
                URL="file:///android_asset/chapter3.html";
                break;
            case 4:
                URL="file:///android_asset/chapter4.html";
                break;
            case 5:
                URL="file:///android_asset/chapter5.html";
                break;
            case 6:
                URL="file:///android_asset/chapter6.html";
                break;
            case 7:
                URL="file:///android_asset/chapter7.html";
                break;
            case 8:
                URL="file:///android_asset/chapter8.html";
                break;
        }

        myWebView = findViewById(R.id.webview);
        websettings = myWebView.getSettings();

        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setDisplayZoomControls(false);
        if(checkInternetConnection(this)) {
            myWebView.setWebViewClient(new myWebClient());
            myWebView.loadUrl(URL);

        }
        else {
            myWebView.loadUrl("file:///android_asset/networkerror.html");
        }
    }

    public static boolean checkInternetConnection(Context context) {
        boolean isConnected=false;

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        try{
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

        }
        catch (Exception e){
            Log.d("Saif","Internet Access Request Exception");
        }
        return isConnected;
    }

    public class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().equals(URL)){
                return false;
            }

            else{
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
                return true;
            }
        }

        ProgressDialog pd = null;

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);

        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd=new ProgressDialog(WebPageActivity.this);
            pd.setTitle("Please Wait...");
            pd.setMessage("Page is loading...");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView myWebView, int errorCode, String description, String fallingUrl) {
            super.onReceivedError(myWebView,errorCode,description,fallingUrl);
            myWebView.loadUrl("file:///android_asset/networkerror.html");
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
