package vn.name.admin.appbansach.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import vn.name.admin.appbansach.R;
import vn.name.admin.appbansach.adapter.UserChatAdapter;
import vn.name.admin.appbansach.model.User;

public class QLChatActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    UserChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlchat);
        initView();
        initControl();
        ActionToolBar();
        getUserFromFire();
    }

    private void getUserFromFire() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            List<User> userList = new ArrayList<>();
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                User user = new User();
                                user.setId(documentSnapshot.getLong("id").intValue());
                                user.setUsername(documentSnapshot.getString("username"));
                                userList.add(user);
                            }
                            if (userList.size()>0){
                                adapter = new UserChatAdapter(getApplicationContext(),userList);
                                recyclerView.setAdapter(adapter);
                            }
                        }
                    }
                });
    }

    private void initControl() {
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarchat);
        recyclerView = findViewById(R.id.recycler_chat);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());
    }
}