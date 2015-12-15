package com.example.kelson.footballfantasy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Kelson Sipe
 *
 * @version  09/28/2015
 */

public class MainActivity extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener  {

    //Instance variables
    private Button nextActivity;

    private EditText teamName;
    private EditText teamWins;
    private EditText teamLoses;
    private ImageView teamImage;            //Displays the team image

    public ArrayList<String> teamList;      //List of the two teams
    public ArrayList<String> teamImageList; //Pictures for the two teams and the players

    private Spinner teamImageSpinner;       //Spinner to select the team

    public HashMap<String,Team> Teams;


    /**Initializes the instance variables
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextActivity = (Button) findViewById(R.id.toEditTeamLayout);
        nextActivity.setOnClickListener(this);

        teamName = (EditText) findViewById(R.id.editTeamName);
        teamWins = (EditText) findViewById(R.id.editTeamWins);
        teamLoses = (EditText) findViewById(R.id.editTeamLoses);

        teamImage = (ImageView) findViewById(R.id.teamImage);

        //Initializes and puts the teams into the hash map
        Team team1 = new Team("Tigers",0,0);
        team1.setImageID("Tigers");
        Team team2 = new Team("Leopards",0,0);
        team2.setImageID("Leopards");
        Teams = new HashMap<String,Team>();
        Teams.put("Tigers", team1);
        Teams.put("Leopards", team2);

        teamList = new ArrayList<String>();
        teamList.add("Tigers");
        teamList.add("Leopards");

        teamImageList = new ArrayList<String>();
        teamImageList.add("wild_tiger");
        teamImageList.add("king_tiger");
        teamImageList.add("tiger");
        teamImageList.add("little_tiger");
        teamImageList.add("little_leopard");
        teamImageList.add("modern_leopard");
        teamImageList.add("snow_leopard");
        teamImageList.add("leopard");
        teamImageList.add("leopards");
        teamImageList.add("tigers");

        teamImageSpinner = (Spinner) findViewById(R.id.editTeamPicture);
        ArrayAdapter<String> teamImageAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,teamList);
        teamImageSpinner.setAdapter(teamImageAdapter);
        teamImageSpinner.setOnItemSelectedListener(this);

        int index = teamImageList.indexOf(Teams.get("Tigers").getImageID());
        teamImageSpinner.setSelection(index);

    }

    //Sends data to edit team activity and goes to the edit team activity
    @Override
    public void onClick(View view) {

        if(view == nextActivity){
            Intent intent = new Intent(this, EditTeam.class);
            intent.putExtra("Team", Teams.get( teamImageSpinner.getSelectedItem().toString() ) );
            startActivityForResult(intent,100);
        }
    }

    //Method for the team image spinner, does not function properly
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        if (adapterView == teamImageSpinner){
            teamName.setText(teamImageSpinner.getSelectedItem().toString());
            teamWins.setText(String.valueOf(Teams.get(teamImageSpinner.getSelectedItem().toString()).getWins()));
            teamLoses.setText(String.valueOf(Teams.get(teamImageSpinner.getSelectedItem().toString()).getLoses()));

//            int index = teamImageList.indexOf(Teams.get(teamImageSpinner.getSelectedItem().toString()).getImageID());
//            teamImageSpinner.setSelection(index);

            int id = getResources().getIdentifier(this.getPackageName() + ":drawable/" + teamImageSpinner.getSelectedItem().toString(), null, null);
            teamImage.setImageResource(id);

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            if (resultCode == 1){
            Team tTemp = (Team) data.getSerializableExtra("returnTeam");
            Teams.put(tTemp.getTeamName().toString(),tTemp);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){
    }
}
