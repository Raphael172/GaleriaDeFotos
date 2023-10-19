package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadefotos.ui.theme.GaleriaDeFotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotosTheme {
                Galeria()
            }
        }
    }
}

@Preview(showSystemUi = true, backgroundColor = 888, showBackground = true)
@Composable
fun Galeria() {
    var foto by remember { mutableStateOf(1) }
    val image = when (foto) {
        1 -> R.drawable.reii
        2 -> R.drawable.shinjii
        3 -> R.drawable.asukaa
        4 -> R.drawable.kaworuu
        5 -> R.drawable.misato
        6 -> R.drawable.ritsuko
        7 -> R.drawable.kaji
        8 -> R.drawable.eva
        9 -> R.drawable.mari
        10 -> R.drawable.ikari
        else -> R.drawable.lilith
    }
    if (foto >11 ){
        foto = 1
    }else if(foto <1){
        foto = 11
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.7F,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 210.dp, bottom = 45.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(end = 10.dp, start = 10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(180.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 3.dp, start = 3.dp)
        ) {
            Button(
                onClick = {
                    foto--
                },

                colors = ButtonDefaults.buttonColors(Color.DarkGray)
            ) {
                Text(
                    text = "Anterior",
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
            Button(
                onClick = {
                    foto++
                },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
            ) {
                Text(
                    text = "Proximo",
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
        }
    }
}