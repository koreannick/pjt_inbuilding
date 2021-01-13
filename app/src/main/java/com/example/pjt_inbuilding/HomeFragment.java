package com.example.pjt_inbuilding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.*;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public RecyclerAdapter_in adapter_in;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);


        View v = inflater.inflate(R.layout.item,container,false);

        // get our folding cell
        final FoldingCell fc = (FoldingCell)v.findViewById(R.id.folding_cell);
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                fc.toggle(true);
            }
        });


        ArrayList<Data_in> tt = new ArrayList<>();
        ArrayList<Data_in> tt2 = new ArrayList<>();

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_in);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter_in = new RecyclerAdapter_in(getContext(),tt,tt2);
        recyclerView.setAdapter(adapter_in);


        //imsi data
        Data_in ex_data = new Data_in();

        ex_data.setTxt_gu("은평구");
        ex_data.setTxt_date("21-01-10");
        ex_data.setTxt_sisul_name("수색이마트");
        ex_data.setTxt_sisulgun("대규모점포");
        ex_data.setTxt_danmal("S10");
        ex_data.setTxt_wi("1순위");

        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.addItem(ex_data);
        adapter_in.backupItem(ex_data);
        adapter_in.notifyDataSetChanged();


        adapter_in.setOnItemClickListener(new RecyclerAdapter_in.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final FoldingCell fc = (FoldingCell) v.findViewById(R.id.folding_cell);
                fc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fc.toggle(false);
                    }
                });
            }
        });




        return root;
    }


}
