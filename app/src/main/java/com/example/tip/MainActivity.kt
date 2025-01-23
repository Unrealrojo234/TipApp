package com.example.tip

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tip.ui.theme.TipTheme
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Tip(
                        modifier = Modifier
                    );
                }
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun Tip(modifier: Modifier = Modifier) {
    var amountInput by remember { mutableStateOf("") }
    var tip by remember { mutableDoubleStateOf(0.0) }
    var hasError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var tipPercentage by remember {
        mutableStateOf("")
    }
    var roundUp by remember {
        mutableStateOf(false)
    }

    var tipHasError by remember {
        mutableStateOf(false)
    }
    var tipErrorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = modifier
                .height(44.dp)
                .padding(0.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(colorResource(id = R.color.rebeccapurple))
        ) {
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tip Calculator",

                style = TextStyle(
                    fontSize = 36.sp,
                    color = colorResource(id = R.color.teal_200)
                )
            )

            Image(
                painter = painterResource(id = R.drawable.donald_duck),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = amountInput,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.rebeccapurple),
                    focusedBorderColor = colorResource(id = R.color.teal_200),
                    errorBorderColor = Color.Red,
                ),

                onValueChange = { newValue ->
                    // Clear error when user starts typing
                    hasError = false
                    errorMessage = ""
                    amountInput = newValue
                },
                label = { Text("Bill Amount", style = TextStyle(
                    color = Color.Gray
                )) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = { Text("$", style = TextStyle(
                    color = Color.Green
                )
                ) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(),
                isError = hasError,

                supportingText = {
                    if (hasError) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },

            )
            
            OutlinedTextField(
                value = tipPercentage, 
                onValueChange = {
                    newValue ->

                    tipPercentage = newValue
                    tipHasError = false
                    tipErrorMessage = ""
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Tip Percentage",
                    style = TextStyle(color = Color.Gray)
                )},
                leadingIcon = { Text(text = "%", style = TextStyle(
                    color = Color.Cyan
                )
                )},

                supportingText = {
                    if(tipHasError){
                        Text(
                            text = tipErrorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                
                colors = OutlinedTextFieldDefaults.colors(

                    unfocusedBorderColor = if(tipHasError) Color.Red else colorResource(id = R.color.rebeccapurple),
                    focusedBorderColor = if(tipHasError) Color.Red else colorResource(id = R.color.teal_200)

                )
            )


            Card(modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                Row (modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(
                        text = "Round tip?",
                        style = TextStyle(
                            fontSize = 24.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    
                    Switch(checked = roundUp, onCheckedChange ={
                        roundUp = if(roundUp) false else true
                    }, modifier = Modifier)


                }
            }

            Spacer(modifier = Modifier.height(60.dp))


            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Text(
                    //text = "Tip Amount: $${String.format("%.2f", tip)}",
                    text = buildAnnotatedString {
                      append("Tip Amount: ")
                      withStyle(style = SpanStyle(color = Color.Green)){
                          append("\$${String.format("%.2f", tip)}")
                      }
                    },
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
            
            

            Spacer(modifier = Modifier.height(84.dp))

            OutlinedButton(
                modifier = Modifier
                    .width(180.dp)
                    .height(56.dp),
                onClick = {
                    try {
                        // Validate empty input
                        if (amountInput.isBlank()) {
                            hasError = true
                            errorMessage = "Please enter a bill amount"
                            return@OutlinedButton
                        }

                        if(tipPercentage.isBlank()){
                            tipHasError = true
                            tipErrorMessage = "Please enter a tip percentage"
                            return@OutlinedButton
                        }

                        // Validate numeric input
                        val amount = amountInput.toDoubleOrNull()
                        val tipAmount = tipPercentage.toDoubleOrNull()

                        if (amount == null) {
                            hasError = true
                            errorMessage = "Please enter a valid number"
                            return@OutlinedButton
                        }

                        if(tipAmount == null){
                            tipHasError = true
                            tipErrorMessage = "Please enter a valid number"
                            return@OutlinedButton
                        }

                        // Validate negative numbers
                        if (amount < 0) {
                            hasError = true
                            errorMessage = "Amount cannot be negative"
                            return@OutlinedButton
                        }
                        if(tipAmount < 0){
                            tipHasError = true;
                            tipErrorMessage = "Tip cannot be negative"
                            return@OutlinedButton
                        }

                        // Validate zero amount
                        if (amount == 0.0) {
                            hasError = true
                            errorMessage = "Amount must be greater than zero"
                            return@OutlinedButton
                        }

                        if(tipAmount == 0.0){
                            tipHasError = true;
                            tipErrorMessage = "Tip must be greater than zero"
                        }

                        // Calculate tip if all validations pass
                            if(roundUp){
                                tip = amount * (tipAmount/100)

                                tip = ceil(tip)
                            }else {
                                tip = amount * (tipAmount / 100)
                            }

                        hasError = false
                        errorMessage = ""

                    } catch (e: Exception) {
                        hasError = true
                        tipHasError = true
                        errorMessage = "An error occurred. Please try again."
                        tipErrorMessage = "An error occurred. Please try again."
                    }
                },
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(2.dp, colorResource(id = R.color.rebeccapurple))
            ) {
                Text(
                    modifier = Modifier,
                    text = "Calculate",
                    style = TextStyle(
                        fontSize = 24.sp,
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(64.dp))
            

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TipPreview(){
    TipTheme {
        Tip();
    }
}