package com.letspracticeskills.ahmedezzulddin.jetpackcomposelayoutsyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.letspracticeskills.ahmedezzulddin.jetpackcomposelayoutsyt.ui.theme.JetpackComposeLayoutsYTTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    //Layout -> Row
    //Layout -> Column
    //Layout -> Box
    //Layout -> Surfaces
    //Layout -> Scaffold

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            Box(modifier = Modifier.fillMaxSize()) {
//
//                MySurface(modifier = Modifier.align(Alignment.Center))
//            }

            MyScaffold()
        }
    }
}


// With using Weight
@Composable
fun RowScope.MyRow() {


    Text(
        modifier = Modifier.weight(1f),
        text = "One",
        style = TextStyle(background = Color.Yellow)
    )

    Text(
        modifier = Modifier.weight(1f),
        text = "Two",
        style = TextStyle(background = Color.Yellow)
    )

    Text(
        modifier = Modifier.weight(1f),
        text = "Three",
        style = TextStyle(background = Color.Yellow)
    )


}


@Composable
fun MyRow() {


    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) { // Linear layout - Horizontal
        Text(
            text = "One",
            fontSize = 22.sp
        )
        Text(
            text = "Two",
            fontSize = 22.sp
        )
        Text(
            text = "Three",
            fontSize = 22.sp
        )
    }


}


@Composable
fun MyColumn() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Drawer Text One",

            fontSize = 22.sp
        )

        Text(
            text = "Drawer Text Two",

            fontSize = 22.sp
        )

        Text(
            text = "Drawer Text Three",

            fontSize = 22.sp
        )
    }

}


@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier
) {

    Box(modifier = modifier.fillMaxSize()) {

        Text(
            modifier = contentModifier.align(Alignment.TopStart),
            text = "One",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )

        Text(
            modifier = contentModifier.align(Alignment.Center),
            text = "Two",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )


        Text(
            modifier = contentModifier.align(Alignment.BottomEnd),
            text = "Three",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )

    }

}


@Composable
fun MySurface(modifier: Modifier) {

    Surface(
        modifier = modifier.size(200.dp),
        color = Color.LightGray,
        contentColor = colorResource(id = R.color.purple_700),
        border = BorderStroke(1.dp, color = Color.Yellow)
    ) {
        MyColumn()
    }
}


@Composable
fun MyScaffold() {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        content = { MyRow() },
        topBar = { MyTopAppBar(scaffoldState, scope) },
        drawerContent = { MyColumn() },
        bottomBar = { MyBottomAppBar() }
    )

}


@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {

    val drawerState = scaffoldState.drawerState

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch(Dispatchers.Main) {
                        if (drawerState.isClosed)
                            drawerState.open() else drawerState.close()
                    }
                },
                content = {
                    Icon(Icons.Default.Menu, contentDescription = "This is a top bar")
                },
            )
        },
        title = { Text(text = stringResource(id = R.string.app_name)) }
    )
}


@Composable
fun MyBottomAppBar() {

    BottomAppBar(
        content = {},
        backgroundColor = Color.Green
    )

}
















