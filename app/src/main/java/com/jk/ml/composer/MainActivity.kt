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
                    navigationIcon = {
                        AppBarIcon(icon = +imageResource(id = android.R.drawable.ic_menu_camera),
                    onClick = {

                    })
                    },
                    title = {
                        Text(text = "Composer")
                    },
                    color = Color.White

                )
                VerticalScroller(
                    isScrollable = true,

                    child = {

                        Column {
                            (0..5).forEachIndexed { index, _ ->
                                createListItem(index)
                                Divider(color = Color.Blue, height = 1.dp)
                            }
                        }
                    })

                Container(alignment = Alignment.BottomCenter, expanded = true) {
                    BottomAppBar(
                        navigationIcon = {
                            AppBarIcon(
                                +imageResource(android.R.drawable.ic_menu_month)
                            ) { Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_LONG).show() }
                        },
                        fabConfiguration =null,
                        actionData= listOf(+imageResource(android.R.drawable.ic_menu_share))

                    )

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
