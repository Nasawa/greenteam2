package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.anigeek.greenteam2.classes.SuperSpinner;

public class StepsActivity extends Activity
{
	Context context;
	boolean catcher = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_steps);

		context = this;

		SuperSpinner spinner = (SuperSpinner) findViewById(R.id.moreback);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.stepschoices, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new SuperSpinner.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				if(!catcher)
					catcher = true;
				else
				{
					catcher = false;
					if (position == 0)
						finish();
					else
					{
						Intent intent = new Intent(context, MainActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						finish();
					}
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{

			}
		});
	}

}
