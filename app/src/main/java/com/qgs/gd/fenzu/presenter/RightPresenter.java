package com.qgs.gd.fenzu.presenter;

import com.qgs.gd.fenzu.bean.LeftUser;
import com.qgs.gd.fenzu.model.RightModel;
import com.qgs.gd.fenzu.view.LeftView;

/**
 * date:2018/11/22    13:24
 * author:秦广帅(Lenovo)
 * fileName:RightPresenter
 */
public class RightPresenter {
    private LeftView mLeftView;
    private RightModel mRightModel;

    public RightPresenter(LeftView leftView) {
        mLeftView = leftView;
        mRightModel = new RightModel();
    }

    public void right(String url) {
        mRightModel.right(url, new RightModel.HttpCallBack() {
            @Override
            public void setData(String ss) {
                if (ss != null) {
                    mLeftView.onRightSuccess(ss);
                } else {
                    mLeftView.onFailer("失败");
                }
            }
        });
    }
}
