package com.xyd.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xyd.R;
import com.xyd.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/21.
 */
public class PhotoMeIdentifyActivity extends BaseActivity implements View.OnClickListener{

    private Button finishButton;
    private ImageView returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photome_identify_activity);
        TextView textView = (TextView) findViewById(R.id.txt_content);
        finishButton = (Button)findViewById(R.id.finish);
        finishButton.setOnClickListener(this);
        returnButton = (ImageView)findViewById(R.id.photome_identify_return);
        returnButton.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Intent intent_login = new Intent();
                intent_login.setClass(PhotoMeIdentifyActivity.this,PhotoIdentifyActivity.class);
                startActivity(intent_login);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.photome_identify_return:
                Intent intent_photo = new Intent();
                intent_photo.setClass(PhotoMeIdentifyActivity.this,PhotoIdentifyActivity.class);
                startActivity(intent_photo);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                break;
            case R.id.finish:
                Intent intent_home = new Intent();
                intent_home.setClass(PhotoMeIdentifyActivity.this,HomeActivity.class);
                startActivity(intent_home);
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                break;
        }
    }
}
