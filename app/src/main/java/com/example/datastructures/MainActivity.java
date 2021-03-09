package com.example.datastructures;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText enterValue;
    Button push;
    Button pop;
    Button clear_stack;
    TextView stack1;
    TextView stack2;
    TextView stack3;
    TextView stack4;
    TextView stack5;
    TextView isEmpty;
    TextView size;
    TextView top;
    TextView errorMessage;
    TextView pop_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterValue = findViewById(R.id.enterValue);
        push = findViewById(R.id.push);
        pop = findViewById(R.id.pop);
        clear_stack = findViewById(R.id.clear_stack);
        stack1 = findViewById(R.id.stack1);
        stack2 = findViewById(R.id.stack2);
        stack3 = findViewById(R.id.stack3);
        stack4 = findViewById(R.id.stack4);
        stack5 = findViewById(R.id.stack5);
        isEmpty = findViewById(R.id.isEmpty);
        size = findViewById(R.id.size);
        top = findViewById(R.id.top);
        errorMessage = findViewById(R.id.errorMessage);
        pop_return = findViewById(R.id.pop_return);

        push.setOnClickListener(v -> {

            //Clears error message if it displays anything and last returned pop value
            errorMessage.setText("");
            pop_return.setText("");

            // Establish variables to store the value entered and the current size of the stack
            String input = enterValue.getText().toString();
            String currentSize = size.getText().toString();
            int count = Integer.parseInt(currentSize);


            // Check the user has input an appropriate value
            if(input.equals("")) {

                String prompt = "Please enter a value";
                errorMessage.setText(prompt);

                String count1 = String.valueOf(count);
                size.setText(count1); }

            else { // Check that the stack is full

                String text = stack5.getText().toString();
                if (!text.matches("")) {
                    String message = "The stack is full";
                    errorMessage.setText(message);

                    String finalCount = String.valueOf(count);
                    size.setText(finalCount); }

                else { // Update the stack

                    stack5.setText(stack4.getText());
                    stack4.setText(stack3.getText());
                    stack3.setText(stack2.getText());
                    stack2.setText(stack1.getText());
                    stack1.setText(input);

                    //Update the top
                    top.setText(input);

                    // Update is empty to false
                    String empty = "false";
                    isEmpty.setText(empty);

                    // Update the size
                    count ++;
                    String count2 = String.valueOf(count);
                    size.setText(count2); } }
        });

        pop.setOnClickListener(v -> {

            //Clears error message if it displays anything and last returned pop value
            errorMessage.setText("");
            pop_return.setText("");

            // Establish variables to store current value in top position and current size
            String value = stack1.getText().toString();
            String currentSize = (String) size.getText();
            int count = Integer.parseInt(currentSize);

            // Check the stack contains any values
            if (value.matches("")) {

                String message = "The stack is empty";
                errorMessage.setText(message); }

            else { //Update the stack

                stack1.setText(stack2.getText());
                stack2.setText(stack3.getText());
                stack3.setText(stack4.getText());
                stack4.setText(stack5.getText());
                stack5.setText("");

                //Update the top
                top.setText(stack1.getText());

                //Display the value popped
                pop_return.setText(value); }

            //Set isEmpty to true after popping last value
            if(count == 1){

                count --;
                String count1 = String.valueOf(count);
                size.setText(count1);

                String empty = "true";
                isEmpty.setText(empty); }

            else {
                //Stop the size counting negative values
                if (count == 0) {

                    String count2 = String.valueOf(count);
                    size.setText(count2); }

                else {
                    //Update the size
                    count --;
                    String count3 = String.valueOf(count);
                    size.setText(count3); }
            }
        });

        clear_stack.setOnClickListener( v -> {

            stack5.setText("");
            stack4.setText("");
            stack3.setText("");
            stack2.setText("");
            stack1.setText("");

            String empty = "true";
            isEmpty.setText(empty);

            String count = "0";
            size.setText(count);

            top.setText(stack1.getText());

            errorMessage.setText("");

            pop_return.setText("");
        });
    }

}

