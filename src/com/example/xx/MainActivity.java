package com.example.xx;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

	WebView mWebView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		class HarlanWebChromeClient extends WebChromeClient {  
	        @Override  
	        public boolean onJsAlert(WebView view, String url, String message,  
	                JsResult result) {  
	            Toast.makeText(getApplicationContext(), message,  
	                    Toast.LENGTH_LONG).show();  
	            result.confirm();  
	            return true;  
	       	}  
		}
		
		mWebView = (WebView) findViewById(R.id.webview);
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		mWebView.setWebChromeClient(new HarlanWebChromeClient());
		mWebView.loadUrl("file:///android_asset/index.html");
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}
}
