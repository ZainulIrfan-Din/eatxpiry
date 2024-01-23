package com.example.eatxpiryinventory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class MainAdapter extends FirebaseRecyclerAdapter <MainModel,MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull MainModel model) {
    holder.FoodName.setText(model.getFoodName());
    holder.ExpiryDate.setText(model.getExpiryDate());
    holder.Location.setText(model.getLocation());

    holder.btnEdit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final DialogPlus dialogPlus = DialogPlus.newDialog(holder.itemView.getContext())
                    .setContentHolder(new ViewHolder(R.layout.update_popup))
                    .setExpanded(true,1200)
                    .create();


            //dialogPlus.show();

            View view = dialogPlus.getHolderView();

            EditText FoodName = view.findViewById(R.id.idTxtFoodName);
            EditText ExpiryDate = view.findViewById(R.id.idTxtExpDate);
            EditText Location = view.findViewById(R.id.idTxtLocation);

            Button btnUpdate = view.findViewById(R.id.idBtnUpdate);

            FoodName.setText(model.getFoodName());
            ExpiryDate.setText(model.getExpiryDate());
            Location.setText(model.getLocation());

            dialogPlus.show();

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Map<String,Object> map = new HashMap<>();
                    map.put("FoodName",FoodName.getText().toString());
                    map.put("ExpiryDate",ExpiryDate.getText().toString());
                    map.put("Location", Location.getText().toString());

                    FirebaseDatabase.getInstance().getReference().child("Inventory")
                            .child(getRef(position).getKey()).updateChildren(map)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(holder.FoodName.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                    dialogPlus.dismiss();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(Exception e) {
                                    Toast.makeText(holder.FoodName.getContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                                    dialogPlus.dismiss();
                                }
                            });
                }
            });


        }
    });


    holder.btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.FoodName.getContext());
            builder.setTitle("Are you sure want to delete");
            builder.setMessage("Deleted data can't be Undo");

            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                FirebaseDatabase.getInstance().getReference().child("Inventory")
                        .child(getRef(position).getKey()).removeValue();
                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(holder.FoodName.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
    });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder {

    TextView FoodName, ExpiryDate, Location;
    Button btnEdit,btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            FoodName = (TextView)itemView.findViewById(R.id.idfoodname);
            ExpiryDate = (TextView)itemView.findViewById(R.id.idexpirydate);
            Location=(TextView)itemView.findViewById(R.id.idlocation);

            btnEdit = (Button)itemView.findViewById(R.id.idBtnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.idBtnDelete);

        }
    }
}
