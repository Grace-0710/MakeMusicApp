/*
package com.grace.makemusic;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity2 extends AppCompatActivity {
    public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this, READ_CONTACTS) ==
                    PackageManager.PERMISSION_GRANTED) {
                getPhone();
            }  else {

                requestPermissionLauncher.launch(READ_CONTACTS);
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                               int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getPhone();
                } else {
                    requestPermissionLauncher.launch(READ_CONTACTS);
                }
                return;
        }

    }
    private void getPhone(){
        ArrayList<JSONObject> phoneAdrrList = new ArrayList<>();
        ArrayList<String> findDup = new ArrayList<>();
        TextView txt = findViewById(R.id.textView2);
        try {
            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            if(cursor.getC)
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                String tempNumber = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String match = "[^0-9]";
                String number = tempNumber.replaceAll(match, "");
                // 이름 + 전화번호 중복 방지
                if (!findDup.contains(name + number)) {
                    findDup.add(name + number);
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", name);
                        jsonObject.put("phoneNumber", number);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    phoneAdrrList.add(jsonObject);

                }

            }
            cursor.close();
            if (phoneAdrrList.size() > 0) {
                // 이름순으로 정렬
                Collections.sort(phoneAdrrList, new Comparator<JSONObject>() {
                    @Override
                    public int compare(JSONObject obj1, JSONObject obj2) {
                        try {
                            String name1 = obj1.getString("name");
                            String name2 = obj2.getString("name");
                            return name1.compareTo(name2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
                txt.setText(phoneAdrrList.toString());
            }else{
                txt.setText("XXXXX");
            }
        } finally {

        }
    }
}
*/
