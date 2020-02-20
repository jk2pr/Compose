package com.jk.ml.composer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }

    }

    @Preview
    @Composable
    fun Test() {

        MaterialTheme {

            Column {
                TopAppBar(
                    title = {
                        Text(text = "Composer")
                    },
                    color = Color.White

                )
                VerticalScroller {
                    Column {
                        (0..100).forEachIndexed { index, _ ->
                            createListItem(index)
                            Divider(color = Color.Blue, height = 1.dp)
                        }
                    }

                }
            }
        }
    }


    @Composable
    private fun createListItem(itemIndex: Int) {
        Padding(left = 8.dp, right = 8.dp, top = 8.dp, bottom = 8.dp) {
            FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
                expanded(1.0f) {
                    Text("Item $itemIndex")
                }
                inflexible {
                    Button(
                        "Button $itemIndex",
                        style = ContainedButtonStyle(),
                        onClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Item name $itemIndex",
                                Toast.LENGTH_SHORT
                            ).show()
                        })
                }
            }
        }
    }


}
