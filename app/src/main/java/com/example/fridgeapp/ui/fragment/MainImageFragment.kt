package com.example.fridgeapp.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fridgeapp.R
import com.example.fridgeapp.ui.dialog.showIngredientDialog
import com.example.fridgeapp.ui.dialog.showIngredientListDialog

class MainImageFragment : Fragment() {

    private var isClosed = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val parentView = inflater.inflate(R.layout.fragment_main_image, container, false)
        val imageView = parentView.findViewById<ImageView>(R.id.fridgeInside)
        val btnAdd = parentView.findViewById<Button>(R.id.btnAddIngredient)

        parentView.isFocusableInTouchMode = true
        parentView.requestFocus()   

        val categoryButtons = mapOf(
            R.id.btnMeat to "육류",
            R.id.btnFruit to "과일",
            R.id.btnDrink to "음료",
            R.id.btnDairy to "유제품",
            R.id.btnFrozen to "냉동식품",
            R.id.btnSeafood to "해산물",
            R.id.btnVegetable to "채소",
            R.id.btnSauce to "소스류",
            R.id.btnSide to "반찬",
            R.id.btnEtc to "기타"
        )

        // 냉장고 이미지 초기화
        imageView.setImageResource(R.drawable.fridge_closed)
        categoryButtons.keys.forEach { parentView.findViewById<Button>(it).visibility = View.GONE }

        // 열기 / 닫기
        imageView.setOnClickListener {
            isClosed = !isClosed
            val nextImage = if (isClosed) R.drawable.fridge_closed else R.drawable.fridgeinside
            imageView.animate().alpha(0f).setDuration(300).withEndAction {
                imageView.setImageResource(nextImage)
                imageView.animate().alpha(1f).setDuration(300).start()
                categoryButtons.keys.forEach { id ->
                    parentView.findViewById<Button>(id).visibility =
                        if (isClosed) View.GONE else View.VISIBLE
                }
            }.start()
        }

        // 카테고리 버튼
        categoryButtons.forEach { (id, name) ->
            parentView.findViewById<Button>(id).setOnClickListener {
                showIngredientListDialog(this, name)
            }
        }

        // 등록 버튼
        btnAdd.setOnClickListener {
            showIngredientDialog(requireContext())
        }

        return parentView
    }
}
