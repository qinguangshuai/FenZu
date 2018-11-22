package com.qgs.gd.fenzu.presenter;

import com.qgs.gd.fenzu.model.LeftModel;
import com.qgs.gd.fenzu.view.LeftView;

/**
 * date:2018/11/22    11:13
 * author:秦广帅(Lenovo)
 * fileName:LeftPresenter
 */
public class LeftPresenter {
    private LeftView mLeftView;
    private LeftModel mLeftModel;

    public LeftPresenter(LeftView leftView) {
        mLeftView = leftView;
        mLeftModel = new LeftModel();
    }

    public void left(String url){
        mLeftModel.left(url, new LeftModel.HttpCallBack() {
            @Override
            public void getData(String s) {
                if(s!=null){
                    mLeftView.onSuccess(s);
                }else{
                    mLeftView.onFailer("失败");
                }
            }
        });
    }
}
