package br.senai.sp.jandira.myapplication.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonPadrao(texto: String, corLetra: Color, navigation: () -> Unit) {
    Button(
        onClick = navigation,
        modifier = Modifier
            .width(230.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 24.dp,
            pressedElevation = 10.dp
        )
    ) {
        Text(
            text = texto,
            color = corLetra,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EntrarPreview() {
    ButtonPadrao("ENTRAR", Color(253, 43, 110, 255), {})
}