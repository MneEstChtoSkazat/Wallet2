package com.example.wallet.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallet.ui.AppColors
import com.example.wallet.ui.components.BackButton

/** Экран 03 «Редактор»: форма добавления и изменения записи кошелька. */
@Composable
fun EditorScreen(
    onBack: () -> Unit,
    onSave: () -> Unit
) {
    var currency by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        BackButton(onClick = onBack)

        // Пустое место под стрелкой, как в макете
        Spacer(modifier = Modifier.height(72.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            FieldLabel("Валюта")
            FormTextField(
                value = currency,
                onValueChange = { currency = it },
                placeholder = "Название"
            )

            Spacer(modifier = Modifier.height(16.dp))

            FieldLabel("Сумма")
            FormTextField(
                value = amount,
                onValueChange = { amount = it },
                placeholder = "Цена",
                keyboardType = KeyboardType.Decimal
            )

            Spacer(modifier = Modifier.height(16.dp))

            FieldLabel("Стоимость в валюте пользователя")
            RateBox()

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.ButtonDark,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Сохранить", fontSize = 14.sp)
            }
        }
    }
}

@Composable
private fun FieldLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(bottom = 6.dp),
        fontSize = 13.sp
    )
}

@Composable
private fun FormTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = AppColors.Hint, fontSize = 14.sp) },
        singleLine = true,
        shape = RoundedCornerShape(6.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = AppColors.FieldBorder,
            focusedBorderColor = AppColors.ButtonDark
        )
    )
}

/** Блок с курсом и стоимостью. Сейчас это статический текст, в ПР 4 сюда придут данные API. */
@Composable
private fun RateBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, AppColors.FieldBorder, RoundedCornerShape(6.dp))
            .padding(12.dp)
    ) {
        Text(text = "По API: 1 EUR = 98.50 RUB", fontSize = 12.sp, color = AppColors.Hint)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "Стоимость в RUB: 9850 ₽", fontSize = 12.sp, color = AppColors.Hint)
    }
}
