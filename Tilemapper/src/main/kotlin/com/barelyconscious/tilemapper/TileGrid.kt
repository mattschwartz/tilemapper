package com.barelyconscious.tilemapper

import java.awt.GridLayout
import javax.swing.JPanel

class TileGrid(cols: Int, rows: Int) : JPanel() {
    init {
        layout = GridLayout(rows, cols, 0, 0)
        for (i in 0..cols*rows) {
            add(Tile())
        }
    }
}
