package vn.name.admin.appbansach.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

import vn.name.admin.appbansach.Interface.ItemClickListener;
import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.model.EventBus.SuaXoaEvent;
import vn.name.admin.appbansach.model.User;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<User> array;

    public UserAdapter(Context context, List<User> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(item);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserAdapter.MyViewHolder myViewHolder = (UserAdapter.MyViewHolder) holder;
        User user = array.get(position);
        myViewHolder.txtEmail.setText("email: "+user.getEmail());
        myViewHolder.txtPass.setText("pass: "+user.getPass());
        myViewHolder.txtUsername.setText("UserName: "+user.getUsername());
        myViewHolder.txtPhone.setText("SDT: "+user.getMobile());
        myViewHolder.setItemClickListener((view, pos, isLongClick) -> {
            if (isLongClick){
                EventBus.getDefault().postSticky(new SuaXoaEvent(user));
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, View.OnLongClickListener {
        TextView txtEmail, txtPass, txtUsername, txtPhone;
        private ItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmail = itemView.findViewById(R.id.itemu_mail);
            txtPass = itemView.findViewById(R.id.itemu_pass);
            txtUsername = itemView.findViewById(R.id.itemu_user);
            txtPhone = itemView.findViewById(R.id.itemu_nphone);
            itemView.setOnLongClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0,0,getAdapterPosition(),"Sửa");
            menu.add(0,0,getAdapterPosition(),"Xóa");
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return false;
        }
    }
}
