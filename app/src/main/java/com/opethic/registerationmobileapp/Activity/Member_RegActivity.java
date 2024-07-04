package com.opethic.registerationmobileapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.opethic.registerationmobileapp.Models.MemberListModel;
import com.opethic.registerationmobileapp.R;
import com.opethic.registerationmobileapp.Utils.Globals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Member_RegActivity extends AppCompatActivity {

    RadioGroup rgRole, rgGender, rgMaritalStatus;
    RadioButton rbSecretary, rbMember, rbMale, rbFemale, rbOther, rbMarried, rbUnmarried;
    int day, month, year, final_diff;
    AppCompatButton btn_submit;

    String dateFrom;
    EditText etMemberMobile,etMemberName,etSubscriptionFee,etDepositAmount,etLoanAmount,etDob,etDateOfJoining,etDateOfMarriage;

    MemberListModel memberListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_reg);
        memberListModel = new MemberListModel();


        rgRole = findViewById(R.id.rg_role);
        rbSecretary = findViewById(R.id.rb_secretary);
        rbMember = findViewById(R.id.rb_member);

        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        rbOther = findViewById(R.id.rb_other);

        rgMaritalStatus = findViewById(R.id.rg_marital_status);
        rbMarried = findViewById(R.id.rb_married);
        rbUnmarried = findViewById(R.id.rb_unmarried);

        btn_submit = findViewById(R.id.btn_submit);

        etMemberMobile = findViewById(R.id.et_member_mobile);
        etMemberName = findViewById(R.id.et_member_name);
        etSubscriptionFee = findViewById(R.id.et_subscription_fee);
        etDepositAmount = findViewById(R.id.et_deposit_amount);
        etLoanAmount = findViewById(R.id.et_loan_amount);
        etDob = findViewById(R.id.et_dob);
        etDateOfJoining = findViewById(R.id.et_date_of_joining);
        etDateOfMarriage = findViewById(R.id.et_date_of_marriage);


        rgRole.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String role = selectedRadioButton.getText().toString();
                Toast.makeText(Member_RegActivity.this, "Selected Role: " + role, Toast.LENGTH_SHORT).show();
                memberListModel.setMemberRole(role);

            }
        });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String gender = selectedRadioButton.getText().toString();
                Toast.makeText(Member_RegActivity.this, "Selected Gender: " + gender, Toast.LENGTH_SHORT).show();

            }
        });

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String maritalStatus = selectedRadioButton.getText().toString();
                Toast.makeText(Member_RegActivity.this, "Selected Marital Status: " + maritalStatus, Toast.LENGTH_SHORT).show();
            }
        });

        etDateOfJoining.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                day = calendar.get( Calendar.DAY_OF_MONTH );
                month = calendar.get( Calendar.MONTH );
                year = calendar.get( Calendar.YEAR );

                Log.d( "DAY:", day + "-" + month + "-" + year );
                DatePickerDialog datePickerDialog = new DatePickerDialog( Member_RegActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set( Calendar.DAY_OF_MONTH, dayOfMonth );
                        calendar.set( Calendar.MONTH, month );
                        calendar.set( Calendar.YEAR, year );
                        String date = new SimpleDateFormat( "dd-MMM-yyyy" ).format( calendar.getTimeInMillis() );
                        etDateOfJoining.setText( date );

                        SimpleDateFormat parseFormat = new SimpleDateFormat( "dd-MMM-yyyy" );
                        try {
                            Date date1 = parseFormat.parse( date );
                            dateFrom = new SimpleDateFormat( "yyyy-MM-dd" ).format( date1 );
                            // ShowToast( dateFrom );
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d( "Date Parse Error", "" + e );
                        }
                    }
                }, year, month, day );
                datePickerDialog.getDatePicker().setMinDate( System.currentTimeMillis() - 1000 );
                datePickerDialog.show();
            }
        } );

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                day = calendar.get( Calendar.DAY_OF_MONTH );
                month = calendar.get( Calendar.MONTH );
                year = calendar.get( Calendar.YEAR );

                Log.d( "DAY:", day + "-" + month + "-" + year );
                DatePickerDialog datePickerDialog = new DatePickerDialog( Member_RegActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set( Calendar.DAY_OF_MONTH, dayOfMonth );
                        calendar.set( Calendar.MONTH, month );
                        calendar.set( Calendar.YEAR, year );
                        String date = new SimpleDateFormat( "dd-MMM-yyyy" ).format( calendar.getTimeInMillis() );
                        etDob.setText( date );

                        SimpleDateFormat parseFormat = new SimpleDateFormat( "dd-MMM-yyyy" );
                        try {
                            Date date1 = parseFormat.parse( date );
                            dateFrom = new SimpleDateFormat( "yyyy-MM-dd" ).format( date1 );
                            // ShowToast( dateFrom );
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d( "Date Parse Error", "" + e );
                        }
                    }
                }, year, month, day );
                datePickerDialog.getDatePicker().setMinDate( System.currentTimeMillis() - 1000 );
                datePickerDialog.show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("btn_submit","btn_submit");
                if (etMemberName.getText().toString().isEmpty() ||
                        etMemberMobile.getText().toString().isEmpty() ||
                        etSubscriptionFee.getText().toString().isEmpty()) {
                    Toast.makeText(Member_RegActivity.this, "Please fill all required fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                memberListModel.setMemberName(etMemberName.getText().toString());
                memberListModel.setMobileNo(etMemberMobile.getText().toString());
                memberListModel.setSubscriptionAmt(etSubscriptionFee.getText().toString());
                memberListModel.setLoanAmt(etLoanAmount.getText().toString());
                memberListModel.setDepositAmt(etDepositAmount.getText().toString());
                Globals.memberListModels.add(memberListModel);

                Intent i = new Intent(Member_RegActivity.this, RegistrationDetailsActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}