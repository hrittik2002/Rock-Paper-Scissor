package com.example.rpc2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rpc2.ui.theme.RPC2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RPC2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RockPaperScissors()
                }
            }
        }
    }
}



@Composable
fun Rockpbutton(bvlaue: String) {
    // buttons generator
    Button(
        modifier = Modifier
            .height(108.dp)
            .width(108.dp)
            .padding(10.dp),
        onClick = {null},
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text = bvlaue)
    }
}

@Composable
fun Playeraction(playera: String, actionc: String) {
    //player and android choices display
    Text(
        text = playera,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
    Text(
        text = actionc,
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun RockPaperScissors() {
    var image = painterResource(id = R.drawable.rock)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Score",
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        Text(
            text = "0 / 0",
            fontSize = 50.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.padding(top = 85.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Playeraction(playera = "You Chose", actionc = "Paper")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Playeraction(playera = "Android chose", actionc = "Rock")
            }



        }
        Row(
            modifier = Modifier.padding(top = 70.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth(0.33f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Rockpbutton(bvlaue = "Rock")
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Rockpbutton(bvlaue = "Paper")
            }
            Column(
                Modifier
                    .fillMaxWidth(0.9999f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Rockpbutton(bvlaue = "Scissor")
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom, modifier = Modifier
                .height(200.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "#JetpackCompose",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RPC2Theme {
        RockPaperScissors()
    }
}