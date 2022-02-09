package com.plcoding.dictionary.feature_dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.feature_dictionary.domain.model.Phonetic
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Composable
fun WordInfoItem(wordItem: WordInfo, modifier: Modifier = Modifier, playAudio: (Phonetic) -> Unit) {
    Column(modifier = modifier) {
        Text(
            text = wordItem.word!!,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = wordItem.phonetic!!, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = wordItem.origin!!)
        Divider(modifier = Modifier.padding(8.dp))
        wordItem.meanings?.forEach { meaning ->
            Text(text = meaning.partOfSpeech!!, fontWeight = FontWeight.Bold)
            meaning.definitions?.forEachIndexed { index, definition ->
                Text(text = "${index.inc()} ${definition.definition}")
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text(text = "Example: $example")
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}