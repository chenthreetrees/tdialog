package com.threetree.ttdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/20.
 */

public class MenuDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private ArrayList<String> mStrs;
    private OnItemClickListener mListener;
    public interface OnItemClickListener
    {
        void onItemClick(int index);
    }

    public MenuDialog(@NonNull Builder builder)
    {
        super(builder.context, R.style.my_dialog);
        mContext = builder.context;
        mStrs = builder.strs;
        mListener = builder.listener;
    }

    public MenuDialog(@NonNull Context context, @StyleRes int themeResId)
    {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundResource(R.drawable.bg_dialog_menu);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.weight = 1;

        LinearLayout.LayoutParams deliverParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(mContext, 1));

        for (int i = 0, size = mStrs.size(); i < size; i++) {
            TextView textView = new TextView(mContext);
            textView.setTag(i);
            textView.setGravity(Gravity.CENTER);
            textView.setText(mStrs.get(i));
            textView.setPadding(180,18,180,18);
            textView.setTextColor(ContextCompat.getColor(mContext, R.color.dialog_menu_text));
            textView.setOnClickListener(this);
            linearLayout.addView(textView, layoutParams);

            View view = new View(mContext);
            view.setBackgroundResource(R.color.dialog_menu_deliver);
            linearLayout.addView(view, deliverParams);
        }
        TextView cancelTv = new TextView(mContext);
        cancelTv.setGravity(Gravity.CENTER);
        cancelTv.setText("取消");
        cancelTv.setPadding(180,18,180,18);
        cancelTv.setTextColor(Color.RED);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });
        linearLayout.addView(cancelTv, layoutParams);
        setContentView(linearLayout);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onClick(View v)
    {
        if(mListener != null)
        {
            mListener.onItemClick((int)v.getTag());
        }
        dismiss();
    }

    public static class Builder {
        private Context context;
        private ArrayList<String> strs;
        private OnItemClickListener listener;
        public Builder(Context context)
        {
            this.context = context;
            strs = new ArrayList<String>();
        }

        public Builder item(String item)
        {
            strs.add(item);
            return this;
        }

        public Builder listener(OnItemClickListener listener)
        {
            this.listener = listener;
            return this;
        }

        public MenuDialog build()
        {
            return new MenuDialog(this);
        }

    }
}
