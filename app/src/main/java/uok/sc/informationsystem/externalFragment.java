package uok.sc.informationsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link externalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class externalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public externalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment externalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static externalFragment newInstance(String param1, String param2) {
        externalFragment fragment = new externalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        if(getActivity().getIntent()!=null){
            String courseName = getActivity().getIntent().getStringExtra("picName");
            int textID = getResources().getIdentifier(courseName,"raw",getActivity().getPackageName());
            String externalDetails = new Scanner(getResources().openRawResource(textID)).nextLine();
            TextView details = getActivity().findViewById(R.id.external_details);
            details.setText(externalDetails);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_external, container, false);
    }
}