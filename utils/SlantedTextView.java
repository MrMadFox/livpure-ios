package com.livpure.safedrink.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.livpure.safedrink.R;
/* loaded from: classes3.dex */
public class SlantedTextView extends View {
    public static final int MODE_LEFT = 0;
    public static final int MODE_LEFT_BOTTOM = 2;
    public static final int MODE_LEFT_BOTTOM_TRIANGLE = 6;
    public static final int MODE_LEFT_TRIANGLE = 4;
    public static final int MODE_RIGHT = 1;
    public static final int MODE_RIGHT_BOTTOM = 3;
    public static final int MODE_RIGHT_BOTTOM_TRIANGLE = 7;
    public static final int MODE_RIGHT_TRIANGLE = 5;
    public static final int ROTATE_ANGLE = 45;
    private int mMode;
    private Paint mPaint;
    private int mSlantedBackgroundColor;
    private float mSlantedLength;
    private String mSlantedText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private float mTextSize;

    public SlantedTextView(Context context) {
        this(context, null);
    }

    public SlantedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SlantedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mSlantedLength = 40.0f;
        this.mTextSize = 16.0f;
        this.mSlantedBackgroundColor = 0;
        this.mTextColor = -1;
        this.mSlantedText = "";
        this.mMode = 0;
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.SlantedTextView);
        this.mTextSize = obtainStyledAttributes.getDimension(5, this.mTextSize);
        this.mTextColor = obtainStyledAttributes.getColor(4, this.mTextColor);
        this.mSlantedLength = obtainStyledAttributes.getDimension(1, this.mSlantedLength);
        this.mSlantedBackgroundColor = obtainStyledAttributes.getColor(0, this.mSlantedBackgroundColor);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mSlantedText = obtainStyledAttributes.getString(3);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.mMode = obtainStyledAttributes.getInt(2, 0);
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mSlantedBackgroundColor);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mTextColor);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawText(canvas);
    }

    private void drawBackground(Canvas canvas) {
        Path path = new Path();
        int width = getWidth();
        int height = getHeight();
        if (width != height) {
            throw new IllegalStateException("SlantedTextView's width must equal to height");
        }
        switch (this.mMode) {
            case 0:
                path = getModeLeftPath(path, width, height);
                break;
            case 1:
                path = getModeRightPath(path, width, height);
                break;
            case 2:
                path = getModeLeftBottomPath(path, width, height);
                break;
            case 3:
                path = getModeRightBottomPath(path, width, height);
                break;
            case 4:
                path = getModeLeftTrianglePath(path, width, height);
                break;
            case 5:
                path = getModeRightTrianglePath(path, width, height);
                break;
            case 6:
                path = getModeLeftBottomTrianglePath(path, width, height);
                break;
            case 7:
                path = getModeRightBottomTrianglePath(path, width, height);
                break;
        }
        path.close();
        canvas.drawPath(path, this.mPaint);
        canvas.save();
    }

    private Path getModeLeftPath(Path path, int w, int h) {
        float f = w;
        path.moveTo(f, 0.0f);
        float f2 = h;
        path.lineTo(0.0f, f2);
        path.lineTo(0.0f, f2 - this.mSlantedLength);
        path.lineTo(f - this.mSlantedLength, 0.0f);
        return path;
    }

    private Path getModeRightPath(Path path, int w, int h) {
        float f = w;
        float f2 = h;
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.mSlantedLength);
        path.lineTo(this.mSlantedLength, 0.0f);
        return path;
    }

    private Path getModeLeftBottomPath(Path path, int w, int h) {
        float f = w;
        float f2 = h;
        path.lineTo(f, f2);
        path.lineTo(f - this.mSlantedLength, f2);
        path.lineTo(0.0f, this.mSlantedLength);
        return path;
    }

    private Path getModeRightBottomPath(Path path, int w, int h) {
        float f = h;
        path.moveTo(0.0f, f);
        path.lineTo(this.mSlantedLength, f);
        float f2 = w;
        path.lineTo(f2, this.mSlantedLength);
        path.lineTo(f2, 0.0f);
        return path;
    }

    private Path getModeLeftTrianglePath(Path path, int w, int h) {
        path.lineTo(0.0f, h);
        path.lineTo(w, 0.0f);
        return path;
    }

    private Path getModeRightTrianglePath(Path path, int w, int h) {
        float f = w;
        path.lineTo(f, 0.0f);
        path.lineTo(f, h);
        return path;
    }

    private Path getModeLeftBottomTrianglePath(Path path, int w, int h) {
        float f = h;
        path.lineTo(w, f);
        path.lineTo(0.0f, f);
        return path;
    }

    private Path getModeRightBottomTrianglePath(Path path, int w, int h) {
        float f = h;
        path.moveTo(0.0f, f);
        float f2 = w;
        path.lineTo(f2, f);
        path.lineTo(f2, 0.0f);
        return path;
    }

    private void drawText(Canvas canvas) {
        float[] calculateXY = calculateXY(canvas, (int) (canvas.getWidth() - (this.mSlantedLength / 2.0f)), (int) (canvas.getHeight() - (this.mSlantedLength / 2.0f)));
        float f = calculateXY[0];
        float f2 = calculateXY[1];
        canvas.rotate(calculateXY[4], calculateXY[2], calculateXY[3]);
        canvas.drawText(this.mSlantedText, f, f2, this.mTextPaint);
    }

    private float[] calculateXY(Canvas canvas, int w, int h) {
        Rect rect;
        Rect rect2;
        Rect rect3;
        Rect rect4;
        float[] fArr = new float[5];
        int i = (int) (this.mSlantedLength / 2.0f);
        switch (this.mMode) {
            case 0:
            case 4:
                RectF rectF = new RectF(new Rect(0, 0, w, h));
                TextPaint textPaint = this.mTextPaint;
                String str = this.mSlantedText;
                rectF.right = textPaint.measureText(str, 0, str.length());
                rectF.bottom = this.mTextPaint.descent() - this.mTextPaint.ascent();
                rectF.left += (rect.width() - rectF.right) / 2.0f;
                rectF.top += (rect.height() - rectF.bottom) / 2.0f;
                fArr[0] = rectF.left;
                fArr[1] = rectF.top - this.mTextPaint.ascent();
                fArr[2] = w / 2;
                fArr[3] = h / 2;
                fArr[4] = -45.0f;
                break;
            case 1:
            case 5:
                RectF rectF2 = new RectF(new Rect(i, 0, w + i, h));
                TextPaint textPaint2 = this.mTextPaint;
                String str2 = this.mSlantedText;
                rectF2.right = textPaint2.measureText(str2, 0, str2.length());
                rectF2.bottom = this.mTextPaint.descent() - this.mTextPaint.ascent();
                rectF2.left += (rect2.width() - rectF2.right) / 2.0f;
                rectF2.top += (rect2.height() - rectF2.bottom) / 2.0f;
                fArr[0] = rectF2.left;
                fArr[1] = rectF2.top - this.mTextPaint.ascent();
                fArr[2] = (w / 2) + i;
                fArr[3] = h / 2;
                fArr[4] = 45.0f;
                break;
            case 2:
            case 6:
                RectF rectF3 = new RectF(new Rect(0, i, w, h + i));
                TextPaint textPaint3 = this.mTextPaint;
                String str3 = this.mSlantedText;
                rectF3.right = textPaint3.measureText(str3, 0, str3.length());
                rectF3.bottom = this.mTextPaint.descent() - this.mTextPaint.ascent();
                rectF3.left += (rect3.width() - rectF3.right) / 2.0f;
                rectF3.top += (rect3.height() - rectF3.bottom) / 2.0f;
                fArr[0] = rectF3.left;
                fArr[1] = rectF3.top - this.mTextPaint.ascent();
                fArr[2] = w / 2;
                fArr[3] = (h / 2) + i;
                fArr[4] = 45.0f;
                break;
            case 3:
            case 7:
                RectF rectF4 = new RectF(new Rect(i, i, w + i, h + i));
                TextPaint textPaint4 = this.mTextPaint;
                String str4 = this.mSlantedText;
                rectF4.right = textPaint4.measureText(str4, 0, str4.length());
                rectF4.bottom = this.mTextPaint.descent() - this.mTextPaint.ascent();
                rectF4.left += (rect4.width() - rectF4.right) / 2.0f;
                rectF4.top += (rect4.height() - rectF4.bottom) / 2.0f;
                fArr[0] = rectF4.left;
                fArr[1] = rectF4.top - this.mTextPaint.ascent();
                fArr[2] = (w / 2) + i;
                fArr[3] = (h / 2) + i;
                fArr[4] = -45.0f;
                break;
        }
        return fArr;
    }

    public SlantedTextView setText(String str) {
        this.mSlantedText = str;
        postInvalidate();
        return this;
    }

    public SlantedTextView setText(int res) {
        String string = getResources().getString(res);
        if (!TextUtils.isEmpty(string)) {
            setText(string);
        }
        return this;
    }

    public String getText() {
        return this.mSlantedText;
    }

    public SlantedTextView setSlantedBackgroundColor(int color) {
        this.mSlantedBackgroundColor = color;
        this.mPaint.setColor(color);
        postInvalidate();
        return this;
    }

    public SlantedTextView setTextColor(int color) {
        this.mTextColor = color;
        this.mTextPaint.setColor(color);
        postInvalidate();
        return this;
    }

    public SlantedTextView setMode(int mode) {
        int i = this.mMode;
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException(mode + "is illegal argument ,please use right value");
        }
        this.mMode = mode;
        postInvalidate();
        return this;
    }

    public int getMode() {
        return this.mMode;
    }

    public SlantedTextView setTextSize(int size) {
        float f = size;
        this.mTextSize = f;
        this.mTextPaint.setTextSize(f);
        postInvalidate();
        return this;
    }

    public SlantedTextView setSlantedLength(int length) {
        this.mSlantedLength = length;
        postInvalidate();
        return this;
    }
}
