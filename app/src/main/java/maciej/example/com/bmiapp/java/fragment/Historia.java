package maciej.example.com.bmiapp.java.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import maciej.example.com.bmiapp.R;
import maciej.example.com.bmiapp.java.model.BMI_DB;
import maciej.example.com.bmiapp.java.model.DB_Helper;
import maciej.example.com.bmiapp.java.model.ListViewAdapter;

/**
 * Created by Maciej on 2017-08-09.
 */

public class Historia extends Fragment {

    @BindView(R.id.list_item)
    SwipeMenuListView listView;

    private Dao<BMI_DB, Long> dbLongDao;

    private List<BMI_DB> list;

    List<String> values;

    ListViewAdapter arrayAdapter;


    public static Historia newInstance() {
        Historia fragment2 = new Historia();
        Bundle args = new Bundle();
        fragment2.setArguments(args);
        return fragment2;
    }


    public Historia() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        ButterKnife.bind(this, view);

        DB_Helper db_helper = OpenHelperManager.getHelper(getActivity(), DB_Helper.class);
        dbLongDao = db_helper.getBmiDao();
        loadFromDatabase();


        SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem swipeMenuItem = new SwipeMenuItem(getActivity());
                swipeMenuItem.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1, 0xF5)));
                swipeMenuItem.setWidth((200));
                swipeMenuItem.setTitle("Powrót");
                swipeMenuItem.setTitleSize(20);
                swipeMenuItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(swipeMenuItem);
                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                deleteItem.setWidth((200));
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setTitle("Usuń");
                deleteItem.setTitleSize(20);
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(swipeMenuCreator);
        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                switch (index) {
                    case 0:
                        break;
                    case 1:
                        String s = values.get(position);
                        values.remove(s);
                        arrayAdapter.notifyDataSetChanged();
                        Toast.makeText(getActivity(), "Usunięto.", Toast.LENGTH_SHORT).show();


                        break;
                }

                return false;
            }
        });

        listView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {

            }

            @Override
            public void onMenuClose(int position) {

            }
        });

        listView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {
            @Override
            public void onSwipeStart(int position) {
                listView.smoothOpenMenu(position);
            }

            @Override
            public void onSwipeEnd(int position) {

            }
        });


        return view;
    }


    public void loadFromDatabase() {
        try {
            list = dbLongDao.queryForAll();
            values = getFromBmiDb(list);
            //arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.text_view, values);
            arrayAdapter = new ListViewAdapter(getActivity(), values);
            listView.setAdapter(arrayAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<String> getFromBmiDb(List<BMI_DB> bmiList) {
        List<String> values = new ArrayList<>();

        for (BMI_DB tmp : bmiList) {
            values.add(tmp.toString());
        }
        return values;
    }


}
