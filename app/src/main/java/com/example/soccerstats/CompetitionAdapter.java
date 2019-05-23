package com.example.soccerstats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccerstats.model.Competition;
import java.util.List;

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder> {

  private final LayoutInflater mInflater;
  private List<Competition> mCompetitions; // Cached copy of words

  CompetitionAdapter(Context context) { mInflater = LayoutInflater.from(context); }

  @Override
  public CompetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = mInflater.inflate(R.layout.competition_item, parent, false);
    return new CompetitionViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(CompetitionViewHolder holder, int position) {
    if (mCompetitions != null) {
      Competition current = mCompetitions.get(position);
      holder.wordItemView.setText(current.getId());
    } else {
      // Covers the case of data not being ready yet.
      holder.wordItemView.setText("No Word");
    }
  }

  void setId(List<Competition> competitions){
    mCompetitions = competitions;
    notifyDataSetChanged();
  }

  // getItemCount() is called many times, and when it is first called,
  // mWords has not been updated (means initially, it's null, and we can't return null).
  @Override
  public int getItemCount() {
    if (mCompetitions != null)
      return mCompetitions.size();
    else return 0;
  }

  class CompetitionViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;

    private CompetitionViewHolder(View itemView) {
      super(itemView);
      wordItemView = itemView.findViewById(R.id.textView);
    }
  }
}