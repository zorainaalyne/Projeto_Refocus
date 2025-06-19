package com.example.projeto_refocus;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "API_RESPONSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Requisição à API
        ApiService apiService = RetrofitClient.getApiService();

        apiService.getTarefas().enqueue(new Callback<List<Tarefa>>() {
            @Override
            public void onResponse(Call<List<Tarefa>> call, Response<List<Tarefa>> response) {
                if (response.isSuccessful()) {
                    List<Tarefa> tarefas = response.body();
                    for (Tarefa tarefa : tarefas) {
                        Log.d(TAG, "Tarefa: " + tarefa.getTitulo());
                    }
                } else {
                    Log.e(TAG, "Erro no response: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Tarefa>> call, Throwable t) {
                Log.e(TAG, "Falha na requisição: " + t.getMessage());
            }
        });
    }
}
