package com.example.a.checkattendance.counsellor;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AlphabetIndexer;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.a.checkattendance.R;
import com.example.a.checkattendance.counsellor.sidenavigation.ChineseToPinyinHelper;
import com.example.a.checkattendance.counsellor.sidenavigation.LetterIndexView;
import com.example.a.checkattendance.counsellor.sidenavigation.MyAdapter;
import com.example.a.checkattendance.counsellor.sidenavigation.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CounsellorClassmateList extends AppCompatActivity {
    private List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_counsellor_classmate_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ListView listView = (ListView) findViewById(R.id.lv);

        initData();

        final MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = list.get(position);
                Intent intent =new Intent(CounsellorClassmateList.this,CounsellorDAStudent.class);
                intent.putExtra("name",user.getUsername());
                startActivity(intent);
            }
        });

        TextView textView = (TextView) findViewById(R.id.show_letter_in_center);
        final LetterIndexView letterIndexView = (LetterIndexView) findViewById(R.id.letter_index_view);
        letterIndexView.setTextViewDialog(textView);

        letterIndexView.setUpdateListView(new LetterIndexView.UpdateListView() {

            @Override
            public void updateListView(String currentChar) {

                int positionForSection = adapter.getPositionForSection(currentChar.charAt(0));
                listView.setSelection(positionForSection);
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                int sectionForPosition = adapter.getSectionForPosition(firstVisibleItem);
                letterIndexView.updateLetterIndexView(sectionForPosition);
            }
        });
    }

    private void initData() {

        list = new ArrayList<>();
        String[] allUserNames = getResources().getStringArray(R.array.arrUsernames);

        for (String allUserName : allUserNames) {

            User user = new User();
            user.setUsername(allUserName);
            String convert = ChineseToPinyinHelper.getInstance().getPinyin(allUserName).toUpperCase();
            Log.e("nsc","convert="+convert);
            user.setPinyin(convert);
            String substring = convert.substring(0, 1);

            if (substring.matches("[A-Z]")) {
                user.setFirstLetter(substring);
            }else{
                user.setFirstLetter("#");
            }
            list.add(user);

        }

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User lhs, User rhs) {
                if (lhs.getFirstLetter().contains("#")) {
                    return 1;
                } else if (rhs.getFirstLetter().contains("#")) {
                    return -1;
                }else{
                    return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
                }
            }
        });
    }

}
