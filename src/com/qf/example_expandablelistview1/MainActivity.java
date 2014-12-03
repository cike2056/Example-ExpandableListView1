package com.qf.example_expandablelistview1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;
/**
 * ExpandableListView简单实例.
 * @author uaige
 *
 */
public class MainActivity extends Activity {
	private ExpandableListView elv;
	private TextView tx_parent,tx_child;
	private List<String> data_p;
	private List<List<String>> data_c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		initData();
		ELVAdapter adapter = new ELVAdapter(data_p, data_c, MainActivity.this);
		elv.setAdapter(adapter);
		for(int i =0;i<data_p.size();i++){
			elv.expandGroup(i, true);//带有动画效果.逐步向下移动.
		}
	}
	
	/**
	 * 初始化视图
	 */
	private void initUI() {
		// TODO Auto-generated method stub
		elv=(ExpandableListView) findViewById(R.id.elv);
		tx_parent = (TextView) findViewById(R.id.tx_parent);
		tx_child = (TextView) findViewById(R.id.tx_child);
	}
	
	/**
	 * 初始化数据
	 */
	private void initData() {
		// TODO Auto-generated method stub
		data_p = new ArrayList<String>();
		data_c = new ArrayList<List<String>>();
		List<String> data_s = null;
		for(int i=0;i<10;i++){
			data_p.add(" group "+ (i+1));
			data_s = new ArrayList<String>();
			for(int j=0;j<11;j++){
				data_s.add(" group "+ (i+1)+" : "+" child "+ (j+1));
			}
			data_c.add(data_s);
		}
	}
}
