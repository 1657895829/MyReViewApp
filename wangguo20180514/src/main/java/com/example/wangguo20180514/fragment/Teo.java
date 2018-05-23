package com.example.wangguo20180514.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangguo20180514.R;
import com.example.wangguo20180514.adapter.MyAdapter;
import com.example.wangguo20180514.bean.User;
import com.example.wangguo20180514.presenter.UserPresenter;
import com.example.wangguo20180514.view.UserView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2018/5/14.
 */

public class Teo extends Fragment implements UserView{
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private UserPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.two, null);
        unbinder = ButterKnife.bind(this, view);
        presenter=new UserPresenter((UserView) this);
        presenter.attach();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detach();
    }

    @Override
    public void success(User user) {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        MyAdapter adapter=new MyAdapter(getActivity(),user);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
