package com.amontap.lisview_55410512;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amontap.lisview_55410512.R.id;

public class MainActivity extends Activity {
    private ListView listview1;
    private ArrayList<List_items> itemlist;
    private ListAdapter adapter;
    
    private int[] drawable = {
 		   R.drawable.facebook
 		  ,R.drawable.google_plush
 		  ,R.drawable.twitter
 		  ,R.drawable.youtube};
    private String[] title= {"Facebook","Google+","Twitter","Youtube"};
    
 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     listview1=(ListView)findViewById(R.id.listView1);
     itemlist = new ArrayList<List_items>();
     
     for (int i = 0; i<drawable.length; i++){
     	List_items list_items = new List_items();
     	list_items.setTitle(title[i]);
     	list_items.setDrwable(getResources().getDrawable(drawable[i]));
     	itemlist.add(list_items);
     	}
     adapter = new Myadapter();
     listview1.setAdapter(adapter);
     	
 }//End onCreate
  private class Myadapter extends BaseAdapter{
     private Holder holder;
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemlist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position ,View view, ViewGroup parent) {
			view = LayoutInflater.from(getApplicationContext()).
					inflate(R.layout.listview_item, null);
			// TODO Auto-generated method stub
			
			holder = new Holder();
			holder.imageView =(ImageView) view.findViewById(R.id.item_image);
			holder.txt1 = (TextView)view.findViewById(R.id.item_txttitle);
			if (itemlist.get(position).getTitle()!= null){
				holder.txt1.setText(itemlist.get(position).getTitle());
			
			if (itemlist.get(position).getDrwable() != null){
				holder.imageView.setImageDrawable(itemlist.get(position).getDrwable());
			}
			
		}
			return view;
  }

}//End Class
	public class Holder {
		public TextView txt1;
		public ImageView imageView;
	}
}