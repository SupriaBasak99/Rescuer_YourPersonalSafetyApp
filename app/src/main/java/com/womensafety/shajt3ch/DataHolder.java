package com.womensafety.shajt3ch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class DataHolder extends Fragment {
    private RecyclerView mRecyclerView;

    private ArrayList<Model> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;
   /* Configure configure=new Configure();*/
   private final String[] First_Aid={"First of all, calm down the situation ", "Bleeding heavily-Stop the bleeding using clean cloth & clean the wound by removing any dirt or debris" ,"Burns-Run cool Water, avoid sun exposure, apply antibiotic ointments" ,"A broken bone-Stop any bleeding, Clean, Immobilize the injured area, Apply ice pack" ,"Heart attack-Call 911, Chew & swallow an aspirin, take nitroglycerin if prescribed, begin cpr if the person is unconscious " ,"Stroke-Be Calm, Call 911, check breathing, keep the patient warm, don't give anything to eat or drink " ,"Seizures-Ease the person, turn the person onto one side to help in breathing, loosen clothes & accessories, Call 911 if the seizure lasts more than 5 minutes"
           ,"Diabetic emergency-Give something sweet to eat or drink, Reassure the person" ,"Asthma attack-Ask them to breathe slowly & deeply, advise one to take 2 puffs every two minutes up to 10 puffs. Call 911 in case of emergency"};
   private final String[] Self_Defence={"Walk and talk with confidence","Be aware of your environment and use your eye contact and voice","Use the element of surprise"};

    public static DataHolder getInstance(String title) {
        DataHolder fra = new DataHolder();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        initData();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerAdapter(mRecyclerView.getContext(), mDatas));

        return v;
    }

    private void initData() {
        mDatas = new ArrayList<>();
        if (mTitle.equals("First_Aid")) {
            for (int i = 0; i < First_Aid.length; i++) {

                mDatas.add(new Model(First_Aid[i]));
            }
        }

       else if (mTitle.equals("Self_defence")) {
            for (int i = 0; i < Self_Defence.length; i++) {

                mDatas.add(new Model(Self_Defence[i]));
            }
        }

    }
}

