package com.seuic.uhfdemo;

import com.seuic.uhf.UHFService;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private RadioButton rb_inventory;
	private RadioButton rb_settings;

	private UHFService mDevice;

	private FragmentManager fm;
	private FragmentTransaction ft;

	private InventoryFragement m_inventory;
	// private SettingsFragement m_setinventory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// new object
		mDevice = UHFService.getInstance();
		// open UHF
		boolean ret = mDevice.open();
		if (!ret) {
			Toast.makeText(this, R.string.open_failed, 1).show();
		}

		rb_inventory = (RadioButton) findViewById(R.id.rb_inventory);
		rb_settings = (RadioButton) findViewById(R.id.rb_settings);

		rb_inventory.setOnClickListener(this);
		rb_settings.setOnClickListener(this);

		fm = getFragmentManager();
		ft = fm.beginTransaction();
		m_inventory = InventoryFragement.getInstance();
		ft.replace(R.id.frl_content, m_inventory);
		rb_inventory.setEnabled(false);

		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		// new object
		mDevice = UHFService.getInstance();
		// open UHF
		boolean ret = mDevice.open();
		if (!ret) {
			Toast.makeText(this, R.string.open_failed, 1).show();
		}

	}

	@Override
	protected void onPause() {
		super.onPause();
		// close UHF
		mDevice.close();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_exit) {
			mDevice.close();
			// Toast.makeText(this, "exit", 0).show();
			System.exit(0);
			return true;
		}
		if (id == R.id.action_hide) {
			// Toast.makeText(this, "hide", 0).show();
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		ft = fm.beginTransaction();
		switch (v.getId()) {
		case R.id.rb_inventory:
			ft.replace(R.id.frl_content, InventoryFragement.getInstance());
			rb_inventory.setEnabled(false);
			rb_settings.setEnabled(true);
			break;

		case R.id.rb_settings:
			if (!m_inventory.mInventoryStart) {
				ft.replace(R.id.frl_content, SettingsFragement.getInstance());
				rb_settings.setEnabled(false);
			}
			rb_inventory.setEnabled(true);

			break;

		default:
			break;
		}
		ft.commit();
	}

}
