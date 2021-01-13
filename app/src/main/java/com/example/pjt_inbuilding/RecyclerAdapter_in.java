package com.example.pjt_inbuilding;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;

public class RecyclerAdapter_in extends RecyclerView.Adapter<RecyclerAdapter_in.ItemViewHolder> implements Filterable {



    private OnItemClickListener mListener = null ;

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;


    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }


    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    // adapter에 들어갈 list 입니다.
    Context context;
    private ArrayList<Data_in> listData;
    private ArrayList<Data_in> listData_backup;
    private ArrayList<Data_in> listData_filter;


    public RecyclerAdapter_in(Context context, ArrayList<Data_in> list, ArrayList<Data_in> list2) {
        super();
        this.context = context;
        this.listData = list;
        this.listData_backup=list2;
        this.listData_filter = list;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData_filter.size();
    }

    void recover(){
//        listData_filter.add(listData_backup);
        Log.e("backed data",listData_backup.toString());

//        System.arraycopy(listData_backup, 0, listData, 0, listData_backup.size());
//        System.arraycopy(listData_backup, 0, listData_filter, 0, listData_backup.size());
        listData.clear();
        listData.addAll(listData_backup);
        //istData_backup.addAll(listData_backup);

        Log.e("recover",listData.toString());
        Log.e("recover2",listData_filter.toString());
        notifyDataSetChanged();
    }

    void clear(){
        listData.clear();
        listData_filter.clear();

    }
    void addItem(Data_in data_in){
        // 외부에서 item을 추가시킬 함수입니다.
        listData_filter.add(data_in);

    }
    void backupItem(Data_in data_in){
        // 외부에서 item을 추가시킬 함수입니다.
        listData_backup.add(data_in);
        //Log.e("firstbackup",listData_backup.toString());

    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_gu;
        private TextView txt_date;
        private TextView txt_sisul_name;
        private TextView txt_sisulgun;
        private TextView txt_danmal;
        private TextView txt_wi;



        ItemViewHolder(View itemView) {
            super(itemView);

            txt_gu = itemView.findViewById(R.id.txt_gu);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_sisul_name = itemView.findViewById(R.id.txt_sisul_name);
            txt_sisulgun = itemView.findViewById(R.id.txt_sisul_gun);
            txt_danmal = itemView.findViewById(R.id.txt_danmal);
            txt_wi = itemView.findViewById(R.id.txt_wi);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION){
                        if(mListener !=null){
                            mListener.onItemClick(v,position);
                        }
                    }

                }
            });

        }

        void onBind(Data_in data_in) {
//            textView1.setText(data.getTitle());
//            textView2.setText(data.getContent());
//            imageView.setImageResource(data.getResId());
            txt_gu.setText(data_in.getTxt_gu());
            txt_date.setText(data_in.getTxt_date());
            txt_sisul_name.setText(data_in.getTxt_sisul_name());
            txt_sisulgun.setText(data_in.getTxt_sisulgun());
            txt_danmal.setText(data_in.getTxt_danmal());
            txt_wi.setText(data_in.getTxt_wi());
        }
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constrant) {
            ArrayList<Data_in> filteredList = new ArrayList<>();

            if(constrant == null || constrant.length() == 0) {
                filteredList =listData;
                Log.e("0일때",listData.toString());
                Log.e("0일때2",listData_filter.toString());
                filteredList.addAll(filteredList);
            } else {
                //filteredList =listData_backup;
                //filteredList.addAll(filteredList);
                String filterPattern = constrant.toString().toLowerCase().trim();
//
//                for (Data_in item : listData_filter) {
//                    if(nrpci.chk_search_nr == 0){
//
//                        if (item.getNr_Title().toLowerCase().contains(filterPattern)) {
//                            filteredList.add(item);
//                        }
//                    }else if(nrpci.chk_search_nr == 1){
//
//                        if (item.gettxt_nrpci().toLowerCase().contains(filterPattern)) {
//                            if(constrant.length() == item.gettxt_nrpci().length()){
//                                filteredList.add(item);
//                            }
//                        }
//                    }
//
//                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            Log.e("데이터조회",filteredList.toString());
//            filteredList = listData_backup;
            Log.e("ㄷㅔ이터백업",filteredList.toString());

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listData_filter.clear();
            listData_filter.addAll((ArrayList) results.values);
            notifyDataSetChanged();
            Log.e("필터완료","OO");
        }

    };



    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

}
