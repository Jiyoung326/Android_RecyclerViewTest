package kr.or.womanup.nambu.hjy.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.threecolors, R.drawable.yeonnim, R.drawable.moo, R.drawable.raegi,
            R.drawable.marilyn, R.drawable.tungtang};
    String[] names = {"삼색이","연님","무","래기","마를린","뚱땅이"};
    String[] cats = {"Three Colors","YeonNim","Moo","Raegi","Marilyn","Tungtang"};

    RecyclerView recycler;
    ArrayList<Cat> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        members = new ArrayList<>();
        for (int i = 0; i < cats.length; i++) {
            members.add(new Cat(cats[i], names[i], images[i]));
        }

/*        //===리니어 레이아웃===
        CatAdapter1 adapter1 = new CatAdapter1(this,members,R.layout.cats_item_hor);
        recycler.setAdapter(adapter1);
        //매니저로 방향을 설정해줘야 화면이 나옴. 리스트뷰보다 리사이클러뷰가 유연하기 때문에 설정 필요.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(manager);
        DividerItemDecoration decorationHor = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        recycler.addItemDecoration(decorationHor);
        DividerItemDecoration decorationVer = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(decorationVer);*/
        
        //===그리드 레이아웃===
        CatAdapter1 adapter1 = new CatAdapter1(this,members,R.layout.cats_item_hor);
        recycler.setAdapter(adapter1);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        //선 그리기
        DividerItemDecoration decorationHor = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        recycler.addItemDecoration(decorationHor);
        DividerItemDecoration decorationVer = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(decorationVer);
    }
}