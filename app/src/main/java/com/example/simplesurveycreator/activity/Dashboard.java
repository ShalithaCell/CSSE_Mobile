package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.recyclerView.adapter.Model.dashboardAdapter;
import com.example.simplesurveycreator.recyclerView.adapter.Model.dashboardModel;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    RecyclerView recyclerView;
    dashboardAdapter dashboardAdapter;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerViewdashboard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dashboardAdapter = new dashboardAdapter(this, getList());
        recyclerView.setAdapter(dashboardAdapter);
    }

    private ArrayList<dashboardModel> getList(){
        ArrayList<dashboardModel> models = new ArrayList<>();

        dashboardModel m = new dashboardModel();
        m.setSurveyName("Survey 01");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 01");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 02");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 03");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 04");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 05");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);

        m = new dashboardModel();
        m.setSurveyName("Survey 06");
        m.setCreatedDate("date : 10.02.2020");
        m.setSubmissions("submissions : 10");
        m.setQuestions("Questions : 10");
        m.setPages("pages : 1");
        models.add(m);
        return models;
    }
}