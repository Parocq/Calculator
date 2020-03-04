//package com.german.calculator.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.german.calculator.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
//
//    private List<String> historyList = new ArrayList<>();
//
//    class HistoryViewHolder extends RecyclerView.ViewHolder{
//
//        private TextView textView;
//
//        public HistoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.answer);
//        }
//
//        public void bind(List<String> list){
//            textView.setText(list.get(i));
//        }
//    }
//
//    @NonNull
//    @Override
//    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_history, parent, false);
//        return new HistoryViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position, @NonNull List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
//    }
//
//    @Override
//    public int getItemCount() {
//        return historyList.size();
//    }
//}
