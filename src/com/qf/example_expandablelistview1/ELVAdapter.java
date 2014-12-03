package com.qf.example_expandablelistview1;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ELVAdapter extends BaseExpandableListAdapter{
	private List<String> data_p;
	private List<List<String>> data_c;
	private Context context;
	
	public ELVAdapter(List<String> data_p, List<List<String>> data_c,
			Context context) {
		super();
		this.data_p = data_p;
		this.data_c = data_c;
		this.context = context;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return data_c.get(groupPosition).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return data_c==null?0:data_c.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return data_p.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return data_p==null?0:data_p.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	/**
	 * getGroupView
	 */
		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			MyParentHolder holderP;
			if(convertView==null){
				convertView = View.inflate(context, R.layout.item_parent, null);
				holderP = new MyParentHolder();
				holderP.tx_p= (TextView) convertView.findViewById(R.id.tx_parent);
				convertView.setTag(holderP);
			}else {
				holderP = (MyParentHolder)convertView.getTag();
			}
			holderP.tx_p.setText(data_p.get(groupPosition));
			return convertView;
		}
	/**
	 * getChildView
	*/
		@Override
		public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
			MyChildHolder holder_C;
			if(convertView==null){
				convertView = View.inflate(context, R.layout.item_child, null);
				holder_C = new MyChildHolder();
				holder_C.tx_c= (TextView) convertView.findViewById(R.id.tx_child);
				convertView.setTag(holder_C);
			}else {
				holder_C = (MyChildHolder)convertView.getTag();
			}
			holder_C.tx_c.setText(data_c.get(groupPosition).get(childPosition));
			return convertView;
		}	
		class MyChildHolder{
			TextView tx_c;
		}
		class MyParentHolder{
			TextView tx_p;
		}
}
