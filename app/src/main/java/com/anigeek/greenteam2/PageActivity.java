package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PageActivity extends Activity
{
	Context context;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page);

		context = this;
		final Spinner spinner = (Spinner) findViewById(R.id.pagespin);
		textView = (TextView) findViewById(R.id.scrollpage);

		ArrayList<String> list = new ArrayList<>();
		for(int i = 1; i < 150; i++)
			list.add("Page " + i);
		String[] spinnerArray = new String[list.size()];
		list.toArray(spinnerArray);

		ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, spinnerArray);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		(findViewById(R.id.nextpage)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				spinner.setSelection((spinner.getSelectedItemPosition() + 1) % 149 );
			}
		});

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				flipText();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{

			}
		});
	}

	public void flipText()
	{
		if(textView.getText().charAt(0) == 'M')
			textView.setText(R.string.large_text2);
		else
			textView.setText(R.string.large_text);
	}
}
