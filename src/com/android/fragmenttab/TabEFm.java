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
 * Time: 下午2:39
 */
public class TabEFm extends Fragment{
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("EEEEEEEEEEEE____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("EEEEEEEEEEEE____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("EEEEEEEEEEEE____onCreateView");
        return inflater.inflate(R.layout.tab_e, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("EEEEEEEEEEEE____onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("EEEEEEEEEEEE____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("EEEEEEEEEEEE____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("EEEEEEEEEEEE____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("EEEEEEEEEEEE____onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("EEEEEEEEEEEE____onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("EEEEEEEEEEEE____onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("EEEEEEEEEEEE____onDetach");
    }




}
