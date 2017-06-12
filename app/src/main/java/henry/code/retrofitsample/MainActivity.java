package henry.code.retrofitsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import henry.code.retrofitsample.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String HOST_URL = "https://api.openaq.org/";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(HOST_URL)
                .build();

        binding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAirQualityService weatherService = retrofit.create(OpenAirQualityService.class);
                Call<Response> calLResult = weatherService.fetchData();
                calLResult.enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        binding.content.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        binding.content.setText(t.getMessage());
                    }
                });
            }
        });

    }

    private interface OpenAirQualityService {

        @GET("v1/countries")
        Call<Response> fetchData();
    }
}
