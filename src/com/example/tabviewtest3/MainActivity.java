package com.example.tabviewtest3;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//ViewPage + Fragment
public class MainActivity extends FragmentActivity implements OnClickListener {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments;

	private LinearLayout mLayout1;
	private LinearLayout mLayout2;
	private LinearLayout mLayout3;
	private LinearLayout mLayout4;

	private ImageButton mbtn1;
	private ImageButton mbtn2;
	private ImageButton mbtn3;
	private ImageButton mbtn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		setSelect(0);
	}

	private void initView() {

		mViewPager = (ViewPager) findViewById(R.id.id_viewPager);

		mLayout1 = (LinearLayout) findViewById(R.id.layout_1);
		mLayout2 = (LinearLayout) findViewById(R.id.layout_2);
		mLayout3 = (LinearLayout) findViewById(R.id.layout_3);
		mLayout4 = (LinearLayout) findViewById(R.id.layout_4);

		mbtn1 = (ImageButton) findViewById(R.id.btn_1);
		mbtn2 = (ImageButton) findViewById(R.id.btn_2);
		mbtn3 = (ImageButton) findViewById(R.id.btn_3);
		mbtn4 = (ImageButton) findViewById(R.id.btn_4);
		
		mFragments = new ArrayList<Fragment>();
		Fragment mTab01 = new lauout1Fragment();
		Fragment mTab02 = new lauout2Fragment();
		Fragment mTab03 = new lauout3Fragment();
		Fragment mTab04 = new lauout4Fragment();
		
		mFragments.add(mTab01);
		mFragments.add(mTab02);
		mFragments.add(mTab03);
		mFragments.add(mTab04);
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return mFragments.get(arg0);
			}
		};
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int i) {
				// TODO Auto-generated method stub
				int currentItem = mViewPager.getCurrentItem();
				setTab(currentItem);
			}

			@Override
			public void onPageScrolled(int i, float f, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		mLayout1.setOnClickListener(this);
		mLayout2.setOnClickListener(this);
		mLayout3.setOnClickListener(this);
		mLayout4.setOnClickListener(this);
		
		mbtn1.setOnClickListener(this);
		mbtn2.setOnClickListener(this);
		mbtn3.setOnClickListener(this);
		mbtn4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_1:
		case R.layout.tab1:
			setSelect(0);
			break;
		case R.id.btn_2:
		case R.layout.tab2:
			setSelect(1);
			break;
		case R.id.btn_3:
		case R.layout.tab3:
			setSelect(2);
			break;
		case R.id.btn_4:
		case R.layout.tab4:
			setSelect(3);
			break;
		default:
			break;
		}
	}

	private void setSelect(int i) {
		setTab(i);
		mViewPager.setCurrentItem(i);
		
	}

	private void setTab(int i) {
		resetImg();
		switch (i) {
		case 0:
			mbtn1.setImageResource(R.drawable.tab_address_pressed);
			break;
		case 1:
			mbtn2.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			mbtn3.setImageResource(R.drawable.tab_settings_pressed);
			break;
		case 3:
			mbtn4.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		default:
			break;
		}
	}

	private void resetImg() {
		// TODO Auto-generated method stub
		mbtn1.setImageResource(R.drawable.tab_address_normal);
		mbtn2.setImageResource(R.drawable.tab_find_frd_normal);
		mbtn3.setImageResource(R.drawable.tab_settings_normal);
		mbtn4.setImageResource(R.drawable.tab_weixin_normal);
	}

}
