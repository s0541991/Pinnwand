package com.example.pinnwand;

import database.DBHandler;
import database.PinnwandThread;
import database.ThreadDBHandler;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MeineThreads extends PinnwandActivity {
	Button kontext_menu;

	private ThreadDBHandler threadsDB;
	private static ArrayList<PinnwandThread> threads;
	private ThreadsPagerAdapter mThreadsPagerAdapter;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meine_threads);
		kontext_menu = (Button) findViewById(R.id.kontext_menu);
		registerForContextMenu(kontext_menu);
		
		Log.d("MeineThreads.onCreate", "ww");
		threadsDB = new ThreadDBHandler(getApplicationContext());
		threads = threadsDB.getAllThreads();
		Log.d("MeineThreads", "threads.size() = " + threads.size());
		
		mThreadsPagerAdapter = new ThreadsPagerAdapter(getSupportFragmentManager());
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mThreadsPagerAdapter);	
	}

	public static class ThreadsPagerAdapter extends FragmentStatePagerAdapter {

		public ThreadsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			Fragment fragment = new ThreadFragment();
			Bundle args = new Bundle();
            args.putSerializable(ThreadFragment.ARG_OBJECT, threads.get(i));
            fragment.setArguments(args);
			return fragment;
		}

		@Override
		public CharSequence getPageTitle(int i) {
			return "Thread " + threads.get(i).getName();
		}

		@Override
		public int getCount() {
			Log.d("MeineThreads", "# of threads = " + threads.size());
			return threads.size();
		}
	}

	public static class ThreadFragment extends Fragment {
		public static final String ARG_OBJECT = "fffdafda";
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_meine_threads_fragment, container, false);
			Bundle args = getArguments();
			final PinnwandThread thread = (PinnwandThread) args.getSerializable(ARG_OBJECT);
			((TextView) rootView.findViewById(R.id.threadDescription)).setText(thread.getDescription());
			
			Button b_viewThread = (Button) rootView.findViewById(R.id.viewThread);
			b_viewThread.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					PinnwandApplication appState = ((PinnwandApplication) getActivity().getApplicationContext());
					appState.setCurrentTid(thread.getTId());
					getActivity().startActivity(new Intent(getActivity(), ReadThread.class));
				}
			});
			return rootView;
		}
	}
}
