package com.example.projeto_refocus;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @GET("api/tarefas")
    Call<List<Tarefa>> getTarefas();

    @GET("api/tarefas/{id}")
    Call<Tarefa> getTarefaById(@Path("id") Long id);

    @POST("api/tarefas")
    Call<Tarefa> createTarefa(@Body Tarefa tarefa);

    @PUT("api/tarefas/{id}")
    Call<Tarefa> updateTarefa(@Path("id") Long id, @Body Tarefa tarefa);

    @DELETE("api/tarefas/{id}")
    Call<Void> deleteTarefa(@Path("id") Long id);
}

