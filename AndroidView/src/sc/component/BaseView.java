
package sc.component;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;


public class BaseView extends View
{
	List<ViewObj> childsList = new ArrayList<ViewObj>();
	
	// Paint paint;
	Button btn;
	
	public BaseView(Context context)
	{
		super(context);
		
		// paint = new Paint();
		btn = new Button(this);
		
		childsList.add(btn);
	}
	
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		// paint.setColor(Color.WHITE);
		// canvas.drawCircle(300, 300, 150, paint);
		
		// btn.Draw(canvas);
		
		for (ViewObj iteam : childsList)
		{
			iteam.Draw(canvas);
		}
	}
	
	public boolean dispatchTouchEvent(MotionEvent event)
	{
		float x = event.getX();
		float y = event.getY();
		
		for (ViewObj iteam : childsList)
		{
			if(!iteam.isInRegion(x, y)) continue;
				
			switch (event.getAction())
			{
				case MotionEvent.ACTION_DOWN:
					// event.getX();
					// event.getY());
					
					iteam.clickDown(x, y);
					break;
				
				case MotionEvent.ACTION_MOVE:
					break;
				
				case MotionEvent.ACTION_UP:
					iteam.click(x, y);
					
					// String curPos = event.getX() + "," + event.getY();
					// Toast.makeText(this.getContext(), curPos, Toast.LENGTH_SHORT).show();
					break;
			}
		}
		// return super.dispatchTouchEvent(event);
		return true;
	}
	
}
