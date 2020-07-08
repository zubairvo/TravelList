package zubair.com;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        ListView listView;
        String mCountries[] = {"Brazil", "South Africa", "Egypt", "Belgium", "New Zealand", "Bolivia","England","Canada","Saudi Arabia"};
        String mDescription[] = {"South America", "Africa", "Africa", "Europe", "Oceania", "South America","Europe","North America","Middle East"};
        int images[] = {R.drawable.brazil,R.drawable.sa, R.drawable.egypt,R.drawable.belgium,R.drawable.nz,R.drawable.bolivia,R.drawable.england,R.drawable.canada,R.drawable.saudi};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        CustomAdapter ViewList = new CustomAdapter(this, mCountries, mDescription, images);
        listView.setAdapter(ViewList);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Lets go to Brazil", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Let's go to South Africa", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Let's go to Egypt", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "Let's go to Belgium", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "Let's go to New Zealand", Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(MainActivity.this, "Let's go to Bolivia", Toast.LENGTH_SHORT).show();
                }
                if (position == 6){
                    Toast.makeText(MainActivity.this, "Let's go to England", Toast.LENGTH_SHORT).show();
                }
                if (position == 7){
                    Toast.makeText(MainActivity.this, "Let's go to Canada", Toast.LENGTH_SHORT).show();
                }
                if (position == 8){
                    Toast.makeText(MainActivity.this, "Let's go to Saudi Arabia", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    class CustomAdapter extends ArrayAdapter<String>{

        Context context;
        String mCountries[];
        String mDescription[];
        int images [];

        CustomAdapter (Context c, String country[], String description[], int image[]){
            super(c, R.layout.row, R.id.textView1, country);
            this.context = c;
            this.mCountries = country;
            this.mDescription = description;
            this.images = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView vImage = row.findViewById(R.id.image);
            TextView myCountry = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            vImage.setImageResource(images[position]);
            myCountry.setText(mCountries[position]);
            myDescription.setText(mDescription[position]);

            return row;
        }
    }
}