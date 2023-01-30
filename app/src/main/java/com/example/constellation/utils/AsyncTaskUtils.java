package com.example.constellation.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * @PackageName: com.example.constellation.utils
 * @ClassName: AsyncTaskUtils
 * @Author: winwa
 * @Date: 2023/1/29 8:34
 * @Description:
 **/
public class AsyncTaskUtils extends AsyncTask<String, Void, String> {
    private Context mContext;
    private OnReceiveDataListener mListener;
    private boolean mIsShowDialog;

    private ProgressDialog mDialog;

    public AsyncTaskUtils(Context context, OnReceiveDataListener listener, boolean isShowDialog) {
        mContext = context;
        mListener = listener;
        mIsShowDialog = isShowDialog;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (mIsShowDialog) {
            mDialog = new ProgressDialog(mContext);
            mDialog.setTitle("提示信息");
            mDialog.setMessage("加载中…………");
            mDialog.show();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = HttpUtils.getStringFromUrl(strings[0]);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (mIsShowDialog) {
            mDialog.dismiss();
        }

        if (mListener != null) {
            mListener.onSuccess(s);
        }
    }

    public interface OnReceiveDataListener {
        public void onSuccess(String result);
    }
}
