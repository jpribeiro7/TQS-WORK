package ua.pt.clienteexterno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Login extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButton;
    private EditText username;
    private EditText password;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mImageView = findViewById(R.id.image);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data missing", Toast.LENGTH_LONG).show();
                }else{
                    LoginPost login = new LoginPost();
                    try {
                        response = login.execute(new User(user,pass)).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                    if(response.equals("Welcome")){
                        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplicationContext().startActivity(intent);
                    }

                }


            }
        });

    }




}
