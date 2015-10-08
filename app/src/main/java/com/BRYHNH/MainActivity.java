package com.BRYHNH;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

// Import the Flurry libraries
import com.flurry.android.FlurryAgent;


public class MainActivity extends FragmentActivity {

/*  Flurry analytics code
	
		FlurryAgent.onStartSession(this, "253QTC8J4NPM2XJXPNDZ");
			
		FlurryAgent.onEndSession(this);
	
*/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (savedInstanceState == null) {
			addRssFragment();
		}
	}

	private void addRssFragment() {
		FlurryAgent.onStartSession(this, "253QTC8J4NPM2XJXPNDZ");
		FlurryAgent.onEndSession(this);
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		RssFragment fragment = new RssFragment();
		transaction.add(R.id.fragment_container, fragment);
		transaction.commit();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean("fragment_added", true);
	}
}