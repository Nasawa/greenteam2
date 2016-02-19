package com.anigeek.greenteam2.classes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

public class SuperSpinner extends Spinner
{

	private int lastSelected = -1;
	private boolean catcher = false;

	public SuperSpinner(Context context)
	{ super(context); }

	public SuperSpinner(Context context, AttributeSet attrs)
	{ super(context, attrs); }

	public SuperSpinner(Context context, AttributeSet attrs, int defStyle)
	{ super(context, attrs, defStyle); }

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		if(!catcher)
			catcher = true;
		else
		{
			if (this.lastSelected == this.getSelectedItemPosition() && getOnItemSelectedListener() != null)
				getOnItemSelectedListener().onItemSelected(this, getSelectedView(), this.getSelectedItemPosition(), getSelectedItemId());
			if (!changed)
				lastSelected = this.getSelectedItemPosition();
		}

		super.onLayout(changed, l, t, r, b);
	}
}