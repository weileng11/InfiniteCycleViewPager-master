package com.gigamole.sample.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.gigamole.sample.R;
import com.gigamole.sample.adapters.HorizontalPagerAdapter;

/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class HorizontalPagerFragment extends Fragment {
	
	//用来判断是单击还是滑动
	private boolean isOnclick = true;
	private HorizontalPagerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_horizontal, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
	    mAdapter=new HorizontalPagerAdapter(getContext(), false);
        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.hicvp);
        horizontalInfiniteCycleViewPager.setAdapter(mAdapter);

        horizontalInfiniteCycleViewPager.setScrollDuration(400);
        horizontalInfiniteCycleViewPager.setPageDuration(1000);
        horizontalInfiniteCycleViewPager.setInterpolator(
                AnimationUtils.loadInterpolator(getContext(), android.R.anim.overshoot_interpolator)
        );
        horizontalInfiniteCycleViewPager.setMediumScaled(false);
        horizontalInfiniteCycleViewPager.setMaxPageScale(0.8F);
        horizontalInfiniteCycleViewPager.setMinPageScale(0.5F);
        horizontalInfiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        horizontalInfiniteCycleViewPager.setMinPageScaleOffset(5.0F);
        //horizontalInfiniteCycleViewPager.setOnInfiniteCyclePageTransformListener();

        horizontalInfiniteCycleViewPager.setCurrentItem(
                horizontalInfiniteCycleViewPager.getRealItem() + 1
        );
	
	    horizontalInfiniteCycleViewPager.setOnTouchListener(new View.OnTouchListener(){
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
					    int item = horizontalInfiniteCycleViewPager.getCurrentItem() % mAdapter.getCount();
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
