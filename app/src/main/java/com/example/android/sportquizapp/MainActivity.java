package com.example.android.sportquizapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup question1, question2, question3, question4, question5, question6, question7, question8, question9;
    private EditText customerNameEditText;
    private CheckBox question10a;
    private CheckBox question10b;
    private CheckBox question10c;
    private CheckBox question10d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
    }

    private void setupView() {
        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonPressed();
            }
        });

        question1 = (RadioGroup) findViewById(R.id.answer_to_question_1);
        question2 = (RadioGroup) findViewById(R.id.answer_to_question_2);
        question3 = (RadioGroup) findViewById(R.id.answer_to_question_3);
        question4 = (RadioGroup) findViewById(R.id.answer_to_question_4);
        question5 = (RadioGroup) findViewById(R.id.answer_to_question_5);
        question6 = (RadioGroup) findViewById(R.id.answer_to_question_6);
        question7 = (RadioGroup) findViewById(R.id.answer_to_question_7);
        question8 = (RadioGroup) findViewById(R.id.answer_to_question_8);
        question9 = (RadioGroup) findViewById(R.id.answer_to_question_9);
        question10a = (CheckBox) findViewById(R.id.answer_10a);
        question10b = (CheckBox) findViewById(R.id.answer_10b);
        question10c = (CheckBox) findViewById(R.id.answer_10c);
        question10d = (CheckBox) findViewById(R.id.answer_10d);
        customerNameEditText = (EditText) findViewById(R.id.answer_11);
    }

    private void submitButtonPressed() {
        int mResult = 0;
        if (question1.getCheckedRadioButtonId() == R.id.answer_1b) {
            mResult += 10;
        } else if (question1.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question2.getCheckedRadioButtonId() == R.id.answer_2b) {
            mResult += 10;
        } else if (question2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question3.getCheckedRadioButtonId() == R.id.answer_3a) {
            mResult += 10;
        } else if (question3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question4.getCheckedRadioButtonId() == R.id.answer_4b) {
            mResult += 10;
        } else if (question4.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question5.getCheckedRadioButtonId() == R.id.answer_5a) {
            mResult += 10;
        } else if (question5.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question6.getCheckedRadioButtonId() == R.id.answer_6c) {
            mResult += 10;
        } else if (question6.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question7.getCheckedRadioButtonId() == R.id.answer_7b) {
            mResult += 10;
        } else if (question7.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question8.getCheckedRadioButtonId() == R.id.answer_8a) {
            mResult += 10;
        } else if (question8.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        if (question9.getCheckedRadioButtonId() == R.id.answer_9c) {
            mResult += 10;
        } else if (question9.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }


        if (question10a.isChecked() == false && question10b.isChecked() == false &&
                question10c.isChecked() == false && question10d.isChecked() == false) {
            showError();
            return;
        }

        if (question10a.isChecked()) {
            mResult += 5;
        }
        if (question10d.isChecked()) {
            mResult += 5;
        }


        if (customerNameEditText.getText().toString().isEmpty()) {
            showError();
            return;
        }


        displayMessage(mResult);
    }

    void displayMessage(int score) {
        String userName = customerNameEditText.getText().toString();
        String message = "Dear " + userName + ",\nYour score is: " + String.valueOf(score) + " OVER 100";
        message += "\n" + quizResultMessage(score);

        new AlertDialog.Builder(this).setMessage(message).show();
    }

    String quizResultMessage(int score) {
        if (score <= 40) {
            return getString(R.string.result_0_40);
        } else if (score > 40 && score <= 60) {
            return getString(R.string.result_50_60);
        } else if (score > 60 && score <= 90) {
            return getString(R.string.result_70_90);
        } else {
            return getString(R.string.result_90_100);
        }
    }

    void showError() {
        // Show an error message as a toast
        Toast.makeText(this, "Please select answers to all questions.", Toast.LENGTH_SHORT).show();
    }
}
