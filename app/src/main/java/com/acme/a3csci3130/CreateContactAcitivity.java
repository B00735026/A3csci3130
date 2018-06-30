package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Users can create their initial personal information and upload into firebase
 */
public class CreateContactAcitivity extends Activity{

    private Button submitButton;
    private EditText nameField, emailField,bussiness_numField, addressField, primaryField,provinceField;
    private MyApplicationData appState;

    /**
     * Creating fields for user to pass input arguments
     * @param savedInstanceState saving all the input variables to specific fields
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);//password
        emailField = (EditText) findViewById(R.id.email);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        primaryField = (EditText) findViewById(R.id.primary_business);
        bussiness_numField = (EditText) findViewById(R.id.bussiness_num);

    }
    /**
     * Creating several string variables to store the input values
     * @param v the view of person's information such as id, name, email ,address, province, busines number, primary business
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        String bussinessnum = bussiness_numField.getText().toString();
        String primary = primaryField.getText().toString();
        //create a contact object to insert the information
        Contact person = new Contact(personID, name, email,bussinessnum,address,primary,province);
        appState.firebaseReference.child(personID).setValue(person);
        finish();

    }

}
