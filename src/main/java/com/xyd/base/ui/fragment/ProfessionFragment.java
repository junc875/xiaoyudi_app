package com.xyd.base.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.xyd.R;
import com.xyd.base.BaseFragment;

/**
 * Created by Administrator on 2016/7/22.
 */
public class ProfessionFragment extends BaseFragment implements View.OnClickListener{
    private String[] infoStr = new String[] {
            "公司名称", "省份", "单位地址", "公司电话", "职业", "薪资范围"
    };
    private Button nextButton,preButton;
    private FragmentManager fragmentManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profession_fragment, null);
        ListView infoList = (ListView) view.findViewById(R.id.listview);
        infoList.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, infoStr));
        preButton = (Button)view.findViewById(R.id.pre);
        preButton.setOnClickListener(this);
        nextButton = (Button)view.findViewById(R.id.next);
        nextButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        PersonFragment fragment;
        RadioButton personRadio =  (RadioButton)getActivity().findViewById(R.id.person_radio);
        RadioButton professionRadio =  (RadioButton)getActivity().findViewById(R.id.profession_radio);
        RadioButton relationshipRadio =  (RadioButton)getActivity().findViewById(R.id.relationship_radio);
        switch (v.getId()) {
            case R.id.pre:
                personRadio.setTextColor(getResources().getColor(R.color.green));
                professionRadio.setTextColor(getResources().getColor(R.color.black));
                relationshipRadio.setTextColor(getResources().getColor(R.color.black));
                personRadio.setTextColor(getResources().getColor(R.color.green));
                fragment = new PersonFragment();
                transaction.replace(R.id.idcard_content, fragment);
                transaction.commit();
                break;
            case R.id.next:
                personRadio.setTextColor(getResources().getColor(R.color.black));
                professionRadio.setTextColor(getResources().getColor(R.color.black));
                relationshipRadio.setTextColor(getResources().getColor(R.color.green));
                fragment = new RelationShipFragment();
                transaction.replace(R.id.idcard_content, fragment);
                transaction.commit();
                break;
        }
    }
}
