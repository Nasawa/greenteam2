package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.anigeek.greenteam2.classes.GreenExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChapterActivity extends Activity
{
	List<String> headers;
	HashMap<String, List<String>> children;
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter);

		context = this;

		prepareListData();

		ExpandableListView exp = (ExpandableListView) findViewById(R.id.expandable);
		ExpandableListAdapter adapter = new GreenExpandableListAdapter(this, headers, children);

		exp.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
		{
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
			{
				Intent intent = new Intent(context, PageActivity.class);
				startActivity(intent);
				return false;
			}
		});

		exp.setAdapter(adapter);
	}

	private void prepareListData()
	{
		headers = new ArrayList<String>();
		children = new HashMap<String, List<String>>();

		for(int i = 1; i < 11; i++)
		{
			List<String> temp = new ArrayList<String>();
			headers.add("Chapter " + i);
			for(int j = 1; j < 11; j++)
			{
				temp.add("Section " + j);
			}
			children.put(headers.get(i - 1), temp);
		}
	}
}
