package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity
{
	private Context       context;
	private List<Spinner> spinnerList;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;

		LinearLayout left = (LinearLayout) findViewById(R.id.left_layout);
		spinnerList = new ArrayList<Spinner>();

		Spinner spinner;
		ArrayAdapter<CharSequence> adapter;
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, .2f);

		int[] res = new int[] {R.array.states, R.array.cities, R.array.grades, R.array.subjects, R.array.needed};

		for(int i = 0; i < res.length; i++)
		{
			spinner = new Spinner(context);
			spinner.setLayoutParams(layoutParams);
			adapter = ArrayAdapter.createFromResource(context, res[i], android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(adapter);
			spinnerList.add(spinner);
			left.addView(spinner);
		}

		spinner = (Spinner)findViewById(R.id.calc_spinner);
		adapter = ArrayAdapter.createFromResource(context, R.array.calculator, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerList.add(spinner);
		spinner.setAdapter(adapter);

		((Button)findViewById(R.id.submit)).setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(context, CampusActivity.class);
				String[] arr = new String[spinnerList.size()];
				for(int i = 0; i < arr.length; i++)
					arr[i] = ((CharSequence)spinnerList.get(i).getSelectedItem()).toString();
				intent.putExtra("info", arr);
				startActivity(intent);
			}
		});
	}
}