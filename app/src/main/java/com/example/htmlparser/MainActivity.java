package com.example.htmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String html = "<p>An <a href='http://example.com'><b>example</b></a>link</p>";

        TextView textView = (TextView)findViewById(R.id.tv);
        Document doc = Jsoup.parse(html);
        Element link = doc.select("a").first();
        String text = doc.body().text();
        String linkHref=link.attr("href");
        String linkText=link.text();
        String linkOuterH = link.outerHtml();
        String linkInnerH = link.html();

        String result = text + "\n"+linkText+"\n"+linkOuterH+"\n"+linkInnerH;

        textView.setText(result);
    }
}