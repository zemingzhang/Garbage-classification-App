package com.example.zemingzhang.radioassistant;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends DemoKitActivity {

	//private InputController mInputController;

	public BaseActivity() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mAccessory != null) {
	//		showControls();
		} else {
	//		hideControls();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Simulate");
		menu.add("Quit");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getTitle() == "Simulate") {
	//		showControls();
		} else if (item.getTitle() == "Quit") {
			finish();
			System.exit(0);
		}
		return true;
	}

	protected void enableControls(boolean enable) {
		if (enable) {
	//		showControls();
		} else {
	//		hideControls();
		}
	}

    protected void hideControls() {

    }

    protected void showControls() {
        setContentView(R.layout.main);


    }

    protected void handleJoyMessage(JoyMsg j) {

    }

    protected void handleLightMessage(LightMsg l) {

    }

    protected void handleTemperatureMessage(TemperatureMsg t) {

    }

    protected void handleSwitchMessage(SwitchMsg o) {

    }

}