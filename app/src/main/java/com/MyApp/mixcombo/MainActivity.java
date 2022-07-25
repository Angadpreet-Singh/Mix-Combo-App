package com.MyApp.mixcombo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity{
    TextView view,res;
    String work="";
    Double result=null;
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(TextView) findViewById(R.id.view);
        res=(TextView) findViewById(R.id.result);
        final Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    int indexOfPluse=work.indexOf("+");
                    int indexOfminus=work.indexOf("-");
                    int indexOfmul=work.indexOf("*");
                    int indexOfdiv=work.indexOf("/");
                    int indexOfpow=work.indexOf("^");

                    if(indexOfdiv>0||indexOfpow>0||indexOfPluse>0||indexOfminus>0||indexOfmul>0) {

                        if (work.length() > indexOfdiv || work.length() > indexOfpow || work.length() > indexOfPluse || work.length() > indexOfminus || work.length() > indexOfmul) {
                            result = (double) engine.eval(work);
                            res.setText(result.toString());
                        }
                    }
                }
                catch (Exception e){
                }
                finally {
                    handler.postDelayed(this,100);
                }
            }
        };
        handler.post(runnable);
    }

    private void working(String s){
        work=work+s;
        view.setText(work);
    }

    public void clear(View view) {
        work="";
        this.view.setText(work);
        res.setText(work);
    }

    public void equal(View view) throws ScriptException {
        if(!work.equals("")) {
            this.view.setText(String.valueOf(result));
            work = result.toString();
            result = null;
            res.setText(null);
        }
    }
    private Boolean leftParam=true;
    public void params(View view) {
        if(leftParam){
            leftParam=false;
            work+="(";
            this.view.setText(work);
        }
        else {
            leftParam=true;
            work+=")";
            this.view.setText(work);

        }
    }

    public void zero(View view) {
        working("0");
    }

    public void dot(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working(".");
        }

    }

    public void add(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working("+");
        }

    }

    public void three(View view) {
        working("3");
    }

    public void two(View view) {
        working("2");
    }

    public void one(View view) {
        working("1");
    }

    public void minus(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working("-");
        }

    }

    public void six(View view) {
        working("6");
    }

    public void five(View view) {
        working("5");
    }

    public void four(View view) {
        working("4");
    }

    public void mul(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working("*");
        }

    }

    public void nine(View view) {
        working("9");
    }

    public void eight(View view) {
        working("8");
    }

    public void seven(View view) {
        working("7");
    }

    public void div(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working("/");
        }

    }

    public void pow(View view) {
        if(!work.equals("")){
            String check =work.substring(work.length() - 1,work.length());
            if(!(check.equals("+") || check.equals("/") || check.equals("-") || check.equals("*") || check.equals("^") || check.equals(".") ))
                working("^");
        }

    }

    public void back(View view) {
        try {
            work = work.substring(0, work.length() - 1);
            int indexOfPluse=work.indexOf("+");
            int indexOfminus=work.indexOf("-");
            int indexOfmul=work.indexOf("*");
            int indexOfdiv=work.indexOf("/");
            int indexOfpow=work.indexOf("^");
            String check =work.substring(work.length() - 1,work.length());
            if(!(indexOfdiv>0||indexOfpow>0||indexOfPluse>0||indexOfminus>0||indexOfmul>0))
                res.setText("");
            this.view.setText(work);

        }
        catch (Exception e){
            this.view.setText("");
        }
    }

}