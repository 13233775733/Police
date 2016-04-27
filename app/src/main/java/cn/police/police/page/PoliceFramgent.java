package cn.police.police.page;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.police.police.R;
import cn.police.police.adapter.TableListViewAdapter;


public class PoliceFramgent extends Fragment {

    private ListView listview;
    private boolean scrollFlag = false;// 标记是否滑动
    private int lastVisibleItemPosition;// 标记上次滑动位置
    private float mLastY;


    public static PoliceFramgent newInstance() {
        PoliceFramgent fragment = new PoliceFramgent();
        return fragment;
    }

    private static final String[] m={"1","2","3","4","其他"};
    @InjectView(R.id.spinner1)
    Spinner spinner1;
    private ArrayAdapter<String> adapter;
    private TableListViewAdapter adapter2;

    private List<List<String>> list = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 0; i < 10; i++){
            List<String> str_list = new ArrayList<>();
            for(int j = 0; j < 7; j++){
                str_list.add("预约"+String.valueOf(i)+String.valueOf(j));
            }

            list.add(str_list);
        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      View view= inflater.inflate(R.layout.fragment_police_framgent, container, false);
        ButterKnife.inject(this, view);

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,m);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setVisibility(View.VISIBLE);
        listview = (ListView) view.findViewById(R.id.table_listview);

        adapter2 = new TableListViewAdapter(this.getActivity(),list);

        listview.setAdapter(adapter2);

        View listItem = adapter2.getView(0,null,listview);
        listItem.measure(0, 0);
        listview.getLayoutParams().height = (listItem.getMeasuredHeight()+listview.getDividerHeight()) * 6;

//        scrollVertical(listview, getActivity(), (listItem.getMeasuredHeight()+listview.getDividerHeight()) * 6);

        return view;
    }

    /**
     * Listview 竖直滑动
     * @param y 垂直滑动的距离
     */
    public void scrollVertical(final ListView listView, Activity activity, final int y){
        if(listView == null)
            return;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                invokeMethod(listView, "trackMotionScroll", new Object[]{-y, -y}, new Class[]{int.class, int.class});
            }
        });
    }

    /**
     * 遍历当前类以及父类去查找方法，例子，写的比较简单
     * @param object-
     * @param methodName-
     * @param params-
     * @param paramTypes-
     * @return -
     */
    public Object invokeMethod(Object object, String methodName, Object[] params, Class[] paramTypes){
        Object returnObj = null;
        if (object == null) {
            return null;
        }
        Class cls = object.getClass();
        Method method = null;
        for (; cls != Object.class; cls = cls.getSuperclass()) { //因为取的是父类的默认修饰符的方法，所以需要循环找到该方法
            try {
                method = cls.getDeclaredMethod(methodName, paramTypes);
                break;
            } catch (NoSuchMethodException e) {
//					e.printStackTrace();
            } catch (SecurityException e) {
//					e.printStackTrace();
            }
        }
        if(method != null){
            method.setAccessible(true);
            try {
                returnObj = method.invoke(object, params);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return returnObj;
    }

}
