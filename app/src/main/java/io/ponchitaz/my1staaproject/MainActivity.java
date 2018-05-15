package io.ponchitaz.my1staaproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText userText;
    Button sendToActivity;
    Button sendToMail;
    Button aboutCats;
//    private String mailAddress = "";

    @Nullable
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = (EditText) findViewById(R.id.userText);
        sendToActivity = (Button) findViewById(R.id.sayHere);
        sendToMail = (Button) findViewById(R.id.sendMsg);
        aboutCats = (Button) findViewById(R.id.aboutCatsBtn);

        sendToActivity.setOnClickListener(ActionListener);
        sendToMail.setOnClickListener(ActionListener);
        aboutCats.setOnClickListener(ActionListener);

    }

    private View.OnClickListener ActionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.aboutCatsBtn:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cat_meow_2);
                    mediaPlayer.start();

                    Intent catInfo = new Intent(MainActivity.this, CatHome.class);
                    startActivity(catInfo);
                    break;

                case R.id.sayHere:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cat_hissing);
                    mediaPlayer.start();

                    Intent intent = new Intent(MainActivity.this, CatTalks.class);
                    intent.putExtra("catSays", userText.getText().toString());
                    startActivity(intent);
                    break;

                case R.id.sendMsg:
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cat_sad);
                    mediaPlayer.start();

                    final Intent mailCat = new Intent(Intent.ACTION_SEND);
                    mailCat.setType("plain/text");

                    //message title
                    mailCat.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hello, yes. this is cat");

                    //message content - here is the user input from the app
                    mailCat.putExtra(android.content.Intent.EXTRA_TEXT, userText.getText().toString());

                    MainActivity.this.startActivity(Intent.createChooser(mailCat, "Sending..."));

//                  HERE IS THE ATTEMPT TO MAKE AN ALERT WINDOW FOR EMAIL-INPUT,
//                  BUT THIS TEXT DON'T DROP INTO THE MAIL APP

//                    // a way of customizing the alert window - needs some changes in code of the window calling
////                    LayoutInflater alertInflater = LayoutInflater.from(MainActivity.this);
////                    final View myMailAlert = alertInflater.inflate(R.layout.custom_mail_alert, null);
////                    final EditText mailAddress = (EditText) myMailAlert.findViewById(R.id.addressInput);
////
////                    Button sendBtn = (Button) findViewById(R.id.sendBtn);
////                    Button cancelBtn = (Button) findViewById(R.id.cancelBtn);

//                    //creating the alert dialog to get the e-mail address of the message recipient

//                    AlertDialog.Builder addressAlert = new AlertDialog.Builder(MainActivity.this);
//                    addressAlert.setTitle("Who should get the message?");

//                    //setting up the user email input
//                    final EditText mailInput = new EditText(MainActivity.this);
//                    mailInput.setInputType(InputType.TYPE_CLASS_TEXT);
//                    addressAlert.setView(mailInput);

//                    //now customize the alert window buttons
//                    addressAlert.setPositiveButton("Send", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            mailAddress = mailInput.getText().toString();
//                            final Intent mailCat = new Intent(Intent.ACTION_SEND);
//                            mailCat.setType("plain/text");
//                            //set the address via pop up input
//                            mailCat.putExtra(android.content.Intent.EXTRA_EMAIL, mailAddress);
//
//                            //message title - hardcoded, written right here
//                            mailCat.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hello, yes, this is cat");
//
//                            //message content - here is the user input from the app
//                            mailCat.putExtra(android.content.Intent.EXTRA_TEXT, userText.getText().toString());
//
//                            MainActivity.this.startActivity(Intent.createChooser(mailCat, "Sending an e-mail..."));
//                        }
//                    });
//                    addressAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.cancel();
//                        }
//                    });
//                    addressAlert.show();
            }
        }
    };
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

