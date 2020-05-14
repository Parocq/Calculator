package com.german.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Pair> pairList;
    private Context context;

    public RecyclerViewAdapter(List<Pair> pairList, Context context) {
        this.pairList = pairList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.answer.setText(pairList.get(position).getAnswer());
        holder.expression.setText(pairList.get(position).getExp());

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView recentActions = v.findViewById(R.id.recentActions);
//                TextView answer = v.findViewById(R.id.answer);
//
//
//
//                Intent intent = new Intent(v.getContext(), MainActivity.class);
////                Bundle bundle = new Bundle();
////                bundle.putString("result",holder.answer.getText().toString());
////                bundle.putString("expression",holder.expression.getText().toString());
//                context.startActivity(intent);
//
//                recentActions.setText(""+holder.expression.getText().toString());
//                answer.setText(""+holder.answer.getText().toString());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return pairList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView answer, expression;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            answer = itemView.findViewById(R.id.historyAnswer);
            expression = itemView.findViewById(R.id.historyExpression);
            linearLayout = itemView.findViewById(R.id.itemOfList);
        }
    }
}
