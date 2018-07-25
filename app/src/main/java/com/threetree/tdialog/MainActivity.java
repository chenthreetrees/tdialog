package com.threetree.tdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.threetree.ttdialog.LoadingDialog;
import com.threetree.ttdialog.MenuDialog;
import com.threetree.ttdialog.alertview.AlertView;
import com.threetree.ttdialog.alertview.OnItemClickListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.loading_tv).setOnClickListener(this);
        findViewById(R.id.menu_tv).setOnClickListener(this);
        findViewById(R.id.alert_tv).setOnClickListener(this);
        findViewById(R.id.alert_tv1).setOnClickListener(this);
        findViewById(R.id.alert_tv2).setOnClickListener(this);
        findViewById(R.id.alert_tv3).setOnClickListener(this);
        findViewById(R.id.alert_tv4).setOnClickListener(this);
        findViewById(R.id.alert_tv5).setOnClickListener(this);
        findViewById(R.id.alert_tv6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.loading_tv:
                showLoadingDialog();
                break;
            case R.id.menu_tv:
                showMenuDialog();
                break;
            case R.id.alert_tv:
                showAlertView();
                break;
            case R.id.alert_tv1:
                showAlertView1();
                break;
            case R.id.alert_tv2:
                showAlertView2();
                break;
            case R.id.alert_tv3:
                showAlertView3();
                break;
            case R.id.alert_tv4:
                showAlertView4();
                break;
            case R.id.alert_tv5:
                showAlertView5();
                break;
            case R.id.alert_tv6:
                showAlertView6();
                break;
        }
    }

    @Override
    public void onItemClick(Object o, int position)
    {
        Toast.makeText(this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    private void showLoadingDialog()
    {
        LoadingDialog.Builder loadBuilder=new LoadingDialog.Builder(this)
                .setMessage("加载中")
                .setCancelable(true)
                .setCancelOutside(true);
        LoadingDialog dialog=loadBuilder.create();
        dialog.show();
    }

    private void showMenuDialog()
    {
        MenuDialog dialog = new MenuDialog.Builder(this)
                .item("选项0")
                .item("选项1")
                .item("选项2")
                .listener(new MenuDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(int index)
                    {
                        Toast.makeText(MainActivity.this,"选项"+index + "被点击了",Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
        dialog.show();
    }

    private void showAlertView1()
    {
        new AlertView.Builder().setContext(this)
                .setTitle("标题")
                .setMessage("内容")
                .setCancelText(null)
                .setDestructive("确定")
                .setOthers(null)
                .setStyle(AlertView.Style.Alert)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView2()
    {
        new AlertView.Builder().setContext(this)
//                .setTitle("标题")
                .setMessage("内容")
                .setCancelText("取消")
                .setDestructive("取消", "确定")
                .setOthers(null)
                .setStyle(AlertView.Style.Alert)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView3()
    {
        new AlertView.Builder().setContext(this)
                .setTitle("标题")
                .setMessage("内容")
                .setCancelText("取消")
                .setDestructive("取消", "确定")
                .setOthers(null)
                .setStyle(AlertView.Style.Alert)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView4()
    {
        new AlertView.Builder().setContext(this)
//                .setTitle("标题")
//                .setMessage("内容")
//                .setCancelText("取消")
                .setDestructive("取消", "确定")
                .setOthers(new String[]{"其他按钮1", "其他按钮2", "其他按钮3"})
                .setStyle(AlertView.Style.Alert)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView5()
    {
        new AlertView.Builder().setContext(this)
                .setTitle("标题")
//                .setMessage("内容")
                .setCancelText("取消")
                .setDestructive("高亮", "确定")
                .setOthers(new String[]{"其他按钮1", "其他按钮2", "其他按钮3"})
                .setStyle(AlertView.Style.ActionSheet)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView6()
    {
        new AlertView.Builder().setContext(this)
                .setTitle("标题")
                .setMessage("内容")
                .setCancelText("取消")
//                .setDestructive(null)
                .setOthers(null)
                .setStyle(AlertView.Style.ActionSheet)
                .setOnItemClickListener(this)
                .build()
                .show();
    }

    private void showAlertView()
    {
        new AlertView.Builder().setContext(this)
                .setTitle("标题")
//                .setMessage("内容")
                .setCancelText("取消")
//                .setDestructive("取消", "确定")
                .setOthers(new String[]{"其他按钮1", "其他按钮2", "其他按钮3"})
                .setStyle(AlertView.Style.ActionSheet)
                .setOnItemClickListener(this)
                .build()
                .show();
    }
}
