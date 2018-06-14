package com.qingjiao.sharedbicycle.utils;


import android.app.Notification;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

import java.util.logging.LogRecord;

/**
 * Created by QINGJIU on 2018/5/4.
 */

public class BlueToothTool {
    private BluetoothDevice device;
    private Handler mhandler;
    BluetoothSocket socket;
    static final int CONNECT_FAILED=1;
    static final int CONNECT_SUCCESS=5;
    static final int READ_FAILED=2;
    static final int WRITE_FAILED=3;
    static final int DATA=4;
    private boolean isConnect=false;

    public BlueToothTool(BluetoothDevice device,Handler handler){
        this.device=device;
        this.mhandler=handler;
    }
    /**
     *开辟连接线程任务
     */
    public void connect(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BluetoothSocket tmp = null;
                Method method;
                try {
                    method = device.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
                    tmp = (BluetoothSocket) method.invoke(device, 1);
                } catch (Exception e) {
                    setState(CONNECT_FAILED);
                    Log.e("TAG", e.toString());
                }
                socket = tmp;
                try {
                    socket.connect();
                    isConnect = true;
                    setState(CONNECT_SUCCESS);
                    Readtask  readtask = new Readtask();  //连接成功后开启读取数据的线程
                    readtask.start();
                } catch (Exception e) {
                    setState(CONNECT_FAILED);
                    Log.e("TAG", e.toString());
                }
            }
        });
        new Thread(thread).start();
    }
    /**
     *开辟线程读任务
     */
    public class Readtask extends Thread{
        @Override
        public void run(){
            byte[] buffer = new byte[1024];
            int bytes;
            InputStream inputStream ;   //建立输入流读取数据
            while (true) {
                try {
                    inputStream = socket.getInputStream();
                    if ((bytes = inputStream.read(buffer)) > 0) {
                        byte[] buf_data= new byte[bytes];
                        for (int i = 0; i < bytes; i++) {
                            buf_data[i] = buffer[i];
                        }
                        String s = new String(buf_data);
                        Message msg = mhandler.obtainMessage();
                        msg.what = DATA;
                        msg.obj = s;
                        mhandler.sendMessage(msg);
                    }
                } catch (IOException e) {
                    setState(READ_FAILED);
                    Log.e("TAG", e.toString());
                    break;
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    Log.e("TAG", e.toString());
                }
            }
        }
    }
    /**
     *开辟线程写任务
     */
    public  class WriteTask extends Thread{
        private String srt;
        public  WriteTask(String str){
            this.srt=str;
        }
        @Override
        public void run(){
            OutputStream outputStream=null;
            byte[] st=srt.getBytes();
            try{
                outputStream=socket.getOutputStream();
                outputStream.write(st);
            }catch (Exception e){
                setState(WRITE_FAILED);
                e.printStackTrace();
            }
        }

    }


    private void setState(int mes){
        Message message=new Message();
        message.what=mes;
        mhandler.sendMessage(message);

    }
    /**
     *下面这个方法目前还没有用到
     */
    private byte[] getHexBytes(String message) {
        int len = message.length() / 2;
        char[] chars = message.toCharArray();
        String[] hexStr = new String[len];
        byte[] bytes = new byte[len];
        for (int i = 0, j = 0; j < len; i += 2, j++) {
            hexStr[j] = "" + chars[i] + chars[i + 1];
            bytes[j] = (byte) Integer.parseInt(hexStr[j], 16);
        }
        return bytes;
    }

}