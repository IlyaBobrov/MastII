package com.example.mastii;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class ForumActivity extends AppCompatActivity {

    private final String LOG_TAG = "forum";
    private static int SIGN_IN_CODE = 1;
    private RelativeLayout activity_forum;
    private FirebaseListAdapter<Message> adapter;
    private EmojiconEditText editText;
    private ImageView btnEmoji, btnSend;
    private EmojIconActions emojIconActions;
    private ListView listOfMessages;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_CODE) {
            if (resultCode == RESULT_OK) {
                Snackbar.make(activity_forum, "успешно", Snackbar.LENGTH_LONG).show();
                displayAllMessages();
            } else {
                Snackbar.make(activity_forum, "Вы не авторизованы", Snackbar.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        activity_forum = findViewById(R.id.activity_forum);
        btnSend = findViewById(R.id.btnSend);
        btnEmoji = findViewById(R.id.btnEmoji);
        editText = findViewById(R.id.messageField);
        emojIconActions = new EmojIconActions(getApplicationContext(), activity_forum, editText, btnEmoji);
        emojIconActions.ShowEmojIcon();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidEditText()) return;
                FirebaseDatabase.getInstance().getReference().push().setValue(
                        new Message(
                        FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        editText.getText().toString()
                        )
                );
                editText.setText("");
            }


        });
        //user not auth
        if (FirebaseAuth.getInstance().getCurrentUser() == null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_CODE);
        else {
            Snackbar.make(activity_forum, "Добро пожаловать на форум", Snackbar.LENGTH_LONG).show();
            displayAllMessages();
        }
    }

    private boolean checkValidEditText() {
        return !editText.getText().toString().isEmpty();
    }

    private void displayAllMessages() {
        listOfMessages = findViewById(R.id.listOfMessages);
        adapter = new FirebaseListAdapter<Message>(this, Message.class,
                R.layout.list_item, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, Message model, int position) {
                TextView mess_user, mess_role, mess_time;
                BubbleTextView mess_text;
                mess_user = v.findViewById(R.id.message_user);
                mess_role = v.findViewById(R.id.message_role);
                mess_text = v.findViewById(R.id.message_text);
                mess_time = v.findViewById(R.id.message_time);
                mess_user.setText(model.getUserName());
                mess_role.setText(model.getUserRole());
                mess_text.setText(model.getTextMessage());
                mess_time.setText(DateFormat.format("dd-MM-yyyy HH:mm:ss", model.getMessageTime()));
            }
        };
        listOfMessages.setAdapter(adapter);

        listOfMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
                Log.d(LOG_TAG, "Text message: " + adapter.getItem(position).getTextMessage());

            }
        });


        listOfMessages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // позволяет выбирать item
                //((ListView) parent).getCheckedItemPositions()
                Log.d(LOG_TAG, "itemSelect: position = " + position + ", id = " + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(LOG_TAG, "itemSelect: nothing");
            }
        });
    }
}