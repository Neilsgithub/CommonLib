package me.suanmiao.example.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import me.suanmiao.example.R;


/**
 * Created by suanmiao on 14-11-29.
 */
public class STextView extends TextView {

  private static Typeface hei;
  private static final String TYPEFACE_DEFAULT_PATH = "fonts/heiti.ttf";
  private static final String TYPEFACE_BOLD_PATH = "fonts/heiti_bold.ttf";
  private static final int STYLE_NORMAL = 2;
  private static final int STYLE_BOLD = 3;
  private int textStyle = STYLE_NORMAL;

  public STextView(Context context) {
    super(context);
    init(context);
  }

  public STextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initAttr(context, attrs);
    init(context);
  }

  public STextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    initAttr(context, attrs);
    init(context);
  }

  private void init(Context context) {
    if (hei == null) {
      switch (textStyle) {
        case STYLE_NORMAL:
          hei = Typeface.createFromAsset(getResources().getAssets(), TYPEFACE_DEFAULT_PATH);
          break;
        case STYLE_BOLD:
          hei = Typeface.createFromAsset(getResources().getAssets(), TYPEFACE_BOLD_PATH);
          break;
        default:
          hei = Typeface.createFromAsset(getResources().getAssets(), TYPEFACE_DEFAULT_PATH);
          break;
      }
    }
    setTypeface(hei);
  }


  private void initAttr(Context context, AttributeSet attributeSet) {
    TypedArray a =
        context.obtainStyledAttributes(attributeSet, R.styleable.STextView);
    try {
      textStyle = a.getInt(R.styleable.STextView_textStyle, STYLE_NORMAL);
    } finally {
      a.recycle();
    }
  }



}