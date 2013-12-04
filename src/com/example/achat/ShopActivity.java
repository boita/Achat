package com.example.achat;

import com.example.game.model.StoreDatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class ShopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		MyApplication myApplication = (MyApplication) getApplication();
		Toast.makeText(getApplicationContext(), "Character Name " + myApplication.character.getName(), Toast.LENGTH_SHORT).show();
		
		StoreDatabaseHelper storeDatabaseHelper = new StoreDatabaseHelper(myApplication);
		Cursor cursor = storeDatabaseHelper.selectALL(null);
		Log.i("rory", "Name" + cursor.getCount());
		
		while (cursor.moveToNext()){
			Log.i("rory", "Name" + cursor.getString(0));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

}
