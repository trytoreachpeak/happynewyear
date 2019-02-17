package com.example.a.checkattendance.counsellor;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.counsellor.contactpick.Contact;
import com.example.a.checkattendance.counsellor.contactpick.ContactAdapter;
import com.example.a.checkattendance.counsellor.contactpick.PinYin;
import com.example.a.checkattendance.counsellor.contactpick.QuickIndexBar;
import com.example.a.checkattendance.counsellor.contactpick.SearchContactAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CounsellorClassmateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_counsellor_classmate_list);

    }

}
