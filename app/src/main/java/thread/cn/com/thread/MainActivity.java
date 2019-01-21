package thread.cn.com.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String s = "MAC id=\"8F0C3D3EB35559D7FA37D5095B4EA283A01809639E814C4903B185CD81E69660D5EAE227AEF2A4DF\",nonce=\"1547707444986:wuaHluSR\",mac=\"ld9NmB/kGizDOXxqLQGbYKhv9LyeA6fyfU03ix4hzgU=\"";
//        System.out.println("strBase64:"+s);
//
//        String strBase64 = Base64.encodeToString(s.getBytes(), Base64.DEFAULT);
//        System.out.println("strBase64:"+strBase64);
//
//        String encodedString = Base64.encodeToString("whoislcj".getBytes(), Base64.DEFAULT);
//        System.out.println("strBase64:"+encodedString);
//
//        String strBase642 = Base64.encodeToString(s.getBytes(),
//                Base64.DEFAULT);
//        System.out.println("strBase64:"+strBase642);

        String strBase641 = Base64.encodeToString(s.getBytes(), Base64.DEFAULT);
//        String strBase64 = new String(Base64.encode(s.getBytes(), Base64.DEFAULT));
//        System.out.println("strBase64:"+s);
        System.out.println("strBase64:"+strBase641);
        System.out.println("\n");
        try {
            String  enStr1 = URLEncoder.encode(strBase641, "utf-8");
            System.out.println("strBase64:"+enStr1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
        try {
            String  enStr1 = URLEncoder.encode(s, "utf-8");
            System.out.println("strBase64:"+enStr1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
