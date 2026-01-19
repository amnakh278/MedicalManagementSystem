package ui.patient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicalmanagementsystem.R;
import data.entities.TreatmentEntity;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TreatmentAdapter extends RecyclerView.Adapter<TreatmentAdapter.TVH> {
    private final List<TreatmentEntity> treatments;
    private final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public TreatmentAdapter(List<TreatmentEntity> treatments) {
        this.treatments = treatments;
    }

    @NonNull
    @Override
    public TVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_treatment, parent, false);
        return new TVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TVH holder, int position) {
        TreatmentEntity t = treatments.get(position);
        holder.tvDisease.setText(t.getDisease());
        holder.tvPrescription.setText(t.getPrescription());
        holder.tvDate.setText(fmt.format(t.getDate()));
    }

    @Override
    public int getItemCount() {
        return treatments.size();
    }

    public static class TVH extends RecyclerView.ViewHolder {
        final TextView tvDisease;
        final TextView tvPrescription;
        final TextView tvDate;

        public TVH(@NonNull View itemView) {
            super(itemView);
            tvDisease      = itemView.findViewById(R.id.tvDisease);
            tvPrescription = itemView.findViewById(R.id.tvPrescription);
            tvDate         = itemView.findViewById(R.id.tvDate);
        }
    }
}

