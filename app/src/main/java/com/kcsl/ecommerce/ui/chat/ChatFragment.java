package com.kcsl.ecommerce.ui.chat;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.ChatAdapter;
import com.kcsl.ecommerce.adapter.NumberOfCategoriesAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import es.dmoral.toasty.Toasty;


public class ChatFragment extends Fragment {

    EditText chatbox;    
    ImageButton send;
    RecyclerView chatList;
    ArrayList<String> messages;
    ArrayList<String> timeList;
    int size;
    LinearLayout chatLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  root =  inflater.inflate(R.layout.fragment_chat, container, false);
        chatbox = root.findViewById(R.id.chatbox);       
        send = root.findViewById(R.id.send);
        chatList = root.findViewById(R.id.chat_list);
        chatLayout = root.findViewById(R.id.chatLayout);
        messages = new ArrayList<>();
        timeList = new ArrayList<>();

        chatbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)chatLayout.getLayoutParams();
                params.setMargins(0, 520, 0, 0);
                chatLayout.setLayoutParams(params);
                chatList.getLayoutParams().height = 480;

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!chatbox.getText().toString().trim().equals("")){
                    size++;
                    chatList.setHasFixedSize(false);
                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
                    chatList.setLayoutManager(layoutManager);
                    messages.add(chatbox.getText().toString().trim());
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date time = new Date();
                    String timeString =  timeFormat.format(time);
                    timeList.add(timeString);
                    ChatAdapter chatAdapter = new ChatAdapter(size,requireContext(),
                         messages,timeList);
                    chatList.setAdapter(chatAdapter);
                    chatList.smoothScrollToPosition(chatAdapter.getItemCount());
                    chatAdapter.notifyDataSetChanged();
                    layoutManager.setStackFromEnd(true);
                    chatbox.setText("");
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)chatLayout.getLayoutParams();
                    params.setMargins(0, 780, 0, 0);
                    chatLayout.setLayoutParams(params);
                    hideKeyboard(requireActivity());
                    chatList.getLayoutParams().height = 720;
                }else {
                    Toasty.error(requireContext(),"Please input in chatbox",Toasty.LENGTH_SHORT).show();
                }

            }
        });
        return  root;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}