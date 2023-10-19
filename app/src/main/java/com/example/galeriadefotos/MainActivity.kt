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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun Galeria(){
    var foto by remember{ mutableStateOf(1) }
    val image = when(foto) {
        1 -> R.drawable.reii
        2 -> R.drawable.shinjii
        3 -> R.drawable.asukaa
        4 -> R.drawable.kaworuu
        5 -> R.drawable.misato
        6 -> R.drawable.ritsuko
        7 -> R.drawable.kaji
        8 -> R.drawable.eva
        else -> R.drawable.lilith
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 190.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription =null
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(180.dp),
            modifier = Modifier
                .padding(top = 240.dp)
        ){
            Button(
                onClick = {foto= (9..9).first
                }
            ) {
                Text(
                    text = "Anterior"
                )
            }
            Button(
                onClick = {foto = (1..8).random()
                }
            ) {
                Text(
                    text = "Proximo"
                )
            }
        }
    }
}