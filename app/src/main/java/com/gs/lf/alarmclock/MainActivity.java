package com.gs.lf.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.gs.lf.json.GsonImpl;
import com.gs.lf.json.WeatherInfo;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Calendar calendar;
    TimePicker timePicker;
    TextView updateText;
    Context context;
    Button alarmOn;
    Button alarmOff;

    static String httpUrl = "https://api.heweather.com/x3/weather?city=guangzhou&key=56bfff638a374b4e9ab999ce70f75744";
    SpeechSynthesizer mTts;


    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = getApplicationContext();

        //initial timePicker, alarmManager,
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(false);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        updateText = (TextView)findViewById(R.id.update_text);

        alarmOn = (Button)findViewById(R.id.alarm_on);
        alarmOff = (Button)findViewById(R.id.alarm_off);

        alarmOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("Alarm On!");

                //set calendar
                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());

                //show alarm time
                String hour = String.valueOf(timePicker.getCurrentHour());
                String minute = String.valueOf(timePicker.getCurrentMinute());
                if(Integer.valueOf(hour) > 12){
                    hour = String.valueOf(timePicker.getCurrentHour() - 12);
                }
                if(Integer.valueOf(minute) < 10){
                    minute = '0' + String.valueOf(timePicker.getCurrentMinute());
                }
                setText("Alarm set to "+hour+":"+minute);

                //set up alarm
                Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);
                //sendBroadcast(intent);
                pendingIntent = PendingIntent.getBroadcast(context,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                //If the stated trigger time is in the past, the alarm will be triggered immediately
                //Explicit Intent:In your case, you should use an explicit Intent as you already know which Activity you want to start. So create an Intent by passing the context and the component(Activity) class you want to start.
                //Intent i=new Intent (this,MainActivity.class);
                //startActivity(i)
                // minus one day;
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis()-24*60*60*1000,pendingIntent);
//                System.out.println("MainActivity--Alarm Time:" + calendar.getTimeInMillis()+"Year:"+calendar.get(Calendar.YEAR)+" Month:"+calendar.get(Calendar.MONTH)+" Day:"+calendar.get(Calendar.DAY_OF_MONTH)+" Hour:"+calendar.get(Calendar.HOUR)+" Minute:"+calendar.get(Calendar.MINUTE)+" Second:"+calendar.get(Calendar.SECOND));
//                calendar = Calendar.getInstance();
//                System.out.println(TAG+"--Current Time:"+calendar.getTimeInMillis()+" Year:"+calendar.get(Calendar.YEAR)+" Month:"+calendar.get(Calendar.MONTH)+" Day:"+calendar.get(Calendar.DAY_OF_MONTH)+" Hour:"+calendar.get(Calendar.HOUR)+" Minute:"+calendar.get(Calendar.MINUTE)+" Second:"+calendar.get(Calendar.SECOND));
//                System.out.println("MainActivity--Alarm set");
            }
        });
        alarmOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText("Alarm Off!");
                alarmManager.cancel(pendingIntent);
            }
        });

        Intent intent = getIntent();
        if(intent.getAction()=="ALARM_GOES_OFF"){
            Toast.makeText(context,TAG+":Alarm goes off",Toast.LENGTH_LONG).show();
            SpeechUtility.createUtility(context, SpeechConstant.APPID + "=57a2be33 ");
            new getWeatherInfo().execute(httpUrl);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mTts != null){
            if(mTts.isSpeaking() == true){
                Toast.makeText(context,"isSpeaking",Toast.LENGTH_SHORT).show();
                mTts.resumeSpeaking();
                Toast.makeText(context,"SpeakResumed",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mTts != null){
            if(mTts.isSpeaking() == true){
                mTts.pauseSpeaking();
            }
        }
    }

    private void setText(String text) {
        updateText.setText(text);
    }

    public static String request(String httpUrl) {
        BufferedReader reader = null;String result = null;StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(httpUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead); sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) { e.printStackTrace(); }
        return result;
    }

    private void speak(String content) {
        //1.创建 SpeechSynthesizer 对象, 第二个参数： 本地合成时传 InitListener
        mTts = SpeechSynthesizer.createSynthesizer(context, null);
        //2.合成参数设置，详见《科大讯飞MSC API手册(Android)》 SpeechSynthesizer 类
        //设置发音人（更多在线发音人，用户可参见 附录12.2
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围 0~100
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端
        //设置合成音频保存位置（可自定义保存位置），保存在“./sdcard/iflytek.pcm”
        //保存在 SD 卡需要在 AndroidManifest.xml 添加写 SD 卡权限
        //仅支持保存为 pcm 格式， 如果不需要保存合成音频，注释该行代码
        //mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./sdcard/iflytek.pcm");
        //3.开始合成
        mTts.startSpeaking(content, new SynthesizerListener() {
            //会话结束回调接口，没有错误时， error为null
            public void onCompleted(SpeechError error) {
            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
            //缓冲进度回调
            //percent为缓冲进度0~100， beginPos为缓冲音频在文本中开始位置， endPos表示缓冲音频在
            //文本中结束位置，info为附加信息。

            public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
            }

            //开始播放
            public void onSpeakBegin() {
                Toast.makeText(context,"SpeakBegin",Toast.LENGTH_SHORT).show();
            }

            //暂停播放
            public void onSpeakPaused() {
            }
            //播放进度回调
            //percent为播放进度0~100,beginPos为播放音频在文本中开始位置， endPos表示播放音频在文
            //本中结束位置.

            public void onSpeakProgress(int percent, int beginPos, int endPos) {
            }

            //恢复播放回调接口
            public void onSpeakResumed() {
            }
            //会话事件回调接口
        });
    }

    private class getWeatherInfo extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {
            StringBuffer jsonResult = new StringBuffer(request(params[0]));
            jsonResult.deleteCharAt(11);
            jsonResult.deleteCharAt(15);
            jsonResult.delete(22, 26);
            WeatherInfo weatherInfo = GsonImpl.get().toObject(jsonResult.toString(), WeatherInfo.class);

            //Construct string for read, date,time,city,temperature,whether,humidity,PM2.5,wind direction and level
            StringBuffer content = new StringBuffer();
            content.append(calendarToText());

            content.append(weatherInfo.getHeWeatherdataservice().get(0).getBasic().getCity());
            content.append(",");
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getCond().getTxt_d());
            content.append("转");
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getCond().getTxt_n());
            content.append(",");
            content.append(String.valueOf(weatherInfo.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getTmp().getMin()));
            content.append("至");
            content.append(String.valueOf(weatherInfo.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getTmp().getMax()));
            content.append("摄氏度");
            content.append("。");

            content.append("湿度百分之");
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getDaily_forecast().get(0).getHum());
            content.append("。");

            content.append("PM 2.5，");
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getAqi().getCity().getPm25());
            content.append("。");

            content.append(weatherInfo.getHeWeatherdataservice().get(0).getNow().getWind().getDir());
            content.append(",");
            String windLevel = weatherInfo.getHeWeatherdataservice().get(0).getNow().getWind().getSc();
            int i = windLevel.indexOf("-");

            content.append(windLevel.subSequence(0,i));
            content.append("到");
            content.append(windLevel.subSequence(i+1,windLevel.length()));
            content.append("级");
            content.append("。");

            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getComf().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getCw().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getDrsg().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getFlu().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getSport().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getTrav().getTxt());
            content.append('\n');
            content.append(weatherInfo.getHeWeatherdataservice().get(0).getSuggestion().getUv().getTxt());
            return content.toString();
        }

        private String calendarToText() {
            Calendar calendar = Calendar.getInstance();
            StringBuffer stringBuffer = new StringBuffer();

            String YEAR = String.valueOf(calendar.get(Calendar.YEAR));
            stringBuffer.append(YEAR.charAt(0));
            stringBuffer.append(" ");
            stringBuffer.append(YEAR.charAt(1));
            stringBuffer.append(" ");
            stringBuffer.append(YEAR.charAt(2));
            stringBuffer.append(" ");
            stringBuffer.append(YEAR.charAt(3));
            stringBuffer.append("年");

            //plus 1 because january is 0
            stringBuffer.append(String.valueOf(calendar.get(Calendar.MONTH)+1));
            stringBuffer.append("月");

            stringBuffer.append(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            stringBuffer.append("日");

            if(calendar.get(Calendar.AM_PM)==Calendar.PM){
                stringBuffer.append("下午");
                stringBuffer.append(String.valueOf(calendar.get(Calendar.HOUR)));
            }else{
                stringBuffer.append("上午");
                stringBuffer.append(String.valueOf(calendar.get(Calendar.HOUR)));
            }
            stringBuffer.append("点");
            stringBuffer.append(String.valueOf(calendar.get(Calendar.MINUTE)));
            stringBuffer.append("分。");

            return stringBuffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(mTts == null){
                speak(s);
            }
            Toast.makeText(context,s,Toast.LENGTH_LONG).show();
        }
    }
}
