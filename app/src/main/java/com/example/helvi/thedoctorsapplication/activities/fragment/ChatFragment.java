package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.model.ChatMessage;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.Activity.RESULT_OK;


public class ChatFragment extends Fragment {
    private View mView;
    EditText input;
    private static final int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMessage> adapter;

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_chat, container, false);

           if(FirebaseAuth.getInstance().getCurrentUser() == null) {
               // Start sign in/sign up activity
               startActivityForResult(
                       AuthUI.getInstance().createSignInIntentBuilder().build(),
                       SIGN_IN_REQUEST_CODE
               );
           } else {

              Toast.makeText(getContext(),"Welcome " + FirebaseAuth.getInstance()
                               .getCurrentUser()
                               .getDisplayName(),
                       Toast.LENGTH_LONG)
                       .show();

               displayChatMessages();
           }

           FloatingActionButton fab = mView.findViewById(R.id.fab);
           fab.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   input = mView.findViewById(R.id.input);
                   // Log.d("input",input+"");
                   FirebaseDatabase.getInstance()
                           .getReference()
                           .push()
                           .setValue(new ChatMessage(input.getText().toString(),
                                   FirebaseAuth.getInstance()
                                           .getCurrentUser()
                                           .getDisplayName())
                           );


                   input.setText("");
               }
           });


           return mView;


       }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
               /* Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
*/
                displayChatMessages();
            } else {
                Toast.makeText(getActivity(),
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();
               // finish();
            }
        }
    }
    private void displayChatMessages() {
        ListView listOfMessages = (ListView)mView.findViewById(R.id.list_of_messages);

        adapter = new FirebaseListAdapter<ChatMessage>(getActivity(), ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.message_text);
                TextView messageUser = (TextView)v.findViewById(R.id.message_user);
                TextView messageTime = (TextView)v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
    }

}



