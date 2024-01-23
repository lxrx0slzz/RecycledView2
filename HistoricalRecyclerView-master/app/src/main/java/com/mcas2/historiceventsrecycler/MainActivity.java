package com.mcas2.historiceventsrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<HistoricEventModel> historicEventModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.historicEventsRecycler);
        setHistoricEventModels();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(this, historicEventModels, selectedCurrency);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setHistoricEventModels() {
        String[] eventNames = getResources().getStringArray(R.array.event_name);
        String[] evenPrices = getResources().getStringArray(R.array.event_price);
        String[] eventImages = {
                R.drawable.ic_dolar,
                R.drawable.ic_rupia,
                R.drawable.ic_yuanes,
                R.drawable.ic_francos,


        }

        for (int i = 0; i < eventNames.length; i++) {
            historicEventModels.add(new HistoricEventModel(
                    eventNames[i],
                    eventDates[i],
                    eventLocations[i]
            ));
        }
    }
}