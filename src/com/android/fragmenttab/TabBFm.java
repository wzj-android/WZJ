package com.android.fragmenttab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:wangjie@cyyun.com
 * Date: 13-6-14
 * Time: 涓嬪崍2:39
 */
public class TabBFm extends Fragment{//367271832
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("BBBBBBBBBBB____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("BBBBBBBBBBB____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("BBBBBBBBBBB____onCreateView");
        return inflater.inflate(R.layout.tab_b, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("BBBBBBBBBBB____onActivityCreated");
       /* this.getView().findViewById(R.id.clickme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 鑾峰緱缁戝畾鐨凢ragmentActivity
                MainActivity activity = ((MainActivity)getActivity());
                // 鑾峰緱TabAFm鐨勬帶浠�
                EditText editText = (EditText) activity.fragments.get(0).getView().findViewById(R.id.edit);

                Toast.makeText(activity, activity.hello + editText.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("BBBBBBBBBBB____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("BBBBBBBBBBB____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("BBBBBBBBBBB____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("BBBBBBBBBBB____onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("BBBBBBBBBBB____onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("BBBBBBBBBBB____onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("BBBBBBBBBBB____onDetach");
    }




}
