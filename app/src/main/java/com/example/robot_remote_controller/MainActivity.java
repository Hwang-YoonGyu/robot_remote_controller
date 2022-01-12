package com.example.robot_remote_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {
    private MqttAndroidClient mqttAndroidClient;

    private Button go_btn1, go_btn2, go_btn3, go_btn4, go_btn5, go_btn6, go_btn7,go_btn8, go_btn9;
    private Button fgo_btn1, fgo_btn2, fgo_btn3, fgo_btn4, fgo_btn5, fgo_btn6, fgo_btn7, fgo_btn8, fgo_btn9;
    private Button back_btn1, back_btn2, back_btn3, back_btn4, back_btn5, back_btn6, back_btn7, back_btn8, back_btn9;
    private Button fback_btn1, fback_btn2, fback_btn3, fback_btn4, fback_btn5, fback_btn6, fback_btn7, fback_btn8, fback_btn9;
    private Button left_btn1, left_btn2, left_btn3, left_btn4, left_btn5, left_btn6, left_btn7, left_btn8, left_btn9;
    private Button right_btn1, right_btn2, right_btn3, right_btn4, right_btn5, right_btn6, right_btn7, right_btn8, right_btn9;
    private Button stop_btn1, fstop_btn;
    private Button rightspin_btn1, rightspin_btn2, rightspin_btn3, leftspin_btn1, leftspin_btn2, leftspin_btn3;
    private Button mode1, mode2, mode3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_btn1 = (Button)findViewById(R.id.go_btn1);
        go_btn2 = (Button)findViewById(R.id.go_btn2);
        go_btn3 = (Button)findViewById(R.id.go_btn3);
        go_btn4 = (Button)findViewById(R.id.go_btn4);
        go_btn5 = (Button)findViewById(R.id.go_btn5);
        go_btn6 = (Button)findViewById(R.id.go_btn6);
        go_btn7 = (Button)findViewById(R.id.go_btn7);
        go_btn8 = (Button)findViewById(R.id.go_btn8);
        go_btn9 = (Button)findViewById(R.id.go_btn9);

        fgo_btn1 = (Button)findViewById(R.id.fgo_btn1);
        fgo_btn2 = (Button)findViewById(R.id.fgo_btn2);
        fgo_btn3 = (Button)findViewById(R.id.fgo_btn3);
        fgo_btn4 = (Button)findViewById(R.id.fgo_btn4);
        fgo_btn5 = (Button)findViewById(R.id.fgo_btn5);
        fgo_btn6 = (Button)findViewById(R.id.fgo_btn6);
        fgo_btn7 = (Button)findViewById(R.id.fgo_btn7);
        fgo_btn8 = (Button)findViewById(R.id.fgo_btn8);
        fgo_btn9 = (Button)findViewById(R.id.fgo_btn9);

        back_btn1 = (Button)findViewById(R.id.back_btn1);
        back_btn2 = (Button)findViewById(R.id.back_btn2);
        back_btn3 = (Button)findViewById(R.id.back_btn3);
        back_btn4 = (Button)findViewById(R.id.back_btn4);
        back_btn5 = (Button)findViewById(R.id.back_btn5);
        back_btn6 = (Button)findViewById(R.id.back_btn6);
        back_btn7 = (Button)findViewById(R.id.back_btn7);
        back_btn8 = (Button)findViewById(R.id.back_btn8);
        back_btn9 = (Button)findViewById(R.id.back_btn9);

        fback_btn1 = (Button)findViewById(R.id.fback_btn1);
        fback_btn2 = (Button)findViewById(R.id.fback_btn2);
        fback_btn3 = (Button)findViewById(R.id.fback_btn3);
        fback_btn4 = (Button)findViewById(R.id.fback_btn4);
        fback_btn5 = (Button)findViewById(R.id.fback_btn5);
        fback_btn6 = (Button)findViewById(R.id.fback_btn6);
        fback_btn7 = (Button)findViewById(R.id.fback_btn7);
        fback_btn8 = (Button)findViewById(R.id.fback_btn8);
        fback_btn9 = (Button)findViewById(R.id.fback_btn9);

        left_btn1 = (Button)findViewById(R.id.left_btn1);
        left_btn2 = (Button)findViewById(R.id.left_btn2);
        left_btn3 = (Button)findViewById(R.id.left_btn3);
        left_btn4 = (Button)findViewById(R.id.left_btn4);
        left_btn5 = (Button)findViewById(R.id.left_btn5);
        left_btn6 = (Button)findViewById(R.id.left_btn6);
        left_btn7 = (Button)findViewById(R.id.left_btn7);
        left_btn8 = (Button)findViewById(R.id.left_btn8);
        left_btn9 = (Button)findViewById(R.id.left_btn9);

        right_btn1 = (Button)findViewById(R.id.right_btn1);
        right_btn2 = (Button)findViewById(R.id.right_btn2);
        right_btn3 = (Button)findViewById(R.id.right_btn3);
        right_btn4 = (Button)findViewById(R.id.right_btn4);
        right_btn5 = (Button)findViewById(R.id.right_btn5);
        right_btn6 = (Button)findViewById(R.id.right_btn6);
        right_btn7 = (Button)findViewById(R.id.right_btn7);
        right_btn8 = (Button)findViewById(R.id.right_btn8);
        right_btn9 = (Button)findViewById(R.id.right_btn9);

        stop_btn1 = (Button)findViewById(R.id.stop_btn1);
        fstop_btn = (Button)findViewById(R.id.fstop_btn);

        rightspin_btn1 = (Button)findViewById(R.id.rightspin_btn1);
        rightspin_btn2 = (Button)findViewById(R.id.rightspin_btn2);
        rightspin_btn3 = (Button)findViewById(R.id.rightspin_btn3);
        leftspin_btn1 = (Button)findViewById(R.id.leftspin_btn1);
        leftspin_btn2 = (Button)findViewById(R.id.leftspin_btn2);
        leftspin_btn3 = (Button)findViewById(R.id.leftspin_btn3);
        mode1 = (Button)findViewById(R.id.mode1);
        mode2 = (Button)findViewById(R.id.mode2);
        mode3 = (Button)findViewById(R.id.mode3);

        mqttAndroidClient = new MqttAndroidClient(this, "tcp://" + "192.168.12.102" + ":1883", MqttClient.generateClientId());
        //"tcp://" + "113.198.48.4" + ":80", MqttClient.generateClientId());

        // 2번째 파라메터 : 브로커의 ip 주소 , 3번째 파라메터 : client 의 id를 지정함 여기서는 paho 의 자동으로 id를 만들어주는것

        try {
            IMqttToken token = mqttAndroidClient.connect(getMqttConnectionOption());    //mqtttoken 이라는것을 만들어 connect option을 달아줌
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {

                    mqttAndroidClient.setBufferOpts(getDisconnectedBufferOptions());    //연결에 성공한경우
                    Log.e("Connect_success", "Success");
                    Toast.makeText(getApplicationContext(), "CONNECT SUCCESS", Toast.LENGTH_LONG).show();


                    try {

                        mqttAndroidClient.subscribe("android", 0);   //연결에 성공하면 kitae 라는 토픽으로 subscribe함
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {   //연결에 실패한경우
                    Log.e("connect_fail", "Failure " + exception.toString());
                    Toast.makeText(getApplicationContext(), "CONNECT FAIL", Toast.LENGTH_LONG).show();

                }
            });

        } catch (MqttException e) {
            e.printStackTrace();
        }

        go_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go1");
                    mqttAndroidClient.publish("drive", "go1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go2");
                    mqttAndroidClient.publish("drive", "go2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go3");
                    mqttAndroidClient.publish("drive", "go3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go4");
                    mqttAndroidClient.publish("drive", "go4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go5");
                    mqttAndroidClient.publish("drive", "go5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go6");
                    mqttAndroidClient.publish("drive", "go6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go7");
                    mqttAndroidClient.publish("drive", "go7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go8");
                    mqttAndroidClient.publish("drive", "go8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        go_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "go9");
                    mqttAndroidClient.publish("drive", "go9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        fgo_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo1");
                    mqttAndroidClient.publish("drive", "fgo1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo2");
                    mqttAndroidClient.publish("drive", "fgo2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo3");
                    mqttAndroidClient.publish("drive", "fgo3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo4");
                    mqttAndroidClient.publish("drive", "fgo4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo5");
                    mqttAndroidClient.publish("drive", "fgo5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo6");
                    mqttAndroidClient.publish("drive", "fgo6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo7");
                    mqttAndroidClient.publish("drive", "fgo7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo8");
                    mqttAndroidClient.publish("drive", "fgo8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fgo_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fgo9");
                    mqttAndroidClient.publish("drive", "fgo9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        back_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back1");
                    mqttAndroidClient.publish("drive", "back1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back2");
                    mqttAndroidClient.publish("drive", "back2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back3");
                    mqttAndroidClient.publish("drive", "back3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back4");
                    mqttAndroidClient.publish("drive", "back4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back5");
                    mqttAndroidClient.publish("drive", "back5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back6");
                    mqttAndroidClient.publish("drive", "back6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back7");
                    mqttAndroidClient.publish("drive", "back7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back8");
                    mqttAndroidClient.publish("drive", "back8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        back_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "back9");
                    mqttAndroidClient.publish("drive", "back9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        fback_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback1");
                    mqttAndroidClient.publish("drive", "fback1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback2");
                    mqttAndroidClient.publish("drive", "fback2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback3");
                    mqttAndroidClient.publish("drive", "fback3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback4");
                    mqttAndroidClient.publish("drive", "fback4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback5");
                    mqttAndroidClient.publish("drive", "fback5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback6");
                    mqttAndroidClient.publish("drive", "fback6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback7");
                    mqttAndroidClient.publish("drive", "fback7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback8");
                    mqttAndroidClient.publish("drive", "fback8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        fback_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fback9");
                    mqttAndroidClient.publish("drive", "fback9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        left_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left1");
                    mqttAndroidClient.publish("drive", "left1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left2");
                    mqttAndroidClient.publish("drive", "left2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left3");
                    mqttAndroidClient.publish("drive", "left3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left4");
                    mqttAndroidClient.publish("drive", "left4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left5");
                    mqttAndroidClient.publish("drive", "left5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left6");
                    mqttAndroidClient.publish("drive", "left6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left7");
                    mqttAndroidClient.publish("drive", "left7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left8");
                    mqttAndroidClient.publish("drive", "left8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        left_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "left9");
                    mqttAndroidClient.publish("drive", "left9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        right_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right1");
                    mqttAndroidClient.publish("drive", "right1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right2");
                    mqttAndroidClient.publish("drive", "right2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right3");
                    mqttAndroidClient.publish("drive", "right3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right4");
                    mqttAndroidClient.publish("drive", "right4".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right5");
                    mqttAndroidClient.publish("drive", "right5".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right6");
                    mqttAndroidClient.publish("drive", "right6".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right7");
                    mqttAndroidClient.publish("drive", "right7".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right8");
                    mqttAndroidClient.publish("drive", "right8".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });
        right_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "right9");
                    mqttAndroidClient.publish("drive", "right9".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        stop_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "stop1");
                    mqttAndroidClient.publish("drive", "stop1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }}
        });

        fstop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "fstop");
                    mqttAndroidClient.publish("drive", "fstop".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        rightspin_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "rightspin1");
                    mqttAndroidClient.publish("drive", "rightspin1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        rightspin_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "rightspin2");
                    mqttAndroidClient.publish("drive", "rightspin2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        rightspin_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "rightspin3");
                    mqttAndroidClient.publish("drive", "rightspin3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        leftspin_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "leftspin1");
                    mqttAndroidClient.publish("drive", "leftspin1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        leftspin_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "leftspin2");
                    mqttAndroidClient.publish("drive", "leftspin2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        leftspin_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "leftspin3");
                    mqttAndroidClient.publish("drive", "leftspin3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        mode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "mode1");
                    mqttAndroidClient.publish("mode", "mode1".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        mode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "mode2");
                    mqttAndroidClient.publish("mode", "mode2".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
        mode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Log.e("button_press", "mode3");
                    mqttAndroidClient.publish("mode", "mode3".getBytes(), 0, false);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });

        mqttAndroidClient.setCallback(new MqttCallback() {  //클라이언트의 콜백을 처리하는부분
            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {   //모든 메시지가 올때 Callback method
                if (topic.equals("drive")) {     //topic 별로 분기처리하여 작업을 수행할수도있음
                    String msg = new String(message.getPayload());
                    Log.e("arrive message : ", msg);
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }

    private DisconnectedBufferOptions getDisconnectedBufferOptions() {

        DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
        disconnectedBufferOptions.setBufferEnabled(true);
        disconnectedBufferOptions.setBufferSize(100);
        disconnectedBufferOptions.setPersistBuffer(true);
        disconnectedBufferOptions.setDeleteOldestMessages(false);
        return disconnectedBufferOptions;
    }

    private MqttConnectOptions getMqttConnectionOption() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setWill("aaa", "I am going offline".getBytes(), 1, true);
        return mqttConnectOptions;
    }
}