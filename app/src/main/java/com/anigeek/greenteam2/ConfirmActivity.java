package com.anigeek.greenteam2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Christopher on 2/14/2016.
 */
public class ConfirmActivity extends Activity
{
	private String[] info;
	private Context context;
	private static Intent intent;
	private final int STATE = 0, CITY = 1, GRADE = 2, SUBJECT = 3, NEEDED = 4, CALCULATOR = 5, CAMPUS = 6;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm);

		context = this;

		Bundle extras = getIntent().getExtras();
		if (extras != null)
			info = extras.getStringArray("info");

		String[] labels = new String[] {"State", "City", "Grade", "Subject", "What needed", "Calculator", "Campus"};

		LinearLayout root = (LinearLayout)findViewById(R.id.confirm_root);
		TextView tv;

		for(int i = 0; i < labels.length; i++)
		{
			tv = new TextView(context);
			tv.setText(String.format("%s: %s", labels[i], info.length <= i ? "unknown" : info[i]));
			if(i != CALCULATOR)
				root.addView(tv);
		}

		ImageView im = new ImageView(context);
		im.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
		                                                 LinearLayout.LayoutParams.MATCH_PARENT));


		if (info[NEEDED].equals("Book"))
		{
			im.setImageResource(R.drawable.book);
			intent = new Intent(context, ChapterActivity.class);
		}
		else if (info[NEEDED].equals("Website"))
		{
			im.setImageResource(R.drawable.wifi);
			intent = new Intent(context, ChapterActivity.class);
		}
		else if (info[NEEDED].equals("Question"))
		{
			im.setImageResource(R.drawable.question);
			intent = new Intent(context, ProblemActivity.class);
			if(info[CALCULATOR].equals("Yes"))
				intent.putExtra("Calculator", true);
		}
		else
			intent = new Intent(context, ChapterActivity.class);

		im.setColorFilter(Color.parseColor("#6495ed"));

		im.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startActivity(intent);
			}
		});

		root.addView(im);
	}
}
