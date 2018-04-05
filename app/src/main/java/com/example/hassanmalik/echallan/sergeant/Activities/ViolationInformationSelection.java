package com.example.hassanmalik.echallan.sergeant.Activities;
import android.media.session.PlaybackState;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.customListAdapterSel;
import com.example.hassanmalik.echallan.sergeant.Model.ListViewModel;
import java.util.ArrayList;
import java.util.List;

public class ViolationInformationSelection extends Fragment {
    //Default Fragments
    public ViolationInformationSelection(){
    }
    ListView list;
    List<ListViewModel> users = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_violation_information_selection, container, false);

        list = (ListView)rootView.findViewById(R.id.listView);

        users.add(new ListViewModel("speed limit","200"));
        users.add(new ListViewModel("speed limit","200"));

        final customListAdapterSel adapterSel = new customListAdapterSel(getActivity(),users);
        list.setAdapter(adapterSel);
        //On Item Listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewModel listViewModel = users.get(position);
                if(listViewModel.isSelected())
                    listViewModel.setSelected(false);
                else
                    listViewModel.setSelected(true);
                    users.set(position,listViewModel);
                    adapterSel.updateRecords(users);
            }
        });
   return rootView;
    }
}