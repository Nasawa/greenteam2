package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Christopher on 2/14/2016.
 */
public class CampusActivity extends Activity
{
	private Context context;
	private String[] info;
	private ListView lv;
	private String selected = "unknown";

	public void onCreate(Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.activity_campus);

		context = this;

		Bundle extras = getIntent().getExtras();
		if (extras != null)
			info = extras.getStringArray("info");

		String[] temp = new String[info.length + 1];

		for(int i = 0; i < info.length; i++)
			temp[i] = info[i];

		info = temp;

		ArrayAdapter adapter = ArrayAdapter.createFromResource(context, R.array.campuses, android.R.layout.simple_list_item_1);
		lv = (ListView)findViewById(R.id.listView);

		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new ListView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long arg3)
			{
				view.setSelected(true);
				selected = parent.getItemAtPosition(position).toString();
			}
		});

		((Button)findViewById(R.id.submit)).setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(context, ConfirmActivity.class);
				info[info.length - 1] = selected;
				intent.putExtra("info", info);
				startActivity(intent);
			}
		});
	}
}
