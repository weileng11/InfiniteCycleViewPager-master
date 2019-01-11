package com.gigamole.sample.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.Toast;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.gigamole.sample.R;
import com.gigamole.sample.adapters.VerticalPagerAdapter;

/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class VerticalPagerFragment extends Fragment {
	
	//用来判断是单击还是滑动
	private boolean isOnclick = true;
	private  VerticalPagerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vertical, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
	    mAdapter=new VerticalPagerAdapter(getContext());
        final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                (VerticalInfiniteCycleViewPager) view.findViewById(R.id.vicvp);
        verticalInfiniteCycleViewPager.setAdapter(mAdapter);

        verticalInfiniteCycleViewPager.setScrollDuration(1000);
	    verticalInfiniteCycleViewPager.startAutoScroll(true);
	
	    verticalInfiniteCycleViewPager.setOnTouchListener(new View.OnTouchListener(){
		    @Override
		    public boolean onTouch(View v, MotionEvent event){
			    switch (event.getAction()){
			    case MotionEvent.ACTION_DOWN:
				    isOnclick  = true;
				    break ;
			    case MotionEvent.ACTION_MOVE:
				    //滑动置为false
				    isOnclick  = false;
				    break ;
			    case  MotionEvent.ACTION_UP :
				    if (isOnclick) {
					    int item = verticalInfiniteCycleViewPager.getCurrentItem() % mAdapter.getCount();
					    if (item == 0) {
						    Toast.makeText(getActivity(),"点击了1",Toast.LENGTH_LONG);
					    } else if (item == 1) {
						    Toast.makeText(getActivity(),"点击了2",Toast.LENGTH_LONG);
					    } else if (item == 2) {
						    Toast.makeText(getActivity(),"点击了3",Toast.LENGTH_LONG);
					    }else if (item == 3) {
						    Toast.makeText(getActivity(),"点击了4",Toast.LENGTH_LONG);
					    }
				    }
				    break ;
			    }
			    return false;
		    }
	    });
    }
}
