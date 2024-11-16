package com.barelyconscious.tilemapper

import java.awt.Dimension
import java.awt.GridLayout
import java.util.function.Consumer
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.SwingConstants

class Palette(sprites: List<Sprite>, brushSetter: Consumer<Sprite>) : JPanel() {
    init {
        layout = GridLayout(0, 3)
        preferredSize = Dimension(100, 0)

        for (sprite in sprites) {
            val button = JButton(sprite.name, sprite.imageIcon)
            button.horizontalAlignment = SwingConstants.LEFT
            button.addActionListener {
                brushSetter.accept(sprite)
            }
            add(button)
        }
    }
}
