package com.example.zooapp.AnimalsDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zooapp.Calculations;
import com.example.zooapp.Page1;
import com.example.zooapp.R;
import com.example.zooapp.ZooMap;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class AnimalsList extends AppCompatActivity {
    AnimalsData Adata;
    AnimalsData2 Adata2;
    List<AnimalsData> Alist;
    List<AnimalsData2> Alist2;
    Toolbar animalsBAR;
    BottomNavigationView navigationView;
    RecyclerView rview1;
    RecyclerView rview2;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.animalsBAR);
        this.animalsBAR = toolbar;
        setSupportActionBar(toolbar);
        this.navigationView = (BottomNavigationView) findViewById(R.id.botNav);
        navigation();
        this.rview1 = (RecyclerView) findViewById(R.id.rview1);
        this.rview2 = (RecyclerView) findViewById(R.id.rview2);
        this.rview1.setLayoutManager(new GridLayoutManager(this, 1));
        this.Alist = new ArrayList();
        AnimalsData animalsData = new AnimalsData(R.drawable.tiger, "Tiger", "Species: Panthera tigris", "LIFE-SPAN: 10 – 15 years", "Description: The tiger is the largest extant cat species and a member of the genus Panthera. It is most recognisable for its dark vertical stripes on orange-brown fur with a lighter underside. It is an apex predator, primarily preying on ungulates such as deer and wild boar.");
        this.Adata = animalsData;
        this.Alist.add(animalsData);
        AnimalsData animalsData2 = new AnimalsData(R.drawable.panda, "Panda", "Species: Ailuropoda melanoleuca", "LIFE-SPAN: 20 years", "Description: The giant panda, also known as the panda bear or simply the panda, is a bear native to south central China. It is characterised by large, black patches around its eyes, over the ears, and across its round body. The name \"giant panda\" is sometimes used to distinguish it from the red panda, a neighboring musteloid.");
        this.Adata = animalsData2;
        this.Alist.add(animalsData2);
        AnimalsData animalsData3 = new AnimalsData(R.drawable.zebra, "Zebra", "Species: Plains zebra", "LIFE-SPAN: 25 years", "Description: The plains zebra, also known as the common zebra, is the most common and geographically widespread species of zebra. Its range is fragmented, but spans much of southern and eastern Africa south of the Sahara. Six subspecies have been recognised including the extinct quagga which was thought to be a separate species.");
        this.Adata = animalsData3;
        this.Alist.add(animalsData3);
        AnimalsData animalsData4 = new AnimalsData(R.drawable.hippopotamus, "Hippopotamus", "Species: Hippopotamus amphibius", "LIFE-SPAN: 40 – 50 years", "Description: The hippopotamus, also called the hippo, common hippopotamus or river hippopotamus, is a large, mostly herbivorous, semiaquatic mammal and ungulate native to sub-Saharan Africa. It is one of only two extant species in the family Hippopotamidae, the other being the pygmy hippopotamus.");
        this.Adata = animalsData4;
        this.Alist.add(animalsData4);
        AnimalsData animalsData5 = new AnimalsData(R.drawable.alligator, "Alligator", "Species: Alligator mississippiensis", "LIFE-SPAN: 30 – 50 years", "Description: The American alligator, sometimes referred to colloquially as a gator or common alligator.");
        this.Adata = animalsData5;
        this.Alist.add(animalsData5);
        this.rview1.setAdapter(new AnimalsAdapter(this, this.Alist));
        this.rview2.setLayoutManager(new GridLayoutManager(this, 1));
        this.Alist2 = new ArrayList();
        AnimalsData2 animalsData22 = new AnimalsData2(R.drawable.bear, "Bear", "Species: Ursidae", "LIFE-SPAN: 25 years", "Description: Bears are carnivoran mammals of the family Ursidae. They are classified as caniforms, or doglike carnivorans. Although only eight species of bears are extant, they are widespread, appearing in a wide variety of habitats throughout the Northern Hemisphere and partially in the Southern Hemisphere.");
        this.Adata2 = animalsData22;
        this.Alist2.add(animalsData22);
        AnimalsData2 animalsData23 = new AnimalsData2(R.drawable.lion, "Lion", "Species: Panthera leo", "LIFE-SPAN: 10 – 14 years", "Description: The lion is a species in the family Felidae and a member of the genus Panthera. It is most recognisable for its muscular, deep-chested body, short, rounded head, round ears, and a hairy tuft at the end of its tail. It is sexually dimorphic; adult male lions have a prominent mane.");
        this.Adata2 = animalsData23;
        this.Alist2.add(animalsData23);
        AnimalsData2 animalsData24 = new AnimalsData2(R.drawable.elephant, "Elephant", "Species: Loxodonta", "LIFE-SPAN: 60 – 70 years", "Description: The African bush elephant, also known as the African savanna elephant, is the largest living terrestrial animal with bulls reaching a shoulder height of up to 3.96 m. Both sexes have tusks, which erupt when they are 1–3 years old and grow throughout life.");
        this.Adata2 = animalsData24;
        this.Alist2.add(animalsData24);
        AnimalsData2 animalsData25 = new AnimalsData2(R.drawable.rhino, "Rhino", "Species: Rhinocerotidae", "LIFE-SPAN: 40 – 50 years", "Description: The rhinoceros or square-lipped rhinoceros is the largest extant species of rhinoceros. It has a wide mouth used for grazing and is the most social of all rhino species.");
        this.Adata2 = animalsData25;
        this.Alist2.add(animalsData25);
        AnimalsData2 animalsData26 = new AnimalsData2(R.drawable.monkey, "Monkey", "Species: Cercopithecidae", "LIFE-SPAN: 20 years", "Description: Monkey is a common name that may refer to groups or species of mammals, in part, the simians of infraorder Simiiformes. The term is applied descriptively to groups of primates, such as families of New World monkeys and Old World monkeys.");
        this.Adata2 = animalsData26;
        this.Alist2.add(animalsData26);
        this.rview2.setAdapter(new AnimalsAdapter2(this, this.Alist2));
    }

    private void navigation() {
        this.navigationView.setSelectedItemId(R.id.Animals);
        this.navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* class com.example.zooapp.AnimalsDetails.AnimalsList.AnonymousClass1 */

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.mainHome) {
                    AnimalsList.this.startActivity(new Intent(AnimalsList.this, Page1.class));
                    return true;
                } else if (item.getItemId() == R.id.calculation) {
                    AnimalsList.this.startActivity(new Intent(AnimalsList.this, Calculations.class));
                    return true;
                } else if (item.getItemId() != R.id.mainLoc) {
                    return false;
                } else {
                    AnimalsList.this.startActivity(new Intent(AnimalsList.this, ZooMap.class));
                    return true;
                }
            }
        });
    }
}
