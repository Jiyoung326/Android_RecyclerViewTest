package kr.or.womanup.nambu.hjy.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Recycler를 위한 어뎁터
//view holder만 주고 받는다.
public class CatAdapter1 extends RecyclerView.Adapter<CatAdapter1.ViewHolder> {//정의한 홀더로 제너릭 해주기
    Context context;
    ArrayList<Cat> cats;
    int layout;

    public CatAdapter1(Context context, ArrayList<Cat> cats, int layout) {
        this.context = context;
        this.cats = cats;
        this.layout = layout;
    }

    @NonNull
    @Override //재활용할 것이 없으면 리사이클러에서 먼저 호출됨
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //한 리사이클러뷰 안에 다른 모양의 아이템뷰가 들어올 수 있어서 뷰타입이 있다.
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(layout,parent,false); //아이텝뷰 만들어짐
        ViewHolder holder = new ViewHolder(itemView);
        return holder; //리사이클러뷰에 ViewHolder를 반환 후 리사이클러뷰는 onBindViewHolder를 호출
    }

    @Override //재활용할 것이 있으면 리사이클러뷰에서 바로 호출됨
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat member = cats.get(position);
        holder.imageView.setImageResource(member.image);
        holder.txtNick.setText(member.nick);
        holder.txtName.setText(member.name);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    //상속 꼭 RecyclerView.ViewHolder 으로 해주기
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtNick;
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview_item);
            txtNick = itemView.findViewById(R.id.txt_nick_item);
            txtName = itemView.findViewById(R.id.txt_name_item);
            //리사이클러 뷰엔 온클릭 리스너 없음. 아이템뷰에 온 클릭 리스너 구현
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition(); //선택된 아이템의 포지션
                    Cat member = cats.get(pos);
                    Toast.makeText(context,member.nick,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
