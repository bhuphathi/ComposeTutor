package com.example.composetutor

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutor.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
//                ) {
//
////                    MessageCard(msg = Message("Picture", "Demo"))
//                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        ComposeTutorTheme(darkTheme = false) {
            var name by remember { mutableStateOf("") }
            Column {
                MessageCard(msg = Message("Picture", "Demo"))
                Spacer(modifier = Modifier.height(2.dp))
                Row {
                    PaddingExample()
                }
                Input(name = name, onNameChange = { name = it })
                //Columns Example
                ColumnExample()
            }
        }
    }
}

data class Message(val msg: String, val author: String)

@Composable
fun MessageCard(msg: Message) {
    Column {
        Row(
            modifier = Modifier
                .background(Tomato9)
                .border(1.dp, Tomato12, RectangleShape)
                .height(100.dp)
        ) {
//            Spacer(modifier = Modifier.width(2.dp))
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "MessageCardDisplayPhoto",
                modifier = Modifier
                    .padding(2.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = msg.msg + " " + msg.author)
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                        .background(MaterialTheme.colors.background, RectangleShape)
                )
                Text(text = msg.author)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
    }

}

@Composable
fun PaddingExample() {
    Text(
        text = "Hello World!", modifier = Modifier
            .border(1.dp, Color.Black) // outer border
            .background(Tomato3) // margin
            .padding(12.dp) // margin space between outer border and center borders

            .border(1.dp, Color.Red) // center border
            .background(Sky6) // center border
            .padding(12.dp) // space between inner border and center border

            .border(1.dp, Color.Magenta) // inner border
            .background(Tomato6) // inner space
            .padding(4.dp) // padding
    )
}

@Composable
fun Input(name: String, onNameChange: (String) -> Unit) {

    Row(modifier = Modifier.padding(top = 5.dp).border(width = 1.dp, Color.Black)) {
        TextField(value = name, onValueChange = onNameChange, label = { Text(text = "Name") }, modifier = Modifier.padding(top = 9.dp, end = 1.dp))
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Name") })
    }
}

//@Composable
//fun ColumnScope.CustomItem

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .padding(top = 5.dp)
            .background(Sky6)
    ) {
        Text(text = "Test Column")
        Row1()
        Col1()
    }
    Row1()
}

@Composable
fun Col1() {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(600.dp)
            .background(Tomato3),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Sky3)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Sky4)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Sky5)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Sky6)
        )
    }
}

@Composable
fun Row1() {
    Row {
        for (i in 1..5) {
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.Cyan)
                    .clickable(enabled = true, onClick = { Log.d("test", "Box Clicked $i") })
            )
        }
    }
}