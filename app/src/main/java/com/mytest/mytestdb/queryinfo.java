package com.mytest.mytestdb;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class queryinfo extends AppCompatActivity {

    public static final int DOUPDATETEXT=1;
    public Statement stmt;
    public ResultSet rs;
    public Connection conn1;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://46.17.42.200:3306/road_event";



    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASS = "030906zxy";

    private String sedit;
    private String data;
    private EditText edittext1;
    private RecyclerView recyclerView;

    List<String> infolist =new ArrayList<>();
    ListAdapter adapter = new ListAdapter(infolist);


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }

            if (stmt != null) {
                stmt.close();
                stmt = null;
            }

            if (conn1 != null) {
                conn1.close();
                conn1 = null;
            }
        }catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryinfo);
        edittext1=(EditText)findViewById(R.id.input_text);
        Button button1=(Button)findViewById(R.id.search);



        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //从意图读取传递过来的数据
        Intent intent=getIntent();
        data =intent.getStringExtra("extra_data");

        connectdb();

        switch(data.toString())
        {
            case "contact":
                edittext1.setHint("请输入居村关键字");
                break;
            case "resident":
                edittext1.setHint("请输入小区名称关键字");
                break;
            case "road":
                edittext1.setHint("请输入道路名称关键字");
                break;
            case "widget":
                edittext1.setHint("请输入部件事件关键字");
                break;
        }

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                sedit=edittext1.getText().toString();
                switch(data.toString())
                {
                    case "contact":
                        //添加查询处理逻辑
                        if (!sedit.isEmpty())
                        {
                            querycontactinfo();
                        }
                        else
                        {
                             Toast.makeText(queryinfo.this,"输入为空",Toast.LENGTH_SHORT).show();
                         }
                        break;
                    case "resident":
                        //添加查询处理逻辑
                        if (!sedit.isEmpty()) {
                           queryresident();
                        }
                        else
                            {
                                Toast.makeText(queryinfo.this,"输入为空",Toast.LENGTH_SHORT).show();
                            }
                        break;
                    case "road":
                        //添加查询处理逻辑
                        if (!sedit.isEmpty()) {
                           queryroad();
                        }
                        else
                            {
                                Toast.makeText(queryinfo.this,"输入为空",Toast.LENGTH_SHORT).show();
                            }
                        break;
                    case "widget":
                        //添加查询处理逻辑
                        if (!sedit.isEmpty())
                        {
                            querywidget();
                        }
                        else
                        {
                            Toast.makeText(queryinfo.this,"输入为空",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
    }

    private void connectdb()
    {
        //开启一个新线程
        new Thread(new Runnable(){
           @Override
           public void run()
           {
               //打开数据库连接
               //conn1 =null;
               stmt = null;
               rs=null;

               try
               {
                   Class.forName(JDBC_DRIVER);
                   conn1 = DriverManager.getConnection(DB_URL,USER,PASS);
               }catch(ClassNotFoundException e)
               {
                   e.printStackTrace();
               } catch(Exception e)
               {
                   e.printStackTrace();
               }
           }

        }).start();
    }

    private void querycontactinfo()
    {
        //开启一个新线程
        new Thread(new Runnable(){
            @Override
            public void run()
            {
                try {
                    //System.out.println(" 实例化Statement对象...");
                    stmt = conn1.createStatement();
                    String sql;
                    sql = "SELECT * FROM contactinfo WHERE unit LIKE"+"'%"+sedit+"%'";
                    rs = stmt.executeQuery(sql);
                    String lcstring;
                    int lnint=1;
                    lcstring=lnint+"";
                    infolist.clear();
                    while(rs.next())
                    {

                        lcstring=lcstring+"、单位名称:"+rs.getString("unit")+"\n";
                        lcstring=lcstring+"    联系人:"+rs.getString("contact")+"\n";
                        lcstring=lcstring+"    电话:"+rs.getString("phone")+"\n";
                        lcstring=lcstring+"    手机:"+rs.getString("mobile");
                        infolist.add(lcstring);
                        lnint=lnint+1;
                        lcstring=lnint+"";

                    }
                } catch (SQLException se) {
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                Message message=new Message();
                message.what=DOUPDATETEXT;
                handler.sendMessage(message);

            }
        }).start();
    }

    private void queryresident()
    {
        //开启一个新线程
        new Thread(new Runnable(){
            @Override
            public void run()
            {
                try {
                    stmt = conn1.createStatement();
                    String sql;
                    sql = "SELECT * FROM resident WHERE name LIKE"+"'%"+sedit+"%'";
                    rs = stmt.executeQuery(sql);
                    String lcstring;
                    int lnint=1;
                    lcstring=lnint+"";
                    infolist.clear();
                    while(rs.next())
                    {
                        lcstring=lcstring+"、小区名称:"+rs.getString("name")+"\n";
                        lcstring=lcstring+"    小区地址:"+rs.getString("address")+"\n";
                        lcstring=lcstring+"    房屋性质:"+rs.getString("properties")+"\n";
                        lcstring=lcstring+"    所属物业公司:"+rs.getString("belong")+"\n";
                        lcstring=lcstring+"    物业联系人:"+rs.getString("person")+"\n";
                        lcstring=lcstring+"    物业联系电话:"+rs.getString("mobile")+"\n";
                        lcstring=lcstring+"    所属居委:"+rs.getString("wuye")+"\n";
                        lcstring=lcstring+"    居委联系人姓名:"+rs.getString("wuyeren")+"\n";
                        lcstring=lcstring+"    居委联系人电话:"+rs.getString("wuyephone");
                        infolist.add(lcstring);
                        lnint=lnint+1;
                        lcstring=lnint+"";

                    }
                } catch (SQLException se) {
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                Message message=new Message();
                message.what=DOUPDATETEXT;
                handler.sendMessage(message);

            }
        }).start();
    }


    private void queryroad()
    {
        //开启一个新线程
        new Thread(new Runnable(){
            @Override
            public void run()
            {
                try {
                    //System.out.println(" 实例化Statement对象...");
                    stmt = conn1.createStatement();
                    String sql;
                    sql = "SELECT * FROM road WHERE roadname LIKE"+"'%"+sedit+"%'";
                    rs = stmt.executeQuery(sql);
                    String lcstring;
                    int lnint=1;
                    lcstring=lnint+"";
                    infolist.clear();
                    while(rs.next())
                    {
                        lcstring=lcstring+"、路名:"+rs.getString("roadname")+"\n";
                        lcstring=lcstring+"    路段:"+rs.getString("range")+"\n";
                        lcstring=lcstring+"    市政设施主体:"+rs.getString("dealunit1")+"\n";
                        lcstring=lcstring+"    道路保洁主体:"+rs.getString("dealunit2")+"\n";
                        lcstring=lcstring+"    道路绿化主体:"+rs.getString("dealunit3");
                        infolist.add(lcstring);
                        lnint=lnint+1;
                        lcstring=lnint+"";

                    }
                } catch (SQLException se) {
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                Message message=new Message();
                message.what=DOUPDATETEXT;
                handler.sendMessage(message);

            }
        }).start();
    }

    private void querywidget()
    {
        //开启一个新线程
        new Thread(new Runnable(){
            @Override
            public void run()
            {
                try {
                    //System.out.println(" 实例化Statement对象...");
                    stmt = conn1.createStatement();
                    String sql;
                    sql = "SELECT * FROM widgetevent WHERE name LIKE"+"'%"+sedit+"%'";
                    rs = stmt.executeQuery(sql);
                    String lcstring;
                    int lnint=1;
                    lcstring=lnint+"";
                    infolist.clear();
                    while(rs.next())
                    {
                        lcstring=lcstring+"、部件名称:"+rs.getString("name")+"\n";
                        lcstring=lcstring+"    适用范围:"+rs.getString("range")+"\n";
                        lcstring=lcstring+"    处置单位:"+rs.getString("dealunit")+"\n";
                        lcstring=lcstring+"    处置时限:"+rs.getString("dealtime");
                        infolist.add(lcstring);
                        lnint=lnint+1;
                        lcstring=lnint+"";

                    }
                } catch (SQLException se) {
                    // 处理 JDBC 错误
                    se.printStackTrace();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                Message message=new Message();
                message.what=DOUPDATETEXT;
                handler.sendMessage(message);

            }
        }).start();
    }

    private Handler handler=new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case DOUPDATETEXT:
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                default:
                    break;
            }
        }
    };

}



