package com.example.projeto_refocus;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {

    private EditText etEmail, etSenha;
    private Button btnEntrar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail      = findViewById(R.id.etEmail);
        etSenha      = findViewById(R.id.etSenha);
        btnEntrar    = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnEntrar.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString();

            if (TextUtils.isEmpty(email))  { etEmail.setError("Digite o e‑mail"); return; }
            if (TextUtils.isEmpty(senha)) { etSenha.setError("Digite a senha");  return; }

            if (email.equals("admin@refocus.com") && senha.equals("123456")) {
                Intent i = new Intent(this, ActivityHome.class);
                i.putExtra("email", email);          // envia e‑mail para Home
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "E‑mail ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCadastrar.setOnClickListener(v ->
                startActivity(new Intent(this, ActivityCadastro.class)));
    }
}
