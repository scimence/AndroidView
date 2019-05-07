package sc.component;

import android.graphics.Canvas;

/** View自定义对象 */
public abstract class ViewObj
{
	public abstract void Draw(Canvas canvas);			// 绘制当前View
	
	public abstract void clickDown(float x, float y);	// 当前View按下
	public abstract void click(float x, float y);		// 当前View点击释放
	public abstract boolean isInRegion(float x, float y);		// 坐标x,y是否在当前View的显示范围内
}
