package presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun actionScreen (){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

       Text(text = " Insert ACTION question here", color = Color.White, modifier = Modifier.padding(32.dp))
       // Image(imageVector = , contentDescription = "Photograph of Madrid " )

        //INTRODUCING BUTTONS
        //BUTTON NUMBER 1
        Button(onClick = { /*TODO*/ },modifier= Modifier.padding(8.dp), shape = RectangleShape) {
            Text( text= "Choice number one")
        }
        //BUTTON NUMBER 3
        Button(onClick = { /*TODO*/ },modifier= Modifier.padding(8.dp), shape = RectangleShape) {
            Text( text= "Choice number two")
        }
        //BUTTON NUMBER 3
        Button(onClick = { /*TODO*/ },modifier= Modifier.padding(8.dp), shape = RectangleShape) {
            Text( text= "Choice number three")
        }



    }

}
@Preview
@Composable
fun actionScreenPreview(){
    actionScreen()
}