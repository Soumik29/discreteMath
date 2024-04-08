    package com.example.mathprojectraoli;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.ActionBarDrawerToggle;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;
    import android.content.Intent;
    import android.graphics.Color;
    import android.graphics.drawable.ColorDrawable;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import com.google.android.gms.ads.AdRequest;
    import com.google.android.gms.ads.AdView;
    import com.google.android.gms.ads.MobileAds;
    import com.google.android.gms.ads.initialization.InitializationStatus;
    import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
    import com.google.android.material.navigation.NavigationView;

    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        private AdView mAdView;
        public DrawerLayout drawerLayout;
        public ActionBarDrawerToggle actionBarDrawerToggle;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            drawerLayout = findViewById(R.id.drawer_layout);
            actionBarDrawerToggle = new ActionBarDrawerToggle(
                    this,
                    drawerLayout, R.string.open, R.string.close);

            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
            ActionBar actionBar;
            actionBar = getSupportActionBar();

            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
            actionBar.setBackgroundDrawable(colorDrawable);


            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
            navigationView.setNavigationItemSelectedListener(this);

            MobileAds.initialize(this, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                }
            });
            mAdView = findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);


            String[] activityNames = {
                "com.example.mathprojectraoli.Chapter1",
                "com.example.mathprojectraoli.Chapter2",
                "com.example.mathprojectraoli.Chapter3",
                "com.example.mathprojectraoli.Chapter4",
                "com.example.mathprojectraoli.Chapter5",
                "com.example.mathprojectraoli.Chapter6",
                "com.example.mathprojectraoli.Chapter7",
                "com.example.mathprojectraoli.Chapter8",
                "com.example.mathprojectraoli.Chapter9",
                "com.example.mathprojectraoli.Chapter10",
                "com.example.mathprojectraoli.Chapter11",
                "com.example.mathprojectraoli.Chapter12"
            };
            Button buttons[] = {
                    findViewById(R.id.btn1),
                    findViewById(R.id.btn2),
                    findViewById(R.id.btn3),
                    findViewById(R.id.btn4),
                    findViewById(R.id.btn5),
                    findViewById(R.id.btn6),
                    findViewById(R.id.btn7),
                    findViewById(R.id.btn8),
                    findViewById(R.id.btn9),
                    findViewById(R.id.btn10),
                    findViewById(R.id.btn11),
                    findViewById(R.id.btn12)
            };

            for(int i = 0; i < buttons.length; i++)
            {
                final String activityName = activityNames[i];
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent(MainActivity.this, Class.forName(activityName));
                            startActivity(intent);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    break;
                case R.id.Share:
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareLink = "https://play.google.com/store/apps/details?id=com.dismathinyourhands.mathprojectraoli&pcampaignid=web_share";
                    String shareTitle = "Discrete Math in Your Hands";
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareLink);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareTitle);
                    startActivity(Intent.createChooser(myIntent, "Share Using"));
                    break;
                case R.id.AboutUs:
                    Intent aboutUs = new Intent(MainActivity.this, aboutUs.class);
                    startActivity(aboutUs);
                    break;
                case R.id.Contacts:
                    Intent contactUs = new Intent(MainActivity.this, contacts.class);
                    startActivity(contactUs);
                    break;
                case R.id.Feedback:
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    String uriText = "mailto:" + Uri.encode("RaoL@usca.edu") + "?subject=" + Uri.encode("Give us some feedback: ") + " body" + Uri.encode("");
                    Uri uri = Uri.parse(uriText);
                    intent.setData(uri);
                    startActivity(Intent.createChooser(intent, "send email"));
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }