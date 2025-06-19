package com.example.projeto_refocus;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCadastro extends AppCompatActivity {

    private EditText etNome, etEmail, etSenha;
    private Button   btnCadastrar, btnVoltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome         = findViewById(R.id.etNome);
        etEmail        = findViewById(R.id.etEmailCadastro);
        etSenha        = findViewById(R.id.etSenhaCadastro);
        btnCadastrar   = findViewById(R.id.btnConfirmarCadastro);
        btnVoltarLogin = findViewById(R.id.btnVoltarLogin);

        // ► CONFIRMAR CADASTRO ◄
        btnCadastrar.setOnClickListener(v -> {
            String nome  = etNome.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString();

            if (TextUtils.isEmpty(nome))  { etNome.setError("Digite o nome");  return; }
            if (TextUtils.isEmpty(email)) { etEmail.setError("Digite o e‑mail"); return; }
            if (TextUtils.isEmpty(senha)) { etSenha.setError("Digite a senha"); return; }

            // Aqui você salvaria no banco / API
            Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

            // ► DIRETO PARA HOME ◄
            Intent intent = new Intent(this, ActivityHome.class);
            intent.putExtra("email", email);   // leva o e‑mail para saudação
            startActivity(intent);
            finish();                          // fecha Cadastro
        });

        // ► VOLTAR PARA LOGIN (sem cadastrar) ◄
        btnVoltarLogin.setOnClickListener(v -> finish());
    }
}
