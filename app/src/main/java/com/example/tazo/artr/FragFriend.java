package com.example.tazo.artr;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Tazo on 2018-05-06.
 */

public class FragFriend extends Fragment {
    View root;
    ArrayList<Friend> arrayList;
    FriendAdapter friendAdapter;
    Friend[] friends = new Friend[2];

    ListView listView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_friend, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성
        arrayList = new ArrayList<Friend>();
        listView = (ListView)root.findViewById(R.id.listview);
        friends[0] = new Friend(R.drawable.friavatar,"남정아",1,2);
        friends[1] = new Friend(R.drawable.friavatar, "박민지", 2,1);
        arrayList.add(friends[0]);
        arrayList.add(friends[1]);

        friendAdapter = new FriendAdapter(root.getContext(),R.layout.friend_row,arrayList);
        listView.setAdapter(friendAdapter);
    }
}
