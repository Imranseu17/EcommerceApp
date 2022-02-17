package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.ChatAdapter;
import com.kcsl.ecommerce.databinding.ActivityChatBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import es.dmoral.toasty.Toasty;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding chatBinding;
    ArrayList<String> messages;
    ArrayList<String> timeList;
    int size;
    private int currentApiVersion;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatBinding = DataBindingUtil. setContentView(this,R.layout.activity_chat);
        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(flags);
                    }
                }
            });
        }

        messages = new ArrayList<>();
        timeList = new ArrayList<>();

        chatBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

       chatBinding. send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chatBinding. chatbox.getText().toString().trim().equals("")){
                    size++;
                   chatBinding. chatList.setHasFixedSize(false);
                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(ChatActivity.this,
                            LinearLayoutManager.VERTICAL, false);
                    chatBinding.chatList.setLayoutManager(layoutManager);
                    messages.add(chatBinding.chatbox.getText().toString().trim());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date time = new Date();
                    String timeString =  timeFormat.format(time);
                    timeList.add(timeString);
                    ChatAdapter chatAdapter = new ChatAdapter(size,ChatActivity.this,
                            messages,timeList);
                    chatBinding. chatList.setAdapter(chatAdapter);
                    chatBinding. chatList.smoothScrollToPosition(chatAdapter.getItemCount());
                     chatAdapter.notifyDataSetChanged();
                    layoutManager.setStackFromEnd(true);
                    chatBinding. chatbox.setText("");
                }else {
                    Toasty.error(ChatActivity.this,"Please input in chatbox",Toasty.LENGTH_SHORT).show();
                }

            }
        });
    }


}