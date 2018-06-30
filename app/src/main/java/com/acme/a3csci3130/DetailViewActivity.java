package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import android.app.ProgressDialog;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseListAdapter;

/**
 * Shows the information of each user.
 * User can modify and delete the personal information
 */
public class DetailViewActivity extends Activity {
    private EditText nameField, emailField,bussiness_numField, addressField, primaryField,provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    /**
     * Storing all information in the object receivedPersonInfo
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        primaryField = (EditText) findViewById(R.id.primary_business);
        bussiness_numField = (EditText) findViewById(R.id.bussiness_num);
        appState =(MyApplicationData)getApplicationContext();
       // If current field contains information,then store these information into object receivedPersonInfo
       if(receivedPersonInfo != null){
           nameField.setText(receivedPersonInfo.name);
           emailField.setText(receivedPersonInfo.email);
           addressField.setText(receivedPersonInfo.address);
           provinceField.setText(receivedPersonInfo.province);
           primaryField.setText(receivedPersonInfo.primary_business);
           bussiness_numField.setText(receivedPersonInfo.bussiness_num);
       }
    }

    /**
     * Creates a method called updateInfo that update new information for each user
     */
    public void updateInfo(){
        String personID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        String bussinessnum = bussiness_numField.getText().toString();
        String primary = primaryField.getText().toString();
        //update new information to firebase
        Contact person = new Contact(personID, name, email,bussinessnum,address,primary,province);
        appState.firebaseReference.child(personID).setValue(person);
        }
    /**
     * Creates a method call updateInfo that delete user's information
     */
    public void deleteData(){
    String personID = receivedPersonInfo.uid;
        appState.firebaseReference.child(personID).removeValue();
   // personID.removeValue();
    }

    /**
     *  Executing the updateInfo method.
     *  The interface will turn to the create interface, if  user update information Successfully,
     * @param v A button once users click on it then they can update the new information
     */
    public void updateContact(View v){
        //TODO: Update contact funcionality
       updateInfo();
       Intent intent=new Intent(this, MainActivity.class);
       startActivity(intent);
    }

    /**
     * Executing the delete method.
     * The interface will turn to the create interface, if  user update information Successfully,
     * @param v A button once users click on it then they can delete information
     */
    public void eraseContact(View v)
    {
        deleteData();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        //TODO: Erase contact functionality
    }
}
