package com.example.s420.uidemo.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.support.v7.appcompat.R;

/**
 * Created by s420 on 2017/1/12.
 */
public class ToNewActivityListener implements View.OnClickListener {
    private Intent intent;
    private Context context;

    public ToNewActivityListener(Context context, Intent intent) {
        this.intent = intent;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        context.startActivity(intent);
//       context.overridePendingTransition( android.support.v7.appcompat.R.anim.abc_fade_in, android.support.v7.appcompat.R.anim.abc_fade_out);
    }
}
