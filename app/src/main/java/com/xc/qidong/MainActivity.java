package com.xc.qidong;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建一个白色背景的布局
        FrameLayout layout = new FrameLayout(this);
        layout.setBackgroundColor(0xFFFFFFFF); // 白色
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // 添加图标
        ImageView icon = new ImageView(this);
        icon.setImageResource(android.R.drawable.ic_dialog_info); // 使用系统自带图标
        FrameLayout.LayoutParams iconParams = new FrameLayout.LayoutParams(
                120, 120
        );
        iconParams.gravity = Gravity.CENTER;
        iconParams.bottomMargin = 80; // 图标在文字上方
        layout.addView(icon, iconParams);

        // 添加文字
        TextView text = new TextView(this);
        text.setText("启动完成示例");
        text.setTextSize(24);
        text.setTextColor(0xFF000000); // 黑色
        FrameLayout.LayoutParams textParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        textParams.gravity = Gravity.CENTER;
        layout.addView(text, textParams);

        setContentView(layout);
    }
}
