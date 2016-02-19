package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.anigeek.greenteam2.classes.SuperSpinner;

public class ProblemActivity extends Activity
{
	boolean calc    = false;
	boolean catcher = false;
	SuperSpinner spinner;
	Context      context;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_problem);

		context = this;

		Bundle extras = getIntent().getExtras();
		if (extras != null)
			calc = extras.getBoolean("Calculator", false);

		if (calc)
			(findViewById(R.id.calcimg)).setVisibility(ImageView.VISIBLE);

		spinner = (SuperSpinner) findViewById(R.id.probchoice);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.probchoices, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setSelection(1);

		catcher = false;

		spinner.setOnItemSelectedListener(new SuperSpinner.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				if (!catcher)
					catcher = true;
				else
				{
					if (position == 0)
					{
						catcher = false;
						spinner.setSelection(1);
						Intent intent = new Intent(context, StepsActivity.class);
						context.startActivity(intent);
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
