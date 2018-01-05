package com.leiholmes.cleanarchdemo.ui;

import android.widget.TextView;
import android.widget.Toast;

import com.leiholmes.cleanarchdemo.R;
import com.leiholmes.cleanarchdemo.contract.MainContract;
import com.leiholmes.cleanarchdemo.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tv_show)
    TextView tvShow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initStateAndData() {
        mPresenter.getTitle();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(mContext, "" + toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTitle(String title) {
        tvShow.setText(title);
    }
}
