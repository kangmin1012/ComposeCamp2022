package com.codelabs.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.basicstatecodelab.ui.theme.BasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }

        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }

    }
}


@Composable
fun StatelessCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit
) {
   Column(modifier = modifier.padding(16.dp)) {
       if (count > 0) {
           Text("You've had $count glasses.")
       }

       Button(
           onClick = onIncrement,
           modifier = Modifier.padding(top = 8.dp),
           enabled = count < 10
       ) {
           Text(text = "Add one")
       }
   }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(modifier, count) { count++ }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    BasicStateCodelabTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            WellnessScreen()
        }
    }
}