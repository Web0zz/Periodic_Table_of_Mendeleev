package com.web0zz.periodic_table_of_mendeleev.binding

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

object ViewBinding {
    @JvmStatic
    @BindingAdapter(value = ["customWidth", "customHeight"], requireAll = true)
    fun View.setLayoutSize(width: Float, height: Float) {
        this.layoutParams = this.layoutParams.apply {
            this.width = width.toInt()
            this.height = height.toInt()
        }
    }

    @JvmStatic
    @BindingAdapter("textColorId")
    fun TextView.setTextColorValue(@ColorRes colorId: Int) {
        if (colorId == 0) return
        setTextColor(ContextCompat.getColor(context, colorId))
    }

    @JvmStatic
    @BindingAdapter("backgroundColorId")
    fun View.setTextColorValue(@ColorRes colorId: Int) {
        if (colorId == 0) return
        setBackgroundColor(ContextCompat.getColor(context, colorId))
    }
}