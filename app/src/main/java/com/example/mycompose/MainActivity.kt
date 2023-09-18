@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mycompose

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count = remember {
        mutableStateOf(0)
    }
    var text by remember {
        mutableStateOf("")
    }


    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        //horizontalArrangement= Arrangement.Center,
        modifier = Modifier.background(Color.Red)
    ) {


        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            readOnly = false,
            label = { Text(text = "Type Here")},
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon( imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                    
                }
            },
            trailingIcon = {
                Icon( imageVector = Icons.Default.Check,contentDescription = null)
            }

            )


        Text(
            text = count.value.toString(),
            modifier = modifier
                .background(Color.Yellow)
                .padding(10.dp),
            color = Color.Blue,
            fontSize = 30.sp

        )

        Button(onClick = { /*TODO*/ count.value++
            Toast.makeText(context, "${count.value} "+"${text}", Toast.LENGTH_SHORT).show()
        }) {

            Image(imageVector = Icons.Default.Send, contentDescription = null)
            Text(text = "Click")
        }


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeTheme {
        Greeting("Android")
    }
}


