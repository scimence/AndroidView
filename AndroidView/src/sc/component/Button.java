
package sc.component;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.view.View;


public class Button
{
	View Parent = null;
	
	public int BorderColor = 0xffc9c9c9;
	public int BackColor = 0xffdadada;
	public int BackColor_Click = 0xffcccccc;
	
	public int BorderWitdh = 2;
	public RectF Region = new RectF(30, 30, 300, 100);
	public float RegionRoundX = Region.height() / 2;
	public float RegionRoundY = Region.height() / 2;
	
	public String Text = "Button";
	public float TextSize = Region.height() / 2;
	public int TextColor = 0xff000000;
	
	Paint paint = new Paint();
	
	public Button(View Parent)
	{
		this.Parent = Parent;
	}
	
	public void Draw(Canvas canvas)
	{
		DrawBackGround(canvas);	// 绘制背景填充色
		DrawBorder(canvas);		// 绘制边框
		DrawString(canvas);		// 绘制显示文本
	}
	
	// 绘制边框轮廓
	private void DrawBorder(Canvas canvas)
	{
		paint.setColor(BorderColor);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(BorderWitdh);
		
		canvas.drawRoundRect(Region, RegionRoundX, RegionRoundY, paint);
	}
	
	// 绘制背景
	private void DrawBackGround(Canvas canvas)
	{
		if (isClickDown)
			paint.setColor(BackColor_Click);
		else paint.setColor(BackColor);
		
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(BorderWitdh);
		
		canvas.drawRoundRect(Region, RegionRoundX, RegionRoundY, paint);
	}
	
	// 绘制文本
	private void DrawString(Canvas canvas)
	{
		paint.setColor(TextColor);
		paint.setTextSize(TextSize);  
		
		FontMetricsInt fm = paint.getFontMetricsInt();
		float FontHeight = (fm.bottom - fm.top);
		
		paint.setTextAlign(Paint.Align.CENTER);  
		
		// 居中绘制文本
		canvas.drawText(Text, Region.centerX(), Region.centerY() + FontHeight / 4, paint);
	}
	
	boolean isClickDown = false;
	
	// 点击指定的坐标
	public void clickDown(float x, float y)
	{
		if (isInRegion(x, y))
		{
			isClickDown = true;
			Parent.invalidate();
		}
	}
	
	// 点击释放时的坐标
	public void click(float x, float y)
	{
		if (isInRegion(x, y))
		{
			isClickDown = false;
			Parent.invalidate();
		}
	}
	
	// 判断坐标x,y是否在Region区域范围内
	public boolean isInRegion(float x, float y)
	{
		if (x < Region.left || Region.right < x) return false;
		if (y < Region.top || Region.bottom < y) return false;
		
		return true;
	}
	
	//--------------
	

	/** 设置Button显示坐标、大小 */
	public void SetRegion(float left, float top, float right, float bottom)
	{
		Region = new RectF(left, top, right, bottom);
		RegionRoundX = Region.height() / 2;
		RegionRoundY = Region.height() / 2;
		TextSize = Region.height() / 2;
		
		Parent.invalidate();	// 刷新显示
	}
	
	/** 设置Button显示坐标、大小 */
	public void SetText(String Text)
	{
		this.Text = Text;
	}
}
