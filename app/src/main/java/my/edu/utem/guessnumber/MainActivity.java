package my.edu.utem.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText guessNum;
    Button flagCheck, flagReset;
    int ranNum, guessNo;
    int totTry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessNum = findViewById(R.id.txtGuessNum);
        flagReset = findViewById(R.id.btnReset);
        flagCheck = findViewById(R.id.btnChkGuessNum);
        flagCheck.setVisibility(View.VISIBLE);
        flagReset.setVisibility(View.INVISIBLE);
        ranNum = (int)(Math.random() * 100);
    }

    public void chkGuessNum(View view) {
        if (guessNum.getText().toString().equals(""))
            Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
        else {
            totTry++;
            if (totTry <= 3) {
                guessNo = Integer.parseInt(guessNum.getText().toString());
                if (guessNo < ranNum) //check for low number
                    Toast.makeText(MainActivity.this, "The number is too low", Toast.LENGTH_LONG).show();
                if (guessNo > ranNum) //check for big number
                    Toast.makeText(MainActivity.this, "The number is too big", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Game over.. the number is", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, ranNum + "", Toast.LENGTH_LONG).show();
                flagCheck.setVisibility(View.INVISIBLE);
                flagReset.setVisibility(View.VISIBLE);
            }
        }
        }

    public void btnReset(View view) {
        flagCheck.setVisibility(View.VISIBLE);
        flagReset.setVisibility(View.INVISIBLE);
        guessNum.setText("");
    }
}

