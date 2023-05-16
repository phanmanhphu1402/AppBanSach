package vn.name.admin.appbansach.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import vn.name.admin.appbansach.Interface.ItemClickListener;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.activity.ChatActivity;
import vn.name.admin.appbansach.model.User;

public class UserChatAdapter extends RecyclerView.Adapter<UserChatAdapter.MyViewHolder> {
    Context context;
    List<User> userList;

    public UserChatAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.txtid.setText(user.getId()+ "");
        holder.txtuser.setText(user.getUsername());
        holder.setItemClickListener((view, pos, isLongClick) -> {
            if (!isLongClick){
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("id",user.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView txtid, txtuser;
        ItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtid = itemView.findViewById(R.id.iduserchat);
            txtuser = itemView.findViewById(R.id.username);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(),false);
            return false;
        }
    }
}
