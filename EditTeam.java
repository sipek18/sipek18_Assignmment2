package com.example.kelson.footballfantasy;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * @author Kelson Sipe
 *
 * @version  09/29/2015
 */
public class EditTeam extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    //Instance variables
    public Button mainMenu;
    public Button addPlayer;

    public  Team theTeam;

    //Player attributes
    public EditText playerName;
    public EditText playerGoals;
    public EditText playerShotsOnGoal;
    public EditText playerAssists;
    public EditText playerSaves;
    public EditText playerFouls;
    public EditText playerYellowCards;
    public EditText playerRedCards;

    public ImageView playerImage;       //Displays the player's image

    public Spinner playerSpinner;       //Spinner to select a player
    public Spinner playerImageSpinner;  //Spinner to select an image

    public ArrayList<String> imageList; //Images for the players

    Intent intent;


    //Initializes instance variables and a default player
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_team);

        mainMenu = (Button) findViewById(R.id.toMainActivity);
        mainMenu.setOnClickListener(this);

        addPlayer = (Button) findViewById(R.id.addPlayer);
        addPlayer.setOnClickListener(this);

        playerName = (EditText) findViewById(R.id.editPlayerName);
        playerGoals = (EditText) findViewById(R.id.goals);
        playerShotsOnGoal = (EditText) findViewById(R.id.shotOnGoal);
        playerAssists = (EditText) findViewById(R.id.assists);
        playerSaves = (EditText) findViewById(R.id.saves);
        playerFouls = (EditText) findViewById(R.id.fouls);
        playerYellowCards = (EditText) findViewById(R.id.yellowCards);
        playerRedCards = (EditText) findViewById(R.id.redCards);
        intent = getIntent();
        playerImage = (ImageView) findViewById(R.id.playerPic);

        theTeam = (Team) getIntent().getSerializableExtra("Team");
        intent = getIntent();

        playerName.setText(theTeam.getPlayer("Snow Leopard").getPlayerName());
        playerGoals.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getGoals()));
        playerShotsOnGoal.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getShotsOnGoal()));
        playerAssists.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getAssists()));
        playerSaves.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getSaves()));
        playerFouls.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getFouls()));
        playerYellowCards.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getYellowCards()));
        playerRedCards.setText(String.valueOf(theTeam.getPlayer("Snow Leopard").getRedCards()));

        int id = getResources().getIdentifier(this.getPackageName() + ":drawable/" + theTeam.getPlayer("Snow Leopard").getImageID(),null,null);
        playerImage.setImageResource(id);

        //selectable images for the player in the Image spinner
        imageList = new ArrayList<String>();
        imageList.add("wild_tiger");
        imageList.add("king_tiger");
        imageList.add("tiger");
        imageList.add("little_tiger");
        imageList.add("little_leopard");
        imageList.add("modern_leopard");
        imageList.add("snow_leopard");
        imageList.add("leopard");




        playerSpinner = (Spinner) findViewById(R.id.playerSpinner);
        ArrayAdapter<String> playerSpinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, theTeam.playerList);
        playerSpinner.setAdapter(playerSpinnerAdapter);
        playerSpinner.setOnItemSelectedListener(this);

        playerImageSpinner = (Spinner) findViewById(R.id.playerImageSpinner);
        ArrayAdapter<String> imagePlayerSelectorAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,imageList);
        playerImageSpinner.setAdapter(imagePlayerSelectorAdapter);
        playerImageSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {
        //Adds a player to a team, does not function properly if you return to the main menu and go back to edit team
        if(view == addPlayer){
            if(String.valueOf(playerGoals.getText()).isEmpty() || String.valueOf(playerShotsOnGoal.getText()).isEmpty() || String.valueOf(playerAssists.getText()).isEmpty() ||
                    String.valueOf(playerSaves.getText()).isEmpty() || String.valueOf(playerFouls.getText()).isEmpty() || String.valueOf(playerYellowCards.getText()).isEmpty() ||
                    String.valueOf(playerRedCards.getText()).isEmpty() || String.valueOf(playerName.getText()).isEmpty())
                return;

            if(theTeam.playerList.indexOf(String.valueOf(playerName.getText())) == -1 )
            {
                Player pTemp = new Player(String.valueOf(playerName.getText()), Integer.parseInt(String.valueOf(playerGoals.getText())),
                        Integer.parseInt(String.valueOf(playerShotsOnGoal.getText())), Integer.parseInt(String.valueOf(playerAssists.getText())),
                        Integer.parseInt(String.valueOf(playerSaves.getText())), Integer.parseInt(String.valueOf(playerFouls.getText())),
                        Integer.parseInt(String.valueOf(playerYellowCards.getText())), Integer.parseInt(String.valueOf(playerRedCards.getText())));

                pTemp.setImageID( playerImageSpinner.getSelectedItem().toString() );

                theTeam.addPlayer(pTemp);

            }
            else
            {
                theTeam.getPlayer(String.valueOf(playerName.getText())).setGoals( Integer.parseInt(String.valueOf(playerGoals.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerShotsOnGoal.getText())));
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerAssists.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerSaves.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerFouls.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerYellowCards.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setAssists(Integer.parseInt(String.valueOf(playerRedCards.getText())) );
                theTeam.getPlayer(String.valueOf(playerName.getText())).setImageID(playerImageSpinner.getSelectedItem().toString() );
            }

            playerSpinner.setSelection( theTeam.playerList.indexOf(String.valueOf(playerName.getText())) );
        }
        //returns to the main menu and sends data
        {
            if(view == mainMenu) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivityForResult(intent, 100);
                finish();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Allows you to select a player that has been added to the team
        if(adapterView == playerSpinner)
        {
            playerGoals.setText(String.valueOf(theTeam.getPlayer(playerSpinner.getSelectedItem().toString()).getGoals()));
            playerName.setText(playerSpinner.getSelectedItem().toString());
            playerAssists.setText(String.valueOf(theTeam.getPlayer(playerSpinner.getSelectedItem().toString()).getAssists()));

            int index = imageList.indexOf(theTeam.getPlayer(playerSpinner.getSelectedItem().toString()).getImageID());
            playerImageSpinner.setSelection(index);

            int id = getResources().getIdentifier(this.getPackageName() + ":drawable/" +  theTeam.getPlayer(playerSpinner.getSelectedItem().toString()).getImageID(), null, null);
            playerImage.setImageResource(id);
        }
        //Allows you to select an image for a player
        if(adapterView == playerImageSpinner)
        {
            int id = getResources().getIdentifier(this.getPackageName() + ":drawable/" +  playerImageSpinner.getSelectedItem().toString(), null, null);
            playerImage.setImageResource(id);

        }
}

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
