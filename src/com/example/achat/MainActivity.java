package com.example.achat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.game.character.Character;
import com.example.game.character.Warrior;

public class MainActivity extends Activity {

	private final String tag = "Character_Creation";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onCreateCharacterClick(View v){
		Log.d(tag, "coucou");
		
		Context context = getApplicationContext();
		
		Spinner CharSelect = (Spinner)findViewById(R.id.Character_select);
		String CharType = CharSelect.getSelectedItem().toString();
		Log.d(tag, CharType);
		
		EditText CharName = (EditText)findViewById(R.id.Character_name);
		String CharNameText = CharName.getText().toString();
		Log.d(tag, CharNameText);
		
		if(CharNameText.matches("")){
			Toast.makeText(context, "Give your Character a name!", Toast.LENGTH_SHORT).show();
		} 
		else {
			if (CharType.matches("Choose your type")){
				Toast.makeText(context, "Choose your character type!", Toast.LENGTH_SHORT).show();
			} 
			else {
				MyApplication myApplication = (MyApplication) getApplication();
				Character character;
				if(CharType.matches("Character")){
					myApplication.character = new Character(CharNameText);
				}
				else {
					myApplication.character = new Warrior(CharNameText);
				}
				Intent intent = new Intent(this, ShopActivity.class);
				
				//intent.putExtra(character, value)
				startActivity(intent);
			}
		}
	}

}
