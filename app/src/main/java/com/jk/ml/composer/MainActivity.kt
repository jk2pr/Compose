package com.jk.ml.composer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.FlexRow
import androidx.ui.layout.Padding
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
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
            VerticalScroller {
                Column {
                    (0..50).forEachIndexed { index, _ ->
                        createListItem(index)
                        Divider(color = Color.Blue, height = 1.dp)
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
