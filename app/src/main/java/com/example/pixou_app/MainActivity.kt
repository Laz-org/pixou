package com.example.pixou_app

import android.icu.text.CaseMap
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.pixou_app.ui.theme.Pixou_appTheme
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference();
        setContent {
            Pixou_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.black)
                ){
                    my_menu();
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun my_menu() {
    val snackbarHostState = remember { SnackbarHostState() }
    var menuOpen by remember { mutableStateOf(false)}
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(title = {
                if (menuOpen) {Text("Pixou app menu open")}
                else {Text("Pixou app menu closed")}},
                navigationIcon = {
                    IconButton(onClick = { menuOpen = !menuOpen }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_menu_24),
                            contentDescription = null)
                    }
                },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(R.color.purple_200)))
                 },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding))
            { Text("Content")}
                  }
   )
}


//@Composable
//fun FilledButtonExample(onClick: () -> Unit) {
//    button(
//        onClick = myclick())
//        {Text("Filled")}
//
//}
//
//
//@Composable
//fun myclick() {
//
//}

@Composable
fun monbtn() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Button") }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pixou_appTheme {
        Greeting("Android")
    }
}