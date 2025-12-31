import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorTesting() {

    var display by remember {
        mutableStateOf("")
    }

    var firstNumber by remember {
        mutableStateOf<Double?>(null)
    }

    var operator by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = display,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.End
        )

        Row(
            modifier = Modifier.fillMaxSize()
        ) {


            Column(
                modifier = Modifier.weight(3f)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                ) {
                    listOf("1", "2", "3").forEach { item1 ->
                        Button(
                            onClick = {
                                display += item1
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCDDC39)),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(16.dp))
                                .size(80.dp)
                                .padding(2.dp)


                        ) {
                            Text(text = item1)
                        }


                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                ) {
                    listOf("4", "5", "6").forEach { item1 ->
                        Button(
                            onClick = {
                                display += item1
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .size(80.dp)
                                .padding(2.dp)


                        )


                        {
                            Text(text = item1)
                        }


                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                ) {
                    listOf("7", "8", "9").forEach { item1 ->
                        Button(
                            onClick = {
                                display += item1
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(4.dp)
                                )
                                .size(80.dp)
                                .padding(2.dp)
                        ) {
                            Text(text = item1)
                        }


                    }

                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                ) {
                    Button(
                        onClick = {
                            display += "0"

                        }, modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .size(80.dp)
                            .padding(2.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)


                    )


                    {
                        Text(text = "0")
                    }

                    Button(
                        onClick = {
                            if (firstNumber != null && operator != null) {
                                val parts = display.split(operator!!)
                                if (parts.size == 2) {
                                    val secondNumber = parts[1].toIntOrNull() ?: return@Button
                                    val result: Double = when (operator) {
                                        "+" -> firstNumber!! + secondNumber
                                        "*" -> firstNumber!! * secondNumber
                                        "-" -> firstNumber!! - secondNumber
                                        "/" -> firstNumber!! / secondNumber
                                        else -> 0.0
                                    }

                                    display =
                                        if (result % 1.0 == 0.0)
                                            result.toInt().toString()
                                        else
                                            result.toString()
                                    operator = null
                                    firstNumber = null
                                }
                            }
                        }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4)),
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .size(80.dp)
                            .padding(2.dp)


                    ) {
                        Text(text = "=")

                    }

                    Button(
                        onClick = {
                            display = ""
                            firstNumber = null
                            operator = null
                        }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .size(80.dp)
                            .padding(2.dp)

                    ) {
                        Text(text = "C")
                    }
                }


            }

            Column(
                modifier = Modifier.weight(1f).padding(10.dp)

            ) {
                Button(
                    onClick = {
                        firstNumber = display.toDoubleOrNull()
                        operator = "+"
                        display += "+"

                    }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(80.dp)
                        .padding(4.dp)


                ) {
                    Text(text = "+")
                }
                Button(
                    onClick = {
                        firstNumber = display.toDoubleOrNull()
                        operator = "-"
                        display += "-"
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF00BCD4)),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(80.dp)
                        .padding(4.dp)

                ) {
                    Text(text = "-")
                }
                Button(
                    onClick = {
                        firstNumber = display.toDoubleOrNull()
                        operator = "*"
                        display += "*"
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF39DC88)),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),

                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(80.dp)
                        .padding(4.dp)

                ) {
                    Text(text = "*")
                }
                Button(
                    onClick = {
                        firstNumber = display.toDoubleOrNull()
                        operator = "/"
                        display += "/"
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(80.dp)
                        .padding(4.dp)

                ) {
                    Text(text = "/")
                }
            }


        }

    }


}


