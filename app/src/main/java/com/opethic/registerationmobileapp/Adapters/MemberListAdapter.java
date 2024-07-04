package com.opethic.registerationmobileapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.opethic.registerationmobileapp.R;
import com.opethic.registerationmobileapp.Utils.Globals;


public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberListAdapterHolder> {
     Context context;

    public MutableLiveData<Integer> countQuantity = new MutableLiveData<>();

    public MemberListAdapter(Context context) {
        this.context = context;

    }



    @NonNull
    @Override
    public MemberListAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.registeration_row, parent, false);
        MemberListAdapterHolder viewHolder = new MemberListAdapterHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MemberListAdapterHolder holder, int position) {
        holder.bindOrder(position);
    }

    @Override
    public int getItemCount() {
        if (Globals.memberListModels != null)
            return Globals.memberListModels.size();
        return 0;
    }

    public class MemberListAdapterHolder extends RecyclerView.ViewHolder {

        RelativeLayout iv_details_delete;
        TextView memberNameTextView,mobileNoTextView,memberRoleTextView,subscriptionAmtTextView,tv_total_tv_deposit,tv_Lone;
        public MemberListAdapterHolder(@NonNull View itemView) {
            super(itemView);

             memberNameTextView = itemView.findViewById(R.id.tv_memberName);
             mobileNoTextView = itemView.findViewById(R.id.tv_mobileNo);
             memberRoleTextView = itemView.findViewById(R.id.tv_memberRole);
             subscriptionAmtTextView = itemView.findViewById(R.id.tv_subscriptionAmt);
            tv_total_tv_deposit = itemView.findViewById(R.id.tv_total_tv_deposit);
            tv_Lone = itemView.findViewById(R.id.tv_totalLone);


        }


        public void bindOrder(int position) {
            System.out.println("BinderPosition : " + position + "," + Globals.memberListModels.size());


            if (Globals.memberListModels.size() > 0) {

                memberNameTextView.setText("Member Name :"+Globals.memberListModels.get(position).getMemberName().toString());
                mobileNoTextView.setText("Mobile No. :"+Globals.memberListModels.get(position).getMobileNo().toString());
                memberRoleTextView.setText("Member Role :"+Globals.memberListModels.get(position).getMemberRole().toString());
                subscriptionAmtTextView.setText("Subscription Amt. :"+Globals.memberListModels.get(position).getSubscriptionAmt().toString());
                tv_Lone.setText(Globals.memberListModels.get(position).getLoanAmt().toString());
                tv_total_tv_deposit.setText(Globals.memberListModels.get(position).getDepositAmt().toString());


            }

           /* iv_details_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Globals.removeitem=position;
                 //   Globals.productList.setValue(position);
                    Globals.memberListModels.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, Globals.memberListModels.size());
                }
            });*/

        }


    }


}
