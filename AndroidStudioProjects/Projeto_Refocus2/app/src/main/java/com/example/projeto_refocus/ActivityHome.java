package com.example.projeto_refocus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHome extends AppCompatActivity {

    private TextView tvBoasVindas;
    private Button btnLogout, btnCadastrarNovamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvBoasVindas           = findViewById(R.id.tvBoasVindas);
        btnLogout              = findViewById(R.id.btnLogout);
        btnCadastrarNovamente  = findViewById(R.id.btnCadastrarNovamente);

        // Recebe o e‑mail da ActivityLogin
        String email = getIntent().getStringExtra("email");
        tvBoasVindas.setText("Bem‑vindo(a), " + email);

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, ActivityLogin.class));
            finish();
        });

        btnCadastrarNovamente.setOnClickListener(v ->
                startActivity(new Intent(this, ActivityCadastro.class)));
    }
}
