
package sc.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class BaseView extends View
{
	Paint paint;
	
	public BaseView(Context context)
	{
		super(context);
		
		paint = new Paint();
	}
	
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		
		paint.setColor(Color.WHITE);
		canvas.drawCircle(300, 300, 150, paint);
	}
	
	public boolean dispatchTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				// event.getX();
				// event.getY());
				break;
			
			case MotionEvent.ACTION_MOVE:
				break;
			
			case MotionEvent.ACTION_UP:
				
				String curPos = event.getX() + "," + event.getY();
				Toast.makeText(this.getContext(), curPos, Toast.LENGTH_SHORT).show();
				break;
		}
		// return super.dispatchTouchEvent(event);
		return true;
	}
	
}
